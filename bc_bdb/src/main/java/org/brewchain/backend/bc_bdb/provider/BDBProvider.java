package org.brewchain.backend.bc_bdb.provider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Invalidate;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.ServiceProperty;
import org.apache.felix.ipojo.annotations.Validate;
import org.osgi.framework.BundleContext;

import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Durability;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentMutableConfig;
import com.sleepycat.je.SecondaryConfig;
import com.sleepycat.je.SecondaryDatabase;
import com.sleepycat.je.SecondaryKeyCreator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import onight.osgi.annotation.iPojoBean;
import onight.tfw.mservice.NodeHelper;
import onight.tfw.ntrans.api.ActorService;
import onight.tfw.ojpa.api.DomainDaoSupport;
import onight.tfw.ojpa.api.StoreServiceProvider;
import onight.tfw.outils.conf.PropHelper;

@iPojoBean
@Component(immediate = true)
@Instantiate(name = "bdb_provider")
@Provides(specifications = { StoreServiceProvider.class, ActorService.class }, strategy = "SINGLETON")
@Slf4j
@Data
public class BDBProvider implements StoreServiceProvider, ActorService {

	@ServiceProperty(name = "name")
	String name = "bdb_provider";

	BundleContext bundleContext;
	public static final String defaultEnvironmentFolder = "appdb";
	@Setter
	@Getter
	String rootPath = "fbs";
	private HashMap<String, OBDBImpl> dbsByDomains = new HashMap<>();
	private Environment dbEnv = null;

	public BDBProvider(BundleContext bundleContext) {
		this.bundleContext = bundleContext;
	}

	@Override
	public String[] getContextConfigs() {
		return new String[] {};
	}

	PropHelper params;

	OBDBImpl default_dbImpl;

	@Validate
	public void startup() {
		try {
			new Thread(new DBStartThread()).start();

			// params = new PropHelper(bundleContext);
			// String dir = params.get("org.bc.obdb.dir", "odb." +
			// Math.abs(NodeHelper.getCurrNodeListenOutPort() - 5100));
			//
			// this.dbEnv = initDatabaseEnvironment(dir);
			// this.dbs = openDatabase("bc_bdb", true, false)[0];
			// default_dbImpl = new OBDBImpl("_", dbs);
			// dbsByDomains.put("_", default_dbImpl);
			// VersionChecker.check(default_dbImpl);
		} catch (Throwable t) {
			log.error("init bc bdb failed", t);
		}
	}

	class DBStartThread extends Thread {
		@Override
		public void run() {
			try {
				params = new PropHelper(bundleContext);
				String dir = params.get("org.bc.obdb.dir",
						"odb." + Math.abs(NodeHelper.getCurrNodeListenOutPort() - 5100));

				dbEnv = initDatabaseEnvironment(dir);
				dbs = openDatabase("bc_bdb", true, false)[0];
				default_dbImpl = new OBDBImpl("_", dbs);
				dbsByDomains.put("_", default_dbImpl);
				VersionChecker.check(default_dbImpl);

				HashMap<String, OBDBImpl> tempDbsByDomains = new HashMap<String, OBDBImpl>();
				for (String domainName : tempDomainName) {
					OBDBImpl dbi = dbsByDomains.get(domainName);
					if (dbi == null) {
						Database[] dbs = openDatabase("bc_bdb_" + domainName, true, false);
						if (dbs.length == 1) {
							dbi = new OBDBImpl(domainName, dbs[0]);
						} else {
							dbi = new OBDBImpl(domainName, dbs[0], dbs[1]);
						}
						tempDbsByDomains.put(domainName, dbi);
						log.debug("delay inject dao::" + domainName);
					}
				}
				dbsByDomains.putAll(tempDbsByDomains);
			} catch (Exception e) {
				log.error("dao注入异常", e);
			}
		}
	}

	private Database dbs;

	private Environment initDatabaseEnvironment(String folder) {
		String network = this.params.get("org.bc.manage.node.network", null);
		if (network == null || network.isEmpty()) {
			try {
				File networkFile = new File(".network");
				while (!networkFile.exists() || !networkFile.canRead()) {
					log.debug("等待读取network设置");
					Thread.sleep(1000);
				}

				FileReader fr = new FileReader(networkFile.getPath());
				BufferedReader br = new BufferedReader(fr);
				network = br.readLine();
				br.close();
				fr.close();

				log.debug("choose the network::" + network);
			} catch (Exception e) {
				log.error("error on read network::" + e.getMessage());
			}
		}

		folder = network.trim() + "/" + folder;
		File homeDir = new File(folder);
		if (!homeDir.exists()) {
			if (!homeDir.mkdirs()) {
				throw new PersistentMapException("make db floder error");
			} else {
				// copy default db
				String defaultDbDir = params.get("org.bc.obdb.dir", "genesis");
				String defaultDbFile = defaultDbDir + "/" + network + "/00000000.jdb";
				File defaultDbFolder = new File(defaultDbFile);
				if (defaultDbFolder.exists()) {
					try {
						log.info("init genesis db from:" + defaultDbFolder.getAbsolutePath() + ",size="
								+ defaultDbFile.length());

						try {
							FileInputStream input = new FileInputStream(defaultDbFile);
							FileOutputStream output = new FileOutputStream(folder + "/00000000.jdb");
							int in = input.read();
							while (in != -1) {
								output.write(in);
								in = input.read();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					} catch (Exception e) {
						log.error("copy db ex:", e);
					}
				}
			}
		}
		EnvironmentConfig envConfig = new EnvironmentConfig();
		// TODO db性能调优
		envConfig.setDurability(Durability.COMMIT_SYNC);
		envConfig.setAllowCreate(true);
		envConfig.setTransactional(true);
		return new Environment(homeDir, envConfig);
	}

	private Database[] openDatabase(String dbNameP, boolean allowCreate, boolean allowDuplicates) {
		DatabaseConfig objDbConf = new DatabaseConfig();
		objDbConf.setAllowCreate(allowCreate);
		objDbConf.setSortedDuplicates(allowDuplicates);
		objDbConf.setDeferredWrite(false);
		objDbConf.setTransactional(true);

		String dbsname[] = dbNameP.split("\\.");

		Database db = this.dbEnv.openDatabase(null, dbsname[0], objDbConf);
		if (dbsname.length == 2) {
			SecondaryConfig sd = new SecondaryConfig();
			sd.setAllowCreate(allowCreate);
			sd.setAllowPopulate(true);
			sd.setSortedDuplicates(true);
			sd.setDeferredWrite(false);
			sd.setTransactional(true);
			ODBTupleBinding tb = new ODBTupleBinding();
			SecondaryKeyCreator keyCreator = new ODBSecondKeyCreator(tb);
			sd.setKeyCreator(keyCreator);

			SecondaryDatabase sdb = this.dbEnv.openSecondaryDatabase(null, dbNameP, db, sd);
			return new Database[] { db, sdb };
		} else {
			return new Database[] { db };
		}
	}

	@Invalidate
	public void shutdown() {
		Iterator<String> it = this.dbsByDomains.keySet().iterator();
		while (it.hasNext()) {
			try {
				this.dbsByDomains.get(it.next()).close();
			} catch (DatabaseException e) {
				log.warn("close db error", e);
			}
		}

		this.dbEnv.close();

	}

	@Override
	public String getProviderid() {
		return "bc_bdb";
	}

	private List<String> tempDomainName = new ArrayList<String>();

	@Override
	public DomainDaoSupport getDaoByBeanName(DomainDaoSupport dds) {
		OBDBImpl dbi = dbsByDomains.get(dds.getDomainName());
		if (dbi == null) {
			synchronized (dbsByDomains) {
				dbi = dbsByDomains.get(dds.getDomainName());
				if (dbi == null) {
					if (this.dbEnv == null) {
						boolean isExists = false;
						for (int i = 0; i < tempDomainName.size(); i++) {
							if (tempDomainName.get(i).equals(dds.getDomainName())) {
								isExists = true;
								break;
							}
						}
						if (!isExists) {
							tempDomainName.add(dds.getDomainName());
						}
						dbi = new OBDBImpl("temp", null);
					} else {
						Database[] dbs = openDatabase("bc_bdb_" + dds.getDomainName(), true, false);
						if (dbs.length == 1) {
							dbi = new OBDBImpl(dds.getDomainName(), dbs[0]);
						} else {
							dbi = new OBDBImpl(dds.getDomainName(), dbs[0], dbs[1]);
						}
						dbsByDomains.put(dds.getDomainName(), dbi);
						log.debug("inject dao::" + dds.getDomainName());
					}
				}
			}
		}
		return dbi;
	}

}

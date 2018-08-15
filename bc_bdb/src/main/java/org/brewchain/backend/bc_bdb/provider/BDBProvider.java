package org.brewchain.backend.bc_bdb.provider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import com.sleepycat.je.SecondaryConfig;
import com.sleepycat.je.SecondaryDatabase;
import com.sleepycat.je.SecondaryKeyCreator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import onight.tfw.mservice.NodeHelper;
import onight.tfw.ntrans.api.ActorService;
import onight.tfw.ojpa.api.DomainDaoSupport;
import onight.tfw.ojpa.api.StoreServiceProvider;
import onight.tfw.outils.conf.PropHelper;

@Component(publicFactory = false)
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
	// private Environment dbEnv = null;

	public BDBProvider(BundleContext bundleContext) {
		this.bundleContext = bundleContext;
		log.debug("new BDBProvider:" + this.hashCode() + ":" + this);
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
			log.debug("InitDBStart:::" + this);
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

				// dbEnv = initDatabaseEnvironment(dir);
				// dbs = openDatabase("bc_bdb", true, false)[0];
				synchronized (dbsByDomains) {
					// default_dbImpl = new OBDBImpl("_", dbs);
					// dbsByDomains.put("_", default_dbImpl);
					// VersionChecker.check(default_dbImpl);

					for (String domainName : dbsByDomains.keySet()) {
						OBDBImpl dbi = dbsByDomains.get(domainName);
						if (dbi == null) {
							dbi = new OBDBImpl(domainName, null);
						}
						if (dbi.getDbs() == null) {
							Environment env = initDatabaseEnvironment(dir, domainName);
							Database[] dbs = openDatabase(env, "bc_bdb_" + domainName, true, false);
							if (dbs.length == 1) {
								dbi.setDbs(dbs[0]);
							} else {
								dbi.setDbs(dbs[0]);
								dbi.setSdb((SecondaryDatabase) dbs[1]);
							}
							log.debug("delay inject dao::" + domainName);
						}
					}
				}
			} catch (Exception e) {
				log.error("dao注入异常", e);
			}
		}
	}

	// private Database dbs;

	private Environment initDatabaseEnvironment(String folder, String domainName) {
		String network = "";
		try {
			File networkFile = new File(".chainnet");
			if (!networkFile.exists() || !networkFile.canRead()) {
				// read default config
				network = this.params.get("org.bc.manage.node.net", null);
			}
			if (network == null || network.isEmpty()) {
				while (!networkFile.exists() || !networkFile.canRead()) {
					log.debug("waiting chain_net config...");
					Thread.sleep(1000);
				}

				FileReader fr = new FileReader(networkFile.getPath());
				BufferedReader br = new BufferedReader(fr);
				network = br.readLine().trim().replace("\r", "").replace("\t", "");
				br.close();
				fr.close();
			}
			log.debug("choose the chain_net::" + network);
		} catch (Exception e) {
			log.error("error on read chain_net::" + e.getMessage());
		}

		folder = "db" + File.separator + network + File.separator + folder + File.separator + domainName;
		File dbHomeFile = new File(folder);
		File dbFile = new File(folder + File.separator + "00000000.jdb");

		if (!dbFile.exists()) {
			if (!dbHomeFile.exists() && !dbHomeFile.mkdirs()) {
				throw new PersistentMapException("make db folder error");
			} else {
				String genesisDbDir = params.get("org.bc.obdb.dir", "genesis");
				String genesisDbFileStr = genesisDbDir + File.separator + network + File.separator + "db"
						+ File.separator + domainName + File.separator + "00000000.jdb";

				File genesisDbFile = new File(genesisDbFileStr);
				if (genesisDbFile.exists() && genesisDbFile.isFile()) {
					try {
						log.info("init genesis db from:" + genesisDbFile.getAbsolutePath() + ",size="
								+ genesisDbFile.length());

						try (FileInputStream input = new FileInputStream(genesisDbFile);
								FileOutputStream output = new FileOutputStream(
										folder + File.separator + "00000000.jdb");) {
							byte[] bb = new byte[10240];
							int size = 0;
							while ((size = input.read(bb)) > 0) {
								output.write(bb, 0, size);
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
		envConfig.setTxnTimeout(params.get("org.brewchain.backend.bdb.txn.timeoutms", 30 * 1000),
				TimeUnit.MILLISECONDS);
		envConfig.setLockTimeout(params.get("org.brewchain.backend.bdb.lock.timeoutms", 30 * 1000),
				TimeUnit.MILLISECONDS);
		envConfig.setAllowCreate(true);
		envConfig.setTransactional(true);
		envConfig.setCacheSize(params.get("org.brewchain.backend.bdb.cache.max", 983040));
		return new Environment(dbHomeFile, envConfig);
	}

	private Database[] openDatabase(Environment env, String dbNameP, boolean allowCreate, boolean allowDuplicates) {
		DatabaseConfig objDbConf = new DatabaseConfig();
		objDbConf.setAllowCreate(allowCreate);
		objDbConf.setSortedDuplicates(allowDuplicates);
		objDbConf.setDeferredWrite(false);
		objDbConf.setTransactional(true);

		String dbsname[] = dbNameP.split("\\.");

		Database db = env.openDatabase(null, dbsname[0], objDbConf);
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

			SecondaryDatabase sdb = env.openSecondaryDatabase(null, dbNameP, db, sd);
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
		// if (this.dbEnv != null) {
		// this.dbEnv.close();
		// }
	}

	@Override
	public String getProviderid() {
		return "bc_bdb";
	}

	private List<String> tempDomainName = new ArrayList<String>();

	@Override
	public DomainDaoSupport getDaoByBeanName(DomainDaoSupport dds) {
		OBDBImpl dbi = dbsByDomains.get(dds.getDomainName());
		String dir = params.get("org.bc.obdb.dir", "odb." + Math.abs(NodeHelper.getCurrNodeListenOutPort() - 5100));

		if (dbi == null) {
			synchronized (dbsByDomains) {
				dbi = dbsByDomains.get(dds.getDomainName());
				if (dbi == null) {
					// if (this.dbEnv == null) {
					// dbi = new OBDBImpl(dds.getDomainName(), null);
					// } else {

					Environment env = initDatabaseEnvironment(dir, dds.getDomainName());
					Database[] dbs = openDatabase(env, "bc_bdb_" + dds.getDomainName(), true, false);
					if (dbs.length == 1) {
						dbi = new OBDBImpl(dds.getDomainName(), dbs[0]);
					} else {
						dbi = new OBDBImpl(dds.getDomainName(), dbs[0], dbs[1]);
					}
					// }
					dbsByDomains.put(dds.getDomainName(), dbi);
					log.debug("inject dao::" + dds.getDomainName());
				}
			}
		}
		return dbi;
	}

	private void copyFolder(File src, File dest) throws IOException {
		if (src.isDirectory()) {
			if (!dest.exists()) {
				dest.mkdir();
			}
			String files[] = src.list();
			for (String file : files) {
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// 递归复制
				copyFolder(srcFile, destFile);
			}
		} else {
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;

			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			in.close();
			out.close();
		}
	}
}

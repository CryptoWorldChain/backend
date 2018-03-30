package org.brewchain.backend.bc_bdb.provider;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Invalidate;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.Validate;
import org.osgi.framework.BundleContext;

import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Durability;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import onight.osgi.annotation.iPojoBean;
import onight.tfw.mservice.NodeHelper;
import onight.tfw.ojpa.api.DomainDaoSupport;
import onight.tfw.ojpa.api.StoreServiceProvider;
import onight.tfw.outils.conf.PropHelper;

@iPojoBean
@Component(immediate = true)
@Instantiate()
@Provides(specifications = StoreServiceProvider.class, strategy = "SINGLETON")
@Slf4j
public class BDBProvider implements StoreServiceProvider {

	BundleContext bundleContext;
	public static final String defaultEnvironmentFolder = "appdb";
	@Setter
	@Getter
	String rootPath = "fbs";
	private HashMap<String, OBDBImpl> dbsByDomains = new HashMap<>();
	private Environment dbEnv;

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
			params = new PropHelper(bundleContext);
			String dir = params.get("org.bc.obdb.dir", "odb." + Math.abs(NodeHelper.getCurrNodeListenOutPort() - 5100));
			this.dbEnv = initDatabaseEnvironment(dir);
			DatabaseConfig dbconf = new DatabaseConfig();

			dbconf.setAllowCreate(true);
			dbconf.setSortedDuplicates(false);
			this.dbs = openDatabase("bc_bdb", true, false);
			default_dbImpl = new OBDBImpl("_", dbs);
			dbsByDomains.put("_", default_dbImpl);
			VersionChecker.check(default_dbImpl);
		} catch (Throwable t) {
			log.error("init bc bdb failed",t);
		}
	}

	private Database dbs;

	private Environment initDatabaseEnvironment(String folder) {
		File homeDir = new File(folder);
		if (!homeDir.exists()) {
			if (!homeDir.mkdir()) {
				throw new PersistentMapException("");
			}
		}
		EnvironmentConfig envConfig = new EnvironmentConfig();
		envConfig.setDurability(Durability.COMMIT_SYNC);
		envConfig.setAllowCreate(true);
		return new Environment(homeDir, envConfig);
	}

	private Database openDatabase(String dbName, boolean allowCreate, boolean allowDuplicates) {
		DatabaseConfig objDbConf = new DatabaseConfig();
		objDbConf.setAllowCreate(allowCreate);
		objDbConf.setSortedDuplicates(allowDuplicates);
		objDbConf.setDeferredWrite(true);
		return this.dbEnv.openDatabase(null, dbName, objDbConf);
	}

	@Invalidate
	public void shutdown() {
		Iterator<String> it = this.dbsByDomains.keySet().iterator();
		while (it.hasNext()) {
			try {
				this.dbsByDomains.get(it.next()).getDbs().close();
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

	@Override
	public DomainDaoSupport getDaoByBeanName(DomainDaoSupport dds) {
		OBDBImpl dbi = dbsByDomains.get(dds.getDomainName());
		if (dbi == null) {
			synchronized (dbsByDomains) {
				dbi = dbsByDomains.get(dds.getDomainName());
				if (dbi == null) {
					Database db = openDatabase("bc_bdb_" + dds.getDomainName(), true, false);
					dbi = new OBDBImpl(dds.getDomainName(), db);
					dbsByDomains.put(dds.getDomainName(), dbi);
				}
			}
		}
		return dbi;
	}

}

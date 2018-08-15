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
import org.brewchain.bcapi.backend.ODBSupport;
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
	private HashMap<String, ODBSupport> dbsByDomains = new HashMap<>();
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
	
	DBHelper dbHelper;

	@Validate
	public void startup() {
		try {
			log.debug("InitDBStart:::" + this);
			new Thread(new DBStartThread()).start();
		} catch (Throwable t) {
			log.error("init bc bdb failed", t);
		}
	}

	class DBStartThread extends Thread {
		@Override
		public void run() {
			try {
				params = new PropHelper(bundleContext);
				dbHelper = new DBHelper(params);
				String dir = params.get("org.bc.obdb.dir",
						"odb." + Math.abs(NodeHelper.getCurrNodeListenOutPort() - 5100));

				synchronized (dbsByDomains) {
					for (String domainName : dbsByDomains.keySet()) {
						dbHelper.createDBI(dbsByDomains,dir,domainName);
					}
				}
			} catch (Exception e) {
				log.error("dao注入异常", e);
			}
		}
	}

	// private Database dbs;

	
	@Invalidate
	public void shutdown() {
		Iterator<String> it = this.dbsByDomains.keySet().iterator();
		while (it.hasNext()) {
			try {
				ODBSupport odb = this.dbsByDomains.get(it.next());
				if (odb != null && odb instanceof OBDBImpl) {
					((OBDBImpl) odb).close();
				} else if (odb != null && odb instanceof SlicerOBDBImpl) {
					((SlicerOBDBImpl) odb).close();
				}

			} catch (DatabaseException e) {
				log.warn("close db error", e);
			}
		}
	}

	@Override
	public String getProviderid() {
		return "bc_bdb";
	}

	private List<String> tempDomainName = new ArrayList<String>();
	
	@Override
	public DomainDaoSupport getDaoByBeanName(DomainDaoSupport dds) {
		ODBSupport dbi = dbsByDomains.get(dds.getDomainName());
		String dir = params.get("org.bc.obdb.dir", "odb." + Math.abs(NodeHelper.getCurrNodeListenOutPort() - 5100));
		if (dbi == null) {
			dbi = dbHelper.createDBI(dbsByDomains, dir, dds.getDomainName());
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

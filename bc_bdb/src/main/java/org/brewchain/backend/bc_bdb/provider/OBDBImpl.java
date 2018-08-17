package org.brewchain.backend.bc_bdb.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.concurrent.ConcurrentUtils;
import org.brewchain.bcapi.backend.ODBException;
import org.brewchain.bcapi.backend.ODBHelper;
import org.brewchain.bcapi.backend.ODBSupport;
import org.brewchain.bcapi.gens.Oentity.OKey;
import org.brewchain.bcapi.gens.Oentity.OPair;
import org.brewchain.bcapi.gens.Oentity.OValue;

import com.google.protobuf.ByteString;
import com.sleepycat.je.CursorConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.SecondaryCursor;
import com.sleepycat.je.SecondaryDatabase;
import com.sleepycat.je.Transaction;
import com.sleepycat.je.TransactionConfig;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import onight.tfw.ojpa.api.DomainDaoSupport;
import onight.tfw.ojpa.api.ServiceSpec;

@Slf4j
@Data
public class OBDBImpl implements ODBSupport, DomainDaoSupport {
	String domainName = "";
	private Database dbs;
	private SecondaryDatabase sdb;

	private boolean autoSync = true;
	private TransactionConfig txnConfig;
	AtomicInteger relayWriteCounter = new AtomicInteger(0);

	public OBDBImpl(String domain, Database dbs) {
		this.domainName = domain;
		this.dbs = dbs;
		txnConfig = new TransactionConfig();
		txnConfig.setReadCommitted(true);
	}

	public OBDBImpl(String domain, Database dbs, Database sdbs) {
		this.domainName = domain;
		this.dbs = dbs;
		this.sdb = (SecondaryDatabase) sdbs;
		txnConfig = new TransactionConfig();
		txnConfig.setReadCommitted(true);
	}

	@Override
	public DomainDaoSupport getDaosupport() {

		if (dbs != null) {
			return this;
		} else {
			return null;
		}
	}

	@Override
	public Class<?> getDomainClazz() {
		return Object.class;
	}

	@Override
	public String getDomainName() {
		return "etcd";
	}

	public void commitTxn(Transaction txn) {
		txn.commit();
	}

	public void close() {
		if (dbs != null) {
			dbs.close();
		}
		if (sdb != null) {
			sdb.close();
		}
	}

	public void sync() {
		if (!this.dbs.getEnvironment().getConfig().getTransactional()) {
			dbs.sync();
		}
	}

	@Override
	public ServiceSpec getServiceSpec() {
		return new ServiceSpec("obdb");
	}

	@Override
	public void setDaosupport(DomainDaoSupport dao) {
		log.trace("setDaosupport::dao=" + dao);
	}

	@Override
	public Future<OValue[]> batchCompareAndDelete(OKey[] keys, OValue[] values) throws ODBException {
		Transaction txn = null;
		List<OValue> list = new ArrayList<OValue>();
		try {
			// TODO db性能调优
			txn = this.dbs.getEnvironment().beginTransaction(null, this.txnConfig);
			for (int i = 0; i < keys.length; i++) {
				DatabaseEntry searchEntry = new DatabaseEntry();
				dbs.get(txn, new DatabaseEntry(keys[i].toByteArray()), searchEntry, LockMode.DEFAULT);
				if (searchEntry.getData() == null) {

				} else {
					OValue v = ODBHelper.b2Value(searchEntry.getData());
					if (v.equals(values[i])) {

					} else {
						dbs.delete(txn, new DatabaseEntry(keys[i].toByteArray()));
						// return old value
						list.add(v);
					}
				}
			}
			commitTxn(txn);
		} catch (Exception e) {
			log.error("fail to batch compare and delete::ex=" + e);

			if (txn != null) {
				txn.abort();
				txn = null;
			}
		}
		return ConcurrentUtils.constantFuture((OValue[]) list.toArray());
	}

	@Override
	public Future<OValue[]> batchCompareAndSwap(OKey[] keys, OValue[] compareValues, OValue[] newValues)
			throws ODBException {
		Transaction txn = null;
		List<OValue> list = new ArrayList<OValue>();
		try {
			txn = this.dbs.getEnvironment().beginTransaction(null, this.txnConfig);
			for (int i = 0; i < keys.length; i++) {
				DatabaseEntry searchEntry = new DatabaseEntry();
				dbs.get(txn, new DatabaseEntry(keys[i].toByteArray()), searchEntry, LockMode.DEFAULT);
				if (searchEntry.getData() == null) {

				} else {
					OValue v = ODBHelper.b2Value(searchEntry.getData());
					if (v.equals(compareValues[i])) {

					} else {
						dbs.put(txn, new DatabaseEntry(keys[i].toByteArray()),
								new DatabaseEntry(newValues[i].toByteArray()));
						// return old value
						list.add(v);
					}
				}
			}
			commitTxn(txn);
		} catch (Exception e) {
			log.error("fail to batch swap::ex=" + e);

			if (txn != null) {
				txn.abort();
				txn = null;
			}
		}
		return ConcurrentUtils.constantFuture((OValue[]) list.toArray());
	}

	@Override
	public Future<OValue[]> batchDelete(OKey[] keys) throws ODBException {
		Transaction txn = null;
		try {
			// need TransactionConfig?
			txn = this.dbs.getEnvironment().beginTransaction(null, this.txnConfig);
			for (OKey key : keys) {
				this.dbs.delete(txn, new DatabaseEntry(key.toByteArray()));
			}
			commitTxn(txn);
		} catch (Exception ex) {
			if (txn != null) {
				txn.abort();
				txn = null;
			}
			log.error("fail to batch delete::ex=" + ex);
		}

		return ConcurrentUtils.constantFuture(null);
	}

	@Override
	public Future<OValue[]> batchPuts(OKey[] keys, OValue[] values) throws ODBException {
		Transaction txn = null;
		try {
			// need TransactionConfig?
			txn = this.dbs.getEnvironment().beginTransaction(null, this.txnConfig);
			for (int i = 0; i < keys.length; i++) {
				OperationStatus os = this.dbs.put(txn, new DatabaseEntry(keys[i].toByteArray()),
						new DatabaseEntry(ODBHelper.v2Bytes(values[i])));
			}
			commitTxn(txn);
		} catch (Exception ex) {
			if (txn != null) {
				txn.abort();
				txn = null;
			}
			log.error("fail to batch put::ex=" + ex);

		}
		return ConcurrentUtils.constantFuture(null);
	}

	@Override
	public Future<OValue> compareAndDelete(OKey key, OValue value) throws ODBException {
		DatabaseEntry searchEntry = new DatabaseEntry();
		dbs.get(null, new DatabaseEntry(key.toByteArray()), searchEntry, LockMode.DEFAULT);
		if (searchEntry.getData() == null) {
			return ConcurrentUtils.constantFuture(null);
		} else {
			OValue v = ODBHelper.b2Value(searchEntry.getData());
			if (v.equals(value)) {

			} else {
				dbs.delete(null, new DatabaseEntry(key.toByteArray()));
			}

			// return new value or old value?
			return ConcurrentUtils.constantFuture(v);
		}
	}

	@Override
	public Future<OValue> compareAndSwap(OKey key, OValue compareValue, OValue newValue) throws ODBException {
		DatabaseEntry searchEntry = new DatabaseEntry();
		dbs.get(null, new DatabaseEntry(key.toByteArray()), searchEntry, LockMode.DEFAULT);
		if (searchEntry.getData() == null) {
			return ConcurrentUtils.constantFuture(null);
		} else {
			OValue v = ODBHelper.b2Value(searchEntry.getData());
			if (v.equals(compareValue)) {

			} else {
				dbs.put(null, new DatabaseEntry(key.toByteArray()), new DatabaseEntry(ODBHelper.v2Bytes(newValue)));
			}

			return ConcurrentUtils.constantFuture(newValue);
		}
	}

	@Override
	public Future<OValue> delete(OKey key) throws ODBException {
		dbs.delete(null, new DatabaseEntry(key.toByteArray()));
		return ConcurrentUtils.constantFuture(null);
	}

	@Override
	public Future<OValue> get(OKey key) throws ODBException {
		DatabaseEntry searchEntry = new DatabaseEntry();
		dbs.get(null, new DatabaseEntry(key.toByteArray()), searchEntry, LockMode.DEFAULT);

		if (searchEntry.getData() == null) {
			return ConcurrentUtils.constantFuture(null);
		} else {
			OValue v = ODBHelper.b2Value(searchEntry.getData());
			return ConcurrentUtils.constantFuture(v);
		}
	}

	@Override
	public Future<OValue[]> list(OKey[] keys) throws ODBException {
		List<OValue> list = new ArrayList<OValue>();
		for (OKey key : keys) {
			DatabaseEntry searchEntry = new DatabaseEntry();
			dbs.get(null, new DatabaseEntry(key.toByteArray()), searchEntry, LockMode.DEFAULT);
			if (searchEntry.getData() == null) {

			} else {
				list.add(ODBHelper.b2Value(searchEntry.getData()));
			}
		}
		return ConcurrentUtils.constantFuture((OValue[]) list.toArray());
	}

	@Override
	public Future<OValue> put(OKey key, OValue v) throws ODBException {
		DatabaseEntry keyValue = new DatabaseEntry(key.toByteArray());
		DatabaseEntry dataValue = new DatabaseEntry(ODBHelper.v2Bytes(v));
		dbs.put(null, keyValue, dataValue);
		return ConcurrentUtils.constantFuture(v);
	}

	@Override
	public Future<byte[]> putData(String key, byte[] value) throws ODBException {
		put(OKey.newBuilder().setData(ByteString.copyFrom(key.getBytes())).build(),
				OValue.newBuilder().setExtdata(ByteString.copyFrom(value)).build());
		return ConcurrentUtils.constantFuture(value);
	}

	@Override
	public Future<String> putInfo(String key, String value) throws ODBException {
		put(OKey.newBuilder().setData(ByteString.copyFrom(key.getBytes())).build(),
				OValue.newBuilder().setInfo(value).build());
		return ConcurrentUtils.constantFuture(value);
	}

	@Override
	public Future<OValue> get(String key) throws ODBException {
		return get(OKey.newBuilder().setData(ByteString.copyFrom(key.getBytes())).build());
	}

	@Override
	public Future<OValue> put(String key, OValue value) throws ODBException {
		return put(OKey.newBuilder().setData(ByteString.copyFrom(key.getBytes())).build(), value);

	}

	@Override

	public Future<List<OPair>> listBySecondKey(String secondaryName) throws ODBException {
		if (sdb != null) {
			SecondaryCursor mySecCursor = null;
			try {
				DatabaseEntry secondaryKey = new DatabaseEntry(secondaryName.getBytes("UTF-8"));
				DatabaseEntry foundKey = new DatabaseEntry();
				DatabaseEntry foundData = new DatabaseEntry();

				CursorConfig oCursorConfig = new CursorConfig();

				// mySecCursor = sdb.openSecondaryCursor(null, null);
				oCursorConfig.setReadCommitted(true);
				mySecCursor = sdb.openCursor(null, oCursorConfig);

				// Search for the secondary database entry.
				OperationStatus retVal = mySecCursor.getSearchKey(secondaryKey, foundKey, foundData, LockMode.DEFAULT);
				List<OPair> ret = new ArrayList<>();

				while (retVal == OperationStatus.SUCCESS) {
					OValue ov = ODBHelper.b2Value(foundData.getData());
					OKey key = OKey.newBuilder().mergeFrom(foundKey.getData()).build();
					ret.add(OPair.newBuilder().setKey(key).setValue(ov).build());
					retVal = mySecCursor.getNextDup(secondaryKey, foundKey, foundData, LockMode.DEFAULT);
				}

				return ConcurrentUtils.constantFuture(ret);
			} catch (Exception e) {
				log.debug("ODBError", e);
				return ConcurrentUtils.constantFuture(null);
			} finally {
				if (mySecCursor != null) {
					mySecCursor.close();
				}
			}
		} else {
			return ConcurrentUtils.constantFuture(null);
		}
	}

	@Override
	public Future<List<OPair>> putBySecondKey(String arg0, OValue[] arg1) throws ODBException {
		throw new RuntimeException("Not supported");
	}

	@Override
	public Future<List<OPair>> removeBySecondKey(String secondaryName, OKey[] keys) throws ODBException {
		// 取出一个key
		try {
			List<OPair> list = listBySecondKey(secondaryName).get();
			List<OKey> existsKeys = new ArrayList<OKey>();
			List<OValue> existsValues = new ArrayList<OValue>();
			for (OPair oPair : list) {
				for (OKey oKey : keys) {
					if (oPair.getKey().equals(oKey)) {
						existsKeys.add(oKey);
						OValue.Builder oOValue = oPair.getValue().toBuilder();
						oOValue.setSecondKey("tx_deleted");
						existsValues.add(oOValue.build());
					}
				}
			}
			batchDelete((OKey[]) existsKeys.toArray());
			batchPuts((OKey[]) existsKeys.toArray(), (OValue[]) existsValues.toArray());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Future<OValue> putIfNotExist(OKey key, OValue v) throws ODBException {
		DatabaseEntry keyValue = new DatabaseEntry(key.toByteArray());
		DatabaseEntry dataValue = new DatabaseEntry(ODBHelper.v2Bytes(v));
		OperationStatus opstatus = dbs.putNoOverwrite(null, keyValue, dataValue);
		if (opstatus == OperationStatus.KEYEXIST) {
			return ConcurrentUtils.constantFuture(null);
		} else {
			return ConcurrentUtils.constantFuture(v);
		}
	}

	/**
	 * 如果存在返回null，如果不存在返回当前值
	 */
	@Override
	public Future<OValue[]> putIfNotExist(OKey[] keys, OValue[] values) throws ODBException {
		Transaction txn = null;
		try {
			// need TransactionConfig?
			txn = this.dbs.getEnvironment().beginTransaction(null, this.txnConfig);
			OValue[] ret = new OValue[keys.length];
			for (int i = 0; i < keys.length; i++) {
				OperationStatus os = this.dbs.putNoOverwrite(txn, new DatabaseEntry(keys[i].toByteArray()),
						new DatabaseEntry(ODBHelper.v2Bytes(values[i])));
				if (os == OperationStatus.KEYEXIST) {
					ret[i] = null;
				} else {
					ret[i] = values[i];
				}
			}
			commitTxn(txn);
			return ConcurrentUtils.constantFuture(ret);
		} catch (Exception ex) {
			if (txn != null) {
				txn.abort();
				txn = null;
			}
			log.error("fail to batch put::ex=" + ex);

		}
		return ConcurrentUtils.constantFuture(null);
	}

}

package org.brewchain.backend.bc_bdb.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.apache.commons.lang3.concurrent.ConcurrentUtils;
import org.brewchain.bcapi.backend.ODBException;
import org.brewchain.bcapi.backend.ODBHelper;
import org.brewchain.bcapi.backend.ODBSupport;
import org.brewchain.bcapi.gens.Oentity.OKey;
import org.brewchain.bcapi.gens.Oentity.OValue;

import com.google.protobuf.ByteString;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DiskOrderedCursor;
import com.sleepycat.je.DiskOrderedCursorConfig;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.SecondaryCursor;
import com.sleepycat.je.SecondaryDatabase;

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

	public OBDBImpl(String domain, Database dbs) {
		this.domainName = domain;
		this.dbs = dbs;
	}

	public OBDBImpl(String domain, Database dbs, Database sdbs) {
		this.domainName = domain;
		this.dbs = dbs;
		this.sdb = (SecondaryDatabase)sdbs;
	}

	@Override
	public DomainDaoSupport getDaosupport() {
		return this;
	}

	@Override
	public Class<?> getDomainClazz() {
		return Object.class;
	}

	@Override
	public String getDomainName() {
		return "etcd";
	}

	public void trySync() {
		if (autoSync && dbs != null) {
			dbs.sync();
		}
	}
	public void close(){
		dbs.close();
		if(sdb!=null)
		{
			sdb.close();
		}
	}

	public void sync() {
		dbs.sync();
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
	public Future<OValue[]> batchCompareAndDelete(OKey[] arg0, OValue[] arg1) throws ODBException {
		return ConcurrentUtils.constantFuture(null);
	}

	@Override
	public Future<OValue[]> batchCompareAndSwap(OKey[] arg0, OValue[] arg1, OValue[] arg2) throws ODBException {
		return ConcurrentUtils.constantFuture(null);
	}

	@Override
	public Future<OValue[]> batchDelete(OKey[] arg0) throws ODBException {
		return ConcurrentUtils.constantFuture(null);
	}

	@Override
	public Future<OValue[]> batchPuts(OKey[] arg0, OValue[] arg1) throws ODBException {
		return ConcurrentUtils.constantFuture(null);
	}

	@Override
	public Future<OValue> compareAndDelete(OKey arg0, OValue arg1) throws ODBException {
		return ConcurrentUtils.constantFuture(null);
	}

	@Override
	public Future<OValue> compareAndSwap(OKey arg0, OValue arg1, OValue arg2) throws ODBException {
		return ConcurrentUtils.constantFuture(null);
	}

	@Override
	public Future<OValue> delete(OKey arg0) throws ODBException {
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
	public Future<OValue[]> list(OKey[] arg0) throws ODBException {
		return ConcurrentUtils.constantFuture(null);
	}

	@Override
	public Future<OValue> put(OKey key, OValue v) throws ODBException {
		DatabaseEntry keyValue = new DatabaseEntry(key.toByteArray());
		DatabaseEntry dataValue = new DatabaseEntry(ODBHelper.v2Bytes(v));
		dbs.put(null, keyValue, dataValue);
		// dbs.getSearchBoth(txn, key, data, lockMode)
		trySync();
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
	public Future<List<OValue>> listBySecondKey(String secondaryName) throws ODBException {
		if (sdb != null) {
			try {
				DatabaseEntry secondaryKey = new DatabaseEntry(secondaryName.getBytes("UTF-8"));
				DatabaseEntry foundData = new DatabaseEntry();
				DiskOrderedCursorConfig useConfig=new DiskOrderedCursorConfig();
				useConfig.setKeysOnly(false);
				useConfig.setQueueSize(100);
				SecondaryCursor mySecCursor = sdb.openCursor(null,null);
				List<OValue> ret = new ArrayList<>(); 
				while (mySecCursor.getNext(secondaryKey, foundData, LockMode.READ_UNCOMMITTED) == OperationStatus.SUCCESS) {
//					retVal = mySecCursor.getNextDup(secondaryKey, foundData, LockMode.DEFAULT);
					OValue ov=ODBHelper.b2Value(foundData.getData());
					ret.add(ov);
				}
				return ConcurrentUtils.constantFuture(ret);
			} catch (Exception e) {
				log.debug("ODBError",e);
				return ConcurrentUtils.constantFuture(null);
			}
		} else {
			return ConcurrentUtils.constantFuture(null);
		}
	}

}

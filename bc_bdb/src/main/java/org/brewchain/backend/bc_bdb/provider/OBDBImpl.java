package org.brewchain.backend.bc_bdb.provider;

import java.util.concurrent.Future;

import org.apache.commons.lang3.concurrent.ConcurrentUtils;
import org.brewchain.bcapi.backend.ODBException;
import org.brewchain.bcapi.backend.ODBHelper;
import org.brewchain.bcapi.backend.ODBSupport;
import org.brewchain.bcapi.gens.Odb.OKey;
import org.brewchain.bcapi.gens.Odb.OPair;
import org.brewchain.bcapi.gens.Odb.OValue;

import com.google.protobuf.ByteString;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.LockMode;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import onight.tfw.ojpa.api.DomainDaoSupport;
import onight.tfw.ojpa.api.ServiceSpec;

@Slf4j
@Data
public class OBDBImpl implements ODBSupport, DomainDaoSupport {
	String domainName = "";
	private Database dbs;
	private boolean autoSync = true;

	public OBDBImpl(String domain, Database dbs) {
		this.domainName = domain;
		this.dbs = dbs;
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
		return null;
	}

	@Override
	public Future<OValue[]> batchCompareAndSwap(OKey[] arg0, OValue[] arg1, OValue[] arg2) throws ODBException {
		return null;
	}

	@Override
	public Future<OValue[]> batchDelete(OKey[] arg0) throws ODBException {
		return null;
	}

	@Override
	public Future<OValue[]> batchPuts(OKey[] arg0, OValue[] arg1) throws ODBException {
		return null;
	}

	@Override
	public Future<OValue> compareAndDelete(OKey arg0, OValue arg1) throws ODBException {
		return null;
	}

	@Override
	public Future<OValue> compareAndSwap(OKey arg0, OValue arg1, OValue arg2) throws ODBException {
		return null;
	}

	@Override
	public Future<OValue> delete(OKey arg0) throws ODBException {
		return null;
	}

	@Override
	public Future<OValue> get(OKey key) throws ODBException {
		DatabaseEntry searchEntry = new DatabaseEntry();
		dbs.get(null, new DatabaseEntry(key.toByteArray()), searchEntry, LockMode.DEFAULT);
		if (searchEntry.getData() == null) {
			return null;
		} else {
			OValue v = ODBHelper.b2Value(searchEntry.getData());
			return ConcurrentUtils.constantFuture(v);
		}
	}

	@Override
	public Future<OValue[]> list(OKey[] arg0) throws ODBException {
		return null;
	}

	@Override
	public Future<OValue> put(OKey key, OValue v) throws ODBException {
		DatabaseEntry keyValue = new DatabaseEntry(key.toByteArray());
		DatabaseEntry dataValue = new DatabaseEntry(ODBHelper.v2Bytes(v));
		dbs.put(null, keyValue, dataValue);
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

}

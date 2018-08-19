package org.brewchain.backend.bc_bdb.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.concurrent.ConcurrentUtils;
import org.brewchain.bcapi.backend.ODBException;
import org.brewchain.bcapi.backend.ODBSupport;
import org.brewchain.bcapi.gens.Oentity.OKey;
import org.brewchain.bcapi.gens.Oentity.OPair;
import org.brewchain.bcapi.gens.Oentity.OValue;

import com.google.protobuf.ByteString;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import onight.tfw.ojpa.api.DomainDaoSupport;
import onight.tfw.ojpa.api.ServiceSpec;

@Slf4j
@Data
public class SlicerOBDBImpl implements ODBSupport, DomainDaoSupport {
	String domainName = "";

	OBDBImpl odbs[];

	int sliceCount = 1;

	ScheduledExecutorService exec;

	public SlicerOBDBImpl(String domain, OBDBImpl odbs[], ScheduledExecutorService exec) {
		this.odbs = odbs;
		this.domainName = domain;
		this.sliceCount = odbs.length;
		this.exec = exec;
	}

	@Override
	public DomainDaoSupport getDaosupport() {
		if (odbs != null) {
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

	public void close() {
		for (OBDBImpl odb : odbs) {
			odb.close();
		}
	}

	public void sync() {
		for (OBDBImpl odb : odbs) {
			odb.sync();
		}
	}

	public int getSliceId(ByteString bs) {
		return Math.abs(bs.byteAt(0)) % sliceCount;
	}

	public int getSliceId(String bs) {
		byte[] bb = bs.getBytes();
		return Math.abs(bb[0]) % sliceCount;
	}

	@Override
	public ServiceSpec getServiceSpec() {
		return new ServiceSpec("obdb");
	}

	@Override
	public void setDaosupport(DomainDaoSupport dao) {
		log.trace("setDaosupport::dao=" + dao);
	}

	public OBDBImpl getDb(OKey key) {
		return odbs[getSliceId(key.getData())];
	}

	public OBDBImpl getDb(String key) {
		return odbs[getSliceId(key)];
	}

	class SlicePair {
		List<OKey> keys = new ArrayList<>();
		List<OValue> values = new ArrayList<>();
		List<OValue> newvalues = new ArrayList<>();
	}

	public SlicePair[] seperate(OKey[] keys, OValue[] values) {
		SlicePair[] kvs = new SlicePair[sliceCount];
		for (int i = 0; i < keys.length; i++) {
			int id = getSliceId(keys[i].getData());// (keys[i].getData().byteAt(0))
													// % sliceCount;
			SlicePair sp = kvs[id];
			if (sp == null) {
				sp = new SlicePair();
				kvs[id] = sp;
			}
			sp.keys.add(keys[i]);
			sp.values.add(values[i]);

		}
		return kvs;
	}

	public SlicePair[] seperate(OKey[] keys) {
		SlicePair[] kvs = new SlicePair[sliceCount];
		for (int i = 0; i < keys.length; i++) {
			int id = getSliceId(keys[i].getData());
			SlicePair sp = kvs[id];
			if (sp == null) {
				sp = new SlicePair();
				kvs[id] = sp;
			}
			sp.keys.add(keys[i]);
		}
		return kvs;
	}

	public SlicePair[] seperate(OKey[] keys, OValue[] values, OValue[] newvalues) {
		SlicePair[] kvs = new SlicePair[sliceCount];
		for (int i = 0; i < keys.length; i++) {
			int id = getSliceId(keys[i].getData());
			SlicePair sp = kvs[id];
			if (sp == null) {
				sp = new SlicePair();
				kvs[id] = sp;
			}
			sp.keys.add(keys[i]);
			sp.values.add(values[i]);
			sp.newvalues.add(newvalues[i]);

		}
		return kvs;
	}

	@Override
	public Future<OValue[]> batchCompareAndDelete(OKey[] keys, OValue[] values) throws ODBException {
		SlicePair[] kvs = seperate(keys, values);
		List<OValue> list = new ArrayList<OValue>();
		for (int i = 0; i < sliceCount; i++) {
			if (kvs[i] != null) {
				try {
					OValue[] ret = odbs[i].batchCompareAndDelete(kvs[i].keys.toArray(new OKey[] {}),
							kvs[i].values.toArray(new OValue[] {})).get();
					list.addAll(Arrays.asList(ret));
				} catch (Exception e) {
					throw new ODBException(e);
				}

			}
		}

		return ConcurrentUtils.constantFuture((OValue[]) list.toArray());
	}

	@Override
	public Future<OValue[]> batchCompareAndSwap(OKey[] keys, OValue[] compareValues, OValue[] newValues)
			throws ODBException {
		SlicePair[] kvs = seperate(keys, compareValues, newValues);
		List<OValue> list = new ArrayList<OValue>();
		for (int i = 0; i < sliceCount; i++) {
			if (kvs[i] != null) {
				try {
					OValue[] ret = odbs[i]
							.batchCompareAndSwap(kvs[i].keys.toArray(new OKey[] {}),
									kvs[i].values.toArray(new OValue[] {}), kvs[i].newvalues.toArray(new OValue[] {}))
							.get();
					list.addAll(Arrays.asList(ret));
				} catch (Exception e) {
					throw new ODBException(e);
				}

			}
		}

		return ConcurrentUtils.constantFuture((OValue[]) list.toArray());
	}

	@Override
	public Future<OValue[]> batchDelete(OKey[] keys) throws ODBException {
		SlicePair[] kvs = seperate(keys);
		for (int i = 0; i < sliceCount; i++) {
			if (kvs[i] != null) {
				try {
					OValue[] ret = odbs[i].batchDelete(kvs[i].keys.toArray(new OKey[] {})).get();
				} catch (Exception e) {
					throw new ODBException(e);
				}

			}
		}

		return ConcurrentUtils.constantFuture(null);
	}

	@AllArgsConstructor
	class BatchPutsRunner implements Runnable {
		OBDBImpl odb;

		OKey[] keys;
		OValue[] values;

		CountDownLatch cdl;

		@Override
		public void run() {
			try {
				odb.batchPuts(keys, values);
			} finally {
				cdl.countDown();
			}
		}
	}

	@AllArgsConstructor
	class BatchPutsIfNotExistRunner implements Runnable {
		OBDBImpl odb;

		OKey[] keys;
		OValue[] values;
		List<OValue> resultSet;
		CountDownLatch cdl;

		@Override
		public void run() {
			try {
				Future<OValue[]> f = odb.putIfNotExist(keys, values);
				if (f != null && f.get() != null) {
					for (OValue v : f.get()) {
						if (v != null) {
							resultSet.add(v);
						}
					}
				}
			} catch (Exception e) {
			} finally {
				cdl.countDown();
			}
		}
	}

	@Override
	public Future<OValue[]> batchPuts(OKey[] keys, OValue[] values) throws ODBException {
		SlicePair[] kvs = seperate(keys, values);
		CountDownLatch cdl = new CountDownLatch(sliceCount);
		for (int i = 0; i < sliceCount; i++) {
			if (kvs[i] != null) {
				if (kvs[i].keys.size() > 1) {
					try {
						exec.execute(new BatchPutsRunner(odbs[i], kvs[i].keys.toArray(new OKey[] {}),
								kvs[i].values.toArray(new OValue[] {}), cdl));
					} catch (Exception e) {
						throw new ODBException(e);
					}
				} else {
					odbs[i].put(kvs[i].keys.get(0), kvs[i].values.get(0));
					cdl.countDown();
				}
			} else {
				cdl.countDown();
			}
		}
		try {
			cdl.await(30, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new ODBException("Batch put TimeoutException");
		}
		return ConcurrentUtils.constantFuture(null);

	}

	@Override
	public Future<OValue> compareAndDelete(OKey key, OValue value) throws ODBException {
		return getDb(key).compareAndDelete(key, value);
	}

	@Override
	public Future<OValue> compareAndSwap(OKey key, OValue compareValue, OValue newValue) throws ODBException {
		return getDb(key).compareAndSwap(key, compareValue, newValue);
	}

	@Override
	public Future<OValue> delete(OKey key) throws ODBException {
		return getDb(key).delete(key);
	}

	@Override
	public Future<OValue> get(OKey key) throws ODBException {
		return getDb(key).get(key);
	}

	@Override
	public Future<OValue[]> list(OKey[] keys) throws ODBException {
		SlicePair[] kvs = seperate(keys);
		List<OValue> list = new ArrayList<OValue>();
		for (int i = 0; i < sliceCount; i++) {
			if (kvs[i] != null) {
				try {
					OValue[] ret = odbs[i].list(kvs[i].keys.toArray(new OKey[] {})).get();
					list.addAll(Arrays.asList(ret));
				} catch (Exception e) {
					throw new ODBException(e);
				}

			}
		}
		return ConcurrentUtils.constantFuture((OValue[]) list.toArray());
	}

	@Override
	public Future<OValue> put(OKey key, OValue v) throws ODBException {
		return getDb(key).put(key, v);
	}

	@Override
	public Future<byte[]> putData(String key, byte[] value) throws ODBException {
		return getDb(key).putData(key, value);
	}

	@Override
	public Future<String> putInfo(String key, String value) throws ODBException {
		return getDb(key).putInfo(key, value);
	}

	@Override
	public Future<OValue> get(String key) throws ODBException {
		return get(OKey.newBuilder().setData(ByteString.copyFrom(key.getBytes())).build());
	}

	@Override
	public Future<OValue> put(String key, OValue value) throws ODBException {
		return getDb(key).put(key, value);
	}

	@Override

	public Future<List<OPair>> listBySecondKey(String secondaryName) throws ODBException {
		List<OPair> ret = new ArrayList<>();
		for (int i = 0; i < sliceCount; i++) {
			try {
				Future<List<OPair>> subret = odbs[i].listBySecondKey(secondaryName);
				if (subret != null && subret.get() != null) {
					ret.addAll(subret.get());
				}
			} catch (Exception e) {
				throw new ODBException(e);
			}
		}
		return ConcurrentUtils.constantFuture(ret);
		// throw new RuntimeException("Not supported");
	}

	@Override
	public Future<List<OPair>> putBySecondKey(String arg0, OValue[] arg1) throws ODBException {
		throw new RuntimeException("Not supported");
	}

	@Override
	public Future<List<OPair>> removeBySecondKey(String secondaryName, OKey[] keys) throws ODBException {
		throw new RuntimeException("Not supported");
	}

	@Override
	public Future<OValue> putIfNotExist(OKey key, OValue v) throws ODBException {
		return getDb(key).putIfNotExist(key, v);
	}

	@Override
	public Future<OValue[]> putIfNotExist(OKey[] keys, OValue[] values) throws ODBException {
		SlicePair[] kvs = seperate(keys, values);
		CountDownLatch cdl = new CountDownLatch(sliceCount);
		List<OValue> ret = new ArrayList<>();
		for (int i = 0; i < sliceCount; i++) {
			if (kvs[i] != null) {
				if (kvs[i].keys.size() > 1) {
					try {
						exec.execute(new BatchPutsIfNotExistRunner(odbs[i], kvs[i].keys.toArray(new OKey[] {}),
								kvs[i].values.toArray(new OValue[] {}), ret, cdl));
					} catch (Exception e) {
						throw new ODBException(e);
					}
				} else {
					
					try {
						Future<OValue> v = odbs[i].putIfNotExist(kvs[i].keys.get(0), kvs[i].values.get(0));
						if (v != null && v.get() != null) {
							ret.add(v.get());
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					cdl.countDown();
				}
			} else {
				cdl.countDown();
			}
		}
		try {
			cdl.await(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new ODBException("Batch put TimeoutException");
		}
		return ConcurrentUtils.constantFuture(null);
	}

}

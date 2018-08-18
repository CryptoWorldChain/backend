package org.brewchain.backend.bc_bdb.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

import org.apache.commons.lang3.concurrent.ConcurrentUtils;
import org.brewchain.bcapi.backend.ODBException;
import org.brewchain.bcapi.gens.Oentity.OKey;
import org.brewchain.bcapi.gens.Oentity.OValue;

import com.sleepycat.je.Database;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeferOBDBImpl extends OBDBImpl implements Runnable {

	public ConcurrentHashMap<OKey, OValue> memoryMap = new ConcurrentHashMap<>();
	int maxSize = 100;
	long delayWriteMS = 200;

	public DeferOBDBImpl(int maxSize, long delayWriteMS, String domain, Database dbs, Database sdbs) {
		super(domain, dbs, sdbs);
		this.maxSize = maxSize;
		this.delayWriteMS = delayWriteMS;
	}

	public DeferOBDBImpl(int maxSize, long delayWriteMS, String domain, Database dbs) {
		super(domain, dbs);
		this.maxSize = maxSize;
		this.delayWriteMS = delayWriteMS;
	}

	@Override
	public synchronized Future<OValue[]> batchPuts(OKey[] keys, OValue[] values) throws ODBException {
		for (int i = 0; i < keys.length; i++) {
			memoryMap.put(keys[i], values[i]);
		}
		deferSync();
		return ConcurrentUtils.constantFuture(null);
	}

	long lastSyncTime = 0;

	public synchronized void deferSync() {
		if (memoryMap.size() > 0
				&& (memoryMap.size() >= maxSize || System.currentTimeMillis() - lastSyncTime > delayWriteMS)) {
			OKey[] keys = new OKey[memoryMap.size()];
			OValue[] values = new OValue[memoryMap.size()];
			int cc = 0;
			for (Map.Entry<OKey, OValue> entry : memoryMap.entrySet()) {
				keys[cc] = entry.getKey();
				values[cc] = entry.getValue();
				cc++;
			}
			super.batchPuts(keys, values);
			memoryMap.clear();
			lastSyncTime = System.currentTimeMillis();
		}
	}
	

	@Override
	public void close() {
		deferSync();
		super.close();
	}

	@Override
	public synchronized Future<OValue> put(OKey key, OValue v) throws ODBException {
		memoryMap.put(key, v);
		deferSync();
		return ConcurrentUtils.constantFuture(v);
	}

	@Override
	public synchronized Future<OValue> get(OKey key) throws ODBException {
		OValue ov = memoryMap.get(key);
		if (ov != null)
			return ConcurrentUtils.constantFuture(ov);
		return super.get(key);
	}

	public synchronized Future<OValue[]> list(OKey[] keys) throws ODBException {
		List<OValue> list = new ArrayList<OValue>();
		for (OKey key : keys) {
			Future<OValue> ov = get(key);
			try {
				if (ov != null && ov.get() != null) {
					list.add(ov.get());
				}
			} catch (Exception e) {

			}
		}
		return ConcurrentUtils.constantFuture((OValue[]) list.toArray());

	}

	@Override
	public void run() {
		deferSync();
	}

}

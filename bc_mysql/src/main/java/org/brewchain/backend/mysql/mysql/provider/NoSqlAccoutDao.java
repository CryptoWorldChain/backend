package org.brewchain.backend.mysql.mysql.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.concurrent.ConcurrentUtils;
import org.brewchain.backend.ordbgens.bc.dao.BCAccountDao;
import org.brewchain.backend.ordbgens.bc.entity.BCAccount;
import org.brewchain.backend.ordbgens.bc.entity.BCAccountExample;
import org.brewchain.bcapi.backend.ODBException;
import org.brewchain.bcapi.backend.ODBHelper;
import org.brewchain.bcapi.gens.Oentity.OKey;
import org.brewchain.bcapi.gens.Oentity.OPair;
import org.brewchain.bcapi.gens.Oentity.OValue;
import org.brewchain.evmapi.gens.Act.Account;

import com.google.protobuf.ByteString;

import onight.tfw.ojpa.api.DomainDaoSupport;

public class NoSqlAccoutDao extends ODBWrapper {
	BCAccountDao actDao;

	public NoSqlAccoutDao(DomainDaoSupport dds) {
		super(dds);
	}

	@Override
	public Future<OValue[]> batchCompareAndDelete(OKey[] arg0, OValue[] arg1) throws ODBException {
		throw new ODBException("unsupported");
	}

	@Override
	public Future<OValue[]> batchCompareAndSwap(OKey[] arg0, OValue[] arg1, OValue[] arg2) throws ODBException {
		throw new ODBException("unsupported");
	}

	public List<BCAccount> toORDBRecord(OKey[] keys) {
		List<BCAccount> records = new ArrayList<>();
		for (OKey key : keys) {
			BCAccount rec = new BCAccount();
			rec.setActAddress(Hex.encodeHexString(key.getData().toByteArray()));
			records.add(rec);
		}
		return records;
	}

	public BCAccount toORDBRecord(OKey key) {
		BCAccount rec = new BCAccount();
		rec.setActAddress(Hex.encodeHexString(key.getData().toByteArray()));
		return rec;
	}

	public BCAccount toORDBRecord(OKey key, OValue value) {
		BCAccount rec = new BCAccount();
		rec.setActAddress(Hex.encodeHexString(key.getData().toByteArray()));
		rec.setCodeHashHex(Hex.encodeHexString(key.getData().toByteArray()));
		rec.setStorageHex(value.getSecondKey());
		rec.setDataHex(Hex.encodeHexString(value.getExtdata().toByteArray()));
		return rec;
	}

	public List<BCAccount> toORDBRecord(OKey[] keys, OValue[] values) {
		List<BCAccount> records = new ArrayList<>();
		for (int i = 0; i < keys.length; i++) {
			records.add(toORDBRecord(keys[i], values[i]));
		}
		return records;
	}

	public OPair toPair(BCAccount rec) throws DecoderException {
		// BCAccount rec = (BCAccount) obj;
		OValue.Builder ov = OValue.newBuilder();
		if (rec.getStorageHex() != null) {
			ov.setSecondKey(rec.getStorageHex());
		}
		ov.setExtdata(ByteString.copyFrom(Hex.decodeHex(rec.getDataHex().toCharArray())));
		OKey.Builder ok = OKey.newBuilder();
		ok.setData(ByteString.copyFrom(Hex.decodeHex(rec.getActAddress().toCharArray())));
		return OPair.newBuilder().setKey(ok).setValue(ov).build();
	}

	@Override
	public Future<OValue[]> batchDelete(OKey[] keys) throws ODBException {
		try {
			actDao.batchDelete(toORDBRecord(keys));
		} catch (Exception e) {
			throw new ODBException(e);
		}
		return ConcurrentUtils.constantFuture(null);
	}

	@Override
	public Future<OValue[]> batchPuts(OKey[] keys, OValue[] values) throws ODBException {

		try {
			actDao.batchInsert(toORDBRecord(keys, values));
		} catch (Exception e) {
			throw new ODBException(e);
		}

		return ConcurrentUtils.constantFuture(null);

	}

	@Override
	public Future<OValue> compareAndDelete(OKey arg0, OValue arg1) throws ODBException {
		throw new ODBException("unsupported");
	}

	@Override
	public Future<OValue> compareAndSwap(OKey arg0, OValue arg1, OValue arg2) throws ODBException {
		throw new ODBException("unsupported");
	}

	@Override
	public Future<OValue> delete(OKey key) throws ODBException {
		try {
			actDao.deleteByPrimaryKey(toORDBRecord(key));
		} catch (Exception e) {
			throw new ODBException(e);
		}
		return ConcurrentUtils.constantFuture(null);

	}

	@Override
	public Future<OValue> get(OKey key) throws ODBException {
		try {
			BCAccount rec = actDao.selectByPrimaryKey(toORDBRecord(key));
			if (rec != null) {
				return ConcurrentUtils.constantFuture(toPair(rec).getValue());
			}
		} catch (Exception e) {
			throw new ODBException(e);
		}
		return null;
	}

	@Override
	public Future<OValue> get(String key) throws ODBException {
		try {
			BCAccount rec = actDao.selectByPrimaryKey(
					toORDBRecord(OKey.newBuilder().setData(ByteString.copyFrom(key.getBytes())).build()));
			if (rec != null) {
				return ConcurrentUtils.constantFuture(toPair(rec).getValue());
			}
		} catch (Exception e) {
			throw new ODBException(e);
		}
		return null;
	}

	@Override
	public Future<OValue[]> list(OKey[] keys) throws ODBException {
		List<OValue> list = new ArrayList<OValue>();
		try {
			for (OKey key : keys) {
				Future<OValue> ov = get(key);
				if (ov != null && ov.get() != null) {
					list.add(ov.get());
				}
			}
		} catch (Exception e) {
			throw new ODBException(e);
		}
		return ConcurrentUtils.constantFuture((OValue[]) list.toArray());
	}

	@Override
	public Future<List<OPair>> listBySecondKey(String seckey) throws ODBException {
		BCAccountExample example = new BCAccountExample();
		List<OPair> ret = new ArrayList<OPair>();

		example.createCriteria().andStorageHexEqualTo(seckey);
		List<BCAccount> records = actDao.selectByExample(example);
		if (ret != null) {
			try {
				for (BCAccount rec : records) {
					ret.add(toPair(rec));
				}
			} catch (Exception e) {
				throw new ODBException(e);
			}
		}
		return ConcurrentUtils.constantFuture(ret);
	}

	@Override
	public Future<OValue> put(OKey key, OValue value) throws ODBException {
		try {
			actDao.insertSelective(toORDBRecord(key, value));
		} catch (Exception e) {
			throw new ODBException(e);
		}
		return ConcurrentUtils.constantFuture(value);
	}

	@Override
	public Future<OValue> put(String key, OValue value) throws ODBException {
		return put(OKey.newBuilder().setData(ByteString.copyFrom(key.getBytes())).build(), value);
	}

	@Override
	public Future<List<OPair>> putBySecondKey(String arg0, OValue[] arg1) throws ODBException {
		throw new ODBException("Not supported");
	}

	@Override
	public Future<byte[]> putData(String key, byte[] value) throws ODBException {
		put(OKey.newBuilder().setData(ByteString.copyFrom(key.getBytes())).build(),
				OValue.newBuilder().setExtdata(ByteString.copyFrom(value)).build());
		return ConcurrentUtils.constantFuture(value);
	}

	@Override
	public Future<OValue> putIfNotExist(OKey key, OValue value) throws ODBException {
		try {
			actDao.insertSelective(toORDBRecord(key, value));
		} catch (Exception e) {
			return ConcurrentUtils.constantFuture(null);
		}
		return ConcurrentUtils.constantFuture(value);

	}

	@Override
	public Future<OValue[]> putIfNotExist(OKey[] keys, OValue[] values) throws ODBException {
		List<OValue> ret = new ArrayList<>();
		for (int i = 0; i < keys.length; i++) {
			try {
				actDao.insertSelective(toORDBRecord(keys[i], values[i]));
				ret.add(values[i]);
			} catch (Exception e) {

			}
		}
		return ConcurrentUtils.constantFuture(ret.toArray(new OValue[] {}));
	}

	@Override
	public Future<String> putInfo(String key, String value) throws ODBException {
		put(OKey.newBuilder().setData(ByteString.copyFrom(key.getBytes())).build(),
				OValue.newBuilder().setInfo(value).build());
		return ConcurrentUtils.constantFuture(value);
	}

	@Override
	public Future<List<OPair>> removeBySecondKey(String seckey, OKey[] arg1) throws ODBException {
		try {
			BCAccountExample example = new BCAccountExample();
			example.createCriteria().andStorageHexEqualTo(seckey);
			actDao.deleteByExample(example);
		} catch (Exception e) {
			throw new ODBException(e);
		}
		return ConcurrentUtils.constantFuture(null);

		
	}

	@Override
	public void sync() throws ODBException {
		// TODO Auto-generated method stub

	}

}

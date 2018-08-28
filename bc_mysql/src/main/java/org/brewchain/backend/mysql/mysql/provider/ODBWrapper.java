package org.brewchain.backend.mysql.mysql.provider;

import java.util.List;
import java.util.concurrent.Future;

import org.brewchain.bcapi.backend.ODBException;
import org.brewchain.bcapi.backend.ODBSupport;
import org.brewchain.bcapi.gens.Oentity.OKey;
import org.brewchain.bcapi.gens.Oentity.OPair;
import org.brewchain.bcapi.gens.Oentity.OValue;

import lombok.AllArgsConstructor;
import onight.tfw.ojpa.api.DomainDaoSupport;
import onight.tfw.ojpa.api.ServiceSpec;


@AllArgsConstructor
public class ODBWrapper implements ODBSupport {

	DomainDaoSupport dds;
	@Override
	public DomainDaoSupport getDaosupport() {
		return dds;
	}

	@Override
	public Class<?> getDomainClazz() {
		return dds.getDomainClazz();
	}

	@Override
	public String getDomainName() {
		return dds.getDomainName();
	}

	@Override
	public ServiceSpec getServiceSpec() {
		return dds.getServiceSpec();
	}

	@Override
	public void setDaosupport(DomainDaoSupport dds) {
		this.dds = dds;
	}

	@Override
	public Future<OValue[]> batchCompareAndDelete(OKey[] arg0, OValue[] arg1) throws ODBException {
		return null;
	}

	@Override
	public Future<OValue[]> batchCompareAndSwap(OKey[] arg0, OValue[] arg1, OValue[] arg2) throws ODBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<OValue[]> batchDelete(OKey[] arg0) throws ODBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<OValue[]> batchPuts(OKey[] arg0, OValue[] arg1) throws ODBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<OValue> compareAndDelete(OKey arg0, OValue arg1) throws ODBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<OValue> compareAndSwap(OKey arg0, OValue arg1, OValue arg2) throws ODBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<OValue> delete(OKey arg0) throws ODBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<OValue> get(OKey arg0) throws ODBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<OValue> get(String arg0) throws ODBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<OValue[]> list(OKey[] arg0) throws ODBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<List<OPair>> listBySecondKey(String arg0) throws ODBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<OValue> put(OKey arg0, OValue arg1) throws ODBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<OValue> put(String arg0, OValue arg1) throws ODBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<List<OPair>> putBySecondKey(String arg0, OValue[] arg1) throws ODBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<byte[]> putData(String arg0, byte[] arg1) throws ODBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<OValue> putIfNotExist(OKey arg0, OValue arg1) throws ODBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<OValue[]> putIfNotExist(OKey[] arg0, OValue[] arg1) throws ODBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<String> putInfo(String arg0, String arg1) throws ODBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<List<OPair>> removeBySecondKey(String arg0, OKey[] arg1) throws ODBException {
		return null;
	}

	@Override
	public void sync() throws ODBException {
		
	}

}

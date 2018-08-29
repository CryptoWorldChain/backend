package org.brewchain.backend.dbsync;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;
import org.brewchain.account.core.AccountHelper;
import org.brewchain.account.core.BlockChainHelper;
import org.brewchain.account.core.BlockHelper;
import org.brewchain.account.core.TransactionHelper;
import org.brewchain.backend.ordbgens.bc.entity.BCAccount;
import org.brewchain.backend.ordbgens.bc.entity.BCActAddress;
import org.brewchain.backend.ordbgens.bc.entity.BCBlock;
import org.brewchain.backend.ordbgens.bc.entity.BCMtxInput;
import org.brewchain.backend.ordbgens.bc.entity.BCMtxOutput;
import org.brewchain.backend.ordbgens.bc.entity.BCMtxSignature;
import org.brewchain.backend.ordbgens.bc.entity.BCMutilTransacton;
import org.fc.brewchain.bcapi.EncAPI;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import onight.osgi.annotation.iPojoBean;
import onight.tfw.ntrans.api.ActorService;
import onight.tfw.ntrans.api.annotation.ActorRequire;
import onight.tfw.ojpa.api.DomainDaoSupport;
import onight.tfw.ojpa.api.IJPAClient;
import onight.tfw.ojpa.api.OJpaDAO;
import onight.tfw.ojpa.api.annotations.StoreDAO;

@iPojoBean
@Provides(specifications = { IJPAClient.class, ActorService.class }, strategy = "SINGLETON")
@Slf4j
@Instantiate(name = "dbsync.daos")
@Component
@Data
public class Daos implements ActorService, IJPAClient {

	@StoreDAO
	public OJpaDAO<BCAccount> bcAccountDao;

	@StoreDAO
	public OJpaDAO<BCBlock> bcBlockDao;

	@StoreDAO
	public OJpaDAO<BCMutilTransacton> bcMultiTransactionDao;

	@StoreDAO
	public OJpaDAO<BCActAddress> bcActAddressDao;

	@StoreDAO
	public OJpaDAO<BCMtxInput> bcMtxInputDao;

	@StoreDAO
	public OJpaDAO<BCMtxOutput> bcMtxOutputDao;

	@StoreDAO
	public OJpaDAO<BCMtxSignature> bcMtxSignDao;

	@ActorRequire(name = "BlockChain_Helper", scope = "global")
	BlockChainHelper bcHelper = null;

	@ActorRequire(name = "Block_Helper", scope = "global")
	BlockHelper blkHelper = null;

	@ActorRequire(name = "Transaction_Helper", scope = "global")
	TransactionHelper txHelper = null;

	@ActorRequire(name = "Account_Helper", scope = "global")
	AccountHelper accountHelper = null; 
	@ActorRequire(name = "bc_encoder", scope = "global") // @BeanProperty
	EncAPI enc = null;

	public boolean running = true;

	public boolean ready = false;

	@Override
	public void onDaoServiceAllReady() {
		log.debug("AllDao Ready........:sysParamsDao=");
	}

	@Override
	public void onDaoServiceReady(DomainDaoSupport dds) {
		log.debug("onDaoServiceReady:" + dds);
		ready = true;
	}
}

package org.brewchain.backend.dbsync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.brewchain.account.util.ByteUtil;
import org.brewchain.backend.ordbgens.bc.entity.BCAccount;
import org.brewchain.backend.ordbgens.bc.entity.BCBlock;
import org.brewchain.backend.ordbgens.bc.entity.BCMtxInput;
import org.brewchain.backend.ordbgens.bc.entity.BCMtxOutput;
import org.brewchain.backend.ordbgens.bc.entity.BCMutilTransacton;
import org.brewchain.dposblk.pbgens.Dposblock.PRetCoinbase;
import org.brewchain.dposblk.pbgens.Dposblock.PRetCoinbase.CoinbaseResult;
import org.brewchain.dposblk.pbgens.Dposblock.PSCoinbase;
import org.brewchain.evmapi.gens.Act.Account;
import org.brewchain.evmapi.gens.Block.BlockEntity;
import org.brewchain.evmapi.gens.Block.BlockHeader;
import org.brewchain.evmapi.gens.Tx.MultiTransaction;
import org.brewchain.evmapi.gens.Tx.MultiTransactionInput;
import org.brewchain.evmapi.gens.Tx.MultiTransactionOutput;

import com.google.protobuf.ByteString;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import onight.tfw.ojpa.api.OJpaDAO;
import onight.tfw.otransio.api.PackHeader;
import onight.tfw.otransio.api.beans.FramePacket;

@AllArgsConstructor
@Slf4j
public class ProcDOB implements CMDProc {

	public static String DOB_RESULT_OK = PackHeader.EXT_IGNORE + "__DOB_RET";

	public void onComplete(Daos dao, FramePacket pack) {
		try {
			if (pack != null && pack.getFbody() != null) {
				PRetCoinbase retbody = (PRetCoinbase) pack.getFbody();
				if (retbody.getResult() == CoinbaseResult.CR_PROVEN) {
					pack.putHeader(DOB_RESULT_OK, "1");
				}
			}
		} catch (Exception e) {
			log.debug("error in dob:" + e.getMessage(), e);
		}
	}

	public BCBlock getDBBlock(BlockEntity block) {
		BCBlock dbblock = new BCBlock();
		dbblock.setBhBlockHash(block.getHeader().getBlockHash());
		dbblock.setBhExtradata(block.getHeader().getExtraData());
		dbblock.setBhNumber(new BigDecimal(block.getHeader().getNumber()));
		dbblock.setBhParentHash(block.getHeader().getParentHash());
		dbblock.setBhReceiptTrieroot(block.getHeader().getReceiptTrieRoot());
		dbblock.setBhSliceid((int) block.getHeader().getSliceId());
		dbblock.setBhStateRoot(block.getHeader().getStateRoot());
		dbblock.setBhTimestamp(new BigDecimal(block.getHeader().getTimestamp()));
		dbblock.setBhTxnCount(block.getHeader().getTxHashsCount());
		dbblock.setBhTxtRieroot(block.getHeader().getTxTrieRoot());
		dbblock.setBlockStatus("1");
		dbblock.setBmAddress(block.getMiner().getAddress());
		dbblock.setBmBcuid(block.getMiner().getBcuid());
		dbblock.setBmNode(block.getMiner().getNode());
		dbblock.setBmRewardHex(Hex.encodeHexString(block.getMiner().getReward().toByteArray()));
		dbblock.setBversion(String.valueOf(block.getVersion()));
		dbblock.setCreateTime(new Date());
		dbblock.setLogUuid(block.getHeader().getBlockHash());
		dbblock.setSecondIdx(String.valueOf(block.getHeader().getNumber()));
		return dbblock;
	}

	public void fillInputs(MultiTransaction tx, List<Object> mtxInputs, List<String> accountAddress) {
		int i = 0;
		for (MultiTransactionInput input : tx.getTxBody().getInputsList()) {
			BCMtxInput bean = new BCMtxInput();
			bean.setAmount(new BigDecimal(ByteUtil.bytesToBigInteger(input.getAmount().toByteArray())));
			String addr = Hex.encodeHexString(input.getAddress().toByteArray());
			bean.setBcAddress(addr);
			accountAddress.add(addr);
			bean.setBcNonce(input.getNonce());
			bean.setCreateTime(new Date());
			bean.setCryptoTokenHex(Hex.encodeHexString(input.getCryptoToken().toByteArray()));
			bean.setIndexInTx(i);
			bean.setMtxHash(tx.getTxHash());
			bean.setMtxInputid(tx.getTxHash() + "-i-" + i);
			bean.setTokenId(input.getToken());
			bean.setTokenSymbol(input.getSymbol());
			bean.setTxStatus(tx.getStatus());
			mtxInputs.add(bean);
			i++;
		}
	}

	public void fillOutputs(MultiTransaction tx, List<Object> mtxOutputs, List<String> accountAddress) {
		int i = 0;
		for (MultiTransactionOutput output : tx.getTxBody().getOutputsList()) {
			BCMtxOutput bean = new BCMtxOutput();
			bean.setAmount(new BigDecimal(ByteUtil.bytesToBigInteger(output.getAmount().toByteArray())));
			String addr = Hex.encodeHexString(output.getAddress().toByteArray());
			bean.setBcAddress(addr);
			accountAddress.add(addr);
			bean.setCreateTime(new Date());
			bean.setMtxOutputid(tx.getTxHash() + "-o-" + i);
			bean.setIndexInTx(i);
			bean.setMtxHash(tx.getTxHash());
			bean.setTokenSymbol(output.getSymbol());
			bean.setTxStatus(tx.getStatus());
			mtxOutputs.add(bean);
			i++;
		}
	}

	public List<Object> getMultiTx(Daos dao, BlockEntity block, List<Object> mtxInputs, List<Object> mtxOutputs,
			List<String> accountAddress) {

		List<Object> txs = new ArrayList<>();
		int i = 0;
		for (String txHash : block.getHeader().getTxHashsList()) {
			MultiTransaction tx = null;
			try {
				tx = dao.getTxHelper().GetTransaction(txHash);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BCMutilTransacton trx = new BCMutilTransacton();
			trx.setBlockHeight(new BigDecimal(block.getHeader().getNumber()));
			trx.setBversion(String.valueOf(block.getVersion()));
			trx.setCreateTime(new Date());

			if (tx != null) {
				fillOutputs(tx, mtxOutputs, accountAddress);
				fillInputs(tx, mtxInputs, accountAddress);
				trx.setData(Hex.encodeHexString(tx.getTxBody().getData().toByteArray()));
				trx.setExtraData(Hex.encodeHexString(tx.getTxBody().getExdata().toByteArray()));
				trx.setTxTimestamp(new BigDecimal(tx.getTxBody().getTimestamp()));
				trx.setTxType(tx.getTxBody().getType());
				trx.setTxStatus(tx.getStatus());
				trx.setResultsHex(Hex.encodeHexString(tx.getResult().toByteArray()));
			}
			//
			trx.setHashMerkleRoot(block.getHeader().getTxTrieRoot());
			trx.setIndexInBlock(i);
			trx.setPropCount(trx.getPropCount());
			trx.setTxHash(txHash);
			trx.setTxStatus("1");
			txs.add(trx);
			i++;
		}
		return txs;
	}

	public BCMutilTransacton getCoinBase(BlockEntity block) {
		// coinbase
		BCMutilTransacton trx = new BCMutilTransacton();
		trx.setAddressInCount(0);
		trx.setAddressOutCount(1);
		trx.setBlockHeight(new BigDecimal(block.getHeader().getNumber()));
		trx.setBversion(String.valueOf(block.getVersion()));
		trx.setCreateTime(new Date());
		trx.setData(trx.getData());
		trx.setExtraData(trx.getExtraData());
		trx.setHashMerkleRoot(block.getHeader().getTxTrieRoot());
		trx.setIndexInBlock(0);
		trx.setPropCount(trx.getPropCount());
		trx.setResultsHex(trx.getResultsHex());
		trx.setTxHash(block.getHeader().getBlockHash());
		trx.setTxStatus("1");
		trx.setTxTimestamp(new BigDecimal(block.getHeader().getTimestamp()));
		trx.setTxType(8888);
		return trx;
	}

	@Override
	public void postRoute(Daos dao, FramePacket pack) {
		if ("1".equals(pack.getExtProp(DOB_RESULT_OK))) {
			try {
				PSCoinbase coinbase = (PSCoinbase) pack.getFbody();
				BlockEntity block = BlockEntity.parseFrom(coinbase.getBlockEntry().getBlockHeader());
				BlockHeader header = block.getHeader();
				log.debug("insert block:" + block.getHeader().getBlockHash() + ",txcounts=" + header.getTxHashsCount());
				try {
					dao.getBcBlockDao().insertSelective(getDBBlock(block));
				} catch (Exception e) {
					dao.getBcBlockDao().updateByPrimaryKeySelective(getDBBlock(block));
				}
				List<Object> mtxInputs = new ArrayList<>();
				List<Object> mtxOutputs = new ArrayList<>();
				List<String> accountAddress = new ArrayList<>();
				Object coinbasetx = getCoinBase(block);
				try {
					dao.getBcMultiTransactionDao().insertSelective(coinbasetx);
				} catch (Exception e) {
					dao.getBcMultiTransactionDao().updateByPrimaryKeySelective(coinbasetx);
				}

				accountAddress.add(block.getMiner().getAddress());

				List<Object> txs = getMultiTx(dao, block, mtxInputs, mtxOutputs, accountAddress);
				if (txs != null && txs.size() > 0) {
					try {
						int i = dao.getBcMultiTransactionDao().batchInsert(txs);
						if (i < txs.size()) {
							tryUpdateOrInsert(dao.getBcMultiTransactionDao(), txs);
						}
					} catch (Exception e) {
					}
					try {
						dao.getBcMtxInputDao().batchInsert(mtxInputs);
					} catch (Exception e) {
					}
					try {
						dao.getBcMtxOutputDao().batchInsert(mtxOutputs);
					} catch (Exception e) {
					}
				}
				updateAccount(dao, accountAddress);

			} catch (Exception e) {
				log.error("error in mindob process:" + e.getMessage(), e);
			}
		}
	}

	public BCAccount getAccountDb(String addr, Account.Builder ab) {
		BCAccount bean = new BCAccount();
		bean.setActAddress(addr);
		bean.setActBalance(new BigDecimal(ByteUtil.bytesToBigInteger(ab.getValue().getBalance().toByteArray())));
		bean.setActAcceptLimit(new BigDecimal(ab.getValue().getAcceptLimit()));
		bean.setActAcceptMax(new BigDecimal(ByteUtil.bytesToBigInteger(ab.getValue().getAcceptMax().toByteArray())));
		bean.setActMax(new BigDecimal(ByteUtil.bytesToBigInteger(ab.getValue().getMax().toByteArray())));
		bean.setActNonce(ab.getValue().getNonce());
		bean.setActStatus("0");
		bean.setCodeHashHex(Hex.encodeHexString(ab.getValue().getCodeHash().toByteArray()));
		bean.setCodeHex(Hex.encodeHexString(ab.getValue().getCode().toByteArray()));
		bean.setCreateTime(new Date());
		bean.setDataHex(Hex.encodeHexString(ab.getValue().getData().toByteArray()));
		bean.setStorageHex(Hex.encodeHexString(ab.getValue().getStorage().toByteArray()));
		bean.setUpdateTime(new Date());
		return bean;
	}

	public void updateAccount(Daos dao, List<String> accounts) {
		HashMap<String, Object> actMaps = new HashMap<>();
		List<Object> records = new ArrayList<>();
		for (String account : accounts) {
			try {
				if (!actMaps.containsKey(account)) {
					Account.Builder ab = dao.getAccountHelper()
							.GetAccount(ByteString.copyFrom(Hex.decodeHex(account.toCharArray())));
					if (ab != null) {
						Object dbact = getAccountDb(account, ab);
						actMaps.put(account, dbact);
						records.add(dbact);
					}
				}
			} catch (DecoderException e) {
				log.error("cannot decode Account:" + account);
			}
		}
		try {
			int s = dao.getBcAccountDao().batchUpdate(records);
			log.debug("get update account result size=" + s);
			if (s < records.size()) {
				tryUpdateOrInsert(dao.getBcAccountDao(), records);
			}
		} catch (Exception e) {
		}
	}

	public void tryUpdateOrInsert(OJpaDAO dao, List<Object> txs) {
		for (Object obj : txs) {
			try {
				dao.insertSelective(obj);
			} catch (Exception e1) {
				dao.updateByPrimaryKeySelective(obj);
			}
		}
	}
}

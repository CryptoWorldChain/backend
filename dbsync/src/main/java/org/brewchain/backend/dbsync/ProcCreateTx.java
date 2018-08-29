package org.brewchain.backend.dbsync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Hex;
import org.brewchain.backend.ordbgens.bc.entity.BCBlock;
import org.brewchain.backend.ordbgens.bc.entity.BCMutilTransacton;
import org.brewchain.dposblk.pbgens.Dposblock.PRetCoinbase;
import org.brewchain.dposblk.pbgens.Dposblock.PRetCoinbase.CoinbaseResult;
import org.brewchain.dposblk.pbgens.Dposblock.PSCoinbase;
import org.brewchain.evmapi.gens.Block.BlockEntity;
import org.brewchain.evmapi.gens.Block.BlockHeader;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import onight.tfw.otransio.api.PackHeader;
import onight.tfw.otransio.api.beans.FramePacket;

@AllArgsConstructor
@Slf4j
public class ProcCreateTx implements CMDProc {

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

	public List<Object> getMultiTx(BlockEntity block) {

		List<Object> txs = new ArrayList<>();
		int i = 0;
		for (String txHash : block.getHeader().getTxHashsList()) {
			BCMutilTransacton trx = new BCMutilTransacton();
			trx.setBlockHeight(new BigDecimal(block.getHeader().getNumber()));
			trx.setBversion(String.valueOf(block.getVersion()));
			// trx.setCreateTime(new Date());
			// trx.setData(trx.getData());
			// trx.setExtraData(trx.getExtraData());
			trx.setHashMerkleRoot(trx.getHashMerkleRoot());
			trx.setIndexInBlock(i);
			trx.setPropCount(trx.getPropCount());
			// trx.setResultsHex(Hex.encodeHexString(tx.getResult().toByteArray()));
			trx.setTxHash(txHash);
			trx.setTxStatus("1");
			// trx.setTxTimestamp(new
			// BigDecimal(tx.getTxBody().getTimestamp()));
			// trx.setTxType(tx.getTxBody().getType());
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
		trx.setHashMerkleRoot(
				trx.getHashMerkleRoot() == null ? block.getHeader().getTxTrieRoot() : trx.getHashMerkleRoot());
		trx.setIndexInBlock(0);
		trx.setPropCount(trx.getPropCount());
		trx.setResultsHex(trx.getResultsHex());
		trx.setTxHash(trx.getTxHash() == null ? block.getHeader().getBlockHash() : trx.getTxHash());
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
				List<Object> txs = getMultiTx(block);
				try {
					int i = dao.getBcMultiTransactionDao().batchUpdate(txs);
					if(i<txs.size()){
						tryInsert(dao, txs);
					}
				} catch (Exception e) {
				}
				Object coinbasetx = getCoinBase(block);
				try {
					dao.getBcMultiTransactionDao().insertSelective(coinbasetx);
				} catch (Exception e) {
					dao.getBcMultiTransactionDao().updateByPrimaryKeySelective(coinbasetx);
				}
			} catch (Exception e) {
				log.error("error in mindob process:" + e.getMessage(), e);
			}
		}
	}

	public void tryInsert(Daos dao, List<Object> txs) {
		for (Object obj : txs) {
			try {
				dao.getBcMultiTransactionDao().insertSelective(obj);
			} catch (Exception e1) {
				dao.getBcMultiTransactionDao().updateByPrimaryKeySelective(obj);
			}
		}
	}
}

package org.brewchain.backend.ordbgens.bc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.transaction.annotation.Transactional;

import org.brewchain.backend.ordbgens.bc.entity.BCBlock;
import org.brewchain.backend.ordbgens.bc.entity.BCBlockExample;
import org.brewchain.backend.ordbgens.bc.entity.BCBlockExample.Criteria;
import org.brewchain.backend.ordbgens.bc.entity.BCBlockKey;
import org.brewchain.backend.ordbgens.bc.mapper.BCBlockMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;
import onight.tfw.mservice.ThreadContext;


@Data
@EqualsAndHashCode(callSuper=false)
@Tab(name="BC_BLOCK")
public class BCBlockDao extends ExtendDaoSupper<BCBlock, BCBlockExample, BCBlockKey>{

	private BCBlockMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(BCBlockExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BCBlockExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BCBlockKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BCBlock record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BCBlock record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<BCBlock> records) throws Exception
			 {
		for(BCBlock record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<BCBlock> records) throws Exception
			 {
		for(BCBlock record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BCBlock> selectByExample(BCBlockExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public BCBlock selectByPrimaryKey(BCBlockKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BCBlock> findAll(List<BCBlock> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new BCBlockExample());
		}
		List<BCBlock> list = new ArrayList<>();
		for(BCBlock record : records){
			BCBlock result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BCBlock record, BCBlockExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BCBlock record, BCBlockExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BCBlock record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BCBlock record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BCBlockExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new BCBlockExample());
	}

	@Override
	public BCBlockExample getExample(BCBlock record) {
		BCBlockExample example = new BCBlockExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getLogUuid()!=null){
				criteria.andLogUuidEqualTo(record.getLogUuid());
				}
				if(record.getBversion()!=null){
				criteria.andBversionEqualTo(record.getBversion());
				}
				if(record.getSecondIdx()!=null){
				criteria.andSecondIdxEqualTo(record.getSecondIdx());
				}
				if(record.getBhParentHash()!=null){
				criteria.andBhParentHashEqualTo(record.getBhParentHash());
				}
				if(record.getBhStateRoot()!=null){
				criteria.andBhStateRootEqualTo(record.getBhStateRoot());
				}
				if(record.getBhBlockHash()!=null){
				criteria.andBhBlockHashEqualTo(record.getBhBlockHash());
				}
				if(record.getBhTxtRieroot()!=null){
				criteria.andBhTxtRierootEqualTo(record.getBhTxtRieroot());
				}
				if(record.getBhReceiptTrieroot()!=null){
				criteria.andBhReceiptTrierootEqualTo(record.getBhReceiptTrieroot());
				}
				if(record.getBhTimestamp()!=null){
				criteria.andBhTimestampEqualTo(record.getBhTimestamp());
				}
				if(record.getBhNumber()!=null){
				criteria.andBhNumberEqualTo(record.getBhNumber());
				}
				if(record.getBhTxnCount()!=null){
				criteria.andBhTxnCountEqualTo(record.getBhTxnCount());
				}
				if(record.getBhSliceid()!=null){
				criteria.andBhSliceidEqualTo(record.getBhSliceid());
				}
				if(record.getBhExtradata()!=null){
				criteria.andBhExtradataEqualTo(record.getBhExtradata());
				}
				if(record.getBmNode()!=null){
				criteria.andBmNodeEqualTo(record.getBmNode());
				}
				if(record.getBmRewardHex()!=null){
				criteria.andBmRewardHexEqualTo(record.getBmRewardHex());
				}
				if(record.getBmAddress()!=null){
				criteria.andBmAddressEqualTo(record.getBmAddress());
				}
				if(record.getBmBcuid()!=null){
				criteria.andBmBcuidEqualTo(record.getBmBcuid());
				}
				if(record.getBlockStatus()!=null){
				criteria.andBlockStatusEqualTo(record.getBlockStatus());
				}
				if(record.getCreateTime()!=null){
				criteria.andCreateTimeEqualTo(record.getCreateTime());
				}
				if(record.getUpdateTime()!=null){
				criteria.andUpdateTimeEqualTo(record.getUpdateTime());
				}

		}
		return example;
	}
	
	public BCBlock selectOneByExample(BCBlockExample example)
			 {
		example.setLimit(1);
		List<BCBlock> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<BCBlock> records) throws Exception {
		if(records.size()<=0)return 0;
		
		Connection txconn = (Connection) ThreadContext.getContext("__connection");
		Connection conn = txconn;
		SqlSession session = null;
		if (txconn == null) {
			session = sqlSessionFactory.openSession();
			conn = session.getConnection();
		}
		Statement st = null;

		int result=0;
		try {
			if (txconn == null) {
				conn.setAutoCommit(false);
			}		
			StringBuffer sb=new StringBuffer();
			sb.append("INSERT INTO BC_BLOCK(LOG_UUID,BVERSION,SECOND_IDX,BH_PARENT_HASH,BH_STATE_ROOT,BH_BLOCK_HASH,BH_TXT_RIEROOT,BH_RECEIPT_TRIEROOT,BH_TIMESTAMP,BH_NUMBER,BH_TXN_COUNT,BH_SLICEID,BH_EXTRADATA,BM_NODE,BM_REWARD_HEX,BM_ADDRESS,BM_BCUID,BLOCK_STATUS,CREATE_TIME,UPDATE_TIME) values");
			
				int i=0;
				st = conn.createStatement();
				for (BCBlock record : records) {
					if(i>0){
						sb.append(",");
					}
					i++;
				
			
				sb.append("(");
			
				if(record.getLogUuid()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLogUuid()+"'");
				}
			
				sb.append(",");
			
				if(record.getBversion()==null){
//						sb.append("'"+"CEBPOC"+"'");
						sb.append("'"+"CEBPOC"+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getBversion()+"'");
				}
			
				sb.append(",");
			
				if(record.getSecondIdx()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getSecondIdx()+"'");
				}
			
				sb.append(",");
			
				if(record.getBhParentHash()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getBhParentHash()+"'");
				}
			
				sb.append(",");
			
				if(record.getBhStateRoot()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getBhStateRoot()+"'");
				}
			
				sb.append(",");
			
				if(record.getBhBlockHash()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getBhBlockHash()+"'");
				}
			
				sb.append(",");
			
				if(record.getBhTxtRieroot()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getBhTxtRieroot()+"'");
				}
			
				sb.append(",");
			
				if(record.getBhReceiptTrieroot()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getBhReceiptTrieroot()+"'");
				}
			
				sb.append(",");
			
				if(record.getBhTimestamp()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getBhTimestamp()+"'");
				}
			
				sb.append(",");
			
				if(record.getBhNumber()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getBhNumber()+"'");
				}
			
				sb.append(",");
			
				if(record.getBhTxnCount()==null){
//						sb.append("'"+"0"+"'");
						sb.append("'"+"0"+"'");
						
				}else{
				// java type==Integer
						sb.append("'"+record.getBhTxnCount()+"'");
				}
			
				sb.append(",");
			
				if(record.getBhSliceid()==null){
//						sb.append("'"+"0"+"'");
						sb.append("'"+"0"+"'");
						
				}else{
				// java type==Integer
						sb.append("'"+record.getBhSliceid()+"'");
				}
			
				sb.append(",");
			
				if(record.getBhExtradata()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getBhExtradata()+"'");
				}
			
				sb.append(",");
			
				if(record.getBmNode()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getBmNode()+"'");
				}
			
				sb.append(",");
			
				if(record.getBmRewardHex()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getBmRewardHex()+"'");
				}
			
				sb.append(",");
			
				if(record.getBmAddress()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getBmAddress()+"'");
				}
			
				sb.append(",");
			
				if(record.getBmBcuid()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getBmBcuid()+"'");
				}
			
				sb.append(",");
			
				if(record.getBlockStatus()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getBlockStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getCreateTime()==null){
//						sb.append("'"+"CURRENT_TIMESTAMP"+"'");
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(new java.util.Date())+"'");
						
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getCreateTime())+"'");
				}
			
				sb.append(",");
			
				if(record.getUpdateTime()==null){
						sb.append("null");
				}else{
				// java type==Date
					    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
						sb.append("'"+sdf.format(record.getUpdateTime())+"'");
				}
							sb.append(")");
			
			}
						result=st.executeUpdate(sb.toString());


			if (txconn == null) {
				conn.commit();
			}
		} catch (SQLException e) {
			if (txconn == null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			throw e;
		}finally{
			if(st!=null){
				try {
					st.close();
				} catch (Exception est) {
					est.printStackTrace();
				}
			}
			if(session!=null)session.close();
		}
		return result;
	}
	
	
}

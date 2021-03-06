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

import org.brewchain.backend.ordbgens.bc.entity.BCTransacton;
import org.brewchain.backend.ordbgens.bc.entity.BCTransactonExample;
import org.brewchain.backend.ordbgens.bc.entity.BCTransactonExample.Criteria;
import org.brewchain.backend.ordbgens.bc.entity.BCTransactonKey;
import org.brewchain.backend.ordbgens.bc.mapper.BCTransactonMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;
import onight.tfw.mservice.ThreadContext;


@Data
@EqualsAndHashCode(callSuper=false)
@Tab(name="BC_TRANSACTON")
public class BCTransactonDao extends ExtendDaoSupper<BCTransacton, BCTransactonExample, BCTransactonKey>{

	private BCTransactonMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(BCTransactonExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BCTransactonExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BCTransactonKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BCTransacton record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BCTransacton record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<BCTransacton> records) throws Exception
			 {
		for(BCTransacton record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<BCTransacton> records) throws Exception
			 {
		for(BCTransacton record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BCTransacton> selectByExample(BCTransactonExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public BCTransacton selectByPrimaryKey(BCTransactonKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BCTransacton> findAll(List<BCTransacton> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new BCTransactonExample());
		}
		List<BCTransacton> list = new ArrayList<>();
		for(BCTransacton record : records){
			BCTransacton result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BCTransacton record, BCTransactonExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BCTransacton record, BCTransactonExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BCTransacton record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BCTransacton record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BCTransactonExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new BCTransactonExample());
	}

	@Override
	public BCTransactonExample getExample(BCTransacton record) {
		BCTransactonExample example = new BCTransactonExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getTxid()!=null){
				criteria.andTxidEqualTo(record.getTxid());
				}
				if(record.getBversion()!=null){
				criteria.andBversionEqualTo(record.getBversion());
				}
				if(record.getHashMerkleRoot()!=null){
				criteria.andHashMerkleRootEqualTo(record.getHashMerkleRoot());
				}
				if(record.getBlockHeight()!=null){
				criteria.andBlockHeightEqualTo(record.getBlockHeight());
				}
				if(record.getAddressInCount()!=null){
				criteria.andAddressInCountEqualTo(record.getAddressInCount());
				}
				if(record.getAddressOutCount()!=null){
				criteria.andAddressOutCountEqualTo(record.getAddressOutCount());
				}
				if(record.getPropCount()!=null){
				criteria.andPropCountEqualTo(record.getPropCount());
				}
				if(record.getTxStatus()!=null){
				criteria.andTxStatusEqualTo(record.getTxStatus());
				}
				if(record.getIndexInBlock()!=null){
				criteria.andIndexInBlockEqualTo(record.getIndexInBlock());
				}
				if(record.getExtComments()!=null){
				criteria.andExtCommentsEqualTo(record.getExtComments());
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
	
	public BCTransacton selectOneByExample(BCTransactonExample example)
			 {
		example.setLimit(1);
		List<BCTransacton> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<BCTransacton> records) throws Exception {
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
			sb.append("INSERT INTO BC_TRANSACTON(TXID,BVERSION,HASH_MERKLE_ROOT,BLOCK_HEIGHT,ADDRESS_IN_COUNT,ADDRESS_OUT_COUNT,PROP_COUNT,TX_STATUS,INDEX_IN_BLOCK,EXT_COMMENTS,CREATE_TIME,UPDATE_TIME) values");
			
				int i=0;
				st = conn.createStatement();
				for (BCTransacton record : records) {
					if(i>0){
						sb.append(",");
					}
					i++;
				
			
				sb.append("(");
			
				if(record.getTxid()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getTxid()+"'");
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
			
				if(record.getHashMerkleRoot()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getHashMerkleRoot()+"'");
				}
			
				sb.append(",");
			
				if(record.getBlockHeight()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getBlockHeight()+"'");
				}
			
				sb.append(",");
			
				if(record.getAddressInCount()==null){
//						sb.append("'"+"0"+"'");
						sb.append("'"+"0"+"'");
						
				}else{
				// java type==Integer
						sb.append("'"+record.getAddressInCount()+"'");
				}
			
				sb.append(",");
			
				if(record.getAddressOutCount()==null){
//						sb.append("'"+"0"+"'");
						sb.append("'"+"0"+"'");
						
				}else{
				// java type==Integer
						sb.append("'"+record.getAddressOutCount()+"'");
				}
			
				sb.append(",");
			
				if(record.getPropCount()==null){
//						sb.append("'"+"0"+"'");
						sb.append("'"+"0"+"'");
						
				}else{
				// java type==Integer
						sb.append("'"+record.getPropCount()+"'");
				}
			
				sb.append(",");
			
				if(record.getTxStatus()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getTxStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getIndexInBlock()==null){
//						sb.append("'"+"0"+"'");
						sb.append("'"+"0"+"'");
						
				}else{
				// java type==Integer
						sb.append("'"+record.getIndexInBlock()+"'");
				}
			
				sb.append(",");
			
				if(record.getExtComments()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getExtComments()+"'");
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

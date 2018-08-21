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

import org.brewchain.backend.ordbgens.bc.entity.BCMtxSignature;
import org.brewchain.backend.ordbgens.bc.entity.BCMtxSignatureExample;
import org.brewchain.backend.ordbgens.bc.entity.BCMtxSignatureExample.Criteria;
import org.brewchain.backend.ordbgens.bc.entity.BCMtxSignatureKey;
import org.brewchain.backend.ordbgens.bc.mapper.BCMtxSignatureMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;
import onight.tfw.mservice.ThreadContext;


@Data
@EqualsAndHashCode(callSuper=false)
@Tab(name="BC_MTX_SIGNATURE")
public class BCMtxSignatureDao extends ExtendDaoSupper<BCMtxSignature, BCMtxSignatureExample, BCMtxSignatureKey>{

	private BCMtxSignatureMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(BCMtxSignatureExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BCMtxSignatureExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BCMtxSignatureKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BCMtxSignature record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BCMtxSignature record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<BCMtxSignature> records) throws Exception
			 {
		for(BCMtxSignature record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<BCMtxSignature> records) throws Exception
			 {
		for(BCMtxSignature record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BCMtxSignature> selectByExample(BCMtxSignatureExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public BCMtxSignature selectByPrimaryKey(BCMtxSignatureKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BCMtxSignature> findAll(List<BCMtxSignature> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new BCMtxSignatureExample());
		}
		List<BCMtxSignature> list = new ArrayList<>();
		for(BCMtxSignature record : records){
			BCMtxSignature result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BCMtxSignature record, BCMtxSignatureExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BCMtxSignature record, BCMtxSignatureExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BCMtxSignature record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BCMtxSignature record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BCMtxSignatureExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new BCMtxSignatureExample());
	}

	@Override
	public BCMtxSignatureExample getExample(BCMtxSignature record) {
		BCMtxSignatureExample example = new BCMtxSignatureExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getMtxSignid()!=null){
				criteria.andMtxSignidEqualTo(record.getMtxSignid());
				}
				if(record.getBcAddress()!=null){
				criteria.andBcAddressEqualTo(record.getBcAddress());
				}
				if(record.getMtxHash()!=null){
				criteria.andMtxHashEqualTo(record.getMtxHash());
				}
				if(record.getSignData()!=null){
				criteria.andSignDataEqualTo(record.getSignData());
				}
				if(record.getTxStatus()!=null){
				criteria.andTxStatusEqualTo(record.getTxStatus());
				}
				if(record.getIndexInTx()!=null){
				criteria.andIndexInTxEqualTo(record.getIndexInTx());
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
	
	public BCMtxSignature selectOneByExample(BCMtxSignatureExample example)
			 {
		example.setLimit(1);
		List<BCMtxSignature> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<BCMtxSignature> records) throws Exception {
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
			sb.append("INSERT INTO BC_MTX_SIGNATURE(MTX_SIGNID,BC_ADDRESS,MTX_HASH,SIGN_DATA,TX_STATUS,INDEX_IN_TX,CREATE_TIME,UPDATE_TIME) values");
			
				int i=0;
				st = conn.createStatement();
				for (BCMtxSignature record : records) {
					if(i>0){
						sb.append(",");
					}
					i++;
				
			
				sb.append("(");
			
				if(record.getMtxSignid()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getMtxSignid()+"'");
				}
			
				sb.append(",");
			
				if(record.getBcAddress()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getBcAddress()+"'");
				}
			
				sb.append(",");
			
				if(record.getMtxHash()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getMtxHash()+"'");
				}
			
				sb.append(",");
			
				if(record.getSignData()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getSignData()+"'");
				}
			
				sb.append(",");
			
				if(record.getTxStatus()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getTxStatus()+"'");
				}
			
				sb.append(",");
			
				if(record.getIndexInTx()==null){
//						sb.append("'"+"0"+"'");
						sb.append("'"+"0"+"'");
						
				}else{
				// java type==Integer
						sb.append("'"+record.getIndexInTx()+"'");
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

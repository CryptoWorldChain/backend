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

import org.brewchain.backend.ordbgens.bc.entity.BCMtxOutput;
import org.brewchain.backend.ordbgens.bc.entity.BCMtxOutputExample;
import org.brewchain.backend.ordbgens.bc.entity.BCMtxOutputExample.Criteria;
import org.brewchain.backend.ordbgens.bc.entity.BCMtxOutputKey;
import org.brewchain.backend.ordbgens.bc.mapper.BCMtxOutputMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;
import onight.tfw.mservice.ThreadContext;


@Data
@EqualsAndHashCode(callSuper=false)
@Tab(name="BC_MTX_OUTPUT")
public class BCMtxOutputDao extends ExtendDaoSupper<BCMtxOutput, BCMtxOutputExample, BCMtxOutputKey>{

	private BCMtxOutputMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(BCMtxOutputExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BCMtxOutputExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BCMtxOutputKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BCMtxOutput record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BCMtxOutput record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<BCMtxOutput> records) throws Exception
			 {
		for(BCMtxOutput record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<BCMtxOutput> records) throws Exception
			 {
		for(BCMtxOutput record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BCMtxOutput> selectByExample(BCMtxOutputExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public BCMtxOutput selectByPrimaryKey(BCMtxOutputKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BCMtxOutput> findAll(List<BCMtxOutput> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new BCMtxOutputExample());
		}
		List<BCMtxOutput> list = new ArrayList<>();
		for(BCMtxOutput record : records){
			BCMtxOutput result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BCMtxOutput record, BCMtxOutputExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BCMtxOutput record, BCMtxOutputExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BCMtxOutput record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BCMtxOutput record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BCMtxOutputExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new BCMtxOutputExample());
	}

	@Override
	public BCMtxOutputExample getExample(BCMtxOutput record) {
		BCMtxOutputExample example = new BCMtxOutputExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getMtxOutputid()!=null){
				criteria.andMtxOutputidEqualTo(record.getMtxOutputid());
				}
				if(record.getBcAddress()!=null){
				criteria.andBcAddressEqualTo(record.getBcAddress());
				}
				if(record.getMtxHash()!=null){
				criteria.andMtxHashEqualTo(record.getMtxHash());
				}
				if(record.getAmount()!=null){
				criteria.andAmountEqualTo(record.getAmount());
				}
				if(record.getTokenSymbol()!=null){
				criteria.andTokenSymbolEqualTo(record.getTokenSymbol());
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
	
	public BCMtxOutput selectOneByExample(BCMtxOutputExample example)
			 {
		example.setLimit(1);
		List<BCMtxOutput> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<BCMtxOutput> records) throws Exception {
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
			sb.append("INSERT INTO BC_MTX_OUTPUT(MTX_OUTPUTID,BC_ADDRESS,MTX_HASH,AMOUNT,TOKEN_SYMBOL,TX_STATUS,INDEX_IN_TX,CREATE_TIME,UPDATE_TIME) values");
			
				int i=0;
				st = conn.createStatement();
				for (BCMtxOutput record : records) {
					if(i>0){
						sb.append(",");
					}
					i++;
				
			
				sb.append("(");
			
				if(record.getMtxOutputid()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getMtxOutputid()+"'");
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
			
				if(record.getAmount()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getAmount()+"'");
				}
			
				sb.append(",");
			
				if(record.getTokenSymbol()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getTokenSymbol()+"'");
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

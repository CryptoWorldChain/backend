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

import org.brewchain.backend.ordbgens.bc.entity.BCMtxInput;
import org.brewchain.backend.ordbgens.bc.entity.BCMtxInputExample;
import org.brewchain.backend.ordbgens.bc.entity.BCMtxInputExample.Criteria;
import org.brewchain.backend.ordbgens.bc.entity.BCMtxInputKey;
import org.brewchain.backend.ordbgens.bc.mapper.BCMtxInputMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;
import onight.tfw.mservice.ThreadContext;


@Data
@EqualsAndHashCode(callSuper=false)
@Tab(name="BC_MTX_INPUT")
public class BCMtxInputDao extends ExtendDaoSupper<BCMtxInput, BCMtxInputExample, BCMtxInputKey>{

	private BCMtxInputMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(BCMtxInputExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BCMtxInputExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BCMtxInputKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BCMtxInput record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BCMtxInput record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<BCMtxInput> records) throws Exception
			 {
		for(BCMtxInput record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<BCMtxInput> records) throws Exception
			 {
		for(BCMtxInput record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BCMtxInput> selectByExample(BCMtxInputExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public BCMtxInput selectByPrimaryKey(BCMtxInputKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BCMtxInput> findAll(List<BCMtxInput> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new BCMtxInputExample());
		}
		List<BCMtxInput> list = new ArrayList<>();
		for(BCMtxInput record : records){
			BCMtxInput result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BCMtxInput record, BCMtxInputExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BCMtxInput record, BCMtxInputExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BCMtxInput record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BCMtxInput record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BCMtxInputExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new BCMtxInputExample());
	}

	@Override
	public BCMtxInputExample getExample(BCMtxInput record) {
		BCMtxInputExample example = new BCMtxInputExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getMtxInputid()!=null){
				criteria.andMtxInputidEqualTo(record.getMtxInputid());
				}
				if(record.getBcAddress()!=null){
				criteria.andBcAddressEqualTo(record.getBcAddress());
				}
				if(record.getMtxHash()!=null){
				criteria.andMtxHashEqualTo(record.getMtxHash());
				}
				if(record.getBcNonce()!=null){
				criteria.andBcNonceEqualTo(record.getBcNonce());
				}
				if(record.getAmount()!=null){
				criteria.andAmountEqualTo(record.getAmount());
				}
				if(record.getTokenId()!=null){
				criteria.andTokenIdEqualTo(record.getTokenId());
				}
				if(record.getTokenSymbol()!=null){
				criteria.andTokenSymbolEqualTo(record.getTokenSymbol());
				}
				if(record.getCryptoTokenHex()!=null){
				criteria.andCryptoTokenHexEqualTo(record.getCryptoTokenHex());
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
	
	public BCMtxInput selectOneByExample(BCMtxInputExample example)
			 {
		example.setLimit(1);
		List<BCMtxInput> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<BCMtxInput> records) throws Exception {
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
			sb.append("INSERT INTO BC_MTX_INPUT(MTX_INPUTID,BC_ADDRESS,MTX_HASH,BC_NONCE,AMOUNT,TOKEN_ID,TOKEN_SYMBOL,CRYPTO_TOKEN_HEX,TX_STATUS,INDEX_IN_TX,CREATE_TIME,UPDATE_TIME) values");
			
				int i=0;
				st = conn.createStatement();
				for (BCMtxInput record : records) {
					if(i>0){
						sb.append(",");
					}
					i++;
				
			
				sb.append("(");
			
				if(record.getMtxInputid()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getMtxInputid()+"'");
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
			
				if(record.getBcNonce()==null){
//						sb.append("'"+"0"+"'");
						sb.append("'"+"0"+"'");
						
				}else{
				// java type==Integer
						sb.append("'"+record.getBcNonce()+"'");
				}
			
				sb.append(",");
			
				if(record.getAmount()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getAmount()+"'");
				}
			
				sb.append(",");
			
				if(record.getTokenId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getTokenId()+"'");
				}
			
				sb.append(",");
			
				if(record.getTokenSymbol()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getTokenSymbol()+"'");
				}
			
				sb.append(",");
			
				if(record.getCryptoTokenHex()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getCryptoTokenHex()+"'");
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

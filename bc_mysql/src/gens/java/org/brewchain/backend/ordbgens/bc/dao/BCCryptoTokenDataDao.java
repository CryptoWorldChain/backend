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

import org.brewchain.backend.ordbgens.bc.entity.BCCryptoTokenData;
import org.brewchain.backend.ordbgens.bc.entity.BCCryptoTokenDataExample;
import org.brewchain.backend.ordbgens.bc.entity.BCCryptoTokenDataExample.Criteria;
import org.brewchain.backend.ordbgens.bc.entity.BCCryptoTokenDataKey;
import org.brewchain.backend.ordbgens.bc.mapper.BCCryptoTokenDataMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;
import onight.tfw.mservice.ThreadContext;


@Data
@EqualsAndHashCode(callSuper=false)
@Tab(name="BC_CRYPTO_TOKEN_DATA")
public class BCCryptoTokenDataDao extends ExtendDaoSupper<BCCryptoTokenData, BCCryptoTokenDataExample, BCCryptoTokenDataKey>{

	private BCCryptoTokenDataMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(BCCryptoTokenDataExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BCCryptoTokenDataExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BCCryptoTokenDataKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BCCryptoTokenData record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BCCryptoTokenData record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<BCCryptoTokenData> records) throws Exception
			 {
		for(BCCryptoTokenData record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<BCCryptoTokenData> records) throws Exception
			 {
		for(BCCryptoTokenData record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BCCryptoTokenData> selectByExample(BCCryptoTokenDataExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public BCCryptoTokenData selectByPrimaryKey(BCCryptoTokenDataKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BCCryptoTokenData> findAll(List<BCCryptoTokenData> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new BCCryptoTokenDataExample());
		}
		List<BCCryptoTokenData> list = new ArrayList<>();
		for(BCCryptoTokenData record : records){
			BCCryptoTokenData result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BCCryptoTokenData record, BCCryptoTokenDataExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BCCryptoTokenData record, BCCryptoTokenDataExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BCCryptoTokenData record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BCCryptoTokenData record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BCCryptoTokenDataExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new BCCryptoTokenDataExample());
	}

	@Override
	public BCCryptoTokenDataExample getExample(BCCryptoTokenData record) {
		BCCryptoTokenDataExample example = new BCCryptoTokenDataExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getTokenId()!=null){
				criteria.andTokenIdEqualTo(record.getTokenId());
				}
				if(record.getTotals()!=null){
				criteria.andTotalsEqualTo(record.getTotals());
				}
				if(record.getTokenSymbol()!=null){
				criteria.andTokenSymbolEqualTo(record.getTokenSymbol());
				}
				if(record.getTokenName()!=null){
				criteria.andTokenNameEqualTo(record.getTokenName());
				}
				if(record.getTokenCode()!=null){
				criteria.andTokenCodeEqualTo(record.getTokenCode());
				}
				if(record.getExtradata()!=null){
				criteria.andExtradataEqualTo(record.getExtradata());
				}
				if(record.getTokenStatus()!=null){
				criteria.andTokenStatusEqualTo(record.getTokenStatus());
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
	
	public BCCryptoTokenData selectOneByExample(BCCryptoTokenDataExample example)
			 {
		example.setLimit(1);
		List<BCCryptoTokenData> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<BCCryptoTokenData> records) throws Exception {
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
			sb.append("INSERT INTO BC_CRYPTO_TOKEN_DATA(TOKEN_ID,TOTALS,TOKEN_SYMBOL,TOKEN_NAME,TOKEN_CODE,EXTRADATA,TOKEN_STATUS,CREATE_TIME,UPDATE_TIME) values");
			
				int i=0;
				st = conn.createStatement();
				for (BCCryptoTokenData record : records) {
					if(i>0){
						sb.append(",");
					}
					i++;
				
			
				sb.append("(");
			
				if(record.getTokenId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getTokenId()+"'");
				}
			
				sb.append(",");
			
				if(record.getTotals()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getTotals()+"'");
				}
			
				sb.append(",");
			
				if(record.getTokenSymbol()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getTokenSymbol()+"'");
				}
			
				sb.append(",");
			
				if(record.getTokenName()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getTokenName()+"'");
				}
			
				sb.append(",");
			
				if(record.getTokenCode()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getTokenCode()+"'");
				}
			
				sb.append(",");
			
				if(record.getExtradata()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getExtradata()+"'");
				}
			
				sb.append(",");
			
				if(record.getTokenStatus()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getTokenStatus()+"'");
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

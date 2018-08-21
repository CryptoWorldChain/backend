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

import org.brewchain.backend.ordbgens.bc.entity.BCActCryptoValue;
import org.brewchain.backend.ordbgens.bc.entity.BCActCryptoValueExample;
import org.brewchain.backend.ordbgens.bc.entity.BCActCryptoValueExample.Criteria;
import org.brewchain.backend.ordbgens.bc.entity.BCActCryptoValueKey;
import org.brewchain.backend.ordbgens.bc.mapper.BCActCryptoValueMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;
import onight.tfw.mservice.ThreadContext;


@Data
@EqualsAndHashCode(callSuper=false)
@Tab(name="BC_ACT_CRYPTO_VALUE")
public class BCActCryptoValueDao extends ExtendDaoSupper<BCActCryptoValue, BCActCryptoValueExample, BCActCryptoValueKey>{

	private BCActCryptoValueMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(BCActCryptoValueExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BCActCryptoValueExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BCActCryptoValueKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BCActCryptoValue record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BCActCryptoValue record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<BCActCryptoValue> records) throws Exception
			 {
		for(BCActCryptoValue record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<BCActCryptoValue> records) throws Exception
			 {
		for(BCActCryptoValue record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BCActCryptoValue> selectByExample(BCActCryptoValueExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public BCActCryptoValue selectByPrimaryKey(BCActCryptoValueKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BCActCryptoValue> findAll(List<BCActCryptoValue> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new BCActCryptoValueExample());
		}
		List<BCActCryptoValue> list = new ArrayList<>();
		for(BCActCryptoValue record : records){
			BCActCryptoValue result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BCActCryptoValue record, BCActCryptoValueExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BCActCryptoValue record, BCActCryptoValueExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BCActCryptoValue record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BCActCryptoValue record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BCActCryptoValueExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new BCActCryptoValueExample());
	}

	@Override
	public BCActCryptoValueExample getExample(BCActCryptoValue record) {
		BCActCryptoValueExample example = new BCActCryptoValueExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getActvUid()!=null){
				criteria.andActvUidEqualTo(record.getActvUid());
				}
				if(record.getActvHash()!=null){
				criteria.andActvHashEqualTo(record.getActvHash());
				}
				if(record.getActAddress()!=null){
				criteria.andActAddressEqualTo(record.getActAddress());
				}
				if(record.getActvOwner()!=null){
				criteria.andActvOwnerEqualTo(record.getActvOwner());
				}
				if(record.getActvName()!=null){
				criteria.andActvNameEqualTo(record.getActvName());
				}
				if(record.getActvCode()!=null){
				criteria.andActvCodeEqualTo(record.getActvCode());
				}
				if(record.getActvNonce()!=null){
				criteria.andActvNonceEqualTo(record.getActvNonce());
				}
				if(record.getActvTimestamp()!=null){
				criteria.andActvTimestampEqualTo(record.getActvTimestamp());
				}
				if(record.getActvOwnertime()!=null){
				criteria.andActvOwnertimeEqualTo(record.getActvOwnertime());
				}
				if(record.getActvIndex()!=null){
				criteria.andActvIndexEqualTo(record.getActvIndex());
				}
				if(record.getActvTotal()!=null){
				criteria.andActvTotalEqualTo(record.getActvTotal());
				}
				if(record.getDataHex()!=null){
				criteria.andDataHexEqualTo(record.getDataHex());
				}
				if(record.getActvStatus()!=null){
				criteria.andActvStatusEqualTo(record.getActvStatus());
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
	
	public BCActCryptoValue selectOneByExample(BCActCryptoValueExample example)
			 {
		example.setLimit(1);
		List<BCActCryptoValue> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<BCActCryptoValue> records) throws Exception {
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
			sb.append("INSERT INTO BC_ACT_CRYPTO_VALUE(ACTV_UID,ACTV_HASH,ACT_ADDRESS,ACTV_OWNER,ACTV_NAME,ACTV_CODE,ACTV_NONCE,ACTV_TIMESTAMP,ACTV_OWNERTIME,ACTV_INDEX,ACTV_TOTAL,DATA_HEX,ACTV_STATUS,CREATE_TIME,UPDATE_TIME) values");
			
				int i=0;
				st = conn.createStatement();
				for (BCActCryptoValue record : records) {
					if(i>0){
						sb.append(",");
					}
					i++;
				
			
				sb.append("(");
			
				if(record.getActvUid()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getActvUid()+"'");
				}
			
				sb.append(",");
			
				if(record.getActvHash()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getActvHash()+"'");
				}
			
				sb.append(",");
			
				if(record.getActAddress()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getActAddress()+"'");
				}
			
				sb.append(",");
			
				if(record.getActvOwner()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getActvOwner()+"'");
				}
			
				sb.append(",");
			
				if(record.getActvName()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getActvName()+"'");
				}
			
				sb.append(",");
			
				if(record.getActvCode()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getActvCode()+"'");
				}
			
				sb.append(",");
			
				if(record.getActvNonce()==null){
						sb.append("null");
				}else{
				// java type==Integer
						sb.append("'"+record.getActvNonce()+"'");
				}
			
				sb.append(",");
			
				if(record.getActvTimestamp()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getActvTimestamp()+"'");
				}
			
				sb.append(",");
			
				if(record.getActvOwnertime()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getActvOwnertime()+"'");
				}
			
				sb.append(",");
			
				if(record.getActvIndex()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getActvIndex()+"'");
				}
			
				sb.append(",");
			
				if(record.getActvTotal()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getActvTotal()+"'");
				}
			
				sb.append(",");
			
				if(record.getDataHex()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getDataHex()+"'");
				}
			
				sb.append(",");
			
				if(record.getActvStatus()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getActvStatus()+"'");
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

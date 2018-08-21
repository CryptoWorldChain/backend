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

import org.brewchain.backend.ordbgens.bc.entity.BCAccount;
import org.brewchain.backend.ordbgens.bc.entity.BCAccountExample;
import org.brewchain.backend.ordbgens.bc.entity.BCAccountExample.Criteria;
import org.brewchain.backend.ordbgens.bc.entity.BCAccountKey;
import org.brewchain.backend.ordbgens.bc.mapper.BCAccountMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;
import onight.tfw.mservice.ThreadContext;


@Data
@EqualsAndHashCode(callSuper=false)
@Tab(name="BC_ACCOUNT")
public class BCAccountDao extends ExtendDaoSupper<BCAccount, BCAccountExample, BCAccountKey>{

	private BCAccountMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(BCAccountExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BCAccountExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BCAccountKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BCAccount record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BCAccount record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<BCAccount> records) throws Exception
			 {
		for(BCAccount record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<BCAccount> records) throws Exception
			 {
		for(BCAccount record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BCAccount> selectByExample(BCAccountExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public BCAccount selectByPrimaryKey(BCAccountKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BCAccount> findAll(List<BCAccount> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new BCAccountExample());
		}
		List<BCAccount> list = new ArrayList<>();
		for(BCAccount record : records){
			BCAccount result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BCAccount record, BCAccountExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BCAccount record, BCAccountExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BCAccount record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BCAccount record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BCAccountExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new BCAccountExample());
	}

	@Override
	public BCAccountExample getExample(BCAccount record) {
		BCAccountExample example = new BCAccountExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getActAddress()!=null){
				criteria.andActAddressEqualTo(record.getActAddress());
				}
				if(record.getActNonce()!=null){
				criteria.andActNonceEqualTo(record.getActNonce());
				}
				if(record.getActBalance()!=null){
				criteria.andActBalanceEqualTo(record.getActBalance());
				}
				if(record.getActMax()!=null){
				criteria.andActMaxEqualTo(record.getActMax());
				}
				if(record.getActAcceptMax()!=null){
				criteria.andActAcceptMaxEqualTo(record.getActAcceptMax());
				}
				if(record.getActAcceptLimit()!=null){
				criteria.andActAcceptLimitEqualTo(record.getActAcceptLimit());
				}
				if(record.getStorageHex()!=null){
				criteria.andStorageHexEqualTo(record.getStorageHex());
				}
				if(record.getCodeHashHex()!=null){
				criteria.andCodeHashHexEqualTo(record.getCodeHashHex());
				}
				if(record.getCodeHex()!=null){
				criteria.andCodeHexEqualTo(record.getCodeHex());
				}
				if(record.getDataHex()!=null){
				criteria.andDataHexEqualTo(record.getDataHex());
				}
				if(record.getActStatus()!=null){
				criteria.andActStatusEqualTo(record.getActStatus());
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
	
	public BCAccount selectOneByExample(BCAccountExample example)
			 {
		example.setLimit(1);
		List<BCAccount> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<BCAccount> records) throws Exception {
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
			sb.append("INSERT INTO BC_ACCOUNT(ACT_ADDRESS,ACT_NONCE,ACT_BALANCE,ACT_MAX,ACT_ACCEPT_MAX,ACT_ACCEPT_LIMIT,STORAGE_HEX,CODE_HASH_HEX,CODE_HEX,DATA_HEX,ACT_STATUS,CREATE_TIME,UPDATE_TIME) values");
			
				int i=0;
				st = conn.createStatement();
				for (BCAccount record : records) {
					if(i>0){
						sb.append(",");
					}
					i++;
				
			
				sb.append("(");
			
				if(record.getActAddress()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getActAddress()+"'");
				}
			
				sb.append(",");
			
				if(record.getActNonce()==null){
//						sb.append("'"+"0"+"'");
						sb.append("'"+"0"+"'");
						
				}else{
				// java type==Integer
						sb.append("'"+record.getActNonce()+"'");
				}
			
				sb.append(",");
			
				if(record.getActBalance()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getActBalance()+"'");
				}
			
				sb.append(",");
			
				if(record.getActMax()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getActMax()+"'");
				}
			
				sb.append(",");
			
				if(record.getActAcceptMax()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getActAcceptMax()+"'");
				}
			
				sb.append(",");
			
				if(record.getActAcceptLimit()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getActAcceptLimit()+"'");
				}
			
				sb.append(",");
			
				if(record.getStorageHex()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getStorageHex()+"'");
				}
			
				sb.append(",");
			
				if(record.getCodeHashHex()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getCodeHashHex()+"'");
				}
			
				sb.append(",");
			
				if(record.getCodeHex()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getCodeHex()+"'");
				}
			
				sb.append(",");
			
				if(record.getDataHex()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getDataHex()+"'");
				}
			
				sb.append(",");
			
				if(record.getActStatus()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getActStatus()+"'");
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

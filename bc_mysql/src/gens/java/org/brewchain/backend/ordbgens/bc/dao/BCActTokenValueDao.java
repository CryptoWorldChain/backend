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

import org.brewchain.backend.ordbgens.bc.entity.BCActTokenValue;
import org.brewchain.backend.ordbgens.bc.entity.BCActTokenValueExample;
import org.brewchain.backend.ordbgens.bc.entity.BCActTokenValueExample.Criteria;
import org.brewchain.backend.ordbgens.bc.entity.BCActTokenValueKey;
import org.brewchain.backend.ordbgens.bc.mapper.BCActTokenValueMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;
import onight.tfw.mservice.ThreadContext;


@Data
@EqualsAndHashCode(callSuper=false)
@Tab(name="BC_ACT_TOKEN_VALUE")
public class BCActTokenValueDao extends ExtendDaoSupper<BCActTokenValue, BCActTokenValueExample, BCActTokenValueKey>{

	private BCActTokenValueMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(BCActTokenValueExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BCActTokenValueExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BCActTokenValueKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BCActTokenValue record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BCActTokenValue record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<BCActTokenValue> records) throws Exception
			 {
		for(BCActTokenValue record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<BCActTokenValue> records) throws Exception
			 {
		for(BCActTokenValue record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BCActTokenValue> selectByExample(BCActTokenValueExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public BCActTokenValue selectByPrimaryKey(BCActTokenValueKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BCActTokenValue> findAll(List<BCActTokenValue> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new BCActTokenValueExample());
		}
		List<BCActTokenValue> list = new ArrayList<>();
		for(BCActTokenValue record : records){
			BCActTokenValue result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BCActTokenValue record, BCActTokenValueExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BCActTokenValue record, BCActTokenValueExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BCActTokenValue record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BCActTokenValue record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BCActTokenValueExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new BCActTokenValueExample());
	}

	@Override
	public BCActTokenValueExample getExample(BCActTokenValue record) {
		BCActTokenValueExample example = new BCActTokenValueExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getActvTokenId()!=null){
				criteria.andActvTokenIdEqualTo(record.getActvTokenId());
				}
				if(record.getActAddress()!=null){
				criteria.andActAddressEqualTo(record.getActAddress());
				}
				if(record.getActvToken()!=null){
				criteria.andActvTokenEqualTo(record.getActvToken());
				}
				if(record.getActvBalance()!=null){
				criteria.andActvBalanceEqualTo(record.getActvBalance());
				}
				if(record.getActvLocked()!=null){
				criteria.andActvLockedEqualTo(record.getActvLocked());
				}
				if(record.getActtStatus()!=null){
				criteria.andActtStatusEqualTo(record.getActtStatus());
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
	
	public BCActTokenValue selectOneByExample(BCActTokenValueExample example)
			 {
		example.setLimit(1);
		List<BCActTokenValue> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<BCActTokenValue> records) throws Exception {
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
			sb.append("INSERT INTO BC_ACT_TOKEN_VALUE(ACTV_TOKEN_ID,ACT_ADDRESS,ACTV_TOKEN,ACTV_BALANCE,ACTV_LOCKED,ACTT_STATUS,CREATE_TIME,UPDATE_TIME) values");
			
				int i=0;
				st = conn.createStatement();
				for (BCActTokenValue record : records) {
					if(i>0){
						sb.append(",");
					}
					i++;
				
			
				sb.append("(");
			
				if(record.getActvTokenId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getActvTokenId()+"'");
				}
			
				sb.append(",");
			
				if(record.getActAddress()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getActAddress()+"'");
				}
			
				sb.append(",");
			
				if(record.getActvToken()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getActvToken()+"'");
				}
			
				sb.append(",");
			
				if(record.getActvBalance()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getActvBalance()+"'");
				}
			
				sb.append(",");
			
				if(record.getActvLocked()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getActvLocked()+"'");
				}
			
				sb.append(",");
			
				if(record.getActtStatus()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getActtStatus()+"'");
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

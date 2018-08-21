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

import org.brewchain.backend.ordbgens.bc.entity.BCActAddress;
import org.brewchain.backend.ordbgens.bc.entity.BCActAddressExample;
import org.brewchain.backend.ordbgens.bc.entity.BCActAddressExample.Criteria;
import org.brewchain.backend.ordbgens.bc.entity.BCActAddressKey;
import org.brewchain.backend.ordbgens.bc.mapper.BCActAddressMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;
import onight.tfw.mservice.ThreadContext;


@Data
@EqualsAndHashCode(callSuper=false)
@Tab(name="BC_ACT_ADDRESS")
public class BCActAddressDao extends ExtendDaoSupper<BCActAddress, BCActAddressExample, BCActAddressKey>{

	private BCActAddressMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(BCActAddressExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BCActAddressExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BCActAddressKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BCActAddress record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BCActAddress record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<BCActAddress> records) throws Exception
			 {
		for(BCActAddress record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<BCActAddress> records) throws Exception
			 {
		for(BCActAddress record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BCActAddress> selectByExample(BCActAddressExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public BCActAddress selectByPrimaryKey(BCActAddressKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BCActAddress> findAll(List<BCActAddress> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new BCActAddressExample());
		}
		List<BCActAddress> list = new ArrayList<>();
		for(BCActAddress record : records){
			BCActAddress result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BCActAddress record, BCActAddressExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BCActAddress record, BCActAddressExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BCActAddress record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BCActAddress record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BCActAddressExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new BCActAddressExample());
	}

	@Override
	public BCActAddressExample getExample(BCActAddress record) {
		BCActAddressExample example = new BCActAddressExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getAddressUid()!=null){
				criteria.andAddressUidEqualTo(record.getAddressUid());
				}
				if(record.getActAddress()!=null){
				criteria.andActAddressEqualTo(record.getActAddress());
				}
				if(record.getActaStatus()!=null){
				criteria.andActaStatusEqualTo(record.getActaStatus());
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
	
	public BCActAddress selectOneByExample(BCActAddressExample example)
			 {
		example.setLimit(1);
		List<BCActAddress> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<BCActAddress> records) throws Exception {
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
			sb.append("INSERT INTO BC_ACT_ADDRESS(ADDRESS_UID,ACT_ADDRESS,ACTA_STATUS,CREATE_TIME,UPDATE_TIME) values");
			
				int i=0;
				st = conn.createStatement();
				for (BCActAddress record : records) {
					if(i>0){
						sb.append(",");
					}
					i++;
				
			
				sb.append("(");
			
				if(record.getAddressUid()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getAddressUid()+"'");
				}
			
				sb.append(",");
			
				if(record.getActAddress()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getActAddress()+"'");
				}
			
				sb.append(",");
			
				if(record.getActaStatus()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getActaStatus()+"'");
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

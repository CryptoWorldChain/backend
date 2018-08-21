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

import org.brewchain.backend.ordbgens.bc.entity.BCBlockMpt;
import org.brewchain.backend.ordbgens.bc.entity.BCBlockMptExample;
import org.brewchain.backend.ordbgens.bc.entity.BCBlockMptExample.Criteria;
import org.brewchain.backend.ordbgens.bc.entity.BCBlockMptKey;
import org.brewchain.backend.ordbgens.bc.mapper.BCBlockMptMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;
import onight.tfw.mservice.ThreadContext;


@Data
@EqualsAndHashCode(callSuper=false)
@Tab(name="BC_BLOCK_MPT")
public class BCBlockMptDao extends ExtendDaoSupper<BCBlockMpt, BCBlockMptExample, BCBlockMptKey>{

	private BCBlockMptMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(BCBlockMptExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BCBlockMptExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BCBlockMptKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BCBlockMpt record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BCBlockMpt record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<BCBlockMpt> records) throws Exception
			 {
		for(BCBlockMpt record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<BCBlockMpt> records) throws Exception
			 {
		for(BCBlockMpt record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BCBlockMpt> selectByExample(BCBlockMptExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public BCBlockMpt selectByPrimaryKey(BCBlockMptKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BCBlockMpt> findAll(List<BCBlockMpt> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new BCBlockMptExample());
		}
		List<BCBlockMpt> list = new ArrayList<>();
		for(BCBlockMpt record : records){
			BCBlockMpt result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BCBlockMpt record, BCBlockMptExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BCBlockMpt record, BCBlockMptExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BCBlockMpt record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BCBlockMpt record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BCBlockMptExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new BCBlockMptExample());
	}

	@Override
	public BCBlockMptExample getExample(BCBlockMpt record) {
		BCBlockMptExample example = new BCBlockMptExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getLogUuid()!=null){
				criteria.andLogUuidEqualTo(record.getLogUuid());
				}
				if(record.getBversion()!=null){
				criteria.andBversionEqualTo(record.getBversion());
				}
				if(record.getBlockHeight()!=null){
				criteria.andBlockHeightEqualTo(record.getBlockHeight());
				}
				if(record.getHashMpt()!=null){
				criteria.andHashMptEqualTo(record.getHashMpt());
				}
				if(record.getHashPrevMpt()!=null){
				criteria.andHashPrevMptEqualTo(record.getHashPrevMpt());
				}
				if(record.getMptType()!=null){
				criteria.andMptTypeEqualTo(record.getMptType());
				}
				if(record.getValueCounts()!=null){
				criteria.andValueCountsEqualTo(record.getValueCounts());
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
	
	public BCBlockMpt selectOneByExample(BCBlockMptExample example)
			 {
		example.setLimit(1);
		List<BCBlockMpt> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<BCBlockMpt> records) throws Exception {
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
			sb.append("INSERT INTO BC_BLOCK_MPT(LOG_UUID,BVERSION,BLOCK_HEIGHT,HASH_MPT,HASH_PREV_MPT,MPT_TYPE,VALUE_COUNTS,BLOCK_STATUS,CREATE_TIME,UPDATE_TIME) values");
			
				int i=0;
				st = conn.createStatement();
				for (BCBlockMpt record : records) {
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
			
				if(record.getBlockHeight()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getBlockHeight()+"'");
				}
			
				sb.append(",");
			
				if(record.getHashMpt()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getHashMpt()+"'");
				}
			
				sb.append(",");
			
				if(record.getHashPrevMpt()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getHashPrevMpt()+"'");
				}
			
				sb.append(",");
			
				if(record.getMptType()==null){
//						sb.append("'"+"0000"+"'");
						sb.append("'"+"0000"+"'");
						
				}else{
				// java type==String
						sb.append("'"+record.getMptType()+"'");
				}
			
				sb.append(",");
			
				if(record.getValueCounts()==null){
//						sb.append("'"+"0"+"'");
						sb.append("'"+"0"+"'");
						
				}else{
				// java type==Integer
						sb.append("'"+record.getValueCounts()+"'");
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

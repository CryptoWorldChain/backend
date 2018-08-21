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

import org.brewchain.backend.ordbgens.bc.entity.BCGlobalProps;
import org.brewchain.backend.ordbgens.bc.entity.BCGlobalPropsExample;
import org.brewchain.backend.ordbgens.bc.entity.BCGlobalPropsExample.Criteria;
import org.brewchain.backend.ordbgens.bc.entity.BCGlobalPropsKey;
import org.brewchain.backend.ordbgens.bc.mapper.BCGlobalPropsMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;
import onight.tfw.mservice.ThreadContext;


@Data
@EqualsAndHashCode(callSuper=false)
@Tab(name="BC_GLOBAL_PROPS")
public class BCGlobalPropsDao extends ExtendDaoSupper<BCGlobalProps, BCGlobalPropsExample, BCGlobalPropsKey>{

	private BCGlobalPropsMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(BCGlobalPropsExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BCGlobalPropsExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BCGlobalPropsKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BCGlobalProps record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BCGlobalProps record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<BCGlobalProps> records) throws Exception
			 {
		for(BCGlobalProps record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<BCGlobalProps> records) throws Exception
			 {
		for(BCGlobalProps record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BCGlobalProps> selectByExample(BCGlobalPropsExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public BCGlobalProps selectByPrimaryKey(BCGlobalPropsKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BCGlobalProps> findAll(List<BCGlobalProps> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new BCGlobalPropsExample());
		}
		List<BCGlobalProps> list = new ArrayList<>();
		for(BCGlobalProps record : records){
			BCGlobalProps result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BCGlobalProps record, BCGlobalPropsExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BCGlobalProps record, BCGlobalPropsExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BCGlobalProps record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BCGlobalProps record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BCGlobalPropsExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new BCGlobalPropsExample());
	}

	@Override
	public BCGlobalPropsExample getExample(BCGlobalProps record) {
		BCGlobalPropsExample example = new BCGlobalPropsExample();
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
				if(record.getPropKey()!=null){
				criteria.andPropKeyEqualTo(record.getPropKey());
				}
				if(record.getPropValue()!=null){
				criteria.andPropValueEqualTo(record.getPropValue());
				}
				if(record.getMptType()!=null){
				criteria.andMptTypeEqualTo(record.getMptType());
				}
				if(record.getHashValue()!=null){
				criteria.andHashValueEqualTo(record.getHashValue());
				}
				if(record.getTxid()!=null){
				criteria.andTxidEqualTo(record.getTxid());
				}
				if(record.getPrevHashValue()!=null){
				criteria.andPrevHashValueEqualTo(record.getPrevHashValue());
				}
				if(record.getPrevBlockHeight()!=null){
				criteria.andPrevBlockHeightEqualTo(record.getPrevBlockHeight());
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
	
	public BCGlobalProps selectOneByExample(BCGlobalPropsExample example)
			 {
		example.setLimit(1);
		List<BCGlobalProps> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<BCGlobalProps> records) throws Exception {
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
			sb.append("INSERT INTO BC_GLOBAL_PROPS(LOG_UUID,BVERSION,BLOCK_HEIGHT,PROP_KEY,PROP_VALUE,MPT_TYPE,HASH_VALUE,TXID,PREV_HASH_VALUE,PREV_BLOCK_HEIGHT,CREATE_TIME,UPDATE_TIME) values");
			
				int i=0;
				st = conn.createStatement();
				for (BCGlobalProps record : records) {
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
			
				if(record.getPropKey()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getPropKey()+"'");
				}
			
				sb.append(",");
			
				if(record.getPropValue()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getPropValue()+"'");
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
			
				if(record.getHashValue()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getHashValue()+"'");
				}
			
				sb.append(",");
			
				if(record.getTxid()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getTxid()+"'");
				}
			
				sb.append(",");
			
				if(record.getPrevHashValue()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getPrevHashValue()+"'");
				}
			
				sb.append(",");
			
				if(record.getPrevBlockHeight()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getPrevBlockHeight()+"'");
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

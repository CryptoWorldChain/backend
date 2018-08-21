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

import org.brewchain.backend.ordbgens.bc.entity.BCAddress;
import org.brewchain.backend.ordbgens.bc.entity.BCAddressExample;
import org.brewchain.backend.ordbgens.bc.entity.BCAddressExample.Criteria;
import org.brewchain.backend.ordbgens.bc.entity.BCAddressKey;
import org.brewchain.backend.ordbgens.bc.mapper.BCAddressMapper;
import onight.tfw.ojpa.api.annotations.Tab;
import onight.tfw.ojpa.ordb.ExtendDaoSupper;
import onight.tfw.mservice.ThreadContext;


@Data
@EqualsAndHashCode(callSuper=false)
@Tab(name="BC_ADDRESS")
public class BCAddressDao extends ExtendDaoSupper<BCAddress, BCAddressExample, BCAddressKey>{

	private BCAddressMapper mapper;

	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public int countByExample(BCAddressExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BCAddressExample example)  throws Exception{
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BCAddressKey key)  throws Exception{
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BCAddress record)   throws Exception{
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BCAddress record)   throws Exception{
		return mapper.insertSelective(record);
	}

	@Override
	//@Transactional
	public int batchUpdate(List<BCAddress> records) throws Exception
			 {
		for(BCAddress record : records){
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	//@Transactional
	public int batchDelete(List<BCAddress> records) throws Exception
			 {
		for(BCAddress record : records){
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BCAddress> selectByExample(BCAddressExample example)
			 {
		return mapper.selectByExample(example);
	}

	@Override
	public BCAddress selectByPrimaryKey(BCAddressKey key)
			 {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BCAddress> findAll(List<BCAddress> records) {
		if(records==null||records.size()<=0){
			return mapper.selectByExample(new BCAddressExample());
		}
		List<BCAddress> list = new ArrayList<>();
		for(BCAddress record : records){
			BCAddress result = mapper.selectByPrimaryKey(record);
			if(result!=null){
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BCAddress record, BCAddressExample example)  throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BCAddress record, BCAddressExample example)  throws Exception{
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BCAddress record)  throws Exception{
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BCAddress record)  throws Exception{
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BCAddressExample example) {
		return 0;
	}

	@Override
	public void deleteAll()  throws Exception {
		mapper.deleteByExample(new BCAddressExample());
	}

	@Override
	public BCAddressExample getExample(BCAddress record) {
		BCAddressExample example = new BCAddressExample();
		if(record!=null){
			Criteria criteria = example.createCriteria();
							if(record.getTxid()!=null){
				criteria.andTxidEqualTo(record.getTxid());
				}
				if(record.getLogUuid()!=null){
				criteria.andLogUuidEqualTo(record.getLogUuid());
				}
				if(record.getAddress()!=null){
				criteria.andAddressEqualTo(record.getAddress());
				}
				if(record.getBversion()!=null){
				criteria.andBversionEqualTo(record.getBversion());
				}
				if(record.getPrevTxid()!=null){
				criteria.andPrevTxidEqualTo(record.getPrevTxid());
				}
				if(record.getIndexInTx()!=null){
				criteria.andIndexInTxEqualTo(record.getIndexInTx());
				}
				if(record.getAddrType()!=null){
				criteria.andAddrTypeEqualTo(record.getAddrType());
				}
				if(record.getNextScriptId()!=null){
				criteria.andNextScriptIdEqualTo(record.getNextScriptId());
				}
				if(record.getSvalue()!=null){
				criteria.andSvalueEqualTo(record.getSvalue());
				}
				if(record.getFee()!=null){
				criteria.andFeeEqualTo(record.getFee());
				}
				if(record.getTax()!=null){
				criteria.andTaxEqualTo(record.getTax());
				}
				if(record.getExtComments()!=null){
				criteria.andExtCommentsEqualTo(record.getExtComments());
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
	
	public BCAddress selectOneByExample(BCAddressExample example)
			 {
		example.setLimit(1);
		List<BCAddress> list=mapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	//@Transactional
	public int batchInsert(List<BCAddress> records) throws Exception {
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
			sb.append("INSERT INTO BC_ADDRESS(TXID,LOG_UUID,ADDRESS,BVERSION,PREV_TXID,INDEX_IN_TX,ADDR_TYPE,NEXT_SCRIPT_ID,SVALUE,FEE,TAX,EXT_COMMENTS,CREATE_TIME,UPDATE_TIME) values");
			
				int i=0;
				st = conn.createStatement();
				for (BCAddress record : records) {
					if(i>0){
						sb.append(",");
					}
					i++;
				
			
				sb.append("(");
			
				if(record.getTxid()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getTxid()+"'");
				}
			
				sb.append(",");
			
				if(record.getLogUuid()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getLogUuid()+"'");
				}
			
				sb.append(",");
			
				if(record.getAddress()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getAddress()+"'");
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
			
				if(record.getPrevTxid()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getPrevTxid()+"'");
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
			
				if(record.getAddrType()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getAddrType()+"'");
				}
			
				sb.append(",");
			
				if(record.getNextScriptId()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getNextScriptId()+"'");
				}
			
				sb.append(",");
			
				if(record.getSvalue()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getSvalue()+"'");
				}
			
				sb.append(",");
			
				if(record.getFee()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getFee()+"'");
				}
			
				sb.append(",");
			
				if(record.getTax()==null){
						sb.append("null");
				}else{
				// java type==BigDecimal
						sb.append("'"+record.getTax()+"'");
				}
			
				sb.append(",");
			
				if(record.getExtComments()==null){
						sb.append("null");
				}else{
				// java type==String
						sb.append("'"+record.getExtComments()+"'");
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

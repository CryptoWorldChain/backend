package org.brewchain.backend.ordbgens.bc.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.List;
import java.util.Map;
import org.brewchain.backend.ordbgens.bc.entity.BCMtxSignature;
import org.brewchain.backend.ordbgens.bc.entity.BCMtxSignatureExample.Criteria;
import org.brewchain.backend.ordbgens.bc.entity.BCMtxSignatureExample.Criterion;
import org.brewchain.backend.ordbgens.bc.entity.BCMtxSignatureExample;

public class BCMtxSignatureSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_SIGNATURE
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String countByExample(BCMtxSignatureExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("BC_MTX_SIGNATURE");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_SIGNATURE
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String deleteByExample(BCMtxSignatureExample example) {
        BEGIN();
        DELETE_FROM("BC_MTX_SIGNATURE");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_SIGNATURE
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String insertSelective(BCMtxSignature record) {
        BEGIN();
        INSERT_INTO("BC_MTX_SIGNATURE");
        
        if (record.getMtxSignid() != null) {
            VALUES("MTX_SIGNID", "#{mtxSignid,jdbcType=VARCHAR}");
        }
        
        if (record.getBcAddress() != null) {
            VALUES("BC_ADDRESS", "#{bcAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getMtxHash() != null) {
            VALUES("MTX_HASH", "#{mtxHash,jdbcType=VARCHAR}");
        }
        
        if (record.getSignData() != null) {
            VALUES("SIGN_DATA", "#{signData,jdbcType=VARCHAR}");
        }
        
        if (record.getTxStatus() != null) {
            VALUES("TX_STATUS", "#{txStatus,jdbcType=CHAR}");
        }
        
        if (record.getIndexInTx() != null) {
            VALUES("INDEX_IN_TX", "#{indexInTx,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_SIGNATURE
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String selectByExample(BCMtxSignatureExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("MTX_SIGNID");
        } else {
            SELECT("MTX_SIGNID");
        }
        SELECT("BC_ADDRESS");
        SELECT("MTX_HASH");
        SELECT("SIGN_DATA");
        SELECT("TX_STATUS");
        SELECT("INDEX_IN_TX");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("BC_MTX_SIGNATURE");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        if(example!=null&&example.getSelectCols()!=null&&example.getSelectCols().trim().length()>0){
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT(example.getSelectCols());
		} else {
				SELECT(example.getSelectCols());
		}
				FROM("BC_MTX_SIGNATURE");				applyWhere(example, false);
		}
        if(example != null){
            String sql = SQL();

            if(example.getGroupByClause()!=null&&example.getGroupByClause().trim().length()>0)  sql=sql.concat("group by ").concat(example.getGroupByClause());
            if(example.getLimit() !=  Integer.MAX_VALUE && example.getOffset() >0 ){
                String retstr= sql.concat(" limit "+example.getOffset()+","+example.getLimit());
                if(example.isForUpdate()) { return retstr+"  FOR UPDATE " ;} else { return retstr;}}
                else if(example.isForUpdate()){  return sql+"  FOR UPDATE " ;  }
                
		return sql;}

                return SQL();
            }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_SIGNATURE
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        BCMtxSignature record = (BCMtxSignature) parameter.get("record");
        BCMtxSignatureExample example = (BCMtxSignatureExample) parameter.get("example");
        
        BEGIN();
        UPDATE("BC_MTX_SIGNATURE");
        
        if (record.getMtxSignid() != null) {
            SET("MTX_SIGNID = #{record.mtxSignid,jdbcType=VARCHAR}");
        }
        
        if (record.getBcAddress() != null) {
            SET("BC_ADDRESS = #{record.bcAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getMtxHash() != null) {
            SET("MTX_HASH = #{record.mtxHash,jdbcType=VARCHAR}");
        }
        
        if (record.getSignData() != null) {
            SET("SIGN_DATA = #{record.signData,jdbcType=VARCHAR}");
        }
        
        if (record.getTxStatus() != null) {
            SET("TX_STATUS = #{record.txStatus,jdbcType=CHAR}");
        }
        
        if (record.getIndexInTx() != null) {
            SET("INDEX_IN_TX = #{record.indexInTx,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_SIGNATURE
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("BC_MTX_SIGNATURE");
        
        SET("MTX_SIGNID = #{record.mtxSignid,jdbcType=VARCHAR}");
        SET("BC_ADDRESS = #{record.bcAddress,jdbcType=VARCHAR}");
        SET("MTX_HASH = #{record.mtxHash,jdbcType=VARCHAR}");
        SET("SIGN_DATA = #{record.signData,jdbcType=VARCHAR}");
        SET("TX_STATUS = #{record.txStatus,jdbcType=CHAR}");
        SET("INDEX_IN_TX = #{record.indexInTx,jdbcType=INTEGER}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        BCMtxSignatureExample example = (BCMtxSignatureExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_SIGNATURE
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String updateByPrimaryKeySelective(BCMtxSignature record) {
        BEGIN();
        UPDATE("BC_MTX_SIGNATURE");
        
        if (record.getBcAddress() != null) {
            SET("BC_ADDRESS = #{bcAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getMtxHash() != null) {
            SET("MTX_HASH = #{mtxHash,jdbcType=VARCHAR}");
        }
        
        if (record.getSignData() != null) {
            SET("SIGN_DATA = #{signData,jdbcType=VARCHAR}");
        }
        
        if (record.getTxStatus() != null) {
            SET("TX_STATUS = #{txStatus,jdbcType=CHAR}");
        }
        
        if (record.getIndexInTx() != null) {
            SET("INDEX_IN_TX = #{indexInTx,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("MTX_SIGNID = #{mtxSignid,jdbcType=VARCHAR}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_SIGNATURE
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    protected void applyWhere(BCMtxSignatureExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}
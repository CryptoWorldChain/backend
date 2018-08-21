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
import org.brewchain.backend.ordbgens.bc.entity.BCGlobalProps;
import org.brewchain.backend.ordbgens.bc.entity.BCGlobalPropsExample.Criteria;
import org.brewchain.backend.ordbgens.bc.entity.BCGlobalPropsExample.Criterion;
import org.brewchain.backend.ordbgens.bc.entity.BCGlobalPropsExample;

public class BCGlobalPropsSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_GLOBAL_PROPS
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String countByExample(BCGlobalPropsExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("BC_GLOBAL_PROPS");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_GLOBAL_PROPS
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String deleteByExample(BCGlobalPropsExample example) {
        BEGIN();
        DELETE_FROM("BC_GLOBAL_PROPS");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_GLOBAL_PROPS
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String insertSelective(BCGlobalProps record) {
        BEGIN();
        INSERT_INTO("BC_GLOBAL_PROPS");
        
        if (record.getLogUuid() != null) {
            VALUES("LOG_UUID", "#{logUuid,jdbcType=VARCHAR}");
        }
        
        if (record.getBversion() != null) {
            VALUES("BVERSION", "#{bversion,jdbcType=VARCHAR}");
        }
        
        if (record.getBlockHeight() != null) {
            VALUES("BLOCK_HEIGHT", "#{blockHeight,jdbcType=DECIMAL}");
        }
        
        if (record.getPropKey() != null) {
            VALUES("PROP_KEY", "#{propKey,jdbcType=VARCHAR}");
        }
        
        if (record.getPropValue() != null) {
            VALUES("PROP_VALUE", "#{propValue,jdbcType=VARCHAR}");
        }
        
        if (record.getMptType() != null) {
            VALUES("MPT_TYPE", "#{mptType,jdbcType=VARCHAR}");
        }
        
        if (record.getHashValue() != null) {
            VALUES("HASH_VALUE", "#{hashValue,jdbcType=VARCHAR}");
        }
        
        if (record.getTxid() != null) {
            VALUES("TXID", "#{txid,jdbcType=VARCHAR}");
        }
        
        if (record.getPrevHashValue() != null) {
            VALUES("PREV_HASH_VALUE", "#{prevHashValue,jdbcType=VARCHAR}");
        }
        
        if (record.getPrevBlockHeight() != null) {
            VALUES("PREV_BLOCK_HEIGHT", "#{prevBlockHeight,jdbcType=DECIMAL}");
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
     * This method corresponds to the database table BC_GLOBAL_PROPS
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String selectByExample(BCGlobalPropsExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("LOG_UUID");
        } else {
            SELECT("LOG_UUID");
        }
        SELECT("BVERSION");
        SELECT("BLOCK_HEIGHT");
        SELECT("PROP_KEY");
        SELECT("PROP_VALUE");
        SELECT("MPT_TYPE");
        SELECT("HASH_VALUE");
        SELECT("TXID");
        SELECT("PREV_HASH_VALUE");
        SELECT("PREV_BLOCK_HEIGHT");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("BC_GLOBAL_PROPS");
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
				FROM("BC_GLOBAL_PROPS");				applyWhere(example, false);
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
     * This method corresponds to the database table BC_GLOBAL_PROPS
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        BCGlobalProps record = (BCGlobalProps) parameter.get("record");
        BCGlobalPropsExample example = (BCGlobalPropsExample) parameter.get("example");
        
        BEGIN();
        UPDATE("BC_GLOBAL_PROPS");
        
        if (record.getLogUuid() != null) {
            SET("LOG_UUID = #{record.logUuid,jdbcType=VARCHAR}");
        }
        
        if (record.getBversion() != null) {
            SET("BVERSION = #{record.bversion,jdbcType=VARCHAR}");
        }
        
        if (record.getBlockHeight() != null) {
            SET("BLOCK_HEIGHT = #{record.blockHeight,jdbcType=DECIMAL}");
        }
        
        if (record.getPropKey() != null) {
            SET("PROP_KEY = #{record.propKey,jdbcType=VARCHAR}");
        }
        
        if (record.getPropValue() != null) {
            SET("PROP_VALUE = #{record.propValue,jdbcType=VARCHAR}");
        }
        
        if (record.getMptType() != null) {
            SET("MPT_TYPE = #{record.mptType,jdbcType=VARCHAR}");
        }
        
        if (record.getHashValue() != null) {
            SET("HASH_VALUE = #{record.hashValue,jdbcType=VARCHAR}");
        }
        
        if (record.getTxid() != null) {
            SET("TXID = #{record.txid,jdbcType=VARCHAR}");
        }
        
        if (record.getPrevHashValue() != null) {
            SET("PREV_HASH_VALUE = #{record.prevHashValue,jdbcType=VARCHAR}");
        }
        
        if (record.getPrevBlockHeight() != null) {
            SET("PREV_BLOCK_HEIGHT = #{record.prevBlockHeight,jdbcType=DECIMAL}");
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
     * This method corresponds to the database table BC_GLOBAL_PROPS
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("BC_GLOBAL_PROPS");
        
        SET("LOG_UUID = #{record.logUuid,jdbcType=VARCHAR}");
        SET("BVERSION = #{record.bversion,jdbcType=VARCHAR}");
        SET("BLOCK_HEIGHT = #{record.blockHeight,jdbcType=DECIMAL}");
        SET("PROP_KEY = #{record.propKey,jdbcType=VARCHAR}");
        SET("PROP_VALUE = #{record.propValue,jdbcType=VARCHAR}");
        SET("MPT_TYPE = #{record.mptType,jdbcType=VARCHAR}");
        SET("HASH_VALUE = #{record.hashValue,jdbcType=VARCHAR}");
        SET("TXID = #{record.txid,jdbcType=VARCHAR}");
        SET("PREV_HASH_VALUE = #{record.prevHashValue,jdbcType=VARCHAR}");
        SET("PREV_BLOCK_HEIGHT = #{record.prevBlockHeight,jdbcType=DECIMAL}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        BCGlobalPropsExample example = (BCGlobalPropsExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_GLOBAL_PROPS
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String updateByPrimaryKeySelective(BCGlobalProps record) {
        BEGIN();
        UPDATE("BC_GLOBAL_PROPS");
        
        if (record.getBversion() != null) {
            SET("BVERSION = #{bversion,jdbcType=VARCHAR}");
        }
        
        if (record.getBlockHeight() != null) {
            SET("BLOCK_HEIGHT = #{blockHeight,jdbcType=DECIMAL}");
        }
        
        if (record.getPropKey() != null) {
            SET("PROP_KEY = #{propKey,jdbcType=VARCHAR}");
        }
        
        if (record.getPropValue() != null) {
            SET("PROP_VALUE = #{propValue,jdbcType=VARCHAR}");
        }
        
        if (record.getMptType() != null) {
            SET("MPT_TYPE = #{mptType,jdbcType=VARCHAR}");
        }
        
        if (record.getHashValue() != null) {
            SET("HASH_VALUE = #{hashValue,jdbcType=VARCHAR}");
        }
        
        if (record.getTxid() != null) {
            SET("TXID = #{txid,jdbcType=VARCHAR}");
        }
        
        if (record.getPrevHashValue() != null) {
            SET("PREV_HASH_VALUE = #{prevHashValue,jdbcType=VARCHAR}");
        }
        
        if (record.getPrevBlockHeight() != null) {
            SET("PREV_BLOCK_HEIGHT = #{prevBlockHeight,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("LOG_UUID = #{logUuid,jdbcType=VARCHAR}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_GLOBAL_PROPS
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    protected void applyWhere(BCGlobalPropsExample example, boolean includeExamplePhrase) {
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
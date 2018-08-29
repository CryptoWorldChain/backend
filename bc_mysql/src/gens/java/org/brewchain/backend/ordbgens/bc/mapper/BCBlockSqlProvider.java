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
import org.brewchain.backend.ordbgens.bc.entity.BCBlock;
import org.brewchain.backend.ordbgens.bc.entity.BCBlockExample.Criteria;
import org.brewchain.backend.ordbgens.bc.entity.BCBlockExample.Criterion;
import org.brewchain.backend.ordbgens.bc.entity.BCBlockExample;

public class BCBlockSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_BLOCK
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String countByExample(BCBlockExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("BC_BLOCK");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_BLOCK
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String deleteByExample(BCBlockExample example) {
        BEGIN();
        DELETE_FROM("BC_BLOCK");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_BLOCK
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String insertSelective(BCBlock record) {
        BEGIN();
        INSERT_INTO("BC_BLOCK");
        
        if (record.getLogUuid() != null) {
            VALUES("LOG_UUID", "#{logUuid,jdbcType=VARCHAR}");
        }
        
        if (record.getBversion() != null) {
            VALUES("BVERSION", "#{bversion,jdbcType=VARCHAR}");
        }
        
        if (record.getSecondIdx() != null) {
            VALUES("SECOND_IDX", "#{secondIdx,jdbcType=VARCHAR}");
        }
        
        if (record.getBhParentHash() != null) {
            VALUES("BH_PARENT_HASH", "#{bhParentHash,jdbcType=VARCHAR}");
        }
        
        if (record.getBhStateRoot() != null) {
            VALUES("BH_STATE_ROOT", "#{bhStateRoot,jdbcType=VARCHAR}");
        }
        
        if (record.getBhBlockHash() != null) {
            VALUES("BH_BLOCK_HASH", "#{bhBlockHash,jdbcType=VARCHAR}");
        }
        
        if (record.getBhTxtRieroot() != null) {
            VALUES("BH_TXT_RIEROOT", "#{bhTxtRieroot,jdbcType=VARCHAR}");
        }
        
        if (record.getBhReceiptTrieroot() != null) {
            VALUES("BH_RECEIPT_TRIEROOT", "#{bhReceiptTrieroot,jdbcType=VARCHAR}");
        }
        
        if (record.getBhTimestamp() != null) {
            VALUES("BH_TIMESTAMP", "#{bhTimestamp,jdbcType=DECIMAL}");
        }
        
        if (record.getBhNumber() != null) {
            VALUES("BH_NUMBER", "#{bhNumber,jdbcType=DECIMAL}");
        }
        
        if (record.getBhTxnCount() != null) {
            VALUES("BH_TXN_COUNT", "#{bhTxnCount,jdbcType=INTEGER}");
        }
        
        if (record.getBhSliceid() != null) {
            VALUES("BH_SLICEID", "#{bhSliceid,jdbcType=INTEGER}");
        }
        
        if (record.getBhExtradata() != null) {
            VALUES("BH_EXTRADATA", "#{bhExtradata,jdbcType=VARCHAR}");
        }
        
        if (record.getBmNode() != null) {
            VALUES("BM_NODE", "#{bmNode,jdbcType=VARCHAR}");
        }
        
        if (record.getBmRewardHex() != null) {
            VALUES("BM_REWARD_HEX", "#{bmRewardHex,jdbcType=VARCHAR}");
        }
        
        if (record.getBmAddress() != null) {
            VALUES("BM_ADDRESS", "#{bmAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getBmBcuid() != null) {
            VALUES("BM_BCUID", "#{bmBcuid,jdbcType=VARCHAR}");
        }
        
        if (record.getBlockStatus() != null) {
            VALUES("BLOCK_STATUS", "#{blockStatus,jdbcType=CHAR}");
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
     * This method corresponds to the database table BC_BLOCK
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String selectByExample(BCBlockExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("LOG_UUID");
        } else {
            SELECT("LOG_UUID");
        }
        SELECT("BVERSION");
        SELECT("SECOND_IDX");
        SELECT("BH_PARENT_HASH");
        SELECT("BH_STATE_ROOT");
        SELECT("BH_BLOCK_HASH");
        SELECT("BH_TXT_RIEROOT");
        SELECT("BH_RECEIPT_TRIEROOT");
        SELECT("BH_TIMESTAMP");
        SELECT("BH_NUMBER");
        SELECT("BH_TXN_COUNT");
        SELECT("BH_SLICEID");
        SELECT("BH_EXTRADATA");
        SELECT("BM_NODE");
        SELECT("BM_REWARD_HEX");
        SELECT("BM_ADDRESS");
        SELECT("BM_BCUID");
        SELECT("BLOCK_STATUS");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("BC_BLOCK");
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
				FROM("BC_BLOCK");				applyWhere(example, false);
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
     * This method corresponds to the database table BC_BLOCK
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        BCBlock record = (BCBlock) parameter.get("record");
        BCBlockExample example = (BCBlockExample) parameter.get("example");
        
        BEGIN();
        UPDATE("BC_BLOCK");
        
        if (record.getLogUuid() != null) {
            SET("LOG_UUID = #{record.logUuid,jdbcType=VARCHAR}");
        }
        
        if (record.getBversion() != null) {
            SET("BVERSION = #{record.bversion,jdbcType=VARCHAR}");
        }
        
        if (record.getSecondIdx() != null) {
            SET("SECOND_IDX = #{record.secondIdx,jdbcType=VARCHAR}");
        }
        
        if (record.getBhParentHash() != null) {
            SET("BH_PARENT_HASH = #{record.bhParentHash,jdbcType=VARCHAR}");
        }
        
        if (record.getBhStateRoot() != null) {
            SET("BH_STATE_ROOT = #{record.bhStateRoot,jdbcType=VARCHAR}");
        }
        
        if (record.getBhBlockHash() != null) {
            SET("BH_BLOCK_HASH = #{record.bhBlockHash,jdbcType=VARCHAR}");
        }
        
        if (record.getBhTxtRieroot() != null) {
            SET("BH_TXT_RIEROOT = #{record.bhTxtRieroot,jdbcType=VARCHAR}");
        }
        
        if (record.getBhReceiptTrieroot() != null) {
            SET("BH_RECEIPT_TRIEROOT = #{record.bhReceiptTrieroot,jdbcType=VARCHAR}");
        }
        
        if (record.getBhTimestamp() != null) {
            SET("BH_TIMESTAMP = #{record.bhTimestamp,jdbcType=DECIMAL}");
        }
        
        if (record.getBhNumber() != null) {
            SET("BH_NUMBER = #{record.bhNumber,jdbcType=DECIMAL}");
        }
        
        if (record.getBhTxnCount() != null) {
            SET("BH_TXN_COUNT = #{record.bhTxnCount,jdbcType=INTEGER}");
        }
        
        if (record.getBhSliceid() != null) {
            SET("BH_SLICEID = #{record.bhSliceid,jdbcType=INTEGER}");
        }
        
        if (record.getBhExtradata() != null) {
            SET("BH_EXTRADATA = #{record.bhExtradata,jdbcType=VARCHAR}");
        }
        
        if (record.getBmNode() != null) {
            SET("BM_NODE = #{record.bmNode,jdbcType=VARCHAR}");
        }
        
        if (record.getBmRewardHex() != null) {
            SET("BM_REWARD_HEX = #{record.bmRewardHex,jdbcType=VARCHAR}");
        }
        
        if (record.getBmAddress() != null) {
            SET("BM_ADDRESS = #{record.bmAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getBmBcuid() != null) {
            SET("BM_BCUID = #{record.bmBcuid,jdbcType=VARCHAR}");
        }
        
        if (record.getBlockStatus() != null) {
            SET("BLOCK_STATUS = #{record.blockStatus,jdbcType=CHAR}");
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
     * This method corresponds to the database table BC_BLOCK
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("BC_BLOCK");
        
        SET("LOG_UUID = #{record.logUuid,jdbcType=VARCHAR}");
        SET("BVERSION = #{record.bversion,jdbcType=VARCHAR}");
        SET("SECOND_IDX = #{record.secondIdx,jdbcType=VARCHAR}");
        SET("BH_PARENT_HASH = #{record.bhParentHash,jdbcType=VARCHAR}");
        SET("BH_STATE_ROOT = #{record.bhStateRoot,jdbcType=VARCHAR}");
        SET("BH_BLOCK_HASH = #{record.bhBlockHash,jdbcType=VARCHAR}");
        SET("BH_TXT_RIEROOT = #{record.bhTxtRieroot,jdbcType=VARCHAR}");
        SET("BH_RECEIPT_TRIEROOT = #{record.bhReceiptTrieroot,jdbcType=VARCHAR}");
        SET("BH_TIMESTAMP = #{record.bhTimestamp,jdbcType=DECIMAL}");
        SET("BH_NUMBER = #{record.bhNumber,jdbcType=DECIMAL}");
        SET("BH_TXN_COUNT = #{record.bhTxnCount,jdbcType=INTEGER}");
        SET("BH_SLICEID = #{record.bhSliceid,jdbcType=INTEGER}");
        SET("BH_EXTRADATA = #{record.bhExtradata,jdbcType=VARCHAR}");
        SET("BM_NODE = #{record.bmNode,jdbcType=VARCHAR}");
        SET("BM_REWARD_HEX = #{record.bmRewardHex,jdbcType=VARCHAR}");
        SET("BM_ADDRESS = #{record.bmAddress,jdbcType=VARCHAR}");
        SET("BM_BCUID = #{record.bmBcuid,jdbcType=VARCHAR}");
        SET("BLOCK_STATUS = #{record.blockStatus,jdbcType=CHAR}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        BCBlockExample example = (BCBlockExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_BLOCK
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String updateByPrimaryKeySelective(BCBlock record) {
        BEGIN();
        UPDATE("BC_BLOCK");
        
        if (record.getBversion() != null) {
            SET("BVERSION = #{bversion,jdbcType=VARCHAR}");
        }
        
        if (record.getSecondIdx() != null) {
            SET("SECOND_IDX = #{secondIdx,jdbcType=VARCHAR}");
        }
        
        if (record.getBhParentHash() != null) {
            SET("BH_PARENT_HASH = #{bhParentHash,jdbcType=VARCHAR}");
        }
        
        if (record.getBhStateRoot() != null) {
            SET("BH_STATE_ROOT = #{bhStateRoot,jdbcType=VARCHAR}");
        }
        
        if (record.getBhBlockHash() != null) {
            SET("BH_BLOCK_HASH = #{bhBlockHash,jdbcType=VARCHAR}");
        }
        
        if (record.getBhTxtRieroot() != null) {
            SET("BH_TXT_RIEROOT = #{bhTxtRieroot,jdbcType=VARCHAR}");
        }
        
        if (record.getBhReceiptTrieroot() != null) {
            SET("BH_RECEIPT_TRIEROOT = #{bhReceiptTrieroot,jdbcType=VARCHAR}");
        }
        
        if (record.getBhTimestamp() != null) {
            SET("BH_TIMESTAMP = #{bhTimestamp,jdbcType=DECIMAL}");
        }
        
        if (record.getBhNumber() != null) {
            SET("BH_NUMBER = #{bhNumber,jdbcType=DECIMAL}");
        }
        
        if (record.getBhTxnCount() != null) {
            SET("BH_TXN_COUNT = #{bhTxnCount,jdbcType=INTEGER}");
        }
        
        if (record.getBhSliceid() != null) {
            SET("BH_SLICEID = #{bhSliceid,jdbcType=INTEGER}");
        }
        
        if (record.getBhExtradata() != null) {
            SET("BH_EXTRADATA = #{bhExtradata,jdbcType=VARCHAR}");
        }
        
        if (record.getBmNode() != null) {
            SET("BM_NODE = #{bmNode,jdbcType=VARCHAR}");
        }
        
        if (record.getBmRewardHex() != null) {
            SET("BM_REWARD_HEX = #{bmRewardHex,jdbcType=VARCHAR}");
        }
        
        if (record.getBmAddress() != null) {
            SET("BM_ADDRESS = #{bmAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getBmBcuid() != null) {
            SET("BM_BCUID = #{bmBcuid,jdbcType=VARCHAR}");
        }
        
        if (record.getBlockStatus() != null) {
            SET("BLOCK_STATUS = #{blockStatus,jdbcType=CHAR}");
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
     * This method corresponds to the database table BC_BLOCK
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    protected void applyWhere(BCBlockExample example, boolean includeExamplePhrase) {
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
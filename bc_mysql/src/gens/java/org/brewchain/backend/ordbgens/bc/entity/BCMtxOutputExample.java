package org.brewchain.backend.ordbgens.bc.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BCMtxOutputExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BC_MTX_OUTPUT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BC_MTX_OUTPUT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BC_MTX_OUTPUT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    protected List<Criteria> oredCriteria;

    protected int offset;

    protected int limit;

    protected String sumCol;

    protected String groupSelClause;

    protected boolean forUpdate;

    protected String groupByClause;

    String selectCols;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_OUTPUT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public BCMtxOutputExample() {
        oredCriteria = new ArrayList<Criteria>();
        offset = 0;
        limit = Integer.MAX_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_OUTPUT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_OUTPUT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_OUTPUT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_OUTPUT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_OUTPUT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_OUTPUT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_OUTPUT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_OUTPUT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_OUTPUT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_OUTPUT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        this.offset= 0;
        this.limit= Integer.MAX_VALUE;
        this.sumCol=null;
        this.groupSelClause=null;
        this.groupByClause=null;
        this.forUpdate=false;
    }

    public void setOffset(int offset) {
         this.offset = offset;
    }

    public int getOffset() {
          return offset;
    }

    public void setLimit(int limit) {
         this.limit = limit;
    }

    public int getLimit() {
          return limit;
    }

    public void setSumCol(String sumCol) {
         this.sumCol = sumCol;
    }

    public String getSumCol() {
          return sumCol;
    }

    public void setGroupSelClause(String groupSelClause) {
         this.groupSelClause = groupSelClause;
    }

    public String getGroupSelClause() {
          return groupSelClause;
    }

    public void setForUpdate(boolean forUpdate) {
         this.forUpdate = forUpdate;
    }

    public boolean isForUpdate() {
          return forUpdate;
    }

    public void setGroupByClause(String groupByClause) {
         this.groupByClause = groupByClause;
    }

    public String getGroupByClause() {
          return groupByClause;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table BC_MTX_OUTPUT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    @Data
    public abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        public GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        public void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        public void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        public void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMtxOutputidIsNull() {
            addCriterion("MTX_OUTPUTID is null");
            return (Criteria) this;
        }

        public Criteria andMtxOutputidIsNotNull() {
            addCriterion("MTX_OUTPUTID is not null");
            return (Criteria) this;
        }

        public Criteria andMtxOutputidEqualTo(String value) {
            addCriterion("MTX_OUTPUTID =", value, "mtxOutputid");
            return (Criteria) this;
        }

        public Criteria andMtxOutputidNotEqualTo(String value) {
            addCriterion("MTX_OUTPUTID <>", value, "mtxOutputid");
            return (Criteria) this;
        }

        public Criteria andMtxOutputidGreaterThan(String value) {
            addCriterion("MTX_OUTPUTID >", value, "mtxOutputid");
            return (Criteria) this;
        }

        public Criteria andMtxOutputidGreaterThanOrEqualTo(String value) {
            addCriterion("MTX_OUTPUTID >=", value, "mtxOutputid");
            return (Criteria) this;
        }

        public Criteria andMtxOutputidLessThan(String value) {
            addCriterion("MTX_OUTPUTID <", value, "mtxOutputid");
            return (Criteria) this;
        }

        public Criteria andMtxOutputidLessThanOrEqualTo(String value) {
            addCriterion("MTX_OUTPUTID <=", value, "mtxOutputid");
            return (Criteria) this;
        }

        public Criteria andMtxOutputidLike(String value) {
            addCriterion("MTX_OUTPUTID like", value, "mtxOutputid");
            return (Criteria) this;
        }

        public Criteria andMtxOutputidNotLike(String value) {
            addCriterion("MTX_OUTPUTID not like", value, "mtxOutputid");
            return (Criteria) this;
        }

        public Criteria andMtxOutputidIn(List<String> values) {
            addCriterion("MTX_OUTPUTID in", values, "mtxOutputid");
            return (Criteria) this;
        }

        public Criteria andMtxOutputidNotIn(List<String> values) {
            addCriterion("MTX_OUTPUTID not in", values, "mtxOutputid");
            return (Criteria) this;
        }

        public Criteria andMtxOutputidBetween(String value1, String value2) {
            addCriterion("MTX_OUTPUTID between", value1, value2, "mtxOutputid");
            return (Criteria) this;
        }

        public Criteria andMtxOutputidNotBetween(String value1, String value2) {
            addCriterion("MTX_OUTPUTID not between", value1, value2, "mtxOutputid");
            return (Criteria) this;
        }

        public Criteria andBcAddressIsNull() {
            addCriterion("BC_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andBcAddressIsNotNull() {
            addCriterion("BC_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andBcAddressEqualTo(String value) {
            addCriterion("BC_ADDRESS =", value, "bcAddress");
            return (Criteria) this;
        }

        public Criteria andBcAddressNotEqualTo(String value) {
            addCriterion("BC_ADDRESS <>", value, "bcAddress");
            return (Criteria) this;
        }

        public Criteria andBcAddressGreaterThan(String value) {
            addCriterion("BC_ADDRESS >", value, "bcAddress");
            return (Criteria) this;
        }

        public Criteria andBcAddressGreaterThanOrEqualTo(String value) {
            addCriterion("BC_ADDRESS >=", value, "bcAddress");
            return (Criteria) this;
        }

        public Criteria andBcAddressLessThan(String value) {
            addCriterion("BC_ADDRESS <", value, "bcAddress");
            return (Criteria) this;
        }

        public Criteria andBcAddressLessThanOrEqualTo(String value) {
            addCriterion("BC_ADDRESS <=", value, "bcAddress");
            return (Criteria) this;
        }

        public Criteria andBcAddressLike(String value) {
            addCriterion("BC_ADDRESS like", value, "bcAddress");
            return (Criteria) this;
        }

        public Criteria andBcAddressNotLike(String value) {
            addCriterion("BC_ADDRESS not like", value, "bcAddress");
            return (Criteria) this;
        }

        public Criteria andBcAddressIn(List<String> values) {
            addCriterion("BC_ADDRESS in", values, "bcAddress");
            return (Criteria) this;
        }

        public Criteria andBcAddressNotIn(List<String> values) {
            addCriterion("BC_ADDRESS not in", values, "bcAddress");
            return (Criteria) this;
        }

        public Criteria andBcAddressBetween(String value1, String value2) {
            addCriterion("BC_ADDRESS between", value1, value2, "bcAddress");
            return (Criteria) this;
        }

        public Criteria andBcAddressNotBetween(String value1, String value2) {
            addCriterion("BC_ADDRESS not between", value1, value2, "bcAddress");
            return (Criteria) this;
        }

        public Criteria andMtxHashIsNull() {
            addCriterion("MTX_HASH is null");
            return (Criteria) this;
        }

        public Criteria andMtxHashIsNotNull() {
            addCriterion("MTX_HASH is not null");
            return (Criteria) this;
        }

        public Criteria andMtxHashEqualTo(String value) {
            addCriterion("MTX_HASH =", value, "mtxHash");
            return (Criteria) this;
        }

        public Criteria andMtxHashNotEqualTo(String value) {
            addCriterion("MTX_HASH <>", value, "mtxHash");
            return (Criteria) this;
        }

        public Criteria andMtxHashGreaterThan(String value) {
            addCriterion("MTX_HASH >", value, "mtxHash");
            return (Criteria) this;
        }

        public Criteria andMtxHashGreaterThanOrEqualTo(String value) {
            addCriterion("MTX_HASH >=", value, "mtxHash");
            return (Criteria) this;
        }

        public Criteria andMtxHashLessThan(String value) {
            addCriterion("MTX_HASH <", value, "mtxHash");
            return (Criteria) this;
        }

        public Criteria andMtxHashLessThanOrEqualTo(String value) {
            addCriterion("MTX_HASH <=", value, "mtxHash");
            return (Criteria) this;
        }

        public Criteria andMtxHashLike(String value) {
            addCriterion("MTX_HASH like", value, "mtxHash");
            return (Criteria) this;
        }

        public Criteria andMtxHashNotLike(String value) {
            addCriterion("MTX_HASH not like", value, "mtxHash");
            return (Criteria) this;
        }

        public Criteria andMtxHashIn(List<String> values) {
            addCriterion("MTX_HASH in", values, "mtxHash");
            return (Criteria) this;
        }

        public Criteria andMtxHashNotIn(List<String> values) {
            addCriterion("MTX_HASH not in", values, "mtxHash");
            return (Criteria) this;
        }

        public Criteria andMtxHashBetween(String value1, String value2) {
            addCriterion("MTX_HASH between", value1, value2, "mtxHash");
            return (Criteria) this;
        }

        public Criteria andMtxHashNotBetween(String value1, String value2) {
            addCriterion("MTX_HASH not between", value1, value2, "mtxHash");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andTokenSymbolIsNull() {
            addCriterion("TOKEN_SYMBOL is null");
            return (Criteria) this;
        }

        public Criteria andTokenSymbolIsNotNull() {
            addCriterion("TOKEN_SYMBOL is not null");
            return (Criteria) this;
        }

        public Criteria andTokenSymbolEqualTo(String value) {
            addCriterion("TOKEN_SYMBOL =", value, "tokenSymbol");
            return (Criteria) this;
        }

        public Criteria andTokenSymbolNotEqualTo(String value) {
            addCriterion("TOKEN_SYMBOL <>", value, "tokenSymbol");
            return (Criteria) this;
        }

        public Criteria andTokenSymbolGreaterThan(String value) {
            addCriterion("TOKEN_SYMBOL >", value, "tokenSymbol");
            return (Criteria) this;
        }

        public Criteria andTokenSymbolGreaterThanOrEqualTo(String value) {
            addCriterion("TOKEN_SYMBOL >=", value, "tokenSymbol");
            return (Criteria) this;
        }

        public Criteria andTokenSymbolLessThan(String value) {
            addCriterion("TOKEN_SYMBOL <", value, "tokenSymbol");
            return (Criteria) this;
        }

        public Criteria andTokenSymbolLessThanOrEqualTo(String value) {
            addCriterion("TOKEN_SYMBOL <=", value, "tokenSymbol");
            return (Criteria) this;
        }

        public Criteria andTokenSymbolLike(String value) {
            addCriterion("TOKEN_SYMBOL like", value, "tokenSymbol");
            return (Criteria) this;
        }

        public Criteria andTokenSymbolNotLike(String value) {
            addCriterion("TOKEN_SYMBOL not like", value, "tokenSymbol");
            return (Criteria) this;
        }

        public Criteria andTokenSymbolIn(List<String> values) {
            addCriterion("TOKEN_SYMBOL in", values, "tokenSymbol");
            return (Criteria) this;
        }

        public Criteria andTokenSymbolNotIn(List<String> values) {
            addCriterion("TOKEN_SYMBOL not in", values, "tokenSymbol");
            return (Criteria) this;
        }

        public Criteria andTokenSymbolBetween(String value1, String value2) {
            addCriterion("TOKEN_SYMBOL between", value1, value2, "tokenSymbol");
            return (Criteria) this;
        }

        public Criteria andTokenSymbolNotBetween(String value1, String value2) {
            addCriterion("TOKEN_SYMBOL not between", value1, value2, "tokenSymbol");
            return (Criteria) this;
        }

        public Criteria andTxStatusIsNull() {
            addCriterion("TX_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andTxStatusIsNotNull() {
            addCriterion("TX_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andTxStatusEqualTo(String value) {
            addCriterion("TX_STATUS =", value, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusNotEqualTo(String value) {
            addCriterion("TX_STATUS <>", value, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusGreaterThan(String value) {
            addCriterion("TX_STATUS >", value, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusGreaterThanOrEqualTo(String value) {
            addCriterion("TX_STATUS >=", value, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusLessThan(String value) {
            addCriterion("TX_STATUS <", value, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusLessThanOrEqualTo(String value) {
            addCriterion("TX_STATUS <=", value, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusLike(String value) {
            addCriterion("TX_STATUS like", value, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusNotLike(String value) {
            addCriterion("TX_STATUS not like", value, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusIn(List<String> values) {
            addCriterion("TX_STATUS in", values, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusNotIn(List<String> values) {
            addCriterion("TX_STATUS not in", values, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusBetween(String value1, String value2) {
            addCriterion("TX_STATUS between", value1, value2, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusNotBetween(String value1, String value2) {
            addCriterion("TX_STATUS not between", value1, value2, "txStatus");
            return (Criteria) this;
        }

        public Criteria andIndexInTxIsNull() {
            addCriterion("INDEX_IN_TX is null");
            return (Criteria) this;
        }

        public Criteria andIndexInTxIsNotNull() {
            addCriterion("INDEX_IN_TX is not null");
            return (Criteria) this;
        }

        public Criteria andIndexInTxEqualTo(Integer value) {
            addCriterion("INDEX_IN_TX =", value, "indexInTx");
            return (Criteria) this;
        }

        public Criteria andIndexInTxNotEqualTo(Integer value) {
            addCriterion("INDEX_IN_TX <>", value, "indexInTx");
            return (Criteria) this;
        }

        public Criteria andIndexInTxGreaterThan(Integer value) {
            addCriterion("INDEX_IN_TX >", value, "indexInTx");
            return (Criteria) this;
        }

        public Criteria andIndexInTxGreaterThanOrEqualTo(Integer value) {
            addCriterion("INDEX_IN_TX >=", value, "indexInTx");
            return (Criteria) this;
        }

        public Criteria andIndexInTxLessThan(Integer value) {
            addCriterion("INDEX_IN_TX <", value, "indexInTx");
            return (Criteria) this;
        }

        public Criteria andIndexInTxLessThanOrEqualTo(Integer value) {
            addCriterion("INDEX_IN_TX <=", value, "indexInTx");
            return (Criteria) this;
        }

        public Criteria andIndexInTxIn(List<Integer> values) {
            addCriterion("INDEX_IN_TX in", values, "indexInTx");
            return (Criteria) this;
        }

        public Criteria andIndexInTxNotIn(List<Integer> values) {
            addCriterion("INDEX_IN_TX not in", values, "indexInTx");
            return (Criteria) this;
        }

        public Criteria andIndexInTxBetween(Integer value1, Integer value2) {
            addCriterion("INDEX_IN_TX between", value1, value2, "indexInTx");
            return (Criteria) this;
        }

        public Criteria andIndexInTxNotBetween(Integer value1, Integer value2) {
            addCriterion("INDEX_IN_TX not between", value1, value2, "indexInTx");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andMtxOutputidLikeInsensitive(String value) {
            addCriterion("upper(MTX_OUTPUTID) like", value.toUpperCase(), "mtxOutputid");
            return (Criteria) this;
        }

        public Criteria andBcAddressLikeInsensitive(String value) {
            addCriterion("upper(BC_ADDRESS) like", value.toUpperCase(), "bcAddress");
            return (Criteria) this;
        }

        public Criteria andMtxHashLikeInsensitive(String value) {
            addCriterion("upper(MTX_HASH) like", value.toUpperCase(), "mtxHash");
            return (Criteria) this;
        }

        public Criteria andTokenSymbolLikeInsensitive(String value) {
            addCriterion("upper(TOKEN_SYMBOL) like", value.toUpperCase(), "tokenSymbol");
            return (Criteria) this;
        }

        public Criteria andTxStatusLikeInsensitive(String value) {
            addCriterion("upper(TX_STATUS) like", value.toUpperCase(), "txStatus");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table BC_MTX_OUTPUT
     *
     * @mbggenerated do_not_delete_during_merge Tue Aug 21 20:42:28 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        public Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table BC_MTX_OUTPUT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    @Data
    @NoArgsConstructor
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        public Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        public Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        public Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        public Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        public Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
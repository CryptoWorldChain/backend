package org.brewchain.backend.ordbgens.bc.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BCActTokenValueExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BC_ACT_TOKEN_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BC_ACT_TOKEN_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BC_ACT_TOKEN_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
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
     * This method corresponds to the database table BC_ACT_TOKEN_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    public BCActTokenValueExample() {
        oredCriteria = new ArrayList<Criteria>();
        offset = 0;
        limit = Integer.MAX_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_TOKEN_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_TOKEN_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_TOKEN_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_TOKEN_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_TOKEN_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_TOKEN_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_TOKEN_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_TOKEN_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
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
     * This method corresponds to the database table BC_ACT_TOKEN_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_TOKEN_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
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
     * This class corresponds to the database table BC_ACT_TOKEN_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
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

        public Criteria andActvTokenIdIsNull() {
            addCriterion("ACTV_TOKEN_ID is null");
            return (Criteria) this;
        }

        public Criteria andActvTokenIdIsNotNull() {
            addCriterion("ACTV_TOKEN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andActvTokenIdEqualTo(String value) {
            addCriterion("ACTV_TOKEN_ID =", value, "actvTokenId");
            return (Criteria) this;
        }

        public Criteria andActvTokenIdNotEqualTo(String value) {
            addCriterion("ACTV_TOKEN_ID <>", value, "actvTokenId");
            return (Criteria) this;
        }

        public Criteria andActvTokenIdGreaterThan(String value) {
            addCriterion("ACTV_TOKEN_ID >", value, "actvTokenId");
            return (Criteria) this;
        }

        public Criteria andActvTokenIdGreaterThanOrEqualTo(String value) {
            addCriterion("ACTV_TOKEN_ID >=", value, "actvTokenId");
            return (Criteria) this;
        }

        public Criteria andActvTokenIdLessThan(String value) {
            addCriterion("ACTV_TOKEN_ID <", value, "actvTokenId");
            return (Criteria) this;
        }

        public Criteria andActvTokenIdLessThanOrEqualTo(String value) {
            addCriterion("ACTV_TOKEN_ID <=", value, "actvTokenId");
            return (Criteria) this;
        }

        public Criteria andActvTokenIdLike(String value) {
            addCriterion("ACTV_TOKEN_ID like", value, "actvTokenId");
            return (Criteria) this;
        }

        public Criteria andActvTokenIdNotLike(String value) {
            addCriterion("ACTV_TOKEN_ID not like", value, "actvTokenId");
            return (Criteria) this;
        }

        public Criteria andActvTokenIdIn(List<String> values) {
            addCriterion("ACTV_TOKEN_ID in", values, "actvTokenId");
            return (Criteria) this;
        }

        public Criteria andActvTokenIdNotIn(List<String> values) {
            addCriterion("ACTV_TOKEN_ID not in", values, "actvTokenId");
            return (Criteria) this;
        }

        public Criteria andActvTokenIdBetween(String value1, String value2) {
            addCriterion("ACTV_TOKEN_ID between", value1, value2, "actvTokenId");
            return (Criteria) this;
        }

        public Criteria andActvTokenIdNotBetween(String value1, String value2) {
            addCriterion("ACTV_TOKEN_ID not between", value1, value2, "actvTokenId");
            return (Criteria) this;
        }

        public Criteria andActAddressIsNull() {
            addCriterion("ACT_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andActAddressIsNotNull() {
            addCriterion("ACT_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andActAddressEqualTo(String value) {
            addCriterion("ACT_ADDRESS =", value, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressNotEqualTo(String value) {
            addCriterion("ACT_ADDRESS <>", value, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressGreaterThan(String value) {
            addCriterion("ACT_ADDRESS >", value, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ACT_ADDRESS >=", value, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressLessThan(String value) {
            addCriterion("ACT_ADDRESS <", value, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressLessThanOrEqualTo(String value) {
            addCriterion("ACT_ADDRESS <=", value, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressLike(String value) {
            addCriterion("ACT_ADDRESS like", value, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressNotLike(String value) {
            addCriterion("ACT_ADDRESS not like", value, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressIn(List<String> values) {
            addCriterion("ACT_ADDRESS in", values, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressNotIn(List<String> values) {
            addCriterion("ACT_ADDRESS not in", values, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressBetween(String value1, String value2) {
            addCriterion("ACT_ADDRESS between", value1, value2, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActAddressNotBetween(String value1, String value2) {
            addCriterion("ACT_ADDRESS not between", value1, value2, "actAddress");
            return (Criteria) this;
        }

        public Criteria andActvTokenIsNull() {
            addCriterion("ACTV_TOKEN is null");
            return (Criteria) this;
        }

        public Criteria andActvTokenIsNotNull() {
            addCriterion("ACTV_TOKEN is not null");
            return (Criteria) this;
        }

        public Criteria andActvTokenEqualTo(String value) {
            addCriterion("ACTV_TOKEN =", value, "actvToken");
            return (Criteria) this;
        }

        public Criteria andActvTokenNotEqualTo(String value) {
            addCriterion("ACTV_TOKEN <>", value, "actvToken");
            return (Criteria) this;
        }

        public Criteria andActvTokenGreaterThan(String value) {
            addCriterion("ACTV_TOKEN >", value, "actvToken");
            return (Criteria) this;
        }

        public Criteria andActvTokenGreaterThanOrEqualTo(String value) {
            addCriterion("ACTV_TOKEN >=", value, "actvToken");
            return (Criteria) this;
        }

        public Criteria andActvTokenLessThan(String value) {
            addCriterion("ACTV_TOKEN <", value, "actvToken");
            return (Criteria) this;
        }

        public Criteria andActvTokenLessThanOrEqualTo(String value) {
            addCriterion("ACTV_TOKEN <=", value, "actvToken");
            return (Criteria) this;
        }

        public Criteria andActvTokenLike(String value) {
            addCriterion("ACTV_TOKEN like", value, "actvToken");
            return (Criteria) this;
        }

        public Criteria andActvTokenNotLike(String value) {
            addCriterion("ACTV_TOKEN not like", value, "actvToken");
            return (Criteria) this;
        }

        public Criteria andActvTokenIn(List<String> values) {
            addCriterion("ACTV_TOKEN in", values, "actvToken");
            return (Criteria) this;
        }

        public Criteria andActvTokenNotIn(List<String> values) {
            addCriterion("ACTV_TOKEN not in", values, "actvToken");
            return (Criteria) this;
        }

        public Criteria andActvTokenBetween(String value1, String value2) {
            addCriterion("ACTV_TOKEN between", value1, value2, "actvToken");
            return (Criteria) this;
        }

        public Criteria andActvTokenNotBetween(String value1, String value2) {
            addCriterion("ACTV_TOKEN not between", value1, value2, "actvToken");
            return (Criteria) this;
        }

        public Criteria andActvBalanceIsNull() {
            addCriterion("ACTV_BALANCE is null");
            return (Criteria) this;
        }

        public Criteria andActvBalanceIsNotNull() {
            addCriterion("ACTV_BALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andActvBalanceEqualTo(BigDecimal value) {
            addCriterion("ACTV_BALANCE =", value, "actvBalance");
            return (Criteria) this;
        }

        public Criteria andActvBalanceNotEqualTo(BigDecimal value) {
            addCriterion("ACTV_BALANCE <>", value, "actvBalance");
            return (Criteria) this;
        }

        public Criteria andActvBalanceGreaterThan(BigDecimal value) {
            addCriterion("ACTV_BALANCE >", value, "actvBalance");
            return (Criteria) this;
        }

        public Criteria andActvBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTV_BALANCE >=", value, "actvBalance");
            return (Criteria) this;
        }

        public Criteria andActvBalanceLessThan(BigDecimal value) {
            addCriterion("ACTV_BALANCE <", value, "actvBalance");
            return (Criteria) this;
        }

        public Criteria andActvBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTV_BALANCE <=", value, "actvBalance");
            return (Criteria) this;
        }

        public Criteria andActvBalanceIn(List<BigDecimal> values) {
            addCriterion("ACTV_BALANCE in", values, "actvBalance");
            return (Criteria) this;
        }

        public Criteria andActvBalanceNotIn(List<BigDecimal> values) {
            addCriterion("ACTV_BALANCE not in", values, "actvBalance");
            return (Criteria) this;
        }

        public Criteria andActvBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTV_BALANCE between", value1, value2, "actvBalance");
            return (Criteria) this;
        }

        public Criteria andActvBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTV_BALANCE not between", value1, value2, "actvBalance");
            return (Criteria) this;
        }

        public Criteria andActvLockedIsNull() {
            addCriterion("ACTV_LOCKED is null");
            return (Criteria) this;
        }

        public Criteria andActvLockedIsNotNull() {
            addCriterion("ACTV_LOCKED is not null");
            return (Criteria) this;
        }

        public Criteria andActvLockedEqualTo(BigDecimal value) {
            addCriterion("ACTV_LOCKED =", value, "actvLocked");
            return (Criteria) this;
        }

        public Criteria andActvLockedNotEqualTo(BigDecimal value) {
            addCriterion("ACTV_LOCKED <>", value, "actvLocked");
            return (Criteria) this;
        }

        public Criteria andActvLockedGreaterThan(BigDecimal value) {
            addCriterion("ACTV_LOCKED >", value, "actvLocked");
            return (Criteria) this;
        }

        public Criteria andActvLockedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTV_LOCKED >=", value, "actvLocked");
            return (Criteria) this;
        }

        public Criteria andActvLockedLessThan(BigDecimal value) {
            addCriterion("ACTV_LOCKED <", value, "actvLocked");
            return (Criteria) this;
        }

        public Criteria andActvLockedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTV_LOCKED <=", value, "actvLocked");
            return (Criteria) this;
        }

        public Criteria andActvLockedIn(List<BigDecimal> values) {
            addCriterion("ACTV_LOCKED in", values, "actvLocked");
            return (Criteria) this;
        }

        public Criteria andActvLockedNotIn(List<BigDecimal> values) {
            addCriterion("ACTV_LOCKED not in", values, "actvLocked");
            return (Criteria) this;
        }

        public Criteria andActvLockedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTV_LOCKED between", value1, value2, "actvLocked");
            return (Criteria) this;
        }

        public Criteria andActvLockedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTV_LOCKED not between", value1, value2, "actvLocked");
            return (Criteria) this;
        }

        public Criteria andActtStatusIsNull() {
            addCriterion("ACTT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andActtStatusIsNotNull() {
            addCriterion("ACTT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andActtStatusEqualTo(String value) {
            addCriterion("ACTT_STATUS =", value, "acttStatus");
            return (Criteria) this;
        }

        public Criteria andActtStatusNotEqualTo(String value) {
            addCriterion("ACTT_STATUS <>", value, "acttStatus");
            return (Criteria) this;
        }

        public Criteria andActtStatusGreaterThan(String value) {
            addCriterion("ACTT_STATUS >", value, "acttStatus");
            return (Criteria) this;
        }

        public Criteria andActtStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ACTT_STATUS >=", value, "acttStatus");
            return (Criteria) this;
        }

        public Criteria andActtStatusLessThan(String value) {
            addCriterion("ACTT_STATUS <", value, "acttStatus");
            return (Criteria) this;
        }

        public Criteria andActtStatusLessThanOrEqualTo(String value) {
            addCriterion("ACTT_STATUS <=", value, "acttStatus");
            return (Criteria) this;
        }

        public Criteria andActtStatusLike(String value) {
            addCriterion("ACTT_STATUS like", value, "acttStatus");
            return (Criteria) this;
        }

        public Criteria andActtStatusNotLike(String value) {
            addCriterion("ACTT_STATUS not like", value, "acttStatus");
            return (Criteria) this;
        }

        public Criteria andActtStatusIn(List<String> values) {
            addCriterion("ACTT_STATUS in", values, "acttStatus");
            return (Criteria) this;
        }

        public Criteria andActtStatusNotIn(List<String> values) {
            addCriterion("ACTT_STATUS not in", values, "acttStatus");
            return (Criteria) this;
        }

        public Criteria andActtStatusBetween(String value1, String value2) {
            addCriterion("ACTT_STATUS between", value1, value2, "acttStatus");
            return (Criteria) this;
        }

        public Criteria andActtStatusNotBetween(String value1, String value2) {
            addCriterion("ACTT_STATUS not between", value1, value2, "acttStatus");
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

        public Criteria andActvTokenIdLikeInsensitive(String value) {
            addCriterion("upper(ACTV_TOKEN_ID) like", value.toUpperCase(), "actvTokenId");
            return (Criteria) this;
        }

        public Criteria andActAddressLikeInsensitive(String value) {
            addCriterion("upper(ACT_ADDRESS) like", value.toUpperCase(), "actAddress");
            return (Criteria) this;
        }

        public Criteria andActvTokenLikeInsensitive(String value) {
            addCriterion("upper(ACTV_TOKEN) like", value.toUpperCase(), "actvToken");
            return (Criteria) this;
        }

        public Criteria andActtStatusLikeInsensitive(String value) {
            addCriterion("upper(ACTT_STATUS) like", value.toUpperCase(), "acttStatus");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table BC_ACT_TOKEN_VALUE
     *
     * @mbggenerated do_not_delete_during_merge Tue Aug 21 20:42:27 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        public Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table BC_ACT_TOKEN_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
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
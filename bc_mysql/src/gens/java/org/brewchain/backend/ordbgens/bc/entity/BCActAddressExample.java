package org.brewchain.backend.ordbgens.bc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BCActAddressExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BC_ACT_ADDRESS
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
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    public BCActAddressExample() {
        oredCriteria = new ArrayList<Criteria>();
        offset = 0;
        limit = Integer.MAX_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
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
     * This method corresponds to the database table BC_ACT_ADDRESS
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
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:42:27 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
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
     * This class corresponds to the database table BC_ACT_ADDRESS
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

        public Criteria andAddressUidIsNull() {
            addCriterion("ADDRESS_UID is null");
            return (Criteria) this;
        }

        public Criteria andAddressUidIsNotNull() {
            addCriterion("ADDRESS_UID is not null");
            return (Criteria) this;
        }

        public Criteria andAddressUidEqualTo(String value) {
            addCriterion("ADDRESS_UID =", value, "addressUid");
            return (Criteria) this;
        }

        public Criteria andAddressUidNotEqualTo(String value) {
            addCriterion("ADDRESS_UID <>", value, "addressUid");
            return (Criteria) this;
        }

        public Criteria andAddressUidGreaterThan(String value) {
            addCriterion("ADDRESS_UID >", value, "addressUid");
            return (Criteria) this;
        }

        public Criteria andAddressUidGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS_UID >=", value, "addressUid");
            return (Criteria) this;
        }

        public Criteria andAddressUidLessThan(String value) {
            addCriterion("ADDRESS_UID <", value, "addressUid");
            return (Criteria) this;
        }

        public Criteria andAddressUidLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS_UID <=", value, "addressUid");
            return (Criteria) this;
        }

        public Criteria andAddressUidLike(String value) {
            addCriterion("ADDRESS_UID like", value, "addressUid");
            return (Criteria) this;
        }

        public Criteria andAddressUidNotLike(String value) {
            addCriterion("ADDRESS_UID not like", value, "addressUid");
            return (Criteria) this;
        }

        public Criteria andAddressUidIn(List<String> values) {
            addCriterion("ADDRESS_UID in", values, "addressUid");
            return (Criteria) this;
        }

        public Criteria andAddressUidNotIn(List<String> values) {
            addCriterion("ADDRESS_UID not in", values, "addressUid");
            return (Criteria) this;
        }

        public Criteria andAddressUidBetween(String value1, String value2) {
            addCriterion("ADDRESS_UID between", value1, value2, "addressUid");
            return (Criteria) this;
        }

        public Criteria andAddressUidNotBetween(String value1, String value2) {
            addCriterion("ADDRESS_UID not between", value1, value2, "addressUid");
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

        public Criteria andActaStatusIsNull() {
            addCriterion("ACTA_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andActaStatusIsNotNull() {
            addCriterion("ACTA_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andActaStatusEqualTo(String value) {
            addCriterion("ACTA_STATUS =", value, "actaStatus");
            return (Criteria) this;
        }

        public Criteria andActaStatusNotEqualTo(String value) {
            addCriterion("ACTA_STATUS <>", value, "actaStatus");
            return (Criteria) this;
        }

        public Criteria andActaStatusGreaterThan(String value) {
            addCriterion("ACTA_STATUS >", value, "actaStatus");
            return (Criteria) this;
        }

        public Criteria andActaStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ACTA_STATUS >=", value, "actaStatus");
            return (Criteria) this;
        }

        public Criteria andActaStatusLessThan(String value) {
            addCriterion("ACTA_STATUS <", value, "actaStatus");
            return (Criteria) this;
        }

        public Criteria andActaStatusLessThanOrEqualTo(String value) {
            addCriterion("ACTA_STATUS <=", value, "actaStatus");
            return (Criteria) this;
        }

        public Criteria andActaStatusLike(String value) {
            addCriterion("ACTA_STATUS like", value, "actaStatus");
            return (Criteria) this;
        }

        public Criteria andActaStatusNotLike(String value) {
            addCriterion("ACTA_STATUS not like", value, "actaStatus");
            return (Criteria) this;
        }

        public Criteria andActaStatusIn(List<String> values) {
            addCriterion("ACTA_STATUS in", values, "actaStatus");
            return (Criteria) this;
        }

        public Criteria andActaStatusNotIn(List<String> values) {
            addCriterion("ACTA_STATUS not in", values, "actaStatus");
            return (Criteria) this;
        }

        public Criteria andActaStatusBetween(String value1, String value2) {
            addCriterion("ACTA_STATUS between", value1, value2, "actaStatus");
            return (Criteria) this;
        }

        public Criteria andActaStatusNotBetween(String value1, String value2) {
            addCriterion("ACTA_STATUS not between", value1, value2, "actaStatus");
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

        public Criteria andAddressUidLikeInsensitive(String value) {
            addCriterion("upper(ADDRESS_UID) like", value.toUpperCase(), "addressUid");
            return (Criteria) this;
        }

        public Criteria andActAddressLikeInsensitive(String value) {
            addCriterion("upper(ACT_ADDRESS) like", value.toUpperCase(), "actAddress");
            return (Criteria) this;
        }

        public Criteria andActaStatusLikeInsensitive(String value) {
            addCriterion("upper(ACTA_STATUS) like", value.toUpperCase(), "actaStatus");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table BC_ACT_ADDRESS
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
     * This class corresponds to the database table BC_ACT_ADDRESS
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
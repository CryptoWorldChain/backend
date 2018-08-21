package org.brewchain.backend.ordbgens.bc.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="BC_GLOBAL_PROPS")
@AllArgsConstructor
@NoArgsConstructor
public class BCGlobalProps extends BCGlobalPropsKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_GLOBAL_PROPS.BVERSION
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String bversion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_GLOBAL_PROPS.BLOCK_HEIGHT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private BigDecimal blockHeight;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_GLOBAL_PROPS.PROP_KEY
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String propKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_GLOBAL_PROPS.PROP_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String propValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_GLOBAL_PROPS.MPT_TYPE
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String mptType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_GLOBAL_PROPS.HASH_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String hashValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_GLOBAL_PROPS.TXID
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String txid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_GLOBAL_PROPS.PREV_HASH_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String prevHashValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_GLOBAL_PROPS.PREV_BLOCK_HEIGHT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private BigDecimal prevBlockHeight;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_GLOBAL_PROPS.CREATE_TIME
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_GLOBAL_PROPS.UPDATE_TIME
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_GLOBAL_PROPS.BVERSION
     *
     * @return the value of BC_GLOBAL_PROPS.BVERSION
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getBversion() {
        return bversion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_GLOBAL_PROPS.BVERSION
     *
     * @param bversion the value for BC_GLOBAL_PROPS.BVERSION
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setBversion(String bversion) {
        this.bversion = bversion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_GLOBAL_PROPS.BLOCK_HEIGHT
     *
     * @return the value of BC_GLOBAL_PROPS.BLOCK_HEIGHT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public BigDecimal getBlockHeight() {
        return blockHeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_GLOBAL_PROPS.BLOCK_HEIGHT
     *
     * @param blockHeight the value for BC_GLOBAL_PROPS.BLOCK_HEIGHT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setBlockHeight(BigDecimal blockHeight) {
        this.blockHeight = blockHeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_GLOBAL_PROPS.PROP_KEY
     *
     * @return the value of BC_GLOBAL_PROPS.PROP_KEY
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getPropKey() {
        return propKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_GLOBAL_PROPS.PROP_KEY
     *
     * @param propKey the value for BC_GLOBAL_PROPS.PROP_KEY
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setPropKey(String propKey) {
        this.propKey = propKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_GLOBAL_PROPS.PROP_VALUE
     *
     * @return the value of BC_GLOBAL_PROPS.PROP_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getPropValue() {
        return propValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_GLOBAL_PROPS.PROP_VALUE
     *
     * @param propValue the value for BC_GLOBAL_PROPS.PROP_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_GLOBAL_PROPS.MPT_TYPE
     *
     * @return the value of BC_GLOBAL_PROPS.MPT_TYPE
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getMptType() {
        return mptType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_GLOBAL_PROPS.MPT_TYPE
     *
     * @param mptType the value for BC_GLOBAL_PROPS.MPT_TYPE
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setMptType(String mptType) {
        this.mptType = mptType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_GLOBAL_PROPS.HASH_VALUE
     *
     * @return the value of BC_GLOBAL_PROPS.HASH_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getHashValue() {
        return hashValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_GLOBAL_PROPS.HASH_VALUE
     *
     * @param hashValue the value for BC_GLOBAL_PROPS.HASH_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setHashValue(String hashValue) {
        this.hashValue = hashValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_GLOBAL_PROPS.TXID
     *
     * @return the value of BC_GLOBAL_PROPS.TXID
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getTxid() {
        return txid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_GLOBAL_PROPS.TXID
     *
     * @param txid the value for BC_GLOBAL_PROPS.TXID
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setTxid(String txid) {
        this.txid = txid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_GLOBAL_PROPS.PREV_HASH_VALUE
     *
     * @return the value of BC_GLOBAL_PROPS.PREV_HASH_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getPrevHashValue() {
        return prevHashValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_GLOBAL_PROPS.PREV_HASH_VALUE
     *
     * @param prevHashValue the value for BC_GLOBAL_PROPS.PREV_HASH_VALUE
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setPrevHashValue(String prevHashValue) {
        this.prevHashValue = prevHashValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_GLOBAL_PROPS.PREV_BLOCK_HEIGHT
     *
     * @return the value of BC_GLOBAL_PROPS.PREV_BLOCK_HEIGHT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public BigDecimal getPrevBlockHeight() {
        return prevBlockHeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_GLOBAL_PROPS.PREV_BLOCK_HEIGHT
     *
     * @param prevBlockHeight the value for BC_GLOBAL_PROPS.PREV_BLOCK_HEIGHT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setPrevBlockHeight(BigDecimal prevBlockHeight) {
        this.prevBlockHeight = prevBlockHeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_GLOBAL_PROPS.CREATE_TIME
     *
     * @return the value of BC_GLOBAL_PROPS.CREATE_TIME
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_GLOBAL_PROPS.CREATE_TIME
     *
     * @param createTime the value for BC_GLOBAL_PROPS.CREATE_TIME
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_GLOBAL_PROPS.UPDATE_TIME
     *
     * @return the value of BC_GLOBAL_PROPS.UPDATE_TIME
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_GLOBAL_PROPS.UPDATE_TIME
     *
     * @param updateTime the value for BC_GLOBAL_PROPS.UPDATE_TIME
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_GLOBAL_PROPS
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BCGlobalProps other = (BCGlobalProps) that;
        return (this.getLogUuid() == null ? other.getLogUuid() == null : this.getLogUuid().equals(other.getLogUuid()))
            && (this.getBversion() == null ? other.getBversion() == null : this.getBversion().equals(other.getBversion()))
            && (this.getBlockHeight() == null ? other.getBlockHeight() == null : this.getBlockHeight().equals(other.getBlockHeight()))
            && (this.getPropKey() == null ? other.getPropKey() == null : this.getPropKey().equals(other.getPropKey()))
            && (this.getPropValue() == null ? other.getPropValue() == null : this.getPropValue().equals(other.getPropValue()))
            && (this.getMptType() == null ? other.getMptType() == null : this.getMptType().equals(other.getMptType()))
            && (this.getHashValue() == null ? other.getHashValue() == null : this.getHashValue().equals(other.getHashValue()))
            && (this.getTxid() == null ? other.getTxid() == null : this.getTxid().equals(other.getTxid()))
            && (this.getPrevHashValue() == null ? other.getPrevHashValue() == null : this.getPrevHashValue().equals(other.getPrevHashValue()))
            && (this.getPrevBlockHeight() == null ? other.getPrevBlockHeight() == null : this.getPrevBlockHeight().equals(other.getPrevBlockHeight()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_GLOBAL_PROPS
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLogUuid() == null) ? 0 : getLogUuid().hashCode());
        result = prime * result + ((getBversion() == null) ? 0 : getBversion().hashCode());
        result = prime * result + ((getBlockHeight() == null) ? 0 : getBlockHeight().hashCode());
        result = prime * result + ((getPropKey() == null) ? 0 : getPropKey().hashCode());
        result = prime * result + ((getPropValue() == null) ? 0 : getPropValue().hashCode());
        result = prime * result + ((getMptType() == null) ? 0 : getMptType().hashCode());
        result = prime * result + ((getHashValue() == null) ? 0 : getHashValue().hashCode());
        result = prime * result + ((getTxid() == null) ? 0 : getTxid().hashCode());
        result = prime * result + ((getPrevHashValue() == null) ? 0 : getPrevHashValue().hashCode());
        result = prime * result + ((getPrevBlockHeight() == null) ? 0 : getPrevBlockHeight().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_GLOBAL_PROPS
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bversion=").append(bversion);
        sb.append(", blockHeight=").append(blockHeight);
        sb.append(", propKey=").append(propKey);
        sb.append(", propValue=").append(propValue);
        sb.append(", mptType=").append(mptType);
        sb.append(", hashValue=").append(hashValue);
        sb.append(", txid=").append(txid);
        sb.append(", prevHashValue=").append(prevHashValue);
        sb.append(", prevBlockHeight=").append(prevBlockHeight);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}
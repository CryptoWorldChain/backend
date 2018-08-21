package org.brewchain.backend.ordbgens.bc.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="BC_MUTIL_TRANSACTON")
@AllArgsConstructor
@NoArgsConstructor
public class BCMutilTransacton extends BCMutilTransactonKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_MUTIL_TRANSACTON.BVERSION
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    private String bversion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_MUTIL_TRANSACTON.HASH_MERKLE_ROOT
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    private String hashMerkleRoot;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_MUTIL_TRANSACTON.BLOCK_HEIGHT
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    private BigDecimal blockHeight;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_MUTIL_TRANSACTON.ADDRESS_IN_COUNT
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    private Integer addressInCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_MUTIL_TRANSACTON.ADDRESS_OUT_COUNT
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    private Integer addressOutCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_MUTIL_TRANSACTON.PROP_COUNT
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    private Integer propCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_MUTIL_TRANSACTON.TX_STATUS
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    private String txStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_MUTIL_TRANSACTON.INDEX_IN_BLOCK
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    private Integer indexInBlock;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_MUTIL_TRANSACTON.RESULTS_HEX
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    private String resultsHex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_MUTIL_TRANSACTON.DATA
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    private String data;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_MUTIL_TRANSACTON.EXTRA_DATA
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    private String extraData;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_MUTIL_TRANSACTON.TX_TIMESTAMP
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    private BigDecimal txTimestamp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_MUTIL_TRANSACTON.TX_TYPE
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    private Integer txType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_MUTIL_TRANSACTON.CREATE_TIME
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_MUTIL_TRANSACTON.UPDATE_TIME
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_MUTIL_TRANSACTON.BVERSION
     *
     * @return the value of BC_MUTIL_TRANSACTON.BVERSION
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String getBversion() {
        return bversion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_MUTIL_TRANSACTON.BVERSION
     *
     * @param bversion the value for BC_MUTIL_TRANSACTON.BVERSION
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public void setBversion(String bversion) {
        this.bversion = bversion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_MUTIL_TRANSACTON.HASH_MERKLE_ROOT
     *
     * @return the value of BC_MUTIL_TRANSACTON.HASH_MERKLE_ROOT
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String getHashMerkleRoot() {
        return hashMerkleRoot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_MUTIL_TRANSACTON.HASH_MERKLE_ROOT
     *
     * @param hashMerkleRoot the value for BC_MUTIL_TRANSACTON.HASH_MERKLE_ROOT
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public void setHashMerkleRoot(String hashMerkleRoot) {
        this.hashMerkleRoot = hashMerkleRoot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_MUTIL_TRANSACTON.BLOCK_HEIGHT
     *
     * @return the value of BC_MUTIL_TRANSACTON.BLOCK_HEIGHT
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public BigDecimal getBlockHeight() {
        return blockHeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_MUTIL_TRANSACTON.BLOCK_HEIGHT
     *
     * @param blockHeight the value for BC_MUTIL_TRANSACTON.BLOCK_HEIGHT
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public void setBlockHeight(BigDecimal blockHeight) {
        this.blockHeight = blockHeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_MUTIL_TRANSACTON.ADDRESS_IN_COUNT
     *
     * @return the value of BC_MUTIL_TRANSACTON.ADDRESS_IN_COUNT
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public Integer getAddressInCount() {
        return addressInCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_MUTIL_TRANSACTON.ADDRESS_IN_COUNT
     *
     * @param addressInCount the value for BC_MUTIL_TRANSACTON.ADDRESS_IN_COUNT
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public void setAddressInCount(Integer addressInCount) {
        this.addressInCount = addressInCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_MUTIL_TRANSACTON.ADDRESS_OUT_COUNT
     *
     * @return the value of BC_MUTIL_TRANSACTON.ADDRESS_OUT_COUNT
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public Integer getAddressOutCount() {
        return addressOutCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_MUTIL_TRANSACTON.ADDRESS_OUT_COUNT
     *
     * @param addressOutCount the value for BC_MUTIL_TRANSACTON.ADDRESS_OUT_COUNT
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public void setAddressOutCount(Integer addressOutCount) {
        this.addressOutCount = addressOutCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_MUTIL_TRANSACTON.PROP_COUNT
     *
     * @return the value of BC_MUTIL_TRANSACTON.PROP_COUNT
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public Integer getPropCount() {
        return propCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_MUTIL_TRANSACTON.PROP_COUNT
     *
     * @param propCount the value for BC_MUTIL_TRANSACTON.PROP_COUNT
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public void setPropCount(Integer propCount) {
        this.propCount = propCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_MUTIL_TRANSACTON.TX_STATUS
     *
     * @return the value of BC_MUTIL_TRANSACTON.TX_STATUS
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String getTxStatus() {
        return txStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_MUTIL_TRANSACTON.TX_STATUS
     *
     * @param txStatus the value for BC_MUTIL_TRANSACTON.TX_STATUS
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public void setTxStatus(String txStatus) {
        this.txStatus = txStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_MUTIL_TRANSACTON.INDEX_IN_BLOCK
     *
     * @return the value of BC_MUTIL_TRANSACTON.INDEX_IN_BLOCK
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public Integer getIndexInBlock() {
        return indexInBlock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_MUTIL_TRANSACTON.INDEX_IN_BLOCK
     *
     * @param indexInBlock the value for BC_MUTIL_TRANSACTON.INDEX_IN_BLOCK
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public void setIndexInBlock(Integer indexInBlock) {
        this.indexInBlock = indexInBlock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_MUTIL_TRANSACTON.RESULTS_HEX
     *
     * @return the value of BC_MUTIL_TRANSACTON.RESULTS_HEX
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String getResultsHex() {
        return resultsHex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_MUTIL_TRANSACTON.RESULTS_HEX
     *
     * @param resultsHex the value for BC_MUTIL_TRANSACTON.RESULTS_HEX
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public void setResultsHex(String resultsHex) {
        this.resultsHex = resultsHex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_MUTIL_TRANSACTON.DATA
     *
     * @return the value of BC_MUTIL_TRANSACTON.DATA
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String getData() {
        return data;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_MUTIL_TRANSACTON.DATA
     *
     * @param data the value for BC_MUTIL_TRANSACTON.DATA
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_MUTIL_TRANSACTON.EXTRA_DATA
     *
     * @return the value of BC_MUTIL_TRANSACTON.EXTRA_DATA
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String getExtraData() {
        return extraData;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_MUTIL_TRANSACTON.EXTRA_DATA
     *
     * @param extraData the value for BC_MUTIL_TRANSACTON.EXTRA_DATA
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_MUTIL_TRANSACTON.TX_TIMESTAMP
     *
     * @return the value of BC_MUTIL_TRANSACTON.TX_TIMESTAMP
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public BigDecimal getTxTimestamp() {
        return txTimestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_MUTIL_TRANSACTON.TX_TIMESTAMP
     *
     * @param txTimestamp the value for BC_MUTIL_TRANSACTON.TX_TIMESTAMP
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public void setTxTimestamp(BigDecimal txTimestamp) {
        this.txTimestamp = txTimestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_MUTIL_TRANSACTON.TX_TYPE
     *
     * @return the value of BC_MUTIL_TRANSACTON.TX_TYPE
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public Integer getTxType() {
        return txType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_MUTIL_TRANSACTON.TX_TYPE
     *
     * @param txType the value for BC_MUTIL_TRANSACTON.TX_TYPE
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public void setTxType(Integer txType) {
        this.txType = txType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_MUTIL_TRANSACTON.CREATE_TIME
     *
     * @return the value of BC_MUTIL_TRANSACTON.CREATE_TIME
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_MUTIL_TRANSACTON.CREATE_TIME
     *
     * @param createTime the value for BC_MUTIL_TRANSACTON.CREATE_TIME
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_MUTIL_TRANSACTON.UPDATE_TIME
     *
     * @return the value of BC_MUTIL_TRANSACTON.UPDATE_TIME
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_MUTIL_TRANSACTON.UPDATE_TIME
     *
     * @param updateTime the value for BC_MUTIL_TRANSACTON.UPDATE_TIME
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MUTIL_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
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
        BCMutilTransacton other = (BCMutilTransacton) that;
        return (this.getTxHash() == null ? other.getTxHash() == null : this.getTxHash().equals(other.getTxHash()))
            && (this.getBversion() == null ? other.getBversion() == null : this.getBversion().equals(other.getBversion()))
            && (this.getHashMerkleRoot() == null ? other.getHashMerkleRoot() == null : this.getHashMerkleRoot().equals(other.getHashMerkleRoot()))
            && (this.getBlockHeight() == null ? other.getBlockHeight() == null : this.getBlockHeight().equals(other.getBlockHeight()))
            && (this.getAddressInCount() == null ? other.getAddressInCount() == null : this.getAddressInCount().equals(other.getAddressInCount()))
            && (this.getAddressOutCount() == null ? other.getAddressOutCount() == null : this.getAddressOutCount().equals(other.getAddressOutCount()))
            && (this.getPropCount() == null ? other.getPropCount() == null : this.getPropCount().equals(other.getPropCount()))
            && (this.getTxStatus() == null ? other.getTxStatus() == null : this.getTxStatus().equals(other.getTxStatus()))
            && (this.getIndexInBlock() == null ? other.getIndexInBlock() == null : this.getIndexInBlock().equals(other.getIndexInBlock()))
            && (this.getResultsHex() == null ? other.getResultsHex() == null : this.getResultsHex().equals(other.getResultsHex()))
            && (this.getData() == null ? other.getData() == null : this.getData().equals(other.getData()))
            && (this.getExtraData() == null ? other.getExtraData() == null : this.getExtraData().equals(other.getExtraData()))
            && (this.getTxTimestamp() == null ? other.getTxTimestamp() == null : this.getTxTimestamp().equals(other.getTxTimestamp()))
            && (this.getTxType() == null ? other.getTxType() == null : this.getTxType().equals(other.getTxType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MUTIL_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTxHash() == null) ? 0 : getTxHash().hashCode());
        result = prime * result + ((getBversion() == null) ? 0 : getBversion().hashCode());
        result = prime * result + ((getHashMerkleRoot() == null) ? 0 : getHashMerkleRoot().hashCode());
        result = prime * result + ((getBlockHeight() == null) ? 0 : getBlockHeight().hashCode());
        result = prime * result + ((getAddressInCount() == null) ? 0 : getAddressInCount().hashCode());
        result = prime * result + ((getAddressOutCount() == null) ? 0 : getAddressOutCount().hashCode());
        result = prime * result + ((getPropCount() == null) ? 0 : getPropCount().hashCode());
        result = prime * result + ((getTxStatus() == null) ? 0 : getTxStatus().hashCode());
        result = prime * result + ((getIndexInBlock() == null) ? 0 : getIndexInBlock().hashCode());
        result = prime * result + ((getResultsHex() == null) ? 0 : getResultsHex().hashCode());
        result = prime * result + ((getData() == null) ? 0 : getData().hashCode());
        result = prime * result + ((getExtraData() == null) ? 0 : getExtraData().hashCode());
        result = prime * result + ((getTxTimestamp() == null) ? 0 : getTxTimestamp().hashCode());
        result = prime * result + ((getTxType() == null) ? 0 : getTxType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MUTIL_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bversion=").append(bversion);
        sb.append(", hashMerkleRoot=").append(hashMerkleRoot);
        sb.append(", blockHeight=").append(blockHeight);
        sb.append(", addressInCount=").append(addressInCount);
        sb.append(", addressOutCount=").append(addressOutCount);
        sb.append(", propCount=").append(propCount);
        sb.append(", txStatus=").append(txStatus);
        sb.append(", indexInBlock=").append(indexInBlock);
        sb.append(", resultsHex=").append(resultsHex);
        sb.append(", data=").append(data);
        sb.append(", extraData=").append(extraData);
        sb.append(", txTimestamp=").append(txTimestamp);
        sb.append(", txType=").append(txType);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}
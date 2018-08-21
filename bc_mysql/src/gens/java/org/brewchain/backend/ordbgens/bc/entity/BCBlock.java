package org.brewchain.backend.ordbgens.bc.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.ojpa.api.annotations.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="BC_BLOCK")
@AllArgsConstructor
@NoArgsConstructor
public class BCBlock extends BCBlockKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_BLOCK.BVERSION
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String bversion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_BLOCK.SECOND_IDX
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String secondIdx;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_BLOCK.BH_PARENT_HASH
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String bhParentHash;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_BLOCK.BH_STATE_ROOT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String bhStateRoot;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_BLOCK.BH_BLOCK_HASH
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String bhBlockHash;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_BLOCK.BH_TXT_RIEROOT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String bhTxtRieroot;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_BLOCK.BH_RECEIPT_TRIEROOT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String bhReceiptTrieroot;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_BLOCK.BH_TIMESTAMP
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private BigDecimal bhTimestamp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_BLOCK.BH_NUMBER
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private BigDecimal bhNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_BLOCK.BH_TXN_COUNT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private Integer bhTxnCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_BLOCK.BH_SLICEID
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private Integer bhSliceid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_BLOCK.BH_EXTRADATA
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String bhExtradata;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_BLOCK.BM_NODE
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String bmNode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_BLOCK.BM_REWARD_HEX
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String bmRewardHex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_BLOCK.BM_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String bmAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_BLOCK.BM_BCUID
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String bmBcuid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_BLOCK.BLOCK_STATUS
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private String blockStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_BLOCK.CREATE_TIME
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_BLOCK.UPDATE_TIME
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_BLOCK.BVERSION
     *
     * @return the value of BC_BLOCK.BVERSION
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getBversion() {
        return bversion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_BLOCK.BVERSION
     *
     * @param bversion the value for BC_BLOCK.BVERSION
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setBversion(String bversion) {
        this.bversion = bversion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_BLOCK.SECOND_IDX
     *
     * @return the value of BC_BLOCK.SECOND_IDX
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getSecondIdx() {
        return secondIdx;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_BLOCK.SECOND_IDX
     *
     * @param secondIdx the value for BC_BLOCK.SECOND_IDX
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setSecondIdx(String secondIdx) {
        this.secondIdx = secondIdx;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_BLOCK.BH_PARENT_HASH
     *
     * @return the value of BC_BLOCK.BH_PARENT_HASH
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getBhParentHash() {
        return bhParentHash;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_BLOCK.BH_PARENT_HASH
     *
     * @param bhParentHash the value for BC_BLOCK.BH_PARENT_HASH
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setBhParentHash(String bhParentHash) {
        this.bhParentHash = bhParentHash;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_BLOCK.BH_STATE_ROOT
     *
     * @return the value of BC_BLOCK.BH_STATE_ROOT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getBhStateRoot() {
        return bhStateRoot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_BLOCK.BH_STATE_ROOT
     *
     * @param bhStateRoot the value for BC_BLOCK.BH_STATE_ROOT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setBhStateRoot(String bhStateRoot) {
        this.bhStateRoot = bhStateRoot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_BLOCK.BH_BLOCK_HASH
     *
     * @return the value of BC_BLOCK.BH_BLOCK_HASH
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getBhBlockHash() {
        return bhBlockHash;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_BLOCK.BH_BLOCK_HASH
     *
     * @param bhBlockHash the value for BC_BLOCK.BH_BLOCK_HASH
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setBhBlockHash(String bhBlockHash) {
        this.bhBlockHash = bhBlockHash;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_BLOCK.BH_TXT_RIEROOT
     *
     * @return the value of BC_BLOCK.BH_TXT_RIEROOT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getBhTxtRieroot() {
        return bhTxtRieroot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_BLOCK.BH_TXT_RIEROOT
     *
     * @param bhTxtRieroot the value for BC_BLOCK.BH_TXT_RIEROOT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setBhTxtRieroot(String bhTxtRieroot) {
        this.bhTxtRieroot = bhTxtRieroot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_BLOCK.BH_RECEIPT_TRIEROOT
     *
     * @return the value of BC_BLOCK.BH_RECEIPT_TRIEROOT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getBhReceiptTrieroot() {
        return bhReceiptTrieroot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_BLOCK.BH_RECEIPT_TRIEROOT
     *
     * @param bhReceiptTrieroot the value for BC_BLOCK.BH_RECEIPT_TRIEROOT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setBhReceiptTrieroot(String bhReceiptTrieroot) {
        this.bhReceiptTrieroot = bhReceiptTrieroot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_BLOCK.BH_TIMESTAMP
     *
     * @return the value of BC_BLOCK.BH_TIMESTAMP
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public BigDecimal getBhTimestamp() {
        return bhTimestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_BLOCK.BH_TIMESTAMP
     *
     * @param bhTimestamp the value for BC_BLOCK.BH_TIMESTAMP
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setBhTimestamp(BigDecimal bhTimestamp) {
        this.bhTimestamp = bhTimestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_BLOCK.BH_NUMBER
     *
     * @return the value of BC_BLOCK.BH_NUMBER
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public BigDecimal getBhNumber() {
        return bhNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_BLOCK.BH_NUMBER
     *
     * @param bhNumber the value for BC_BLOCK.BH_NUMBER
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setBhNumber(BigDecimal bhNumber) {
        this.bhNumber = bhNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_BLOCK.BH_TXN_COUNT
     *
     * @return the value of BC_BLOCK.BH_TXN_COUNT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public Integer getBhTxnCount() {
        return bhTxnCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_BLOCK.BH_TXN_COUNT
     *
     * @param bhTxnCount the value for BC_BLOCK.BH_TXN_COUNT
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setBhTxnCount(Integer bhTxnCount) {
        this.bhTxnCount = bhTxnCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_BLOCK.BH_SLICEID
     *
     * @return the value of BC_BLOCK.BH_SLICEID
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public Integer getBhSliceid() {
        return bhSliceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_BLOCK.BH_SLICEID
     *
     * @param bhSliceid the value for BC_BLOCK.BH_SLICEID
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setBhSliceid(Integer bhSliceid) {
        this.bhSliceid = bhSliceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_BLOCK.BH_EXTRADATA
     *
     * @return the value of BC_BLOCK.BH_EXTRADATA
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getBhExtradata() {
        return bhExtradata;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_BLOCK.BH_EXTRADATA
     *
     * @param bhExtradata the value for BC_BLOCK.BH_EXTRADATA
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setBhExtradata(String bhExtradata) {
        this.bhExtradata = bhExtradata;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_BLOCK.BM_NODE
     *
     * @return the value of BC_BLOCK.BM_NODE
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getBmNode() {
        return bmNode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_BLOCK.BM_NODE
     *
     * @param bmNode the value for BC_BLOCK.BM_NODE
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setBmNode(String bmNode) {
        this.bmNode = bmNode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_BLOCK.BM_REWARD_HEX
     *
     * @return the value of BC_BLOCK.BM_REWARD_HEX
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getBmRewardHex() {
        return bmRewardHex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_BLOCK.BM_REWARD_HEX
     *
     * @param bmRewardHex the value for BC_BLOCK.BM_REWARD_HEX
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setBmRewardHex(String bmRewardHex) {
        this.bmRewardHex = bmRewardHex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_BLOCK.BM_ADDRESS
     *
     * @return the value of BC_BLOCK.BM_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getBmAddress() {
        return bmAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_BLOCK.BM_ADDRESS
     *
     * @param bmAddress the value for BC_BLOCK.BM_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setBmAddress(String bmAddress) {
        this.bmAddress = bmAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_BLOCK.BM_BCUID
     *
     * @return the value of BC_BLOCK.BM_BCUID
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getBmBcuid() {
        return bmBcuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_BLOCK.BM_BCUID
     *
     * @param bmBcuid the value for BC_BLOCK.BM_BCUID
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setBmBcuid(String bmBcuid) {
        this.bmBcuid = bmBcuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_BLOCK.BLOCK_STATUS
     *
     * @return the value of BC_BLOCK.BLOCK_STATUS
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public String getBlockStatus() {
        return blockStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_BLOCK.BLOCK_STATUS
     *
     * @param blockStatus the value for BC_BLOCK.BLOCK_STATUS
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setBlockStatus(String blockStatus) {
        this.blockStatus = blockStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_BLOCK.CREATE_TIME
     *
     * @return the value of BC_BLOCK.CREATE_TIME
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_BLOCK.CREATE_TIME
     *
     * @param createTime the value for BC_BLOCK.CREATE_TIME
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_BLOCK.UPDATE_TIME
     *
     * @return the value of BC_BLOCK.UPDATE_TIME
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_BLOCK.UPDATE_TIME
     *
     * @param updateTime the value for BC_BLOCK.UPDATE_TIME
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_BLOCK
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
        BCBlock other = (BCBlock) that;
        return (this.getLogUuid() == null ? other.getLogUuid() == null : this.getLogUuid().equals(other.getLogUuid()))
            && (this.getBversion() == null ? other.getBversion() == null : this.getBversion().equals(other.getBversion()))
            && (this.getSecondIdx() == null ? other.getSecondIdx() == null : this.getSecondIdx().equals(other.getSecondIdx()))
            && (this.getBhParentHash() == null ? other.getBhParentHash() == null : this.getBhParentHash().equals(other.getBhParentHash()))
            && (this.getBhStateRoot() == null ? other.getBhStateRoot() == null : this.getBhStateRoot().equals(other.getBhStateRoot()))
            && (this.getBhBlockHash() == null ? other.getBhBlockHash() == null : this.getBhBlockHash().equals(other.getBhBlockHash()))
            && (this.getBhTxtRieroot() == null ? other.getBhTxtRieroot() == null : this.getBhTxtRieroot().equals(other.getBhTxtRieroot()))
            && (this.getBhReceiptTrieroot() == null ? other.getBhReceiptTrieroot() == null : this.getBhReceiptTrieroot().equals(other.getBhReceiptTrieroot()))
            && (this.getBhTimestamp() == null ? other.getBhTimestamp() == null : this.getBhTimestamp().equals(other.getBhTimestamp()))
            && (this.getBhNumber() == null ? other.getBhNumber() == null : this.getBhNumber().equals(other.getBhNumber()))
            && (this.getBhTxnCount() == null ? other.getBhTxnCount() == null : this.getBhTxnCount().equals(other.getBhTxnCount()))
            && (this.getBhSliceid() == null ? other.getBhSliceid() == null : this.getBhSliceid().equals(other.getBhSliceid()))
            && (this.getBhExtradata() == null ? other.getBhExtradata() == null : this.getBhExtradata().equals(other.getBhExtradata()))
            && (this.getBmNode() == null ? other.getBmNode() == null : this.getBmNode().equals(other.getBmNode()))
            && (this.getBmRewardHex() == null ? other.getBmRewardHex() == null : this.getBmRewardHex().equals(other.getBmRewardHex()))
            && (this.getBmAddress() == null ? other.getBmAddress() == null : this.getBmAddress().equals(other.getBmAddress()))
            && (this.getBmBcuid() == null ? other.getBmBcuid() == null : this.getBmBcuid().equals(other.getBmBcuid()))
            && (this.getBlockStatus() == null ? other.getBlockStatus() == null : this.getBlockStatus().equals(other.getBlockStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_BLOCK
     *
     * @mbggenerated Tue Aug 21 20:42:28 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLogUuid() == null) ? 0 : getLogUuid().hashCode());
        result = prime * result + ((getBversion() == null) ? 0 : getBversion().hashCode());
        result = prime * result + ((getSecondIdx() == null) ? 0 : getSecondIdx().hashCode());
        result = prime * result + ((getBhParentHash() == null) ? 0 : getBhParentHash().hashCode());
        result = prime * result + ((getBhStateRoot() == null) ? 0 : getBhStateRoot().hashCode());
        result = prime * result + ((getBhBlockHash() == null) ? 0 : getBhBlockHash().hashCode());
        result = prime * result + ((getBhTxtRieroot() == null) ? 0 : getBhTxtRieroot().hashCode());
        result = prime * result + ((getBhReceiptTrieroot() == null) ? 0 : getBhReceiptTrieroot().hashCode());
        result = prime * result + ((getBhTimestamp() == null) ? 0 : getBhTimestamp().hashCode());
        result = prime * result + ((getBhNumber() == null) ? 0 : getBhNumber().hashCode());
        result = prime * result + ((getBhTxnCount() == null) ? 0 : getBhTxnCount().hashCode());
        result = prime * result + ((getBhSliceid() == null) ? 0 : getBhSliceid().hashCode());
        result = prime * result + ((getBhExtradata() == null) ? 0 : getBhExtradata().hashCode());
        result = prime * result + ((getBmNode() == null) ? 0 : getBmNode().hashCode());
        result = prime * result + ((getBmRewardHex() == null) ? 0 : getBmRewardHex().hashCode());
        result = prime * result + ((getBmAddress() == null) ? 0 : getBmAddress().hashCode());
        result = prime * result + ((getBmBcuid() == null) ? 0 : getBmBcuid().hashCode());
        result = prime * result + ((getBlockStatus() == null) ? 0 : getBlockStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_BLOCK
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
        sb.append(", secondIdx=").append(secondIdx);
        sb.append(", bhParentHash=").append(bhParentHash);
        sb.append(", bhStateRoot=").append(bhStateRoot);
        sb.append(", bhBlockHash=").append(bhBlockHash);
        sb.append(", bhTxtRieroot=").append(bhTxtRieroot);
        sb.append(", bhReceiptTrieroot=").append(bhReceiptTrieroot);
        sb.append(", bhTimestamp=").append(bhTimestamp);
        sb.append(", bhNumber=").append(bhNumber);
        sb.append(", bhTxnCount=").append(bhTxnCount);
        sb.append(", bhSliceid=").append(bhSliceid);
        sb.append(", bhExtradata=").append(bhExtradata);
        sb.append(", bmNode=").append(bmNode);
        sb.append(", bmRewardHex=").append(bmRewardHex);
        sb.append(", bmAddress=").append(bmAddress);
        sb.append(", bmBcuid=").append(bmBcuid);
        sb.append(", blockStatus=").append(blockStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}
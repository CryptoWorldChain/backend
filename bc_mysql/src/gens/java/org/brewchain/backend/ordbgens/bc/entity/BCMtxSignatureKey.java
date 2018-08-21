package org.brewchain.backend.ordbgens.bc.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.outils.serialize.UUIDGenerator;

@AllArgsConstructor
@NoArgsConstructor
public class BCMtxSignatureKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_MTX_SIGNATURE.MTX_SIGNID
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    private String mtxSignid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_MTX_SIGNATURE.MTX_SIGNID
     *
     * @return the value of BC_MTX_SIGNATURE.MTX_SIGNID
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String getMtxSignid() {
        return mtxSignid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_MTX_SIGNATURE.MTX_SIGNID
     *
     * @param mtxSignid the value for BC_MTX_SIGNATURE.MTX_SIGNID
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public void setMtxSignid(String mtxSignid) {
        this.mtxSignid = mtxSignid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_SIGNATURE
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
        BCMtxSignatureKey other = (BCMtxSignatureKey) that;
        return (this.getMtxSignid() == null ? other.getMtxSignid() == null : this.getMtxSignid().equals(other.getMtxSignid()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_SIGNATURE
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMtxSignid() == null) ? 0 : getMtxSignid().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MTX_SIGNATURE
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mtxSignid=").append(mtxSignid);
        sb.append("]");
        return sb.toString();
    }
}
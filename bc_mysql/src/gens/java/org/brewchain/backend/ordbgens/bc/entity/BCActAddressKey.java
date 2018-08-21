package org.brewchain.backend.ordbgens.bc.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.outils.serialize.UUIDGenerator;

@AllArgsConstructor
@NoArgsConstructor
public class BCActAddressKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_ACT_ADDRESS.ADDRESS_UID
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    private String addressUid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_ACT_ADDRESS.ADDRESS_UID
     *
     * @return the value of BC_ACT_ADDRESS.ADDRESS_UID
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    public String getAddressUid() {
        return addressUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_ACT_ADDRESS.ADDRESS_UID
     *
     * @param addressUid the value for BC_ACT_ADDRESS.ADDRESS_UID
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    public void setAddressUid(String addressUid) {
        this.addressUid = addressUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
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
        BCActAddressKey other = (BCActAddressKey) that;
        return (this.getAddressUid() == null ? other.getAddressUid() == null : this.getAddressUid().equals(other.getAddressUid()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAddressUid() == null) ? 0 : getAddressUid().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", addressUid=").append(addressUid);
        sb.append("]");
        return sb.toString();
    }
}
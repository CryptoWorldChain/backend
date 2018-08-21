package org.brewchain.backend.ordbgens.bc.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.outils.serialize.UUIDGenerator;

@AllArgsConstructor
@NoArgsConstructor
public class BCGlobalPropsKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_GLOBAL_PROPS.LOG_UUID
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    private String logUuid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_GLOBAL_PROPS.LOG_UUID
     *
     * @return the value of BC_GLOBAL_PROPS.LOG_UUID
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String getLogUuid() {
        return logUuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_GLOBAL_PROPS.LOG_UUID
     *
     * @param logUuid the value for BC_GLOBAL_PROPS.LOG_UUID
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public void setLogUuid(String logUuid) {
        this.logUuid = logUuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_GLOBAL_PROPS
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
        BCGlobalPropsKey other = (BCGlobalPropsKey) that;
        return (this.getLogUuid() == null ? other.getLogUuid() == null : this.getLogUuid().equals(other.getLogUuid()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_GLOBAL_PROPS
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLogUuid() == null) ? 0 : getLogUuid().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_GLOBAL_PROPS
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", logUuid=").append(logUuid);
        sb.append("]");
        return sb.toString();
    }
}
package org.brewchain.backend.ordbgens.bc.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import onight.tfw.outils.serialize.UUIDGenerator;

@AllArgsConstructor
@NoArgsConstructor
public class BCCryptoTokenDataKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BC_CRYPTO_TOKEN_DATA.TOKEN_ID
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    private String tokenId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BC_CRYPTO_TOKEN_DATA.TOKEN_ID
     *
     * @return the value of BC_CRYPTO_TOKEN_DATA.TOKEN_ID
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public String getTokenId() {
        return tokenId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BC_CRYPTO_TOKEN_DATA.TOKEN_ID
     *
     * @param tokenId the value for BC_CRYPTO_TOKEN_DATA.TOKEN_ID
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_CRYPTO_TOKEN_DATA
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
        BCCryptoTokenDataKey other = (BCCryptoTokenDataKey) that;
        return (this.getTokenId() == null ? other.getTokenId() == null : this.getTokenId().equals(other.getTokenId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_CRYPTO_TOKEN_DATA
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTokenId() == null) ? 0 : getTokenId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_CRYPTO_TOKEN_DATA
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tokenId=").append(tokenId);
        sb.append("]");
        return sb.toString();
    }
}
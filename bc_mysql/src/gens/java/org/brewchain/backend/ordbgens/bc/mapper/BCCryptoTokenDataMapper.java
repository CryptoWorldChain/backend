package org.brewchain.backend.ordbgens.bc.mapper;

import java.util.List;
import onight.tfw.ojpa.ordb.StaticTableDaoSupport;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.brewchain.backend.ordbgens.bc.entity.BCCryptoTokenData;
import org.brewchain.backend.ordbgens.bc.entity.BCCryptoTokenDataExample;
import org.brewchain.backend.ordbgens.bc.entity.BCCryptoTokenDataKey;

public interface BCCryptoTokenDataMapper extends StaticTableDaoSupport<BCCryptoTokenData, BCCryptoTokenDataExample, BCCryptoTokenDataKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_CRYPTO_TOKEN_DATA
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @SelectProvider(type=BCCryptoTokenDataSqlProvider.class, method="countByExample")
    int countByExample(BCCryptoTokenDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_CRYPTO_TOKEN_DATA
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @DeleteProvider(type=BCCryptoTokenDataSqlProvider.class, method="deleteByExample")
    int deleteByExample(BCCryptoTokenDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_CRYPTO_TOKEN_DATA
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Delete({
        "delete from BC_CRYPTO_TOKEN_DATA",
        "where TOKEN_ID = #{tokenId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(BCCryptoTokenDataKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_CRYPTO_TOKEN_DATA
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Insert({
        "insert into BC_CRYPTO_TOKEN_DATA (TOKEN_ID, TOTALS, ",
        "TOKEN_SYMBOL, TOKEN_NAME, ",
        "TOKEN_CODE, EXTRADATA, ",
        "TOKEN_STATUS, CREATE_TIME, ",
        "UPDATE_TIME)",
        "values (#{tokenId,jdbcType=VARCHAR}, #{totals,jdbcType=DECIMAL}, ",
        "#{tokenSymbol,jdbcType=VARCHAR}, #{tokenName,jdbcType=VARCHAR}, ",
        "#{tokenCode,jdbcType=VARCHAR}, #{extradata,jdbcType=VARCHAR}, ",
        "#{tokenStatus,jdbcType=CHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(BCCryptoTokenData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_CRYPTO_TOKEN_DATA
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @InsertProvider(type=BCCryptoTokenDataSqlProvider.class, method="insertSelective")
    int insertSelective(BCCryptoTokenData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_CRYPTO_TOKEN_DATA
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @SelectProvider(type=BCCryptoTokenDataSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="TOKEN_ID", property="tokenId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="TOTALS", property="totals", jdbcType=JdbcType.DECIMAL),
        @Result(column="TOKEN_SYMBOL", property="tokenSymbol", jdbcType=JdbcType.VARCHAR),
        @Result(column="TOKEN_NAME", property="tokenName", jdbcType=JdbcType.VARCHAR),
        @Result(column="TOKEN_CODE", property="tokenCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRADATA", property="extradata", jdbcType=JdbcType.VARCHAR),
        @Result(column="TOKEN_STATUS", property="tokenStatus", jdbcType=JdbcType.CHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BCCryptoTokenData> selectByExample(BCCryptoTokenDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_CRYPTO_TOKEN_DATA
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Select({
        "select",
        "TOKEN_ID, TOTALS, TOKEN_SYMBOL, TOKEN_NAME, TOKEN_CODE, EXTRADATA, TOKEN_STATUS, ",
        "CREATE_TIME, UPDATE_TIME",
        "from BC_CRYPTO_TOKEN_DATA",
        "where TOKEN_ID = #{tokenId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="TOKEN_ID", property="tokenId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="TOTALS", property="totals", jdbcType=JdbcType.DECIMAL),
        @Result(column="TOKEN_SYMBOL", property="tokenSymbol", jdbcType=JdbcType.VARCHAR),
        @Result(column="TOKEN_NAME", property="tokenName", jdbcType=JdbcType.VARCHAR),
        @Result(column="TOKEN_CODE", property="tokenCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRADATA", property="extradata", jdbcType=JdbcType.VARCHAR),
        @Result(column="TOKEN_STATUS", property="tokenStatus", jdbcType=JdbcType.CHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    BCCryptoTokenData selectByPrimaryKey(BCCryptoTokenDataKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_CRYPTO_TOKEN_DATA
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @UpdateProvider(type=BCCryptoTokenDataSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BCCryptoTokenData record, @Param("example") BCCryptoTokenDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_CRYPTO_TOKEN_DATA
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @UpdateProvider(type=BCCryptoTokenDataSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BCCryptoTokenData record, @Param("example") BCCryptoTokenDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_CRYPTO_TOKEN_DATA
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @UpdateProvider(type=BCCryptoTokenDataSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BCCryptoTokenData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_CRYPTO_TOKEN_DATA
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Update({
        "update BC_CRYPTO_TOKEN_DATA",
        "set TOTALS = #{totals,jdbcType=DECIMAL},",
          "TOKEN_SYMBOL = #{tokenSymbol,jdbcType=VARCHAR},",
          "TOKEN_NAME = #{tokenName,jdbcType=VARCHAR},",
          "TOKEN_CODE = #{tokenCode,jdbcType=VARCHAR},",
          "EXTRADATA = #{extradata,jdbcType=VARCHAR},",
          "TOKEN_STATUS = #{tokenStatus,jdbcType=CHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where TOKEN_ID = #{tokenId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(BCCryptoTokenData record);
}
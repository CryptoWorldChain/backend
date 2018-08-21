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
import org.brewchain.backend.ordbgens.bc.entity.BCAccount;
import org.brewchain.backend.ordbgens.bc.entity.BCAccountExample;
import org.brewchain.backend.ordbgens.bc.entity.BCAccountKey;

public interface BCAccountMapper extends StaticTableDaoSupport<BCAccount, BCAccountExample, BCAccountKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACCOUNT
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @SelectProvider(type=BCAccountSqlProvider.class, method="countByExample")
    int countByExample(BCAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACCOUNT
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @DeleteProvider(type=BCAccountSqlProvider.class, method="deleteByExample")
    int deleteByExample(BCAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACCOUNT
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @Delete({
        "delete from BC_ACCOUNT",
        "where ACT_ADDRESS = #{actAddress,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(BCAccountKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACCOUNT
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @Insert({
        "insert into BC_ACCOUNT (ACT_ADDRESS, ACT_NONCE, ",
        "ACT_BALANCE, ACT_MAX, ",
        "ACT_ACCEPT_MAX, ACT_ACCEPT_LIMIT, ",
        "STORAGE_HEX, CODE_HASH_HEX, ",
        "CODE_HEX, DATA_HEX, ",
        "ACT_STATUS, CREATE_TIME, ",
        "UPDATE_TIME)",
        "values (#{actAddress,jdbcType=VARCHAR}, #{actNonce,jdbcType=INTEGER}, ",
        "#{actBalance,jdbcType=DECIMAL}, #{actMax,jdbcType=DECIMAL}, ",
        "#{actAcceptMax,jdbcType=DECIMAL}, #{actAcceptLimit,jdbcType=DECIMAL}, ",
        "#{storageHex,jdbcType=VARCHAR}, #{codeHashHex,jdbcType=VARCHAR}, ",
        "#{codeHex,jdbcType=VARCHAR}, #{dataHex,jdbcType=VARCHAR}, ",
        "#{actStatus,jdbcType=CHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(BCAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACCOUNT
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @InsertProvider(type=BCAccountSqlProvider.class, method="insertSelective")
    int insertSelective(BCAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACCOUNT
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @SelectProvider(type=BCAccountSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ACT_ADDRESS", property="actAddress", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ACT_NONCE", property="actNonce", jdbcType=JdbcType.INTEGER),
        @Result(column="ACT_BALANCE", property="actBalance", jdbcType=JdbcType.DECIMAL),
        @Result(column="ACT_MAX", property="actMax", jdbcType=JdbcType.DECIMAL),
        @Result(column="ACT_ACCEPT_MAX", property="actAcceptMax", jdbcType=JdbcType.DECIMAL),
        @Result(column="ACT_ACCEPT_LIMIT", property="actAcceptLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="STORAGE_HEX", property="storageHex", jdbcType=JdbcType.VARCHAR),
        @Result(column="CODE_HASH_HEX", property="codeHashHex", jdbcType=JdbcType.VARCHAR),
        @Result(column="CODE_HEX", property="codeHex", jdbcType=JdbcType.VARCHAR),
        @Result(column="DATA_HEX", property="dataHex", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACT_STATUS", property="actStatus", jdbcType=JdbcType.CHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BCAccount> selectByExample(BCAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACCOUNT
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @Select({
        "select",
        "ACT_ADDRESS, ACT_NONCE, ACT_BALANCE, ACT_MAX, ACT_ACCEPT_MAX, ACT_ACCEPT_LIMIT, ",
        "STORAGE_HEX, CODE_HASH_HEX, CODE_HEX, DATA_HEX, ACT_STATUS, CREATE_TIME, UPDATE_TIME",
        "from BC_ACCOUNT",
        "where ACT_ADDRESS = #{actAddress,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ACT_ADDRESS", property="actAddress", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ACT_NONCE", property="actNonce", jdbcType=JdbcType.INTEGER),
        @Result(column="ACT_BALANCE", property="actBalance", jdbcType=JdbcType.DECIMAL),
        @Result(column="ACT_MAX", property="actMax", jdbcType=JdbcType.DECIMAL),
        @Result(column="ACT_ACCEPT_MAX", property="actAcceptMax", jdbcType=JdbcType.DECIMAL),
        @Result(column="ACT_ACCEPT_LIMIT", property="actAcceptLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="STORAGE_HEX", property="storageHex", jdbcType=JdbcType.VARCHAR),
        @Result(column="CODE_HASH_HEX", property="codeHashHex", jdbcType=JdbcType.VARCHAR),
        @Result(column="CODE_HEX", property="codeHex", jdbcType=JdbcType.VARCHAR),
        @Result(column="DATA_HEX", property="dataHex", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACT_STATUS", property="actStatus", jdbcType=JdbcType.CHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    BCAccount selectByPrimaryKey(BCAccountKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACCOUNT
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @UpdateProvider(type=BCAccountSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BCAccount record, @Param("example") BCAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACCOUNT
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @UpdateProvider(type=BCAccountSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BCAccount record, @Param("example") BCAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACCOUNT
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @UpdateProvider(type=BCAccountSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BCAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACCOUNT
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @Update({
        "update BC_ACCOUNT",
        "set ACT_NONCE = #{actNonce,jdbcType=INTEGER},",
          "ACT_BALANCE = #{actBalance,jdbcType=DECIMAL},",
          "ACT_MAX = #{actMax,jdbcType=DECIMAL},",
          "ACT_ACCEPT_MAX = #{actAcceptMax,jdbcType=DECIMAL},",
          "ACT_ACCEPT_LIMIT = #{actAcceptLimit,jdbcType=DECIMAL},",
          "STORAGE_HEX = #{storageHex,jdbcType=VARCHAR},",
          "CODE_HASH_HEX = #{codeHashHex,jdbcType=VARCHAR},",
          "CODE_HEX = #{codeHex,jdbcType=VARCHAR},",
          "DATA_HEX = #{dataHex,jdbcType=VARCHAR},",
          "ACT_STATUS = #{actStatus,jdbcType=CHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where ACT_ADDRESS = #{actAddress,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(BCAccount record);
}
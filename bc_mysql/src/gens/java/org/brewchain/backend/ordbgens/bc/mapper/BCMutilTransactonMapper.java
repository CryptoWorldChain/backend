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
import org.brewchain.backend.ordbgens.bc.entity.BCMutilTransacton;
import org.brewchain.backend.ordbgens.bc.entity.BCMutilTransactonExample;
import org.brewchain.backend.ordbgens.bc.entity.BCMutilTransactonKey;

public interface BCMutilTransactonMapper extends StaticTableDaoSupport<BCMutilTransacton, BCMutilTransactonExample, BCMutilTransactonKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MUTIL_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @SelectProvider(type=BCMutilTransactonSqlProvider.class, method="countByExample")
    int countByExample(BCMutilTransactonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MUTIL_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @DeleteProvider(type=BCMutilTransactonSqlProvider.class, method="deleteByExample")
    int deleteByExample(BCMutilTransactonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MUTIL_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Delete({
        "delete from BC_MUTIL_TRANSACTON",
        "where TX_HASH = #{txHash,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(BCMutilTransactonKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MUTIL_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Insert({
        "insert into BC_MUTIL_TRANSACTON (TX_HASH, BVERSION, ",
        "HASH_MERKLE_ROOT, BLOCK_HEIGHT, ",
        "ADDRESS_IN_COUNT, ADDRESS_OUT_COUNT, ",
        "PROP_COUNT, TX_STATUS, ",
        "INDEX_IN_BLOCK, RESULTS_HEX, ",
        "DATA, EXTRA_DATA, ",
        "TX_TIMESTAMP, TX_TYPE, ",
        "CREATE_TIME, UPDATE_TIME)",
        "values (#{txHash,jdbcType=VARCHAR}, #{bversion,jdbcType=VARCHAR}, ",
        "#{hashMerkleRoot,jdbcType=VARCHAR}, #{blockHeight,jdbcType=DECIMAL}, ",
        "#{addressInCount,jdbcType=INTEGER}, #{addressOutCount,jdbcType=INTEGER}, ",
        "#{propCount,jdbcType=INTEGER}, #{txStatus,jdbcType=CHAR}, ",
        "#{indexInBlock,jdbcType=INTEGER}, #{resultsHex,jdbcType=VARCHAR}, ",
        "#{data,jdbcType=VARCHAR}, #{extraData,jdbcType=VARCHAR}, ",
        "#{txTimestamp,jdbcType=DECIMAL}, #{txType,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(BCMutilTransacton record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MUTIL_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @InsertProvider(type=BCMutilTransactonSqlProvider.class, method="insertSelective")
    int insertSelective(BCMutilTransacton record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MUTIL_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @SelectProvider(type=BCMutilTransactonSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="TX_HASH", property="txHash", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="BVERSION", property="bversion", jdbcType=JdbcType.VARCHAR),
        @Result(column="HASH_MERKLE_ROOT", property="hashMerkleRoot", jdbcType=JdbcType.VARCHAR),
        @Result(column="BLOCK_HEIGHT", property="blockHeight", jdbcType=JdbcType.DECIMAL),
        @Result(column="ADDRESS_IN_COUNT", property="addressInCount", jdbcType=JdbcType.INTEGER),
        @Result(column="ADDRESS_OUT_COUNT", property="addressOutCount", jdbcType=JdbcType.INTEGER),
        @Result(column="PROP_COUNT", property="propCount", jdbcType=JdbcType.INTEGER),
        @Result(column="TX_STATUS", property="txStatus", jdbcType=JdbcType.CHAR),
        @Result(column="INDEX_IN_BLOCK", property="indexInBlock", jdbcType=JdbcType.INTEGER),
        @Result(column="RESULTS_HEX", property="resultsHex", jdbcType=JdbcType.VARCHAR),
        @Result(column="DATA", property="data", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRA_DATA", property="extraData", jdbcType=JdbcType.VARCHAR),
        @Result(column="TX_TIMESTAMP", property="txTimestamp", jdbcType=JdbcType.DECIMAL),
        @Result(column="TX_TYPE", property="txType", jdbcType=JdbcType.INTEGER),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BCMutilTransacton> selectByExample(BCMutilTransactonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MUTIL_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Select({
        "select",
        "TX_HASH, BVERSION, HASH_MERKLE_ROOT, BLOCK_HEIGHT, ADDRESS_IN_COUNT, ADDRESS_OUT_COUNT, ",
        "PROP_COUNT, TX_STATUS, INDEX_IN_BLOCK, RESULTS_HEX, DATA, EXTRA_DATA, TX_TIMESTAMP, ",
        "TX_TYPE, CREATE_TIME, UPDATE_TIME",
        "from BC_MUTIL_TRANSACTON",
        "where TX_HASH = #{txHash,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="TX_HASH", property="txHash", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="BVERSION", property="bversion", jdbcType=JdbcType.VARCHAR),
        @Result(column="HASH_MERKLE_ROOT", property="hashMerkleRoot", jdbcType=JdbcType.VARCHAR),
        @Result(column="BLOCK_HEIGHT", property="blockHeight", jdbcType=JdbcType.DECIMAL),
        @Result(column="ADDRESS_IN_COUNT", property="addressInCount", jdbcType=JdbcType.INTEGER),
        @Result(column="ADDRESS_OUT_COUNT", property="addressOutCount", jdbcType=JdbcType.INTEGER),
        @Result(column="PROP_COUNT", property="propCount", jdbcType=JdbcType.INTEGER),
        @Result(column="TX_STATUS", property="txStatus", jdbcType=JdbcType.CHAR),
        @Result(column="INDEX_IN_BLOCK", property="indexInBlock", jdbcType=JdbcType.INTEGER),
        @Result(column="RESULTS_HEX", property="resultsHex", jdbcType=JdbcType.VARCHAR),
        @Result(column="DATA", property="data", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRA_DATA", property="extraData", jdbcType=JdbcType.VARCHAR),
        @Result(column="TX_TIMESTAMP", property="txTimestamp", jdbcType=JdbcType.DECIMAL),
        @Result(column="TX_TYPE", property="txType", jdbcType=JdbcType.INTEGER),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    BCMutilTransacton selectByPrimaryKey(BCMutilTransactonKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MUTIL_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @UpdateProvider(type=BCMutilTransactonSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BCMutilTransacton record, @Param("example") BCMutilTransactonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MUTIL_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @UpdateProvider(type=BCMutilTransactonSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BCMutilTransacton record, @Param("example") BCMutilTransactonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MUTIL_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @UpdateProvider(type=BCMutilTransactonSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BCMutilTransacton record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_MUTIL_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Update({
        "update BC_MUTIL_TRANSACTON",
        "set BVERSION = #{bversion,jdbcType=VARCHAR},",
          "HASH_MERKLE_ROOT = #{hashMerkleRoot,jdbcType=VARCHAR},",
          "BLOCK_HEIGHT = #{blockHeight,jdbcType=DECIMAL},",
          "ADDRESS_IN_COUNT = #{addressInCount,jdbcType=INTEGER},",
          "ADDRESS_OUT_COUNT = #{addressOutCount,jdbcType=INTEGER},",
          "PROP_COUNT = #{propCount,jdbcType=INTEGER},",
          "TX_STATUS = #{txStatus,jdbcType=CHAR},",
          "INDEX_IN_BLOCK = #{indexInBlock,jdbcType=INTEGER},",
          "RESULTS_HEX = #{resultsHex,jdbcType=VARCHAR},",
          "DATA = #{data,jdbcType=VARCHAR},",
          "EXTRA_DATA = #{extraData,jdbcType=VARCHAR},",
          "TX_TIMESTAMP = #{txTimestamp,jdbcType=DECIMAL},",
          "TX_TYPE = #{txType,jdbcType=INTEGER},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where TX_HASH = #{txHash,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(BCMutilTransacton record);
}
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
import org.brewchain.backend.ordbgens.bc.entity.BCTransacton;
import org.brewchain.backend.ordbgens.bc.entity.BCTransactonExample;
import org.brewchain.backend.ordbgens.bc.entity.BCTransactonKey;

public interface BCTransactonMapper extends StaticTableDaoSupport<BCTransacton, BCTransactonExample, BCTransactonKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @SelectProvider(type=BCTransactonSqlProvider.class, method="countByExample")
    int countByExample(BCTransactonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @DeleteProvider(type=BCTransactonSqlProvider.class, method="deleteByExample")
    int deleteByExample(BCTransactonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Delete({
        "delete from BC_TRANSACTON",
        "where TXID = #{txid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(BCTransactonKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Insert({
        "insert into BC_TRANSACTON (TXID, BVERSION, ",
        "HASH_MERKLE_ROOT, BLOCK_HEIGHT, ",
        "ADDRESS_IN_COUNT, ADDRESS_OUT_COUNT, ",
        "PROP_COUNT, TX_STATUS, ",
        "INDEX_IN_BLOCK, EXT_COMMENTS, ",
        "CREATE_TIME, UPDATE_TIME)",
        "values (#{txid,jdbcType=VARCHAR}, #{bversion,jdbcType=VARCHAR}, ",
        "#{hashMerkleRoot,jdbcType=VARCHAR}, #{blockHeight,jdbcType=DECIMAL}, ",
        "#{addressInCount,jdbcType=INTEGER}, #{addressOutCount,jdbcType=INTEGER}, ",
        "#{propCount,jdbcType=INTEGER}, #{txStatus,jdbcType=CHAR}, ",
        "#{indexInBlock,jdbcType=INTEGER}, #{extComments,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(BCTransacton record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @InsertProvider(type=BCTransactonSqlProvider.class, method="insertSelective")
    int insertSelective(BCTransacton record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @SelectProvider(type=BCTransactonSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="TXID", property="txid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="BVERSION", property="bversion", jdbcType=JdbcType.VARCHAR),
        @Result(column="HASH_MERKLE_ROOT", property="hashMerkleRoot", jdbcType=JdbcType.VARCHAR),
        @Result(column="BLOCK_HEIGHT", property="blockHeight", jdbcType=JdbcType.DECIMAL),
        @Result(column="ADDRESS_IN_COUNT", property="addressInCount", jdbcType=JdbcType.INTEGER),
        @Result(column="ADDRESS_OUT_COUNT", property="addressOutCount", jdbcType=JdbcType.INTEGER),
        @Result(column="PROP_COUNT", property="propCount", jdbcType=JdbcType.INTEGER),
        @Result(column="TX_STATUS", property="txStatus", jdbcType=JdbcType.CHAR),
        @Result(column="INDEX_IN_BLOCK", property="indexInBlock", jdbcType=JdbcType.INTEGER),
        @Result(column="EXT_COMMENTS", property="extComments", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BCTransacton> selectByExample(BCTransactonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Select({
        "select",
        "TXID, BVERSION, HASH_MERKLE_ROOT, BLOCK_HEIGHT, ADDRESS_IN_COUNT, ADDRESS_OUT_COUNT, ",
        "PROP_COUNT, TX_STATUS, INDEX_IN_BLOCK, EXT_COMMENTS, CREATE_TIME, UPDATE_TIME",
        "from BC_TRANSACTON",
        "where TXID = #{txid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="TXID", property="txid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="BVERSION", property="bversion", jdbcType=JdbcType.VARCHAR),
        @Result(column="HASH_MERKLE_ROOT", property="hashMerkleRoot", jdbcType=JdbcType.VARCHAR),
        @Result(column="BLOCK_HEIGHT", property="blockHeight", jdbcType=JdbcType.DECIMAL),
        @Result(column="ADDRESS_IN_COUNT", property="addressInCount", jdbcType=JdbcType.INTEGER),
        @Result(column="ADDRESS_OUT_COUNT", property="addressOutCount", jdbcType=JdbcType.INTEGER),
        @Result(column="PROP_COUNT", property="propCount", jdbcType=JdbcType.INTEGER),
        @Result(column="TX_STATUS", property="txStatus", jdbcType=JdbcType.CHAR),
        @Result(column="INDEX_IN_BLOCK", property="indexInBlock", jdbcType=JdbcType.INTEGER),
        @Result(column="EXT_COMMENTS", property="extComments", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    BCTransacton selectByPrimaryKey(BCTransactonKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @UpdateProvider(type=BCTransactonSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BCTransacton record, @Param("example") BCTransactonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @UpdateProvider(type=BCTransactonSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BCTransacton record, @Param("example") BCTransactonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @UpdateProvider(type=BCTransactonSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BCTransacton record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_TRANSACTON
     *
     * @mbggenerated Tue Aug 21 20:51:20 CST 2018
     */
    @Update({
        "update BC_TRANSACTON",
        "set BVERSION = #{bversion,jdbcType=VARCHAR},",
          "HASH_MERKLE_ROOT = #{hashMerkleRoot,jdbcType=VARCHAR},",
          "BLOCK_HEIGHT = #{blockHeight,jdbcType=DECIMAL},",
          "ADDRESS_IN_COUNT = #{addressInCount,jdbcType=INTEGER},",
          "ADDRESS_OUT_COUNT = #{addressOutCount,jdbcType=INTEGER},",
          "PROP_COUNT = #{propCount,jdbcType=INTEGER},",
          "TX_STATUS = #{txStatus,jdbcType=CHAR},",
          "INDEX_IN_BLOCK = #{indexInBlock,jdbcType=INTEGER},",
          "EXT_COMMENTS = #{extComments,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where TXID = #{txid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(BCTransacton record);
}
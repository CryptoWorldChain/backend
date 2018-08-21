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
import org.brewchain.backend.ordbgens.bc.entity.BCActAddress;
import org.brewchain.backend.ordbgens.bc.entity.BCActAddressExample;
import org.brewchain.backend.ordbgens.bc.entity.BCActAddressKey;

public interface BCActAddressMapper extends StaticTableDaoSupport<BCActAddress, BCActAddressExample, BCActAddressKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @SelectProvider(type=BCActAddressSqlProvider.class, method="countByExample")
    int countByExample(BCActAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @DeleteProvider(type=BCActAddressSqlProvider.class, method="deleteByExample")
    int deleteByExample(BCActAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @Delete({
        "delete from BC_ACT_ADDRESS",
        "where ADDRESS_UID = #{addressUid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(BCActAddressKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @Insert({
        "insert into BC_ACT_ADDRESS (ADDRESS_UID, ACT_ADDRESS, ",
        "ACTA_STATUS, CREATE_TIME, ",
        "UPDATE_TIME)",
        "values (#{addressUid,jdbcType=VARCHAR}, #{actAddress,jdbcType=VARCHAR}, ",
        "#{actaStatus,jdbcType=CHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(BCActAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @InsertProvider(type=BCActAddressSqlProvider.class, method="insertSelective")
    int insertSelective(BCActAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @SelectProvider(type=BCActAddressSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ADDRESS_UID", property="addressUid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ACT_ADDRESS", property="actAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACTA_STATUS", property="actaStatus", jdbcType=JdbcType.CHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BCActAddress> selectByExample(BCActAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @Select({
        "select",
        "ADDRESS_UID, ACT_ADDRESS, ACTA_STATUS, CREATE_TIME, UPDATE_TIME",
        "from BC_ACT_ADDRESS",
        "where ADDRESS_UID = #{addressUid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ADDRESS_UID", property="addressUid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ACT_ADDRESS", property="actAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACTA_STATUS", property="actaStatus", jdbcType=JdbcType.CHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    BCActAddress selectByPrimaryKey(BCActAddressKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @UpdateProvider(type=BCActAddressSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BCActAddress record, @Param("example") BCActAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @UpdateProvider(type=BCActAddressSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BCActAddress record, @Param("example") BCActAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @UpdateProvider(type=BCActAddressSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BCActAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BC_ACT_ADDRESS
     *
     * @mbggenerated Tue Aug 21 20:51:19 CST 2018
     */
    @Update({
        "update BC_ACT_ADDRESS",
        "set ACT_ADDRESS = #{actAddress,jdbcType=VARCHAR},",
          "ACTA_STATUS = #{actaStatus,jdbcType=CHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where ADDRESS_UID = #{addressUid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(BCActAddress record);
}
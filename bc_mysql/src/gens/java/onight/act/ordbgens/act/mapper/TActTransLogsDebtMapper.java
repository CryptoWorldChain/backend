package onight.act.ordbgens.act.mapper;

import java.util.List;
import onight.act.ordbgens.act.entity.TActTransLogsDebt;
import onight.act.ordbgens.act.entity.TActTransLogsDebtExample;
import onight.act.ordbgens.act.entity.TActTransLogsDebtKey;
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

public interface TActTransLogsDebtMapper extends StaticTableDaoSupport<TActTransLogsDebt, TActTransLogsDebtExample, TActTransLogsDebtKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Tue Jan 19 22:41:13 CST 2016
     */
    @SelectProvider(type=TActTransLogsDebtSqlProvider.class, method="countByExample")
    int countByExample(TActTransLogsDebtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Tue Jan 19 22:41:13 CST 2016
     */
    @DeleteProvider(type=TActTransLogsDebtSqlProvider.class, method="deleteByExample")
    int deleteByExample(TActTransLogsDebtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Tue Jan 19 22:41:13 CST 2016
     */
    @Delete({
        "delete from T_ACT_TRANS_LOGS_DEBT",
        "where LOG_UUID = #{logUuid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TActTransLogsDebtKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Tue Jan 19 22:41:13 CST 2016
     */
    @Insert({
        "insert into T_ACT_TRANS_LOGS_DEBT (LOG_UUID, FROM_FUND_NO, ",
        "TO_FUND_NO, FLAG_CANCEL, ",
        "RELATED_TRANS_ID, STATUS, ",
        "CREATE_TIME, UPDATE_TIME)",
        "values (#{logUuid,jdbcType=VARCHAR}, #{fromFundNo,jdbcType=VARCHAR}, ",
        "#{toFundNo,jdbcType=VARCHAR}, #{flagCancel,jdbcType=CHAR}, ",
        "#{relatedTransId,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(TActTransLogsDebt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Tue Jan 19 22:41:13 CST 2016
     */
    @InsertProvider(type=TActTransLogsDebtSqlProvider.class, method="insertSelective")
    int insertSelective(TActTransLogsDebt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Tue Jan 19 22:41:13 CST 2016
     */
    @SelectProvider(type=TActTransLogsDebtSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="LOG_UUID", property="logUuid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="FROM_FUND_NO", property="fromFundNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="TO_FUND_NO", property="toFundNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="FLAG_CANCEL", property="flagCancel", jdbcType=JdbcType.CHAR),
        @Result(column="RELATED_TRANS_ID", property="relatedTransId", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TActTransLogsDebt> selectByExample(TActTransLogsDebtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Tue Jan 19 22:41:13 CST 2016
     */
    @Select({
        "select",
        "LOG_UUID, FROM_FUND_NO, TO_FUND_NO, FLAG_CANCEL, RELATED_TRANS_ID, STATUS, CREATE_TIME, ",
        "UPDATE_TIME",
        "from T_ACT_TRANS_LOGS_DEBT",
        "where LOG_UUID = #{logUuid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="LOG_UUID", property="logUuid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="FROM_FUND_NO", property="fromFundNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="TO_FUND_NO", property="toFundNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="FLAG_CANCEL", property="flagCancel", jdbcType=JdbcType.CHAR),
        @Result(column="RELATED_TRANS_ID", property="relatedTransId", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    TActTransLogsDebt selectByPrimaryKey(TActTransLogsDebtKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Tue Jan 19 22:41:13 CST 2016
     */
    @UpdateProvider(type=TActTransLogsDebtSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TActTransLogsDebt record, @Param("example") TActTransLogsDebtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Tue Jan 19 22:41:13 CST 2016
     */
    @UpdateProvider(type=TActTransLogsDebtSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TActTransLogsDebt record, @Param("example") TActTransLogsDebtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Tue Jan 19 22:41:13 CST 2016
     */
    @UpdateProvider(type=TActTransLogsDebtSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TActTransLogsDebt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_TRANS_LOGS_DEBT
     *
     * @mbggenerated Tue Jan 19 22:41:13 CST 2016
     */
    @Update({
        "update T_ACT_TRANS_LOGS_DEBT",
        "set FROM_FUND_NO = #{fromFundNo,jdbcType=VARCHAR},",
          "TO_FUND_NO = #{toFundNo,jdbcType=VARCHAR},",
          "FLAG_CANCEL = #{flagCancel,jdbcType=CHAR},",
          "RELATED_TRANS_ID = #{relatedTransId,jdbcType=VARCHAR},",
          "STATUS = #{status,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where LOG_UUID = #{logUuid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TActTransLogsDebt record);
}
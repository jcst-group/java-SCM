package com.nongxin.terminal.dao.scfinance.detection;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.entity.base.BaseInfo;
import com.nongxin.terminal.entity.scfinance.system.FinanceRole;
import com.nongxin.terminal.entity.scfinance.system.FinanceUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author clover
 * @since 2019-12-10
 */
public interface FinanceUserMapper extends BaseMapper<FinanceUser> {



    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property = "cominfo",column = "id",
                    one = @One(select = "com.nongxin.terminal.dao.scfinance.detection.FinanceCominfoMapper.queryFinanceCominfoById")),
            @Result(property = "registInfo",column = "id",
                    one = @One(select = "com.nongxin.terminal.dao.scfinance.detection.CompanyRegistInfoMapper.queryOneByFinanceUserId")),
            @Result(property = "legalPerson",column = "id",
                    one = @One(select = "com.nongxin.terminal.dao.scfinance.detection.CompanyLegalPersonMapper.queryOneByFinanceUserId"))
    })
    @Select("select id from ddwb_finance_user where id = #{id}")
    FinanceUser queryFinanceUserById(Integer id);


    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property = "bases",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.scfinance.detection.FinanceUserMapper.queryCoopRelBases")),
            @Result(property = "financeRoles",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.scfinance.detection.FinanceUserMapper.queryRolesByUserId"))
    })
    @Select(
            "select * from ddwb_finance_user "
                    + "${ew.customSqlSegment}"
    )
    IPage<FinanceUser> userList(Page page, @Param("ew") QueryWrapper<FinanceUser> wrapper);


    @Select("select a.base_name,a.id from ddwb_base_info a,fianceuser_user_base_rel b where a.id = b.base_id and b.financeuser_id = #{coopId} ")
    List<BaseInfo> queryCoopRelBases(Integer coopId);

    @Select("select * from finance_role a LEFT JOIN finance_user_role b on a.id = b.role_id where b.user_id = #{userId} ")
    List<FinanceRole> queryRolesByUserId(Integer userId);


}

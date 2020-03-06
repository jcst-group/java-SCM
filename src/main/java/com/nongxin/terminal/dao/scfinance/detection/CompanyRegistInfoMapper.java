package com.nongxin.terminal.dao.scfinance.detection;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nongxin.terminal.entity.scfinance.detection.CompanyRegistInfo;
import org.apache.ibatis.annotations.*;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author clover
 * @since 2019-12-10
 */
public interface CompanyRegistInfoMapper extends BaseMapper<CompanyRegistInfo> {

    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property = "businessAddress",column = "id",
                    one = @One(select = "com.nongxin.terminal.dao.address.AddressMapper.getComanyBusinessAddres")),
            @Result(property = "registAddress",column = "id",
                    one = @One(select = "com.nongxin.terminal.dao.address.AddressMapper.getComanyRegistAddres"))
    })
    @Select("select * from ddwb_company_regist_info where 1=1 and ${ew.sqlSegment}")
    CompanyRegistInfo queryRegistInfo(@Param("ew") QueryWrapper wrapper);

    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property = "businessAddress",column = "id",
                    one = @One(select = "com.nongxin.terminal.dao.address.AddressMapper.getComanyBusinessAddres")),
            @Result(property = "registAddress",column = "id",
                    one = @One(select = "com.nongxin.terminal.dao.address.AddressMapper.getComanyRegistAddres"))
    })
    @Select("select * from ddwb_company_regist_info where finance_user_id = #{financeId}")
    CompanyRegistInfo queryOneByFinanceUserId(Integer financeId);
}

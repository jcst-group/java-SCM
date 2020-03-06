package com.nongxin.terminal.dao.scfinance.detection;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nongxin.terminal.entity.scfinance.detection.FinanceCominfo;
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
public interface FinanceCominfoMapper extends BaseMapper<FinanceCominfo> {


    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property = "pictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getFinanceBusinessPic")),
            @Result(property = "address",column = "id",
                        one = @One(select = "com.nongxin.terminal.dao.address.AddressMapper.getCompanyAddress"))
    })
    @Select("select * from ddwb_finance_cominfo where 1=1 and ${ew.sqlSegment}")
    FinanceCominfo queryFinanceCominfo(@Param("ew") QueryWrapper wrapper);


    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property = "pictureInfos",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getFinanceBusinessPic")),
            @Result(property = "address",column = "id",
                    one = @One(select = "com.nongxin.terminal.dao.address.AddressMapper.getCompanyAddress"))
    })
    @Select("select * from ddwb_finance_cominfo where finance_user_id = #{financeUserId}")
    FinanceCominfo queryFinanceCominfoById(Integer financeUserId);

    /**
     * 查询某种类型用户的公司信息
     * @param userType
     * @return
     */
    @Select("select a.username,a.finance_user_id from ddwb_finance_cominfo a,ddwb_finance_user b where a.finance_user_id= b.id and b.user_type = #{userType}")
    List<FinanceCominfo> queryCominfosByUserType(Integer userType);
}

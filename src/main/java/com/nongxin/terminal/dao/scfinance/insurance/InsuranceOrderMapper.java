package com.nongxin.terminal.dao.scfinance.insurance;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.entity.scfinance.insurance.InsuranceOrder;
import org.apache.ibatis.annotations.*;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author clover
 * @since 2019-12-13
 */
public interface InsuranceOrderMapper extends BaseMapper<InsuranceOrder> {


    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="insurance_id",property="insuranceId"),
            @Result(column="finance_user_id",property="financeUserId"),
            //保险公司信息
            @Result(property = "insuranceUser",column = "insurance_id",
                    one = @One(select = "com.nongxin.terminal.dao.scfinance.detection.FinanceUserMapper.queryFinanceUserById")),
            //合作社信息
            @Result(property = "coperativeUser",column = "finance_user_id",
                    one = @One(select = "com.nongxin.terminal.dao.scfinance.detection.FinanceUserMapper.queryFinanceUserById")),
            @Result(property = "plantInfo",column = "id",
                    one = @One(select = "com.nongxin.terminal.dao.scfinance.insurance.InsurancePlantInfoMapper.queryPlantInfoByOrderId")),
            @Result(property = "messages",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.scfinance.insurance.InsuranceOrderMessageMapper.queryRelMessges")),
            @Result(property = "orderPics",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getInsuranceOrderPic")),
            @Result(property = "orderFiles",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.scfinance.system.FinanceFileInfoMapper.getInsuranceOrder")),
    })
    @Select(
            "select * from insurance_order "
                    + "${ew.customSqlSegment}"
    )
    IPage<InsuranceOrder> orderList(Page page, @Param("ew") QueryWrapper<InsuranceOrder> wrapper);


}

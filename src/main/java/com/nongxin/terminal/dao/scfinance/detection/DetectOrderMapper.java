package com.nongxin.terminal.dao.scfinance.detection;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.entity.scfinance.insurance.DetectOrder;
import org.apache.ibatis.annotations.*;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author clover
 * @since 2019-12-24
 */
public interface DetectOrderMapper extends BaseMapper<DetectOrder> {


    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="order_user_id",property="orderUserId"),
            @Result(column="finance_user_id",property="financeUserId"),
            @Result(column="detect_user_id",property="detectUserId"),
            @Result(column="bank_id",property="bankId"),
            //费用项
            @Result(property = "feeItems",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.scfinance.detection.DetectFeeItemMapper.selectByDetectOrderId")),
            //社员
            @Result(property = "financeMember",column = "number_id",
                    one = @One(select = "com.nongxin.terminal.dao.scfinance.system.FinanceMemberMapper.queryFinanceMemberById")),
            //订单企业信息
            @Result(property = "orderUser",column = "order_user_id",
                    one = @One(select = "com.nongxin.terminal.dao.scfinance.detection.FinanceUserMapper.queryFinanceUserById")),
            //合作社信息
            @Result(property = "financeUser",column = "finance_user_id",
                    one = @One(select = "com.nongxin.terminal.dao.scfinance.detection.FinanceUserMapper.queryFinanceUserById")),
            //检测机构信息
            @Result(property = "detectUser",column = "detect_user_id",
                    one = @One(select = "com.nongxin.terminal.dao.scfinance.detection.FinanceUserMapper.queryFinanceUserById")),
            //提交的担保审批图片
            @Result(property = "relatePics",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getDetectRelatePics")),
            //提交的贷款银行审批图片
            @Result(property = "resultPics",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getDetectResultPics")),
            @Result(property = "messages",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.scfinance.insurance.InsuranceOrderMessageMapper.queryDetectOrderRelMessges")),
            @Result(property = "applyFiles",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.scfinance.system.FinanceFileInfoMapper.getdetectApply")),
            @Result(property = "resultFiles",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.scfinance.system.FinanceFileInfoMapper.getDetectResult")),
    })
    @Select("select * from detect_order "
                    + "${ew.customSqlSegment}"
    )
    IPage<DetectOrder> orderList(Page page, @Param("ew") QueryWrapper<DetectOrder> wrapper);
}

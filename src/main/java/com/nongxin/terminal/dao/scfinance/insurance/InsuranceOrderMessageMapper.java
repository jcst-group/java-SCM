package com.nongxin.terminal.dao.scfinance.insurance;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nongxin.terminal.entity.scfinance.insurance.InsuranceOrderMessage;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author clover
 * @since 2019-12-16
 */
public interface InsuranceOrderMessageMapper extends BaseMapper<InsuranceOrderMessage> {


    @Select(
            " select * from insurance_order_message  where relate_id=#{relateId} and relate_type=1"
    )
    List<InsuranceOrderMessage> queryRelMessges(Integer relateId);

    @Select(
            " select * from insurance_order_message  where relate_id=#{relateId} and relate_type=2"
    )
    List<InsuranceOrderMessage> queryLoanApplyRelMessges(Integer relateId);

    @Select(
            " select * from insurance_order_message  where relate_id=#{relateId} and relate_type=3"
    )
    List<InsuranceOrderMessage> queryDetectOrderRelMessges(Integer relateId);

}

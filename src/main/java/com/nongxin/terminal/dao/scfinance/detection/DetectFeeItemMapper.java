package com.nongxin.terminal.dao.scfinance.detection;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nongxin.terminal.entity.scfinance.insurance.DetectFeeItem;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author clover
 * @since 2019-12-24
 */
public interface DetectFeeItemMapper extends BaseMapper<DetectFeeItem> {


    @Select("select * from detect_fee_item where detect_order_id = #{orderId}")
    List<DetectFeeItem> selectByDetectOrderId(Integer orderId);
}

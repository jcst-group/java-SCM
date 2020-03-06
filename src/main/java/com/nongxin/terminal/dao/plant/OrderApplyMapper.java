package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.OrderApply;
import com.nongxin.terminal.util.enumUtil.plan.AgreeEnum;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderApply record);

    int insertSelective(OrderApply record);

    OrderApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderApply record);

    int updateByPrimaryKey(OrderApply record);

    List<OrderApply> getOrderApply(@Param("orderId")Integer orderId,@Param("status")String status);

    int getOrderApplyCount();

    AgreeEnum getLastOrderApply(@Param("orderId")Integer orderId);
}
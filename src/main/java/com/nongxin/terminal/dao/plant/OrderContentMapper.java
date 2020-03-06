package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.OrderContent;

public interface OrderContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderContent record);

    int insertSelective(OrderContent record);

    OrderContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderContent record);

    int updateByPrimaryKey(OrderContent record);

    OrderContent selectByOrderId(Integer orderId);

    int deleteByOrderId(Integer orderId);
}
package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.OrderRole;
import org.apache.ibatis.annotations.Param;

public interface OrderRoleMapper {
    int deleteByPrimaryKey(Integer workOrderId);

    int insert(OrderRole record);

    int insertSelective(OrderRole record);

    OrderRole selectByPrimaryKey(Integer workOrderId);

    int updateByPrimaryKeySelective(OrderRole record);

    int updateByPrimaryKey(OrderRole record);

    int addOrderRole(@Param("roleIds") Integer[] roleIds, @Param("orderId") Integer orderId);
}
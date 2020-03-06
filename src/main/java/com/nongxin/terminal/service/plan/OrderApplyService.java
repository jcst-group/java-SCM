package com.nongxin.terminal.service.plan;

import com.nongxin.terminal.entity.plant.OrderApply;

import java.util.List;

public interface OrderApplyService {

    boolean add(OrderApply orderApply);

    List<OrderApply> getOrderApply(Integer orderId,String status);

    int getOrderApplyCount();

    boolean update(OrderApply orderApply);

}

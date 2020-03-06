package com.nongxin.terminal.service.plan;

import com.nongxin.terminal.entity.plant.OrderContent;

public interface OrderContentService {

    boolean add(OrderContent orderContent);

    boolean delete(Integer id);

}

package com.nongxin.terminal.service.plan.impl;

import com.nongxin.terminal.dao.plant.OrderContentMapper;
import com.nongxin.terminal.entity.plant.OrderContent;
import com.nongxin.terminal.service.plan.OrderContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderContentServiceImpl implements OrderContentService {

    @Autowired(required = false)
    private OrderContentMapper orderContentMapper;

    @Override
    public boolean add(OrderContent orderContent) {
        return orderContentMapper.insertSelective(orderContent)==1;
    }

    @Override
    public boolean delete(Integer id) {
        return orderContentMapper.deleteByPrimaryKey(id)==1;
    }
}

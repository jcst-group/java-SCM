package com.nongxin.terminal.service.plan.impl;

import com.nongxin.terminal.dao.file.FileInfoMapper;
import com.nongxin.terminal.dao.plant.OrderApplyMapper;
import com.nongxin.terminal.entity.file.FileInfo;
import com.nongxin.terminal.entity.plant.OrderApply;
import com.nongxin.terminal.service.plan.OrderApplyService;
import com.nongxin.terminal.service.plan.WorkOrderService;
import com.nongxin.terminal.util.enumUtil.plan.AgreeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderApplyServiceImpl implements OrderApplyService {

    @Autowired
    private OrderApplyMapper orderApplyMapper;
    @Autowired
    private FileInfoMapper fileInfoMapper;
    @Autowired
    private WorkOrderService workOrderService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(OrderApply orderApply) {
        FileInfo fileInfo = orderApply.getFileInfo();
        int count = orderApplyMapper.insertSelective(orderApply);
        if (fileInfo != null){
            fileInfo.setRelationId(orderApply.getId());
            fileInfoMapper.updateByPrimaryKeySelective(fileInfo);
        }
        return count==1;
    }

    @Override
    public List<OrderApply> getOrderApply(Integer orderId,String status) {
        return orderApplyMapper.getOrderApply(orderId,status);
    }

    @Override
    public int getOrderApplyCount() {
        return orderApplyMapper.getOrderApplyCount();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(OrderApply orderApply) {
        if (orderApply.getAgree() == AgreeEnum.Agree){
            workOrderService.updateAllowedExecute(orderApply.getOrderId(),true);
        }
        return orderApplyMapper.updateByPrimaryKeySelective(orderApply)==1;
    }
}

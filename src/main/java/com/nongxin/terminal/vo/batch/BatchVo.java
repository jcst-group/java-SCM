package com.nongxin.terminal.vo.batch;

import com.nongxin.terminal.util.enumUtil.plan.WorkOrderStatusEnum;

public class BatchVo {

    private Integer id;

    private String batchName;

    private String isEstablish;

    private WorkOrderStatusEnum orderStatus;

    public WorkOrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(WorkOrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getIsEstablish() {
        return isEstablish;
    }

    public void setIsEstablish(String isEstablish) {
        this.isEstablish = isEstablish;
    }
}

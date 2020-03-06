package com.nongxin.terminal.vo.lookboard;

import java.util.List;

public class CropBatchVo {

    private Integer id;

    private String batchName;

    private List<WorkOrderVo> workOrderList;

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

    public List<WorkOrderVo> getWorkOrderList() {
        return workOrderList;
    }

    public void setWorkOrderList(List<WorkOrderVo> workOrderList) {
        this.workOrderList = workOrderList;
    }
}

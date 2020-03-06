package com.nongxin.terminal.vo.push;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class CIDVo {

    private Integer userId;

    private String baseName;

    private Integer farming_item_id;

    private String farmingName;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date execution_time;

    private String batchName;

    private List<String> cidList;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<String> getCidList() {
        return cidList;
    }

    public void setCidList(List<String> cidList) {
        this.cidList = cidList;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public Integer getFarming_item_id() {
        return farming_item_id;
    }

    public void setFarming_item_id(Integer farming_item_id) {
        this.farming_item_id = farming_item_id;
    }

    public String getFarmingName() {
        return farmingName;
    }

    public void setFarmingName(String farmingName) {
        this.farmingName = farmingName;
    }

    public Date getExecution_time() {
        return execution_time;
    }

    public void setExecution_time(Date execution_time) {
        this.execution_time = execution_time;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }
}

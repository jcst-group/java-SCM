package com.nongxin.terminal.vo.workorder;

import com.nongxin.terminal.entity.system.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class BusinessReportVo {

    private Integer id;

    private String batchName;

    private BigDecimal humanCost;

    private Short startYear;

    private List<User> userList;

    private List<Map<String,Object>> deviceCost;

    private List<Map<String,Object>> materielCost;

    private List<Map<String,Object>> harvested;

    public List<Map<String, Object>> getHarvested() {
        return harvested;
    }

    public void setHarvested(List<Map<String, Object>> harvested) {
        this.harvested = harvested;
    }

    public List<Map<String, Object>> getDeviceCost() {
        return deviceCost;
    }

    public void setDeviceCost(List<Map<String, Object>> deviceCost) {
        this.deviceCost = deviceCost;
    }

    public List<Map<String, Object>> getMaterielCost() {
        return materielCost;
    }

    public void setMaterielCost(List<Map<String, Object>> materielCost) {
        this.materielCost = materielCost;
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

    public BigDecimal getHumanCost() {
        return humanCost;
    }

    public void setHumanCost(BigDecimal humanCost) {
        this.humanCost = humanCost;
    }

    public Short getStartYear() {
        return startYear;
    }

    public void setStartYear(Short startYear) {
        this.startYear = startYear;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}

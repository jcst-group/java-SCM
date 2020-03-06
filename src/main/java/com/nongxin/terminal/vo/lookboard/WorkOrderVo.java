package com.nongxin.terminal.vo.lookboard;

import com.nongxin.terminal.util.enumUtil.solar.SolarTermsEnum;

import java.util.Date;

public class WorkOrderVo {

    private Integer id;

    private Date executionTime;

    private SolarTermsEnum solarTerm;

    private Integer farmingItemId;

    private FarmingItemVo farmingItem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public SolarTermsEnum getSolarTerm() {
        return solarTerm;
    }

    public void setSolarTerm(SolarTermsEnum solarTerm) {
        this.solarTerm = solarTerm;
    }

    public Integer getFarmingItemId() {
        return farmingItemId;
    }

    public void setFarmingItemId(Integer farmingItemId) {
        this.farmingItemId = farmingItemId;
    }

    public FarmingItemVo getFarmingItem() {
        return farmingItem;
    }

    public void setFarmingItem(FarmingItemVo farmingItem) {
        this.farmingItem = farmingItem;
    }
}

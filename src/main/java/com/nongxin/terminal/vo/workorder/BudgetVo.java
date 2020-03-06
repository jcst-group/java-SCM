package com.nongxin.terminal.vo.workorder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.plant.DeviceAct;
import com.nongxin.terminal.entity.plant.MaterialAct;
import com.nongxin.terminal.entity.plant.PersonnelAct;
import com.nongxin.terminal.entity.system.Role;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BudgetVo {

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date executionTime;

    private String farmingName;

    private BigDecimal costSum;

    private Integer farmingId;

    private List<DeviceAct> deviceActList;

    private List<MaterialAct> materialActList;

    private List<PersonnelAct> personnelActList;

    public Integer getFarmingId() {
        return farmingId;
    }

    public void setFarmingId(Integer farmingId) {
        this.farmingId = farmingId;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public String getFarmingName() {
        return farmingName;
    }

    public void setFarmingName(String farmingName) {
        this.farmingName = farmingName;
    }

    public BigDecimal getCostSum() {
        return costSum;
    }

    public void setCostSum(BigDecimal costSum) {
        this.costSum = costSum;
    }

    public List<DeviceAct> getDeviceActList() {
        return deviceActList;
    }

    public void setDeviceActList(List<DeviceAct> deviceActList) {
        this.deviceActList = deviceActList;
    }

    public List<MaterialAct> getMaterialActList() {
        return materialActList;
    }

    public void setMaterialActList(List<MaterialAct> materialActList) {
        this.materialActList = materialActList;
    }

    public List<PersonnelAct> getPersonnelActList() {
        return personnelActList;
    }

    public void setPersonnelActList(List<PersonnelAct> personnelActList) {
        this.personnelActList = personnelActList;
    }
}

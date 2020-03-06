package com.nongxin.terminal.entity.plant;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PersonnelInfo {
    private Integer id;

    @NotEmpty(message = "人员信息不能为空")
    private String personnelName;

    @NotNull(message = "人天/亩不能为空")
    private BigDecimal unitMu;

    @NotNull(message = "人工费用不能为空")
    private BigDecimal laborCosts;

    @NotNull(message = "提前准备天数不能为空")
    private Short prepareDay;

    @NotNull(message = "农事活动id不能为空")
    private Integer farmingId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName == null ? null : personnelName.trim();
    }

    public BigDecimal getUnitMu() {
        return unitMu;
    }

    public void setUnitMu(BigDecimal unitMu) {
        this.unitMu = unitMu;
    }

    public BigDecimal getLaborCosts() {
        return laborCosts;
    }

    public void setLaborCosts(BigDecimal laborCosts) {
        this.laborCosts = laborCosts;
    }

    public Short getPrepareDay() {
        return prepareDay;
    }

    public void setPrepareDay(Short prepareDay) {
        this.prepareDay = prepareDay;
    }

    public Integer getFarmingId() {
        return farmingId;
    }

    public void setFarmingId(Integer farmingId) {
        this.farmingId = farmingId;
    }
}
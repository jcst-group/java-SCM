package com.nongxin.terminal.entity.plant;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class DeviceInfo {
    private Integer id;

    @NotEmpty(message = "设备名称不能为空")
    private String deviceName;

    @NotEmpty(message = "单位不能为空")
    private String company;

    @NotNull(message = "单位/亩不能为空")
    private BigDecimal unitMu;

    @NotNull(message = "设备租金不能为空")
    private BigDecimal rent;

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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public BigDecimal getUnitMu() {
        return unitMu;
    }

    public void setUnitMu(BigDecimal unitMu) {
        this.unitMu = unitMu;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
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
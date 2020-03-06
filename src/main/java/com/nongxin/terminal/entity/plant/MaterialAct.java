package com.nongxin.terminal.entity.plant;

import java.math.BigDecimal;

public class MaterialAct {
    private Integer id;

    private String materialName;

    private String company;

    private BigDecimal preUnitPrice;

    private BigDecimal preUnitCount;

    private BigDecimal preCal;

    private BigDecimal actCal;

    private BigDecimal actUnitPrice;

    private BigDecimal actUnitCount;

    private Integer orderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public BigDecimal getPreUnitPrice() {
        return preUnitPrice;
    }

    public void setPreUnitPrice(BigDecimal preUnitPrice) {
        this.preUnitPrice = preUnitPrice;
    }

    public BigDecimal getPreUnitCount() {
        return preUnitCount;
    }

    public void setPreUnitCount(BigDecimal preUnitCount) {
        this.preUnitCount = preUnitCount;
    }

    public BigDecimal getPreCal() {
        return preCal;
    }

    public void setPreCal(BigDecimal preCal) {
        this.preCal = preCal;
    }

    public BigDecimal getActCal() {
        return actCal;
    }

    public void setActCal(BigDecimal actCal) {
        this.actCal = actCal;
    }

    public BigDecimal getActUnitPrice() {
        return actUnitPrice;
    }

    public void setActUnitPrice(BigDecimal actUnitPrice) {
        this.actUnitPrice = actUnitPrice;
    }

    public BigDecimal getActUnitCount() {
        return actUnitCount;
    }

    public void setActUnitCount(BigDecimal actUnitCount) {
        this.actUnitCount = actUnitCount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public MaterialAct() {
    }

    public MaterialAct(String materialName, String company, BigDecimal preUnitPrice, BigDecimal preUnitCount, BigDecimal preCal, Integer orderId) {
        this.materialName = materialName;
        this.company = company;
        this.preUnitPrice = preUnitPrice;
        this.preUnitCount = preUnitCount;
        this.preCal = preCal;
        this.orderId = orderId;
    }
}
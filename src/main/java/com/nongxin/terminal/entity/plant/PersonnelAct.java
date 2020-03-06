package com.nongxin.terminal.entity.plant;

import java.math.BigDecimal;

public class PersonnelAct {
    private Integer id;

    private String personName;

    private BigDecimal preUnitPrice;

    private BigDecimal preUnitCount;

    private BigDecimal preCal;

    private BigDecimal actUnitPrice;

    private BigDecimal actCal;

    private BigDecimal actUnitCount;

    private Integer orderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
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

    public BigDecimal getActUnitPrice() {
        return actUnitPrice;
    }

    public void setActUnitPrice(BigDecimal actUnitPrice) {
        this.actUnitPrice = actUnitPrice;
    }

    public BigDecimal getActCal() {
        return actCal;
    }

    public void setActCal(BigDecimal actCal) {
        this.actCal = actCal;
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

    public PersonnelAct() {
    }

    public PersonnelAct(String personName, BigDecimal preUnitPrice, BigDecimal preUnitCount, BigDecimal preCal, Integer orderId) {
        this.personName = personName;
        this.preUnitPrice = preUnitPrice;
        this.preUnitCount = preUnitCount;
        this.preCal = preCal;
        this.orderId = orderId;
    }
}
package com.nongxin.terminal.vo.detection;

import com.nongxin.terminal.entity.common.Unit;

import java.math.BigDecimal;

public class DetectionVo {

    private Integer id;

    private String item;

    private BigDecimal minValue;

    private BigDecimal maxValue;

    private BigDecimal actValue;

    private Unit unit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public BigDecimal getMinValue() {
        return minValue;
    }

    public void setMinValue(BigDecimal minValue) {
        this.minValue = minValue;
    }

    public BigDecimal getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(BigDecimal maxValue) {
        this.maxValue = maxValue;
    }

    public BigDecimal getActValue() {
        return actValue;
    }

    public void setActValue(BigDecimal actValue) {
        this.actValue = actValue;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}

package com.nongxin.terminal.vo.lookboard;

import com.nongxin.terminal.entity.common.Unit;

import java.math.BigDecimal;

public class DetectionValueVo {

    private BigDecimal value;

    private String item;

    private Unit unit;

    private BigDecimal min_value;

    private BigDecimal max_value;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public BigDecimal getMin_value() {
        return min_value;
    }

    public void setMin_value(BigDecimal min_value) {
        this.min_value = min_value;
    }

    public BigDecimal getMax_value() {
        return max_value;
    }

    public void setMax_value(BigDecimal max_value) {
        this.max_value = max_value;
    }
}

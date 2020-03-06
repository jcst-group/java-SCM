package com.nongxin.terminal.entity.base;

import com.nongxin.terminal.entity.common.Unit;
import com.nongxin.terminal.util.enumUtil.base.EnvStandardsEnum;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class EnvStandards {
    private Integer id;

    /*@NotNull(message = "检测项目名称不能为空")
    private Short itemName;*/
    private EnvStandardsEnum itemName;

    @NotEmpty(message = "检测项目不能为空")
    private String item;

    @NotNull(message = "检测单位不能为空")
    private Unit unit;

    @NotNull(message = "检测标准最小值不能为空")
    private BigDecimal minValue;

    @NotNull(message = "检测标准最大值不能为空")
    private BigDecimal maxValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EnvStandardsEnum getItemName() {
        return itemName;
    }

    public void setItemName(EnvStandardsEnum itemName) {
        this.itemName = itemName;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
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
}
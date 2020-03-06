package com.nongxin.terminal.vo.base;

import com.nongxin.terminal.util.enumUtil.base.EnvStandardsEnum;

import java.math.BigDecimal;

public class BaseTestingVo {

    private Integer baseId;

    private Integer envStandardsId;

    //检测项目
    private String item;

    //检测项目所属类型
    private EnvStandardsEnum itemName;

    //值
    private BigDecimal value;

    private BigDecimal maxValue;

    public BigDecimal getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(BigDecimal maxValue) {
        this.maxValue = maxValue;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public EnvStandardsEnum getItemName() {
        return itemName;
    }

    public void setItemName(EnvStandardsEnum itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    public Integer getEnvStandardsId() {
        return envStandardsId;
    }

    public void setEnvStandardsId(Integer envStandardsId) {
        this.envStandardsId = envStandardsId;
    }
}

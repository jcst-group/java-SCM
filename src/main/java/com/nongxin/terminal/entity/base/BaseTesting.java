package com.nongxin.terminal.entity.base;

import java.math.BigDecimal;

public class BaseTesting {
    private Integer envStandardsId;

    private Integer baseId;

    private BigDecimal value;

    public Integer getEnvStandardsId() {
        return envStandardsId;
    }

    public void setEnvStandardsId(Integer envStandardsId) {
        this.envStandardsId = envStandardsId;
    }

    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
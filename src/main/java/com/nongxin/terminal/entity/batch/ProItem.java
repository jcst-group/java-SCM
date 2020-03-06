package com.nongxin.terminal.entity.batch;

import com.nongxin.terminal.util.enumUtil.common.UnitEnum;

import java.math.BigDecimal;

public class ProItem {
    private Integer id;

    private Integer initproBatchId;

    private Integer revoceryBatchId;

    private String proName;

    private String proLevel;

    private UnitEnum unit;

    private BigDecimal weightCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInitproBatchId() {
        return initproBatchId;
    }

    public void setInitproBatchId(Integer initproBatchId) {
        this.initproBatchId = initproBatchId;
    }

    public Integer getRevoceryBatchId() {
        return revoceryBatchId;
    }

    public void setRevoceryBatchId(Integer revoceryBatchId) {
        this.revoceryBatchId = revoceryBatchId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public String getProLevel() {
        return proLevel;
    }

    public void setProLevel(String proLevel) {
        this.proLevel = proLevel == null ? null : proLevel.trim();
    }

    public UnitEnum getUnit() {
        return unit;
    }

    public void setUnit(UnitEnum unit) {
        this.unit = unit;
    }

    public BigDecimal getWeightCount() {
        return weightCount;
    }

    public void setWeightCount(BigDecimal weightCount) {
        this.weightCount = weightCount;
    }
}
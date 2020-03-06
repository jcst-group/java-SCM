package com.nongxin.terminal.entity.testing;

import com.nongxin.terminal.util.enumUtil.test.DetectionStageEnum;

import java.math.BigDecimal;

public class DetectionRel {
    private Integer relationId;

    private Integer detectionId;

    private BigDecimal value;

    private DetectionStageEnum type;

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public Integer getDetectionId() {
        return detectionId;
    }

    public void setDetectionId(Integer detectionId) {
        this.detectionId = detectionId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public DetectionStageEnum getType() {
        return type;
    }

    public void setType(DetectionStageEnum type) {
        this.type = type;
    }
}
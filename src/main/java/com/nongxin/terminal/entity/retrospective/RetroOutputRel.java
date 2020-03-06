package com.nongxin.terminal.entity.retrospective;

import com.nongxin.terminal.util.enumUtil.retrospective.RetroCodingTypeEnum;

import java.math.BigDecimal;

public class RetroOutputRel {
    private Integer relationId;

    private RetroCodingTypeEnum relationType;

    private BigDecimal residualOutput;

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public RetroCodingTypeEnum getRelationType() {
        return relationType;
    }

    public void setRelationType(RetroCodingTypeEnum relationType) {
        this.relationType = relationType;
    }

    public BigDecimal getResidualOutput() {
        return residualOutput;
    }

    public void setResidualOutput(BigDecimal residualOutput) {
        this.residualOutput = residualOutput;
    }
}
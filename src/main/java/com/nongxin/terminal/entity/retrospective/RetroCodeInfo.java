package com.nongxin.terminal.entity.retrospective;

import com.nongxin.terminal.entity.batch.InitialProBatch;
import com.nongxin.terminal.entity.crop.Crop;
import com.nongxin.terminal.entity.recovery.RecoveryBatch;
import com.nongxin.terminal.util.enumUtil.retrospective.RetroCodingTypeEnum;
import com.nongxin.terminal.util.enumUtil.retrospective.RetroUnitEnum;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RetroCodeInfo {
    private Integer id;

    private Integer initId;

    private Integer recoId;

    @NotNull(message = "净重不能为空")
    private BigDecimal netWeight;

    @NotNull(message = "单位不能为空")
    private RetroUnitEnum unit;

    @NotNull(message = "规格不能为空")
    private String specifications;

    @NotNull(message = "质检员不能为空")
    private String qc;

    private String remarks;

    @NotNull(message = "类型不能为空")
    private RetroCodingTypeEnum type;

    private String executeStandard;

    private String provenance;

    private InitialProBatch initialProBatch;

    private RecoveryBatch recoveryBatch;

    private Crop crop;

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public InitialProBatch getInitialProBatch() {
        return initialProBatch;
    }

    public void setInitialProBatch(InitialProBatch initialProBatch) {
        this.initialProBatch = initialProBatch;
    }

    public RecoveryBatch getRecoveryBatch() {
        return recoveryBatch;
    }

    public void setRecoveryBatch(RecoveryBatch recoveryBatch) {
        this.recoveryBatch = recoveryBatch;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInitId() {
        return initId;
    }

    public void setInitId(Integer initId) {
        this.initId = initId;
    }

    public Integer getRecoId() {
        return recoId;
    }

    public void setRecoId(Integer recoId) {
        this.recoId = recoId;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public String getQc() {
        return qc;
    }

    public void setQc(String qc) {
        this.qc = qc == null ? null : qc.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getExecuteStandard() {
        return executeStandard;
    }

    public void setExecuteStandard(String executeStandard) {
        this.executeStandard = executeStandard == null ? null : executeStandard.trim();
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance == null ? null : provenance.trim();
    }

    public RetroUnitEnum getUnit() {
        return unit;
    }

    public void setUnit(RetroUnitEnum unit) {
        this.unit = unit;
    }

    public RetroCodingTypeEnum getType() {
        return type;
    }

    public void setType(RetroCodingTypeEnum type) {
        this.type = type;
    }
}
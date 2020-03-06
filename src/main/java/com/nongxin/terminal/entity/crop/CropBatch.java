package com.nongxin.terminal.entity.crop;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.base.BaseInfo;
import com.nongxin.terminal.entity.base.Lot;
import com.nongxin.terminal.entity.batch.SeedBatch;
import com.nongxin.terminal.entity.plant.PlantingPlan;
import com.nongxin.terminal.entity.recovery.RecoveryBatch;
import com.nongxin.terminal.util.enumUtil.crop.BatchStatusEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CropBatch {
    private Integer id;

    @NotEmpty(message = "批次名称不能为空")
    private String batchName;

    @NotNull(message = "种植计划不能为空")
    private Integer planId;

    private Integer cropId;

    @NotNull(message = "种子批次不能为空")
    private Integer seedBatchId;

    @NotNull(message = "预计亩产值不能为空")
    private BigDecimal projectedMuYield;

    @NotNull(message = "开始阳历年份不能为空")
    private Short startYear;

    private BatchStatusEnum status;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startTime;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endTime;

    @NotNull(message = "基地不能为空")
    private Integer baseId;

    @NotNull(message = "地块不能为空")
    private List<Lot> lotList;

    private Crop crop;

    private SeedBatch seedBatch;

    private PlantingPlan plantingPlan;

    private BaseInfo baseInfo;

    private List<RecoveryBatch> recoveryList;

    public List<RecoveryBatch> getRecoveryList() {
        return recoveryList;
    }

    public void setRecoveryList(List<RecoveryBatch> recoveryList) {
        this.recoveryList = recoveryList;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public PlantingPlan getPlantingPlan() {
        return plantingPlan;
    }

    public void setPlantingPlan(PlantingPlan plantingPlan) {
        this.plantingPlan = plantingPlan;
    }

    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public SeedBatch getSeedBatch() {
        return seedBatch;
    }

    public void setSeedBatch(SeedBatch seedBatch) {
        this.seedBatch = seedBatch;
    }

    public List<Lot> getLotList() {
        return lotList;
    }

    public void setLotList(List<Lot> lotList) {
        this.lotList = lotList;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName == null ? null : batchName.trim();
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public Integer getSeedBatchId() {
        return seedBatchId;
    }

    public void setSeedBatchId(Integer seedBatchId) {
        this.seedBatchId = seedBatchId;
    }

    public BigDecimal getProjectedMuYield() {
        return projectedMuYield;
    }

    public void setProjectedMuYield(BigDecimal projectedMuYield) {
        this.projectedMuYield = projectedMuYield;
    }

    public Short getStartYear() {
        return startYear;
    }

    public void setStartYear(Short startYear) {
        this.startYear = startYear;
    }

    public BatchStatusEnum getStatus() {
        return status;
    }

    public void setStatus(BatchStatusEnum status) {
        this.status = status;
    }
}
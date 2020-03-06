package com.nongxin.terminal.entity.batch;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.crop.Crop;
import com.nongxin.terminal.entity.plant.PlantingPlan;
import com.nongxin.terminal.entity.processing.ProcessingMethods;
import com.nongxin.terminal.util.enumUtil.common.CodingStatusEnum;
import com.nongxin.terminal.util.enumUtil.common.UnitEnum;
import com.nongxin.terminal.vo.recovery.BaseRecoveryVo;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class InitialProBatch {
    private Integer id;

    private String initialName;

    private String initialProcessingCode;

    @NotNull(message = "加工日期不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date initialProcessingTime;

    private String content;

    @NotNull(message = "种植计划不能为空")
    private Integer planId;

    private Integer harvestedProductId;

    private Integer processingId;

    private Integer productsId;

    private BigDecimal yield;

    private UnitEnum unit;

    private Integer recoveryBatchId;

    @NotNull(message = "作物不能为空")
    private Integer cropId;

    private List<ProItem> proItemList;

    private List<Integer> recoveryBatchIds;

    private List<Integer> methodIds;

    private Crop crop;

    private PlantingPlan plantingPlan;

    private List<BaseRecoveryVo> recoveryList;

    private List<ProcessingMethods> methodsList;

    private CodingStatusEnum status;

    public CodingStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CodingStatusEnum status) {
        this.status = status;
    }

    public UnitEnum getUnit() {
        return unit;
    }

    public void setUnit(UnitEnum unit) {
        this.unit = unit;
    }

    public List<ProcessingMethods> getMethodsList() {
        return methodsList;
    }

    public void setMethodsList(List<ProcessingMethods> methodsList) {
        this.methodsList = methodsList;
    }

    public List<BaseRecoveryVo> getRecoveryList() {
        return recoveryList;
    }

    public void setRecoveryList(List<BaseRecoveryVo> recoveryList) {
        this.recoveryList = recoveryList;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public PlantingPlan getPlantingPlan() {
        return plantingPlan;
    }

    public void setPlantingPlan(PlantingPlan plantingPlan) {
        this.plantingPlan = plantingPlan;
    }

    public List<Integer> getMethodIds() {
        return methodIds;
    }

    public void setMethodIds(List<Integer> methodIds) {
        this.methodIds = methodIds;
    }

    public List<ProItem> getProItemList() {
        return proItemList;
    }



    public List<Integer> getRecoveryBatchIds() {
        return recoveryBatchIds;
    }

    public void setRecoveryBatchIds(List<Integer> recoveryBatchIds) {
        this.recoveryBatchIds = recoveryBatchIds;
    }

    public void setProItemList(List<ProItem> proItemList) {
        this.proItemList = proItemList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInitialName() {
        return initialName;
    }

    public void setInitialName(String initialName) {
        this.initialName = initialName == null ? null : initialName.trim();
    }

    public String getInitialProcessingCode() {
        return initialProcessingCode;
    }

    public void setInitialProcessingCode(String initialProcessingCode) {
        this.initialProcessingCode = initialProcessingCode == null ? null : initialProcessingCode.trim();
    }

    public Date getInitialProcessingTime() {
        return initialProcessingTime;
    }

    public void setInitialProcessingTime(Date initialProcessingTime) {
        this.initialProcessingTime = initialProcessingTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getHarvestedProductId() {
        return harvestedProductId;
    }

    public void setHarvestedProductId(Integer harvestedProductId) {
        this.harvestedProductId = harvestedProductId;
    }

    public Integer getProcessingId() {
        return processingId;
    }

    public void setProcessingId(Integer processingId) {
        this.processingId = processingId;
    }

    public Integer getProductsId() {
        return productsId;
    }

    public void setProductsId(Integer productsId) {
        this.productsId = productsId;
    }

    public BigDecimal getYield() {
        return yield;
    }

    public void setYield(BigDecimal yield) {
        this.yield = yield;
    }

    public Integer getRecoveryBatchId() {
        return recoveryBatchId;
    }

    public void setRecoveryBatchId(Integer recoveryBatchId) {
        this.recoveryBatchId = recoveryBatchId;
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    @Override
    public String toString() {
        return "InitialProBatch{" +
                "id=" + id +
                ", initialName='" + initialName + '\'' +
                ", initialProcessingCode='" + initialProcessingCode + '\'' +
                ", initialProcessingTime=" + initialProcessingTime +
                ", content='" + content + '\'' +
                ", planId=" + planId +
                ", harvestedProductId=" + harvestedProductId +
                ", processingId=" + processingId +
                ", productsId=" + productsId +
                ", yield=" + yield +
                ", recoveryBatchId=" + recoveryBatchId +
                ", cropId=" + cropId +
                ", proItemList=" + proItemList +
                ", recoveryBatchIds=" + recoveryBatchIds +
                ", methodIds=" + methodIds +
                '}';
    }
}
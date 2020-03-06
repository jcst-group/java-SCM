package com.nongxin.terminal.entity.recovery;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.crop.Crop;
import com.nongxin.terminal.entity.crop.CropBatch;
import com.nongxin.terminal.entity.crop.HarvestedProduct;
import com.nongxin.terminal.util.enumUtil.common.CodingStatusEnum;
import com.nongxin.terminal.util.enumUtil.common.UnitEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class RecoveryBatch {
    private Integer id;

    private String recoveryCode;

    @NotNull(message = "作物不能为空")
    private Integer cropId;

    @NotNull(message = "批次不能为空")
    private Integer cropBatchId;

    @NotNull(message = "采收时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date harvestingTime;

    private BigDecimal yield;

    @NotNull(message = "单位不能为空")
    private UnitEnum unit;

    private Integer harvestedId;

    private HarvestedProduct harvestedProduct;

    private List<RecoveryLot> recoveryLotList;

    private Crop crop;

    private CropBatch cropBatch;

    private CodingStatusEnum status;

    public CodingStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CodingStatusEnum status) {
        this.status = status;
    }

    public HarvestedProduct getHarvestedProduct() {
        return harvestedProduct;
    }

    public void setHarvestedProduct(HarvestedProduct harvestedProduct) {
        this.harvestedProduct = harvestedProduct;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public CropBatch getCropBatch() {
        return cropBatch;
    }

    public void setCropBatch(CropBatch cropBatch) {
        this.cropBatch = cropBatch;
    }

    public List<RecoveryLot> getRecoveryLotList() {
        return recoveryLotList;
    }

    public void setRecoveryLotList(List<RecoveryLot> recoveryLotList) {
        this.recoveryLotList = recoveryLotList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecoveryCode() {
        return recoveryCode;
    }

    public void setRecoveryCode(String recoveryCode) {
        this.recoveryCode = recoveryCode == null ? null : recoveryCode.trim();
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public Integer getCropBatchId() {
        return cropBatchId;
    }

    public void setCropBatchId(Integer cropBatchId) {
        this.cropBatchId = cropBatchId;
    }

    public Date getHarvestingTime() {
        return harvestingTime;
    }

    public void setHarvestingTime(Date harvestingTime) {
        this.harvestingTime = harvestingTime;
    }

    public BigDecimal getYield() {
        return yield;
    }

    public void setYield(BigDecimal yield) {
        this.yield = yield;
    }

    public UnitEnum getUnit() {
        return unit;
    }

    public void setUnit(UnitEnum unit) {
        this.unit = unit;
    }

    public Integer getHarvestedId() {
        return harvestedId;
    }

    public void setHarvestedId(Integer harvestedId) {
        this.harvestedId = harvestedId;
    }
}
package com.nongxin.terminal.entity.batch;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.crop.Crop;
import com.nongxin.terminal.entity.crop.CropBatch;
import com.nongxin.terminal.entity.recovery.RecoveryBatch;
import com.nongxin.terminal.entity.testing.SeedDetection;
import com.nongxin.terminal.util.enumUtil.seed.SeedTypeEnum;
import com.nongxin.terminal.util.enumUtil.seed.SelfSpeciesEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class SeedBatch {
    private Integer id;

    @NotNull(message = "种子类型不能为空")
    private SeedTypeEnum type;

    @NotNull(message = "是否自种不能为空")
    private SelfSpeciesEnum selfSpecies;

    private String seedCode;

    @NotNull(message = "作物不能为空")
    private Integer cropId;

    @NotEmpty(message = "供应商不能为空")
    private String supplier;

    @NotNull(message = "登记时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date registrationTime;

    private String remark;

    private Crop crop;

    private Integer recoveryId;

    private RecoveryBatch recoveryBatch;

    private SeedDetection seedDetection;

    private CropBatch cropBatch;

    public CropBatch getCropBatch() {
        return cropBatch;
    }

    public void setCropBatch(CropBatch cropBatch) {
        this.cropBatch = cropBatch;
    }

    public SeedDetection getSeedDetection() {
        return seedDetection;
    }

    public void setSeedDetection(SeedDetection seedDetection) {
        this.seedDetection = seedDetection;
    }

    public RecoveryBatch getRecoveryBatch() {
        return recoveryBatch;
    }

    public void setRecoveryBatch(RecoveryBatch recoveryBatch) {
        this.recoveryBatch = recoveryBatch;
    }

    public Integer getRecoveryId() {
        return recoveryId;
    }

    public void setRecoveryId(Integer recoveryId) {
        this.recoveryId = recoveryId;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SeedTypeEnum getType() {
        return type;
    }

    public void setType(SeedTypeEnum type) {
        this.type = type;
    }

    public SelfSpeciesEnum getSelfSpecies() {
        return selfSpecies;
    }

    public void setSelfSpecies(SelfSpeciesEnum selfSpecies) {
        this.selfSpecies = selfSpecies;
    }

    public String getSeedCode() {
        return seedCode;
    }

    public void setSeedCode(String seedCode) {
        this.seedCode = seedCode == null ? null : seedCode.trim();
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
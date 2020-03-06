package com.nongxin.terminal.entity.testing;

import com.nongxin.terminal.entity.common.Unit;
import com.nongxin.terminal.entity.crop.Crop;
import com.nongxin.terminal.util.enumUtil.test.DetectionCategoryEnum;
import com.nongxin.terminal.util.enumUtil.test.DetectionStageEnum;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class DetectionItems {
    private Integer id;

    @NotNull(message = "检测项目阶段不能为空")
    private DetectionStageEnum stage;

    @NotEmpty(message = "检测项目不能为空")
    private String item;

    @NotNull(message = "单位不能为空")
    private Unit unit;

    @NotNull(message = "检测标准最小值不能为空")
    private BigDecimal minValue;

    @NotNull(message = "检测标准最大值不能为空")
    private BigDecimal maxValue;

    @NotNull(message = "作物不能为空")
    private Integer cropId;

    private DetectionCategoryEnum itemCategory;

    private Date createTime;

    private Crop crop;

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


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
    }



    public BigDecimal getMinValue() {
        return minValue;
    }

    public void setMinValue(BigDecimal minValue) {
        this.minValue = minValue;
    }

    public BigDecimal getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(BigDecimal maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }


    public DetectionStageEnum getStage() {
        return stage;
    }

    public void setStage(DetectionStageEnum stage) {
        this.stage = stage;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public DetectionCategoryEnum getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(DetectionCategoryEnum itemCategory) {
        this.itemCategory = itemCategory;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
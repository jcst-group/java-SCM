package com.nongxin.terminal.entity.plant;

import com.nongxin.terminal.entity.file.FileInfo;
import com.nongxin.terminal.entity.file.PictureInfo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class MaterialInfo {
    private Integer id;

    @NotEmpty(message = "物料名称不能为空")
    private String materialName;

    @NotEmpty(message = "单位不能为空")
    private String company;

    @NotNull(message = "单位/亩不能为空")
    private BigDecimal unitMu;

    @NotNull(message = "物料单价不能为空")
    private BigDecimal unitPrice;

    @NotNull(message = "提前准备天数不能为空")
    private Short prepareDay;

    @NotNull(message = "农事活动id不能为空")
    private Integer farmingId;

    private PictureInfo pictureInfo;

    public PictureInfo getPictureInfo() {
        return pictureInfo;
    }

    public void setPictureInfo(PictureInfo pictureInfo) {
        this.pictureInfo = pictureInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public BigDecimal getUnitMu() {
        return unitMu;
    }

    public void setUnitMu(BigDecimal unitMu) {
        this.unitMu = unitMu;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Short getPrepareDay() {
        return prepareDay;
    }

    public void setPrepareDay(Short prepareDay) {
        this.prepareDay = prepareDay;
    }

    public Integer getFarmingId() {
        return farmingId;
    }

    public void setFarmingId(Integer farmingId) {
        this.farmingId = farmingId;
    }
}
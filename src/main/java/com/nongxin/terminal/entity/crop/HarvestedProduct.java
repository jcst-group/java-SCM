package com.nongxin.terminal.entity.crop;

import com.nongxin.terminal.util.enumUtil.crop.HarvestedTypeEnum;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class HarvestedProduct {
    private Integer id;

    @NotNull(message = "作物不能为空")
    private Integer cropId;

    @NotEmpty(message = "采收品名称")
    private String harvestedName;

    @NotNull(message = "采收物类型不能为空")
    private HarvestedTypeEnum type;

    private String describe;

    private List<CropProduct> cropProductList;

    public List<CropProduct> getCropProductList() {
        return cropProductList;
    }

    public void setCropProductList(List<CropProduct> cropProductList) {
        this.cropProductList = cropProductList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public String getHarvestedName() {
        return harvestedName;
    }

    public void setHarvestedName(String harvestedName) {
        this.harvestedName = harvestedName == null ? null : harvestedName.trim();
    }

    public HarvestedTypeEnum getType() {
        return type;
    }

    public void setType(HarvestedTypeEnum type) {
        this.type = type;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}
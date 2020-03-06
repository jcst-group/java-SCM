package com.nongxin.terminal.entity.plant;

import com.nongxin.terminal.entity.crop.Crop;
import com.nongxin.terminal.entity.file.PictureInfo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class FarmingItem {
    private Integer id;

    @NotEmpty(message = "农事项目名称不能为空")
    private String farmingName;

    @NotNull(message = "作物不能为空")
    private Integer cropId;

    @NotEmpty(message = "方法不能为空")
    private String method;

    private List<PictureInfo> pictureInfoList;

    private Crop crop;

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public List<PictureInfo> getPictureInfoList() {
        return pictureInfoList;
    }

    public void setPictureInfoList(List<PictureInfo> pictureInfoList) {
        this.pictureInfoList = pictureInfoList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFarmingName() {
        return farmingName;
    }

    public void setFarmingName(String farmingName) {
        this.farmingName = farmingName == null ? null : farmingName.trim();
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }
}
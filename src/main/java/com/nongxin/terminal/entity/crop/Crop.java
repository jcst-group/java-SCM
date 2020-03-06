package com.nongxin.terminal.entity.crop;

import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.product.Products;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Crop {
    private Integer id;

    @NotEmpty(message = "拼音码不能为空")
    private String pinyinCode;

    @NotEmpty(message = "药材名称")
    private String cropName;

    private String cropCode;

    @NotEmpty(message = "药材描述不能为空")
    private String describe;

    @NotEmpty(message = "食用价值不能为空")
    private String edibleValue;

    @NotEmpty(message = "药用价值不能为空")
    private String medicinalValue;

    @NotNull(message = "药材图片不能为空")
    private PictureInfo cropPic;

    @NotNull(message = "食用价值图片不能为空")
    private PictureInfo ediblePic;

    @NotNull(message = "药用价值图片不能为空")
    private PictureInfo medicinalPic;

    //private List<Products> productsList;

    private List<HarvestedProduct> harvestedProductList;

    public List<HarvestedProduct> getHarvestedProductList() {
        return harvestedProductList;
    }

    public void setHarvestedProductList(List<HarvestedProduct> harvestedProductList) {
        this.harvestedProductList = harvestedProductList;
    }

    public PictureInfo getCropPic() {
        return cropPic;
    }

    public void setCropPic(PictureInfo cropPic) {
        this.cropPic = cropPic;
    }

    public PictureInfo getEdiblePic() {
        return ediblePic;
    }

    public void setEdiblePic(PictureInfo ediblePic) {
        this.ediblePic = ediblePic;
    }

    public PictureInfo getMedicinalPic() {
        return medicinalPic;
    }

    public void setMedicinalPic(PictureInfo medicinalPic) {
        this.medicinalPic = medicinalPic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPinyinCode() {
        return pinyinCode;
    }

    public void setPinyinCode(String pinyinCode) {
        this.pinyinCode = pinyinCode == null ? null : pinyinCode.trim();
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName == null ? null : cropName.trim();
    }

    public String getCropCode() {
        return cropCode;
    }

    public void setCropCode(String cropCode) {
        this.cropCode = cropCode == null ? null : cropCode.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getEdibleValue() {
        return edibleValue;
    }

    public void setEdibleValue(String edibleValue) {
        this.edibleValue = edibleValue == null ? null : edibleValue.trim();
    }

    public String getMedicinalValue() {
        return medicinalValue;
    }

    public void setMedicinalValue(String medicinalValue) {
        this.medicinalValue = medicinalValue == null ? null : medicinalValue.trim();
    }
}
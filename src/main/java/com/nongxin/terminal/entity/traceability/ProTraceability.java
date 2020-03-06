package com.nongxin.terminal.entity.traceability;

import com.nongxin.terminal.entity.file.PictureInfo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ProTraceability {
    private Integer id;

    private String pinyinCode;

    @NotEmpty(message = "名称不能为空")
    private String cropName;

    @NotEmpty(message = "编码不能为空")
    private String cropCode;

    private String describe;

    private String edibleValue;

    private String medicinalValue;

    @NotNull(message = "批次不能为空")
    private Integer batchId;

    private List<PictureInfo> cropPic;

    public List<PictureInfo> getCropPic() {
        return cropPic;
    }

    public void setCropPic(List<PictureInfo> cropPic) {
        this.cropPic = cropPic;
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

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }
}
package com.nongxin.terminal.entity.illness;

import com.nongxin.terminal.entity.file.PictureInfo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class TreatmentPlan {
    private Integer id;

    @NotNull(message = "病虫害id")
    private Integer illId;

    @NotEmpty(message = "治疗方案名称")
    private String planName;

    @NotEmpty(message = "治疗方法不能为空")
    private String method;

    private List<PictureInfo> pictureInfoList;

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

    public Integer getIllId() {
        return illId;
    }

    public void setIllId(Integer illId) {
        this.illId = illId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }
}
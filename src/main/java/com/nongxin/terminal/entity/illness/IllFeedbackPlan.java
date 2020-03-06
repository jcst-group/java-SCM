package com.nongxin.terminal.entity.illness;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class IllFeedbackPlan {
    private Integer id;

    private Integer illId;

    @NotEmpty(message = "病虫害名称不能为空")
    private String illName;

    @NotEmpty(message = "治疗方案名称不能为空")
    private String planName;

    @NotEmpty(message = "治疗方法不能为空")
    private String method;

    @NotNull(message = "病虫害巡视反馈不能为空")
    private Integer feedbackId;

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

    public String getIllName() {
        return illName;
    }

    public void setIllName(String illName) {
        this.illName = illName == null ? null : illName.trim();
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

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }
}
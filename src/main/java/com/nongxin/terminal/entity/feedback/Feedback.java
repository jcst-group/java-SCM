package com.nongxin.terminal.entity.feedback;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.base.BaseInfo;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.util.enumUtil.illness.IllFeedbackStatusEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class Feedback {
    private Integer id;

    private Date feedbackTime;

    private Integer userId;

    //private Integer lotId;
    @NotNull(message = "基地不能为空")
    private Integer baseId;

    @NotNull(message = "内容不能为空")
    private String content;

    private IllFeedbackStatusEnum status;

    private String remark;

    private List<PictureInfo> pictureInfoList;

    private User user;

    private BaseInfo baseInfo;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
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

    public Date getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public IllFeedbackStatusEnum getStatus() {
        return status;
    }

    public void setStatus(IllFeedbackStatusEnum status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
package com.nongxin.terminal.entity.illness;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.base.BaseInfo;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.util.enumUtil.illness.IllFeedbackStatusEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class IllFeedback {
    private Integer id;

    private Integer userId;

    @NotNull(message = "基地id不能为空")
    private Integer baseId;

    @NotEmpty(message = "反馈内容不能为空")
    private String content;

    /*@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")*/
    private Date feedbackTime;

    /*@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")*/
    private Date answerTime;

    private String answerContent;

    private IllFeedbackStatusEnum status;

    private List<PictureInfo> pictureInfoList;

    private User user;

    private BaseInfo baseInfo;

    private List<IllFeedbackPlan> illFeedbackPlans;

    public List<IllFeedbackPlan> getIllFeedbackPlans() {
        return illFeedbackPlans;
    }

    public void setIllFeedbackPlans(List<IllFeedbackPlan> illFeedbackPlans) {
        this.illFeedbackPlans = illFeedbackPlans;
    }

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

    public Date getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent == null ? null : answerContent.trim();
    }

    public IllFeedbackStatusEnum getStatus() {
        return status;
    }

    public void setStatus(IllFeedbackStatusEnum status) {
        this.status = status;
    }
}
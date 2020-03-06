package com.nongxin.terminal.entity.finance;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.base.BaseInfo;
import com.nongxin.terminal.entity.file.PictureInfo;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class StandardPlan {
    private Integer id;

    @NotEmpty(message = "甲方不能为空")
    private String partyA;

    @NotNull(message = "乙方不能为空")
    private Integer partyB;

    @NotNull(message = "签订时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date signTime;

    @NotNull(message = "面积不能为空")
    private BigDecimal acreage;

    @NotNull(message = "开始时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startTime;

    @NotNull(message = "结束时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endTime;

    @NotNull(message = "每亩农资投入不能为空")
    private BigDecimal investMu;

    @NotNull(message = "合同年份不能为空")
    private Integer yearId;

    private List<PictureInfo> pictureInfos;

    private BaseInfo baseInfo;

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public List<PictureInfo> getPictureInfos() {
        return pictureInfos;
    }

    public void setPictureInfos(List<PictureInfo> pictureInfos) {
        this.pictureInfos = pictureInfos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartyA() {
        return partyA;
    }

    public void setPartyA(String partyA) {
        this.partyA = partyA == null ? null : partyA.trim();
    }

    public Integer getPartyB() {
        return partyB;
    }

    public void setPartyB(Integer partyB) {
        this.partyB = partyB;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public void setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getInvestMu() {
        return investMu;
    }

    public void setInvestMu(BigDecimal investMu) {
        this.investMu = investMu;
    }

    public Integer getYearId() {
        return yearId;
    }

    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }
}
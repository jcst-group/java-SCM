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

public class BasePurchase {
    private Integer id;

    @NotEmpty(message = "甲方不能为空")
    private String partyA;

    @NotNull(message = "乙方不能为空")
    private Integer partyB;

    @NotNull(message = "签订时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date signTime;

    @NotEmpty(message = "交付产品不能为空")
    private String payPro;

    @NotNull(message = "交付面积不能为空")
    private BigDecimal payAcreage;

    @NotNull(message = "交付时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date payTime;

    private BigDecimal price;

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

    public String getPayPro() {
        return payPro;
    }

    public void setPayPro(String payPro) {
        this.payPro = payPro == null ? null : payPro.trim();
    }

    public BigDecimal getPayAcreage() {
        return payAcreage;
    }

    public void setPayAcreage(BigDecimal payAcreage) {
        this.payAcreage = payAcreage;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getYearId() {
        return yearId;
    }

    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }
}
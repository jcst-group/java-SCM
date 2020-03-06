package com.nongxin.terminal.entity.finance;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.file.PictureInfo;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LaborDispatch {

    private Integer id;

    @NotEmpty(message = "甲方不能为空")
    private String partyA;

    @NotEmpty(message = "乙方不能为空")
    private String partyB;

    @NotNull(message = "派遣数量不能为空")
    private BigDecimal total;

    @NotNull(message = "价格不能为空")
    private BigDecimal price;

    @NotNull(message = "签订时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date signTime;

    @NotNull(message = "合同年份不能为空")
    private Integer yearId;

    @NotNull(message = "派遣日期不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dispatchTime;

    @NotNull(message = "派遣月份不能为空")
    private BigDecimal dispatchMonth;

    private List<PictureInfo> pictureInfos;

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

    public String getPartyB() {
        return partyB;
    }

    public void setPartyB(String partyB) {
        this.partyB = partyB == null ? null : partyB.trim();
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public Integer getYearId() {
        return yearId;
    }

    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }

    public Date getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(Date dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public BigDecimal getDispatchMonth() {
        return dispatchMonth;
    }

    public void setDispatchMonth(BigDecimal dispatchMonth) {
        this.dispatchMonth = dispatchMonth;
    }
}
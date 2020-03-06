package com.nongxin.terminal.entity.finance;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.file.PictureInfo;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderContract {
    private Integer id;

    @NotEmpty(message = "甲方不能为空")
    private String partyA;

    @NotEmpty(message = "乙方不能为空")
    private String partyB;

    @NotNull(message = "签订时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date signTime;

    @NotEmpty(message = "产品不能为空")
    private String product;

    @NotEmpty(message = "等级不能为空")
    private String level;

    @NotNull(message = "价格不能为空")
    private BigDecimal price;

    @NotNull(message = "总量不能为空")
    private BigDecimal total;

    @NotNull(message = "总金额不能为空")
    private BigDecimal totalMoney;

    @NotNull(message = "交货时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date deliveryTime;

    @NotNull(message = "合同年份不能为空")
    private Integer yearId;

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

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Integer getYearId() {
        return yearId;
    }

    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }
}
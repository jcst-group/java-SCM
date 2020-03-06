package com.nongxin.terminal.entity.base;

import com.nongxin.terminal.entity.address.Address;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.system.User;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class Lot {
    private Integer id;

    @NotNull(message = "基地不能为空")
    private Integer baseId;

    @NotEmpty(message = "地块名称不能为空")
    private String lotName;

    private String lotCode;

    private String areaCode;

    @NotNull(message = "地块面积不能为空")
    private BigDecimal lotAcreage;

    private BigDecimal lotRadius;

    private String survey;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private BigDecimal altitude;

    private Short status;

    //private Address address;

    @NotNull(message = "地块拥有者不能为空")
    private Integer userId;

    private BaseInfo baseInfo;

    private User user;

    private String remark;

    private List<PictureInfo> pictureInfoList;

    public List<PictureInfo> getPictureInfoList() {
        return pictureInfoList;
    }

    public void setPictureInfoList(List<PictureInfo> pictureInfoList) {
        this.pictureInfoList = pictureInfoList;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    public String getLotName() {
        return lotName;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName == null ? null : lotName.trim();
    }

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode == null ? null : lotCode.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public BigDecimal getLotAcreage() {
        return lotAcreage;
    }

    public void setLotAcreage(BigDecimal lotAcreage) {
        this.lotAcreage = lotAcreage;
    }

    public BigDecimal getLotRadius() {
        return lotRadius;
    }

    public void setLotRadius(BigDecimal lotRadius) {
        this.lotRadius = lotRadius;
    }

    public String getSurvey() {
        return survey;
    }

    public void setSurvey(String survey) {
        this.survey = survey == null ? null : survey.trim();
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getAltitude() {
        return altitude;
    }

    public void setAltitude(BigDecimal altitude) {
        this.altitude = altitude;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}
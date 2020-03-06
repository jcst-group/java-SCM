package com.nongxin.terminal.vo.lookboard;


import com.nongxin.terminal.entity.file.PictureInfo;

import java.math.BigDecimal;
import java.util.List;

public class LotTwoVo {

    private Integer id;

    private Integer baseId;

    private String lotName;

    private BigDecimal lotAcreage;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private Short status;

    private String remark;

    private Integer userId;

    private List<BaseUserVo> user;

    private BaseLotInfoVo baseInfo;

    private List<PictureInfo> lotPic;

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
        this.lotName = lotName;
    }

    public BigDecimal getLotAcreage() {
        return lotAcreage;
    }

    public void setLotAcreage(BigDecimal lotAcreage) {
        this.lotAcreage = lotAcreage;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BaseLotInfoVo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseLotInfoVo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<BaseUserVo> getUser() {
        return user;
    }

    public void setUser(List<BaseUserVo> user) {
        this.user = user;
    }

    public List<PictureInfo> getLotPic() {
        return lotPic;
    }

    public void setLotPic(List<PictureInfo> lotPic) {
        this.lotPic = lotPic;
    }
}

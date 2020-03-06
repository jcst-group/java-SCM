package com.nongxin.terminal.vo.lookboard;

import java.math.BigDecimal;

public class LotVo {

    private Integer id;

    private Integer baseId;

    private String lotName;

    private BigDecimal lotAcreage;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String remark;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

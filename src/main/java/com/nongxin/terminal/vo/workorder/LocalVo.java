package com.nongxin.terminal.vo.workorder;

import com.nongxin.terminal.entity.base.Lot;

import java.math.BigDecimal;
import java.util.List;

public class LocalVo {

    private BigDecimal longitude;

    private BigDecimal latitude;

    private BigDecimal baseLongitude;

    private BigDecimal baseLatitude;

    private List<Lot> lotList;

    public BigDecimal getBaseLongitude() {
        return baseLongitude;
    }

    public void setBaseLongitude(BigDecimal baseLongitude) {
        this.baseLongitude = baseLongitude;
    }

    public BigDecimal getBaseLatitude() {
        return baseLatitude;
    }

    public void setBaseLatitude(BigDecimal baseLatitude) {
        this.baseLatitude = baseLatitude;
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

    public List<Lot> getLotList() {
        return lotList;
    }

    public void setLotList(List<Lot> lotList) {
        this.lotList = lotList;
    }
}

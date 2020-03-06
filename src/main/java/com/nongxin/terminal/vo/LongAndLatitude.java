package com.nongxin.terminal.vo;

import java.math.BigDecimal;

/**
 * @author clover
 * @date 2019/5/6
 * @description
 */
public class LongAndLatitude {

    private BigDecimal lng;

    private BigDecimal lat;

    public LongAndLatitude() {
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }
}

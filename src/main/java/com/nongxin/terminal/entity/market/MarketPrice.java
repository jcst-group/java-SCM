package com.nongxin.terminal.entity.market;

import java.math.BigDecimal;
import java.util.Date;

public class MarketPrice {
    private Integer id;

    /**
     * 当前只有麦冬 1
     */
    private Integer breedId;

    /**
     *  当前有市场1 产地2
     */
    private Integer fromType;

    /**
     * 当前有安国 1， 毫州 2， 成都 3， 玉林 4 ，三台5
     */
    private Integer areaId;

    /**
     * 当前只有统货 1
     */
    private Integer specId;

    /**
     * 当前有两种，日 1 ，月 2
     */
    private Integer dateType;

    private Date priceDate;

    private BigDecimal priceValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBreedId() {
        return breedId;
    }

    public void setBreedId(Integer breedId) {
        this.breedId = breedId;
    }

    public Integer getFromType() {
        return fromType;
    }

    public void setFromType(Integer fromType) {
        this.fromType = fromType;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public Integer getDateType() {
        return dateType;
    }

    public void setDateType(Integer dateType) {
        this.dateType = dateType;
    }

    public Date getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }

    public BigDecimal getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(BigDecimal priceValue) {
        this.priceValue = priceValue;
    }
}
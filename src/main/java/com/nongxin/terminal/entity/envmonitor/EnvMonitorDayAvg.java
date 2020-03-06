package com.nongxin.terminal.entity.envmonitor;

import java.math.BigDecimal;
import java.util.Date;

public class EnvMonitorDayAvg {
    private Integer id;

    private BigDecimal avgAirTemperature;

    private BigDecimal avgAirHumidity;

    private BigDecimal avgAirPressure;

    private BigDecimal avgWindSpeed;

    private BigDecimal avgWindDirection;

    private BigDecimal avgRainfall;

    private BigDecimal avgIllIntensity;

    private BigDecimal avgCo2Value;

    private BigDecimal avgPm25Value;

    private BigDecimal avgPm10Value;

    private BigDecimal avgSoilTemperature;

    private BigDecimal avgSoilHumidity;

    private BigDecimal avgSoilPh;

    private BigDecimal avgSoilEc;

    private BigDecimal avgSoilS;

    private Date monitorTime;

    private Integer equipmentId;

    private Integer factoryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAvgAirTemperature() {
        return avgAirTemperature;
    }

    public void setAvgAirTemperature(BigDecimal avgAirTemperature) {
        this.avgAirTemperature = avgAirTemperature;
    }

    public BigDecimal getAvgAirHumidity() {
        return avgAirHumidity;
    }

    public void setAvgAirHumidity(BigDecimal avgAirHumidity) {
        this.avgAirHumidity = avgAirHumidity;
    }

    public BigDecimal getAvgAirPressure() {
        return avgAirPressure;
    }

    public void setAvgAirPressure(BigDecimal avgAirPressure) {
        this.avgAirPressure = avgAirPressure;
    }

    public BigDecimal getAvgWindSpeed() {
        return avgWindSpeed;
    }

    public void setAvgWindSpeed(BigDecimal avgWindSpeed) {
        this.avgWindSpeed = avgWindSpeed;
    }

    public BigDecimal getAvgWindDirection() {
        return avgWindDirection;
    }

    public void setAvgWindDirection(BigDecimal avgWindDirection) {
        this.avgWindDirection = avgWindDirection;
    }

    public BigDecimal getAvgRainfall() {
        return avgRainfall;
    }

    public void setAvgRainfall(BigDecimal avgRainfall) {
        this.avgRainfall = avgRainfall;
    }

    public BigDecimal getAvgIllIntensity() {
        return avgIllIntensity;
    }

    public void setAvgIllIntensity(BigDecimal avgIllIntensity) {
        this.avgIllIntensity = avgIllIntensity;
    }

    public BigDecimal getAvgCo2Value() {
        return avgCo2Value;
    }

    public void setAvgCo2Value(BigDecimal avgCo2Value) {
        this.avgCo2Value = avgCo2Value;
    }

    public BigDecimal getAvgPm25Value() {
        return avgPm25Value;
    }

    public void setAvgPm25Value(BigDecimal avgPm25Value) {
        this.avgPm25Value = avgPm25Value;
    }

    public BigDecimal getAvgPm10Value() {
        return avgPm10Value;
    }

    public void setAvgPm10Value(BigDecimal avgPm10Value) {
        this.avgPm10Value = avgPm10Value;
    }

    public BigDecimal getAvgSoilTemperature() {
        return avgSoilTemperature;
    }

    public void setAvgSoilTemperature(BigDecimal avgSoilTemperature) {
        this.avgSoilTemperature = avgSoilTemperature;
    }

    public BigDecimal getAvgSoilHumidity() {
        return avgSoilHumidity;
    }

    public void setAvgSoilHumidity(BigDecimal avgSoilHumidity) {
        this.avgSoilHumidity = avgSoilHumidity;
    }

    public BigDecimal getAvgSoilPh() {
        return avgSoilPh;
    }

    public void setAvgSoilPh(BigDecimal avgSoilPh) {
        this.avgSoilPh = avgSoilPh;
    }

    public BigDecimal getAvgSoilEc() {
        return avgSoilEc;
    }

    public void setAvgSoilEc(BigDecimal avgSoilEc) {
        this.avgSoilEc = avgSoilEc;
    }

    public BigDecimal getAvgSoilS() {
        return avgSoilS;
    }

    public void setAvgSoilS(BigDecimal avgSoilS) {
        this.avgSoilS = avgSoilS;
    }

    public Date getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(Date monitorTime) {
        this.monitorTime = monitorTime;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }
}
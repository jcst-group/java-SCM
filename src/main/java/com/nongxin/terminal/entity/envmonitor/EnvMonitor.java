package com.nongxin.terminal.entity.envmonitor;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.vo.annotation.FieldAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class EnvMonitor {
    private Integer id;

    @FieldAnnotation(value = "大气温度")
    private BigDecimal airTemperature;

    @FieldAnnotation(value = "大气湿度")
    private BigDecimal airHumidity;

    @FieldAnnotation(value = "大气压")
    private BigDecimal airPressure;

    @FieldAnnotation(value = "风速")
    private BigDecimal windSpeed;

    @FieldAnnotation(value = "风向")
    private BigDecimal windDirection;

    @FieldAnnotation(value = "雨量")
    private BigDecimal rainfall;

    @FieldAnnotation(value = "光照强度")
    private BigDecimal illIntensity;

    @FieldAnnotation(value = "二氧化碳")
    private BigDecimal co2Value;

    @FieldAnnotation(value = "pm2.5")
    private BigDecimal pm25Value;

    @FieldAnnotation(value = "pm10")
    private BigDecimal pm10Value;

    @FieldAnnotation(value = "土壤温度")
    private BigDecimal soilTemperature;

    @FieldAnnotation(value = "土壤湿度")
    private BigDecimal soilHumidity;

    @FieldAnnotation(value = "土壤PH")
    private BigDecimal soilPh;

    @FieldAnnotation(value = "土壤EC")
    private BigDecimal soilEc;

    @FieldAnnotation(value = "土壤盐分")
    private BigDecimal soilS;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date monitorTime;

    private Integer equipmentId;

    private Integer factoryId;

    private Equipment equipment;

    private BigDecimal lng;

    private BigDecimal lat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(BigDecimal airTemperature) {
        this.airTemperature = airTemperature;
    }

    public BigDecimal getAirHumidity() {
        return airHumidity;
    }

    public void setAirHumidity(BigDecimal airHumidity) {
        this.airHumidity = airHumidity;
    }

    public BigDecimal getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(BigDecimal airPressure) {
        this.airPressure = airPressure;
    }

    public BigDecimal getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(BigDecimal windSpeed) {
        this.windSpeed = windSpeed;
    }

    public BigDecimal getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(BigDecimal windDirection) {
        this.windDirection = windDirection;
    }

    public BigDecimal getRainfall() {
        return rainfall;
    }

    public void setRainfall(BigDecimal rainfall) {
        this.rainfall = rainfall;
    }

    public BigDecimal getIllIntensity() {
        return illIntensity;
    }

    public void setIllIntensity(BigDecimal illIntensity) {
        this.illIntensity = illIntensity;
    }

    public BigDecimal getCo2Value() {
        return co2Value;
    }

    public void setCo2Value(BigDecimal co2Value) {
        this.co2Value = co2Value;
    }

    public BigDecimal getPm25Value() {
        return pm25Value;
    }

    public void setPm25Value(BigDecimal pm25Value) {
        this.pm25Value = pm25Value;
    }

    public BigDecimal getPm10Value() {
        return pm10Value;
    }

    public void setPm10Value(BigDecimal pm10Value) {
        this.pm10Value = pm10Value;
    }

    public BigDecimal getSoilTemperature() {
        return soilTemperature;
    }

    public void setSoilTemperature(BigDecimal soilTemperature) {
        this.soilTemperature = soilTemperature;
    }

    public BigDecimal getSoilHumidity() {
        return soilHumidity;
    }

    public void setSoilHumidity(BigDecimal soilHumidity) {
        this.soilHumidity = soilHumidity;
    }

    public BigDecimal getSoilPh() {
        return soilPh;
    }

    public void setSoilPh(BigDecimal soilPh) {
        this.soilPh = soilPh;
    }

    public BigDecimal getSoilEc() {
        return soilEc;
    }

    public void setSoilEc(BigDecimal soilEc) {
        this.soilEc = soilEc;
    }

    public BigDecimal getSoilS() {
        return soilS;
    }

    public void setSoilS(BigDecimal soilS) {
        this.soilS = soilS;
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

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
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

    @Override
    public String toString() {
        return "EnvMonitor{" +
                "id=" + id +
                ", airTemperature=" + airTemperature +
                ", airHumidity=" + airHumidity +
                ", airPressure=" + airPressure +
                ", windSpeed=" + windSpeed +
                ", windDirection=" + windDirection +
                ", rainfall=" + rainfall +
                ", illIntensity=" + illIntensity +
                ", co2Value=" + co2Value +
                ", pm25Value=" + pm25Value +
                ", pm10Value=" + pm10Value +
                ", soilTemperature=" + soilTemperature +
                ", soilHumidity=" + soilHumidity +
                ", soilPh=" + soilPh +
                ", soilEc=" + soilEc +
                ", soilS=" + soilS +
                ", monitorTime=" + monitorTime +
                ", equipmentId=" + equipmentId +
                ", factoryId=" + factoryId +
                '}';
    }
}
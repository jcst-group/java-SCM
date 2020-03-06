package com.nongxin.terminal.vo.app;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.envmonitor.WarnEnv;
import com.nongxin.terminal.entity.envmonitor.WarnRecord;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 手机App预警任务 返回正常采集数据 和 预警阈值
 */
public class AppNorEnvMonitor {

    private List<WarnRecord> warnRecordList;

    private Float airTemperature;

    private Float airHumidity;

    private Float airPressure;

    private Float windSpeed;

    private Float windDirection;

    private Float rainfall;

    private Float illIntensity;

    private Float co2Value;

    private Float pm25Value;

    private Float pm10Value;

    private Float soilTemperature;

    private Float soilHumidity;

    private Float soilPh;

    private Float soilEc;

    private Float soilS;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date monitorTime;

    private Integer equipmentId;

    private Integer factoryId;

    private WarnEnv warnEnv;

    public List<WarnRecord> getWarnRecordList() {
        return warnRecordList;
    }

    public void setWarnRecordList(List<WarnRecord> warnRecordList) {
        this.warnRecordList = warnRecordList;
    }

    public Float getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(Float airTemperature) {
        this.airTemperature = airTemperature;
    }

    public Float getAirHumidity() {
        return airHumidity;
    }

    public void setAirHumidity(Float airHumidity) {
        this.airHumidity = airHumidity;
    }

    public Float getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(Float airPressure) {
        this.airPressure = airPressure;
    }

    public Float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Float getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Float windDirection) {
        this.windDirection = windDirection;
    }

    public Float getRainfall() {
        return rainfall;
    }

    public void setRainfall(Float rainfall) {
        this.rainfall = rainfall;
    }

    public Float getIllIntensity() {
        return illIntensity;
    }

    public void setIllIntensity(Float illIntensity) {
        this.illIntensity = illIntensity;
    }

    public Float getCo2Value() {
        return co2Value;
    }

    public void setCo2Value(Float co2Value) {
        this.co2Value = co2Value;
    }

    public Float getPm25Value() {
        return pm25Value;
    }

    public void setPm25Value(Float pm25Value) {
        this.pm25Value = pm25Value;
    }

    public Float getPm10Value() {
        return pm10Value;
    }

    public void setPm10Value(Float pm10Value) {
        this.pm10Value = pm10Value;
    }

    public Float getSoilTemperature() {
        return soilTemperature;
    }

    public void setSoilTemperature(Float soilTemperature) {
        this.soilTemperature = soilTemperature;
    }

    public Float getSoilHumidity() {
        return soilHumidity;
    }

    public void setSoilHumidity(Float soilHumidity) {
        this.soilHumidity = soilHumidity;
    }

    public Float getSoilPh() {
        return soilPh;
    }

    public void setSoilPh(Float soilPh) {
        this.soilPh = soilPh;
    }

    public Float getSoilEc() {
        return soilEc;
    }

    public void setSoilEc(Float soilEc) {
        this.soilEc = soilEc;
    }

    public Float getSoilS() {
        return soilS;
    }

    public void setSoilS(Float soilS) {
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

    public WarnEnv getWarnEnv() {
        return warnEnv;
    }

    public void setWarnEnv(WarnEnv warnEnv) {
        this.warnEnv = warnEnv;
    }
}

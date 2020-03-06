package com.nongxin.terminal.entity.crop;

import java.math.BigDecimal;

public class BatchEnvironment {
    private Integer id;

    private Integer batchId;

    private String temperatureDiffAvg;

    private BigDecimal temperatureAvg;

    private BigDecimal airHumidityAvg;

    private BigDecimal airPressureAvg;

    private BigDecimal windSpeedAvg;

    private BigDecimal rainfallTotal;

    private BigDecimal illTimeAvg;

    private BigDecimal illIntensityAvg;

    private BigDecimal co2ValueAvg;

    private BigDecimal pm25ValueAvg;

    private BigDecimal soilTemperatureAvg;

    private BigDecimal soilHumidityAvg;

    private BigDecimal soilPhAvg;

    private BigDecimal illTimeTotal;

    private String soilType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getTemperatureDiffAvg() {
        return temperatureDiffAvg;
    }

    public void setTemperatureDiffAvg(String temperatureDiffAvg) {
        this.temperatureDiffAvg = temperatureDiffAvg == null ? null : temperatureDiffAvg.trim();
    }

    public BigDecimal getTemperatureAvg() {
        return temperatureAvg;
    }

    public void setTemperatureAvg(BigDecimal temperatureAvg) {
        this.temperatureAvg = temperatureAvg;
    }

    public BigDecimal getAirHumidityAvg() {
        return airHumidityAvg;
    }

    public void setAirHumidityAvg(BigDecimal airHumidityAvg) {
        this.airHumidityAvg = airHumidityAvg;
    }

    public BigDecimal getAirPressureAvg() {
        return airPressureAvg;
    }

    public void setAirPressureAvg(BigDecimal airPressureAvg) {
        this.airPressureAvg = airPressureAvg;
    }

    public BigDecimal getWindSpeedAvg() {
        return windSpeedAvg;
    }

    public void setWindSpeedAvg(BigDecimal windSpeedAvg) {
        this.windSpeedAvg = windSpeedAvg;
    }

    public BigDecimal getRainfallTotal() {
        return rainfallTotal;
    }

    public void setRainfallTotal(BigDecimal rainfallTotal) {
        this.rainfallTotal = rainfallTotal;
    }

    public BigDecimal getIllTimeAvg() {
        return illTimeAvg;
    }

    public void setIllTimeAvg(BigDecimal illTimeAvg) {
        this.illTimeAvg = illTimeAvg;
    }

    public BigDecimal getIllIntensityAvg() {
        return illIntensityAvg;
    }

    public void setIllIntensityAvg(BigDecimal illIntensityAvg) {
        this.illIntensityAvg = illIntensityAvg;
    }

    public BigDecimal getCo2ValueAvg() {
        return co2ValueAvg;
    }

    public void setCo2ValueAvg(BigDecimal co2ValueAvg) {
        this.co2ValueAvg = co2ValueAvg;
    }

    public BigDecimal getPm25ValueAvg() {
        return pm25ValueAvg;
    }

    public void setPm25ValueAvg(BigDecimal pm25ValueAvg) {
        this.pm25ValueAvg = pm25ValueAvg;
    }

    public BigDecimal getSoilTemperatureAvg() {
        return soilTemperatureAvg;
    }

    public void setSoilTemperatureAvg(BigDecimal soilTemperatureAvg) {
        this.soilTemperatureAvg = soilTemperatureAvg;
    }

    public BigDecimal getSoilHumidityAvg() {
        return soilHumidityAvg;
    }

    public void setSoilHumidityAvg(BigDecimal soilHumidityAvg) {
        this.soilHumidityAvg = soilHumidityAvg;
    }

    public BigDecimal getSoilPhAvg() {
        return soilPhAvg;
    }

    public void setSoilPhAvg(BigDecimal soilPhAvg) {
        this.soilPhAvg = soilPhAvg;
    }

    public BigDecimal getIllTimeTotal() {
        return illTimeTotal;
    }

    public void setIllTimeTotal(BigDecimal illTimeTotal) {
        this.illTimeTotal = illTimeTotal;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType == null ? null : soilType.trim();
    }
}
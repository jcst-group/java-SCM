package com.nongxin.terminal.entity.envmonitor;

import java.math.BigDecimal;
import java.util.List;

public class WarnEnv {
    private Integer id;

    private BigDecimal minairtemperature;

    private BigDecimal maxairtemperature;

    private BigDecimal minairhumidity;

    private BigDecimal maxairhumidity;

    private BigDecimal minsoiltemperature;

    private BigDecimal maxsoiltemperature;

    private BigDecimal minsoilhumidity;

    private BigDecimal maxsoilhumidity;

    private BigDecimal minsoilph;

    private BigDecimal maxsoilph;

    private BigDecimal minillIntensity;

    private BigDecimal maxillIntensity;

    private BigDecimal minrainfall = new BigDecimal(0);

    private BigDecimal maxrainfall;

    private BigDecimal minco2;

    private BigDecimal maxco2;

    private BigDecimal minpm25;

    private BigDecimal maxpm25;

    private BigDecimal minpm10;

    private BigDecimal maxpm10;

    private BigDecimal minwindspeed = new BigDecimal(0);

    private BigDecimal maxwindspeed;

    private BigDecimal minsoilec;

    private BigDecimal maxsoilec;

    private BigDecimal minsoils;

    private BigDecimal maxsoils;

    private Integer equipmentId;

    private Integer status;

    private List<Equipment> equipmentIdList;

    private Equipment equipment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMinairtemperature() {
        return minairtemperature;
    }

    public void setMinairtemperature(BigDecimal minairtemperature) {
        this.minairtemperature = minairtemperature;
    }

    public BigDecimal getMaxairtemperature() {
        return maxairtemperature;
    }

    public void setMaxairtemperature(BigDecimal maxairtemperature) {
        this.maxairtemperature = maxairtemperature;
    }

    public BigDecimal getMinairhumidity() {
        return minairhumidity;
    }

    public void setMinairhumidity(BigDecimal minairhumidity) {
        this.minairhumidity = minairhumidity;
    }

    public BigDecimal getMaxairhumidity() {
        return maxairhumidity;
    }

    public void setMaxairhumidity(BigDecimal maxairhumidity) {
        this.maxairhumidity = maxairhumidity;
    }

    public BigDecimal getMinsoiltemperature() {
        return minsoiltemperature;
    }

    public void setMinsoiltemperature(BigDecimal minsoiltemperature) {
        this.minsoiltemperature = minsoiltemperature;
    }

    public BigDecimal getMaxsoiltemperature() {
        return maxsoiltemperature;
    }

    public void setMaxsoiltemperature(BigDecimal maxsoiltemperature) {
        this.maxsoiltemperature = maxsoiltemperature;
    }

    public BigDecimal getMinsoilhumidity() {
        return minsoilhumidity;
    }

    public void setMinsoilhumidity(BigDecimal minsoilhumidity) {
        this.minsoilhumidity = minsoilhumidity;
    }

    public BigDecimal getMaxsoilhumidity() {
        return maxsoilhumidity;
    }

    public void setMaxsoilhumidity(BigDecimal maxsoilhumidity) {
        this.maxsoilhumidity = maxsoilhumidity;
    }

    public BigDecimal getMinsoilph() {
        return minsoilph;
    }

    public void setMinsoilph(BigDecimal minsoilph) {
        this.minsoilph = minsoilph;
    }

    public BigDecimal getMaxsoilph() {
        return maxsoilph;
    }

    public void setMaxsoilph(BigDecimal maxsoilph) {
        this.maxsoilph = maxsoilph;
    }

    public BigDecimal getMinillIntensity() {
        return minillIntensity;
    }

    public void setMinillIntensity(BigDecimal minillIntensity) {
        this.minillIntensity = minillIntensity;
    }

    public BigDecimal getMaxillIntensity() {
        return maxillIntensity;
    }

    public void setMaxillIntensity(BigDecimal maxillIntensity) {
        this.maxillIntensity = maxillIntensity;
    }

    public BigDecimal getMinrainfall() {
        return minrainfall;
    }

    public void setMinrainfall(BigDecimal minrainfall) {
        this.minrainfall = minrainfall;
    }

    public BigDecimal getMaxrainfall() {
        return maxrainfall;
    }

    public void setMaxrainfall(BigDecimal maxrainfall) {
        this.maxrainfall = maxrainfall;
    }

    public BigDecimal getMinco2() {
        return minco2;
    }

    public void setMinco2(BigDecimal minco2) {
        this.minco2 = minco2;
    }

    public BigDecimal getMaxco2() {
        return maxco2;
    }

    public void setMaxco2(BigDecimal maxco2) {
        this.maxco2 = maxco2;
    }

    public BigDecimal getMinpm25() {
        return minpm25;
    }

    public void setMinpm25(BigDecimal minpm25) {
        this.minpm25 = minpm25;
    }

    public BigDecimal getMaxpm25() {
        return maxpm25;
    }

    public void setMaxpm25(BigDecimal maxpm25) {
        this.maxpm25 = maxpm25;
    }

    public BigDecimal getMinpm10() {
        return minpm10;
    }

    public void setMinpm10(BigDecimal minpm10) {
        this.minpm10 = minpm10;
    }

    public BigDecimal getMaxpm10() {
        return maxpm10;
    }

    public void setMaxpm10(BigDecimal maxpm10) {
        this.maxpm10 = maxpm10;
    }

    public BigDecimal getMinwindspeed() {
        return minwindspeed;
    }

    public void setMinwindspeed(BigDecimal minwindspeed) {
        this.minwindspeed = minwindspeed;
    }

    public BigDecimal getMaxwindspeed() {
        return maxwindspeed;
    }

    public void setMaxwindspeed(BigDecimal maxwindspeed) {
        this.maxwindspeed = maxwindspeed;
    }

    public BigDecimal getMinsoilec() {
        return minsoilec;
    }

    public void setMinsoilec(BigDecimal minsoilec) {
        this.minsoilec = minsoilec;
    }

    public BigDecimal getMaxsoilec() {
        return maxsoilec;
    }

    public void setMaxsoilec(BigDecimal maxsoilec) {
        this.maxsoilec = maxsoilec;
    }

    public BigDecimal getMinsoils() {
        return minsoils;
    }

    public void setMinsoils(BigDecimal minsoils) {
        this.minsoils = minsoils;
    }

    public BigDecimal getMaxsoils() {
        return maxsoils;
    }

    public void setMaxsoils(BigDecimal maxsoils) {
        this.maxsoils = maxsoils;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Equipment> getEquipmentIdList() {
        return equipmentIdList;
    }

    public void setEquipmentIdList(List<Equipment> equipmentIdList) {
        this.equipmentIdList = equipmentIdList;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
package com.nongxin.terminal.entity.address;

import com.nongxin.terminal.util.enumUtil.common.AddressRelateTypeEnum;

public class Address {
    private Integer relateId;

    /*private String relateType;*/
    private AddressRelateTypeEnum relateType;

    private String province;

    private String city;

    private String area;

    private String street;

    private String address;

    private String provinceCode;

    private String cityCode;

    private String areaCode;

    private String steetCode;

    public Integer getRelateId() {
        return relateId;
    }

    public void setRelateId(Integer relateId) {
        this.relateId = relateId;
    }

    public AddressRelateTypeEnum getRelateType() {
        return relateType;
    }

    public void setRelateType(AddressRelateTypeEnum relateType) {
        this.relateType = relateType;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getSteetCode() {
        return steetCode;
    }

    public void setSteetCode(String steetCode) {
        this.steetCode = steetCode == null ? null : steetCode.trim();
    }
}
package com.nongxin.terminal.vo.traceability;


public class IpVo {

    private Integer code = 0 ;

    private String ip;

    private String city;

    private String cityId;

    private String region;

    private String regionId;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    @Override
    public String toString() {
        return "IpVo{" +
                "code=" + code +
                ", ip='" + ip + '\'' +
                ", city='" + city + '\'' +
                ", cityId='" + cityId + '\'' +
                ", region='" + region + '\'' +
                ", regionId='" + regionId + '\'' +
                '}';
    }
}

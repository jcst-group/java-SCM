package com.nongxin.terminal.entity.company;

public class Fertilizers {
    private Integer id;

    private Double organicFat;

    private Double ordinaryFat;

    private String year;

    private Integer companyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getOrganicFat() {
        return organicFat;
    }

    public void setOrganicFat(Double organicFat) {
        this.organicFat = organicFat;
    }

    public Double getOrdinaryFat() {
        return ordinaryFat;
    }

    public void setOrdinaryFat(Double ordinaryFat) {
        this.ordinaryFat = ordinaryFat;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
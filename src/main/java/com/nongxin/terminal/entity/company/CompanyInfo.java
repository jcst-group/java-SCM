package com.nongxin.terminal.entity.company;

import com.nongxin.terminal.entity.file.FileInfo;
import com.nongxin.terminal.entity.file.PictureInfo;

import java.util.List;

public class CompanyInfo {
    private Integer id;

    private String companyName;

    private String companyAddress;

    private String platCrop;

    private Double manageArea;

    private Integer manageCooperation;

    private String companyProfile;

    private String shopUrl;

    private List<PictureInfo> managePicture;

    private List<PictureInfo> honorPicture;

    private List<PictureInfo> companyPicture;

    private FileInfo videoCompany;

    private FileInfo videoProduct;

    private List<Fertilizers> fertilizersList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public String getPlatCrop() {
        return platCrop;
    }

    public void setPlatCrop(String platCrop) {
        this.platCrop = platCrop == null ? null : platCrop.trim();
    }

    public Double getManageArea() {
        return manageArea;
    }

    public void setManageArea(Double manageArea) {
        this.manageArea = manageArea;
    }

    public Integer getManageCooperation() {
        return manageCooperation;
    }

    public void setManageCooperation(Integer manageCooperation) {
        this.manageCooperation = manageCooperation;
    }

    public String getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(String companyProfile) {
        this.companyProfile = companyProfile == null ? null : companyProfile.trim();
    }

    public List<PictureInfo> getManagePicture() {
        return managePicture;
    }

    public void setManagePicture(List<PictureInfo> managePicture) {
        this.managePicture = managePicture;
    }

    public List<PictureInfo> getHonorPicture() {
        return honorPicture;
    }

    public List<PictureInfo> getCompanyPicture() {
        return companyPicture;
    }

    public void setCompanyPicture(List<PictureInfo> companyPicture) {
        this.companyPicture = companyPicture;
    }

    public void setHonorPicture(List<PictureInfo> honorPicture) {
        this.honorPicture = honorPicture;
    }

    public FileInfo getVideoCompany() {
        return videoCompany;
    }

    public void setVideoCompany(FileInfo videoCompany) {
        this.videoCompany = videoCompany;
    }

    public FileInfo getVideoProduct() {
        return videoProduct;
    }

    public void setVideoProduct(FileInfo videoProduct) {
        this.videoProduct = videoProduct;
    }

    public List<Fertilizers> getFertilizersList() {
        return fertilizersList;
    }

    public void setFertilizersList(List<Fertilizers> fertilizersList) {
        this.fertilizersList = fertilizersList;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }
}
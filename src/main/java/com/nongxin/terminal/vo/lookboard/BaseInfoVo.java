package com.nongxin.terminal.vo.lookboard;

import com.nongxin.terminal.entity.address.Address;
import com.nongxin.terminal.entity.base.Lot;
import com.nongxin.terminal.entity.crop.CropBatch;
import com.nongxin.terminal.entity.envmonitor.VideoChannel;
import com.nongxin.terminal.entity.envmonitor.VideoEquipment;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.util.enumUtil.base.BaseTypeEnum;
import com.nongxin.terminal.util.enumUtil.base.CategoryEnum;
import com.nongxin.terminal.vo.base.BaseTestingVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 看板基地信息 2019-08-30
 */
public class BaseInfoVo {
    private Integer id;

    private String baseName;

    private CategoryEnum category;

    private BigDecimal acreage;

    private BaseTypeEnum baseType;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private List<BaseUserVo> baseUser;
    //基地环境检测
    private List<BaseTestingVo> baseTestingVoList;

    private PictureInfo basePic;

    private PictureInfo soilPic;

    private PictureInfo airPic;

    private PictureInfo waterPic;

    private Address address;

    private List<Lot> lotList;

    private List<CropBatchVo> cropBatchList;

    private List<VideoEquipment> videoEquipmentList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public void setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
    }

    public BaseTypeEnum getBaseType() {
        return baseType;
    }

    public void setBaseType(BaseTypeEnum baseType) {
        this.baseType = baseType;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public List<BaseUserVo> getBaseUser() {
        return baseUser;
    }

    public void setBaseUser(List<BaseUserVo> baseUser) {
        this.baseUser = baseUser;
    }

    public List<BaseTestingVo> getBaseTestingVoList() {
        return baseTestingVoList;
    }

    public void setBaseTestingVoList(List<BaseTestingVo> baseTestingVoList) {
        this.baseTestingVoList = baseTestingVoList;
    }

    public PictureInfo getBasePic() {
        return basePic;
    }

    public void setBasePic(PictureInfo basePic) {
        this.basePic = basePic;
    }

    public PictureInfo getSoilPic() {
        return soilPic;
    }

    public void setSoilPic(PictureInfo soilPic) {
        this.soilPic = soilPic;
    }

    public PictureInfo getAirPic() {
        return airPic;
    }

    public void setAirPic(PictureInfo airPic) {
        this.airPic = airPic;
    }

    public PictureInfo getWaterPic() {
        return waterPic;
    }

    public void setWaterPic(PictureInfo waterPic) {
        this.waterPic = waterPic;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Lot> getLotList() {
        return lotList;
    }

    public void setLotList(List<Lot> lotList) {
        this.lotList = lotList;
    }

    public List<CropBatchVo> getCropBatchList() {
        return cropBatchList;
    }

    public void setCropBatchList(List<CropBatchVo> cropBatchList) {
        this.cropBatchList = cropBatchList;
    }

    public List<VideoEquipment> getVideoEquipmentList() {
        return videoEquipmentList;
    }

    public void setVideoEquipmentList(List<VideoEquipment> videoEquipmentList) {
        this.videoEquipmentList = videoEquipmentList;
    }
}



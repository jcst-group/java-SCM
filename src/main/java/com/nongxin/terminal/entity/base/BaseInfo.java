package com.nongxin.terminal.entity.base;

import com.nongxin.terminal.entity.address.Address;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.util.enumUtil.base.BaseTypeEnum;
import com.nongxin.terminal.util.enumUtil.base.CategoryEnum;
import com.nongxin.terminal.util.enumUtil.base.SoilTypeEnum;
import com.nongxin.terminal.vo.base.BaseTestingVo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class BaseInfo {
    private Integer id;

    private String baseCode;

    @NotEmpty(message = "基地名称不能为空")
    private String baseName;

    private String areaCode;

    @NotNull(message = "范畴不能为空")
    private CategoryEnum category;

    @NotNull(message = "面积不能为空")
    private BigDecimal acreage;

    @NotNull(message = "基地类型不能为空")
    private BaseTypeEnum baseType;

    @NotEmpty(message = "前茬茬口不能为空")
    private String frontStubble;

    @NotNull(message = "经度不能为空")
    private BigDecimal longitude;

    @NotNull(message = "纬度不能为空")
    private BigDecimal latitude;

    private BigDecimal altitude;

    private String survey;

    private SoilTypeEnum soilType;

    private short position;

    private BigDecimal slope;

    @NotNull(message = "基地环境检测不能为空")
    private List<BaseTestingVo> baseTestingVoList;

    //private List<PictureInfo> pictureInfoList;

    @NotNull(message = "基地图片不能为空")
    private PictureInfo basePic;

    @NotNull(message = "土壤检测图片不能为空")
    private PictureInfo soilPic;

    @NotNull(message = "大气检测图片不能为空")
    private PictureInfo airPic;

    @NotNull(message = "水源检测图片不能为空")
    private PictureInfo waterPic;

    @NotNull(message = "基地地址不能为空")
    private Address address;

    private List<Lot> lotList;

    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Lot> getLotList() {
        return lotList;
    }

    public void setLotList(List<Lot> lotList) {
        this.lotList = lotList;
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

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public BaseTypeEnum getBaseType() {
        return baseType;
    }

    public void setBaseType(BaseTypeEnum baseType) {
        this.baseType = baseType;
    }

    public SoilTypeEnum getSoilType() {
        return soilType;
    }

    public void setSoilType(SoilTypeEnum soilType) {
        this.soilType = soilType;
    }

    public List<BaseTestingVo> getBaseTestingVoList() {
        return baseTestingVoList;
    }

    public void setBaseTestingVoList(List<BaseTestingVo> baseTestingVoList) {
        this.baseTestingVoList = baseTestingVoList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode == null ? null : baseCode.trim();
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName == null ? null : baseName.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public void setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
    }

    public String getFrontStubble() {
        return frontStubble;
    }

    public void setFrontStubble(String frontStubble) {
        this.frontStubble = frontStubble == null ? null : frontStubble.trim();
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

    public BigDecimal getAltitude() {
        return altitude;
    }

    public void setAltitude(BigDecimal altitude) {
        this.altitude = altitude;
    }

    public String getSurvey() {
        return survey;
    }

    public void setSurvey(String survey) {
        this.survey = survey == null ? null : survey.trim();
    }

    public short getPosition() {
        return position;
    }

    public void setPosition(short position) {
        this.position = position;
    }

    public BigDecimal getSlope() {
        return slope;
    }

    public void setSlope(BigDecimal slope) {
        this.slope = slope;
    }
}
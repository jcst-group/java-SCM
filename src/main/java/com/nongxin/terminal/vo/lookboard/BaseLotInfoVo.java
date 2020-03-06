package com.nongxin.terminal.vo.lookboard;

import com.nongxin.terminal.entity.address.Address;
import com.nongxin.terminal.util.enumUtil.base.BaseTypeEnum;
import java.util.List;

/**
 * 看板点击地块后的基地信息
 */
public class BaseLotInfoVo {

    private Integer id;

    private String baseName;

    private BaseTypeEnum baseType;

    private String street;

    private List<CropBatchVo> cropBatchList;

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

    public BaseTypeEnum getBaseType() {
        return baseType;
    }

    public void setBaseType(BaseTypeEnum baseType) {
        this.baseType = baseType;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public List<CropBatchVo> getCropBatchList() {
        return cropBatchList;
    }

    public void setCropBatchList(List<CropBatchVo> cropBatchList) {
        this.cropBatchList = cropBatchList;
    }
}

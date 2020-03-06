package com.nongxin.terminal.entity.product;

import com.nongxin.terminal.util.enumUtil.products.ProductsTypeEnum;

import java.util.List;

public class Products {
    private Integer id;

    private Integer cropId;

    private String productsName;

    private ProductsTypeEnum productsType;

    private String describe;

    private List<Level> levelList;

    public List<Level> getLevelList() {
        return levelList;
    }

    public void setLevelList(List<Level> levelList) {
        this.levelList = levelList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public String getProductsName() {
        return productsName;
    }

    public void setProductsName(String productsName) {
        this.productsName = productsName == null ? null : productsName.trim();
    }

    public ProductsTypeEnum getProductsType() {
        return productsType;
    }

    public void setProductsType(ProductsTypeEnum productsType) {
        this.productsType = productsType;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}
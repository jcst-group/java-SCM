package com.nongxin.terminal.entity.crop;

public class CropProduct {
    private Integer id;

    private String productName;

    private String level;

    private String describe;

    private Integer harvestedId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public Integer getHarvestedId() {
        return harvestedId;
    }

    public void setHarvestedId(Integer harvestedId) {
        this.harvestedId = harvestedId;
    }
}
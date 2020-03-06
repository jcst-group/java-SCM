package com.nongxin.terminal.entity.market;

import java.math.BigDecimal;

public class MarketGood {
    private Integer id;

    private String picSrc;

    private String goodName;

    private BigDecimal goodPrice;

    private String specis;

    private String fromSource;

    private String goodLevel;

    private String comment;

    private BigDecimal saveOne;

    private BigDecimal saveTwo;

    private String charOne;

    private String charTwo;

    private Integer idOne;

    private Integer idTwo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicSrc() {
        return picSrc;
    }

    public void setPicSrc(String picSrc) {
        this.picSrc = picSrc == null ? null : picSrc.trim();
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getSpecis() {
        return specis;
    }

    public void setSpecis(String specis) {
        this.specis = specis == null ? null : specis.trim();
    }

    public String getFromSource() {
        return fromSource;
    }

    public void setFromSource(String fromSource) {
        this.fromSource = fromSource == null ? null : fromSource.trim();
    }

    public String getGoodLevel() {
        return goodLevel;
    }

    public void setGoodLevel(String goodLevel) {
        this.goodLevel = goodLevel == null ? null : goodLevel.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public BigDecimal getSaveOne() {
        return saveOne;
    }

    public void setSaveOne(BigDecimal saveOne) {
        this.saveOne = saveOne;
    }

    public BigDecimal getSaveTwo() {
        return saveTwo;
    }

    public void setSaveTwo(BigDecimal saveTwo) {
        this.saveTwo = saveTwo;
    }

    public String getCharOne() {
        return charOne;
    }

    public void setCharOne(String charOne) {
        this.charOne = charOne == null ? null : charOne.trim();
    }

    public String getCharTwo() {
        return charTwo;
    }

    public void setCharTwo(String charTwo) {
        this.charTwo = charTwo == null ? null : charTwo.trim();
    }

    public Integer getIdOne() {
        return idOne;
    }

    public void setIdOne(Integer idOne) {
        this.idOne = idOne;
    }

    public Integer getIdTwo() {
        return idTwo;
    }

    public void setIdTwo(Integer idTwo) {
        this.idTwo = idTwo;
    }
}
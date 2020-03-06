package com.nongxin.terminal.entity.market;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MarketOrder {

    private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    private Integer id;

    private String customerName;

    private Date contractDate;

    private String contractCode;

    private Date sendDate;

    private String specis;

    private Integer saleAmount;

    private BigDecimal salePrice;

    private BigDecimal saleSum;

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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getContractDate() {
        String formatdate=df.format(contractDate);
        return formatdate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode == null ? null : contractCode.trim();
    }

    public String getSendDate() {
        String formatdate=df.format(sendDate);
        return formatdate;

    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getSpecis() {
        return specis;
    }

    public void setSpecis(String specis) {
        this.specis = specis == null ? null : specis.trim();
    }

    public Integer getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(Integer saleAmount) {
        this.saleAmount = saleAmount;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getSaleSum() {
        return saleSum;
    }

    public void setSaleSum(BigDecimal saleSum) {
        this.saleSum = saleSum;
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
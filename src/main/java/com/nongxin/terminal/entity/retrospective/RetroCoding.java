package com.nongxin.terminal.entity.retrospective;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class RetroCoding {
    private Integer id;

    private String retroCode;

    private Date codingTime;

    private Integer codeInfoId;

    private Integer serialNum;

    private RetroCodeInfo retroCodeInfo;

    @NotNull(message = "追溯码数量不能为空")
    private Integer codeQuantity;

    @NotNull(message = "剩余产量不能为空")
    private BigDecimal residualOutput;

    public BigDecimal getResidualOutput() {
        return residualOutput;
    }

    public void setResidualOutput(BigDecimal residualOutput) {
        this.residualOutput = residualOutput;
    }

    public Integer getCodeQuantity() {
        return codeQuantity;
    }

    public void setCodeQuantity(Integer codeQuantity) {
        this.codeQuantity = codeQuantity;
    }

    public RetroCodeInfo getRetroCodeInfo() {
        return retroCodeInfo;
    }

    public void setRetroCodeInfo(RetroCodeInfo retroCodeInfo) {
        this.retroCodeInfo = retroCodeInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRetroCode() {
        return retroCode;
    }

    public void setRetroCode(String retroCode) {
        this.retroCode = retroCode == null ? null : retroCode.trim();
    }

    public Date getCodingTime() {
        return codingTime;
    }

    public void setCodingTime(Date codingTime) {
        this.codingTime = codingTime;
    }

    public Integer getCodeInfoId() {
        return codeInfoId;
    }

    public void setCodeInfoId(Integer codeInfoId) {
        this.codeInfoId = codeInfoId;
    }

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }
}
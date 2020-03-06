package com.nongxin.terminal.vo.app;

import java.math.BigDecimal;

/**
 * 对照阈值Vo
 */
public class ContrastVo {

    private BigDecimal lowValue;

    private BigDecimal highValue;

    public BigDecimal getLowValue() {
        return lowValue;
    }

    public void setLowValue(BigDecimal lowValue) {
        this.lowValue = lowValue;
    }

    public BigDecimal getHighValue() {
        return highValue;
    }

    public void setHighValue(BigDecimal highValue) {
        this.highValue = highValue;
    }
}

package com.nongxin.terminal.entity.market;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class MarketPriceVo {
    private Date priceDate;
    private BigDecimal priceValue;

    public MarketPriceVo() {
    }

    public Date getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }

    public BigDecimal getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(BigDecimal priceValue) {
        this.priceValue = priceValue;
    }
}

package com.nongxin.terminal.vo.zishan;

import java.math.BigDecimal;

public class RainSpecialVo {

    private String date;

    private BigDecimal value;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        if(value!=null){
            this.value = value.setScale(2,5);
        }else{
            this.value = value;
        }

    }
}

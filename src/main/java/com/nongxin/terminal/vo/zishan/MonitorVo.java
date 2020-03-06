package com.nongxin.terminal.vo.zishan;

import java.math.BigDecimal;
import java.util.Date;

public class MonitorVo {

    private Date createdAt;

    private BigDecimal value;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

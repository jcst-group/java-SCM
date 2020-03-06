package com.nongxin.terminal.vo.lookboard;

import java.math.BigDecimal;

public class BaseTestingAvg {

    private Integer id;  //检测项id

    private String item;  //检测项

    private BigDecimal value; // 检测值

    private BigDecimal max_value; // 检测标准最大值


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getMax_value() {
        return max_value;
    }

    public void setMax_value(BigDecimal max_value) {
        this.max_value = max_value;
    }
}

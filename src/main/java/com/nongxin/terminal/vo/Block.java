package com.nongxin.terminal.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author clover
 * @date 2019/5/6
 * @description 地块信息的存储
 */
public class Block {

    private BigDecimal area;

    private List<LongAndLatitude> list;


    public Block() {
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public List<LongAndLatitude> getList() {
        return list;
    }

    public void setList(List<LongAndLatitude> list) {
        this.list = list;
    }
}

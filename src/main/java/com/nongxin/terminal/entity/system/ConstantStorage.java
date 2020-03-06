package com.nongxin.terminal.entity.system;

import com.nongxin.terminal.util.enumUtil.system.ConstantTypeEnum;

public class ConstantStorage {
    private Integer id;

    private ConstantTypeEnum type;

    private String constant;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ConstantTypeEnum getType() {
        return type;
    }

    public void setType(ConstantTypeEnum type) {
        this.type = type;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant == null ? null : constant.trim();
    }
}
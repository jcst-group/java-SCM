package com.nongxin.terminal.util.enumUtil.common;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CodeEnum implements IEnum<String> {

    BASE("JD","基地"),
    LOT("DK","地块"),
    CROP("ZW","作物"),
    SEED("ZZ","种子"),
    RECOVERYBATCH("CS","采收批次"),
    InitPro("CJG","初加工批次"),
    PROTRACEABILITY("CP","产品"),
    RETROCODING("ZLZS","唯一码"),
    IS("IS","保险码"),
    LOAN("LOAN","贷款码"),
    DETECT("DETECT","检测订单"),
    MEMBER("MEMBER","合作社成员");

    private String prefix;
    private String name;

    CodeEnum(String prefix,String name) {
        this.prefix = prefix;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return this.prefix;
    }
}

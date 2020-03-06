package com.nongxin.terminal.util.enumUtil.retrospective;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RetroUnitEnum implements BaseEnum<RetroUnitEnum, Short>, IEnum<Short> {

    KG_BAG(new Short("1"),"KG_BAG","kg/袋",1),
    G_BAG(new Short("2"),"G_BAG","g/袋",0.001);

    private Short value;
    private String code;
    private String displayName;
    //以kg为基数
    private double radix;

    RetroUnitEnum(Short value, String code, String displayName, double radix) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
        this.radix = radix;
    }

    public static RetroUnitEnum getByValue(Short value){
        RetroUnitEnum baseTypeEnums[] = RetroUnitEnum.values();
        for(RetroUnitEnum baseTypeEnum : baseTypeEnums){
            if(baseTypeEnum.getValue().equals(value)){
                return baseTypeEnum;
            }
        }
        return null;
    }

    public double getRadix() {
        return radix;
    }

    public Short getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }

    public String getDisplayName() {
        return displayName;
    }

}

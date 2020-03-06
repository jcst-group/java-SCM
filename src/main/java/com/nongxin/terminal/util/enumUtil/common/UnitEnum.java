package com.nongxin.terminal.util.enumUtil.common;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UnitEnum implements BaseEnum<UnitEnum, Short>, IEnum<Short> {

    KG(new Short("1"),"KG","千克",1),
    G(new Short("2"),"G","克",0.001);

    private Short value;
    private String code;
    private String displayName;
    //以kg为基数
    private double radix;

    UnitEnum(Short value, String code, String displayName, double radix) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
        this.radix = radix;
    }

    public static UnitEnum getByValue(Short value){
        UnitEnum addressRelateTypeEnums[] = UnitEnum.values();
        for(UnitEnum addressRelateTypeEnum : addressRelateTypeEnums){
            if(addressRelateTypeEnum.getValue().equals(value)){
                return addressRelateTypeEnum;
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

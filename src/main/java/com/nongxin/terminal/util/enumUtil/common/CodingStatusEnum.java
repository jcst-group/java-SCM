package com.nongxin.terminal.util.enumUtil.common;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CodingStatusEnum implements BaseEnum<CodingStatusEnum, Short>, IEnum<Short> {

    UNCODED(new Short("1"),"UNCODED","未打码"),
    CODED(new Short("2"),"CODED","已打码");

    private Short value;
    private String code;
    private String displayName;

    CodingStatusEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static CodingStatusEnum getByValue(Short value){
        CodingStatusEnum addressRelateTypeEnums[] = CodingStatusEnum.values();
        for(CodingStatusEnum addressRelateTypeEnum : addressRelateTypeEnums){
            if(addressRelateTypeEnum.getValue().equals(value)){
                return addressRelateTypeEnum;
            }
        }
        return null;
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

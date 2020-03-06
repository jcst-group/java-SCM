package com.nongxin.terminal.util.enumUtil.seed;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SelfSpeciesEnum implements BaseEnum<SelfSpeciesEnum, Short>, IEnum<Short> {

    YES(new Short("1"),"YES","是"),
    NO(new Short("2"),"NO","否");

    private Short value;
    private String code;
    private String displayName;

    SelfSpeciesEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static SelfSpeciesEnum getByValue(Short value){
        SelfSpeciesEnum baseTypeEnums[] = SelfSpeciesEnum.values();
        for(SelfSpeciesEnum baseTypeEnum : baseTypeEnums){
            if(baseTypeEnum.getValue().equals(value)){
                return baseTypeEnum;
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

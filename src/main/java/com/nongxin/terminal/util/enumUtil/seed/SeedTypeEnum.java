package com.nongxin.terminal.util.enumUtil.seed;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SeedTypeEnum implements BaseEnum<SeedTypeEnum, Short>, IEnum<Short> {

    SEED(new Short("1"),"SEED","种子"),
    SEEDLING(new Short("2"),"SEEDLING","种苗"),
    ROOT_TUBER(new Short("3"),"ROOT_TUBER","块根"),
    REAL_SEEDLING(new Short("4"),"REAL_SEEDLING","实生苗"),
    CULTURE_SEEDLING(new Short("5"),"CULTURE_SEEDLING","组培苗");

    private Short value;
    private String code;
    private String displayName;

    SeedTypeEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static SeedTypeEnum getByValue(Short value){
        SeedTypeEnum baseTypeEnums[] = SeedTypeEnum.values();
        for(SeedTypeEnum baseTypeEnum : baseTypeEnums){
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

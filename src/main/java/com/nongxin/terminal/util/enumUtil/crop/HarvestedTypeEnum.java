package com.nongxin.terminal.util.enumUtil.crop;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum HarvestedTypeEnum implements BaseEnum<HarvestedTypeEnum, Short>, IEnum<Short> {

    MAIN_HARVEST(new Short("1"),"MAIN_HARVEST","主采收物"),
    VICE_HARVEST(new Short("2"),"VICE_HARVEST","副采收物"),
    SEEDLING(new Short("3"),"SEEDLING","种苗");

    private Short value;
    private String code;
    private String displayName;

    HarvestedTypeEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static HarvestedTypeEnum getByValue(Short value){
        HarvestedTypeEnum categoryEnums[] = HarvestedTypeEnum.values();
        for(HarvestedTypeEnum categoryEnum : categoryEnums){
            if(categoryEnum.getValue().equals(value)){
                return categoryEnum;
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

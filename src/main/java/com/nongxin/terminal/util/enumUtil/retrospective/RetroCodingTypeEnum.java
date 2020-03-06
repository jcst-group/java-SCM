package com.nongxin.terminal.util.enumUtil.retrospective;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RetroCodingTypeEnum implements BaseEnum<RetroCodingTypeEnum, Short>, IEnum<Short> {

    RECO_BATCH(new Short("1"),"RECO_BATCH","采收"),
    INIT_BATCH(new Short("2"),"INIT_BATCH","初加工");

    private Short value;
    private String code;
    private String displayName;

    RetroCodingTypeEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static RetroCodingTypeEnum getByValue(Short value){
        RetroCodingTypeEnum baseTypeEnums[] = RetroCodingTypeEnum.values();
        for(RetroCodingTypeEnum baseTypeEnum : baseTypeEnums){
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

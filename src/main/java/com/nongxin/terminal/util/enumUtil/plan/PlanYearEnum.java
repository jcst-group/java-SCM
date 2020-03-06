package com.nongxin.terminal.util.enumUtil.plan;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PlanYearEnum implements BaseEnum<PlanYearEnum, Short>, IEnum<Short> {

    ONE(new Short("1"),"ONE","第一年"),
    TWO(new Short("2"),"TWO","第二年"),
    THREE(new Short("3"),"THREE","第三年"),
    FOUR(new Short("4"),"FOUR","第四年"),
    FIVE(new Short("5"),"FIVE","第五年"),
    SIX(new Short("6"),"SIX","第六年"),
    SEVEN(new Short("7"),"SEVEN","第七年"),
    EIGHT(new Short("8"),"EIGHT","第八年");

    private Short value;
    private String code;
    private String displayName;

    PlanYearEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static PlanYearEnum getByValue(Short value){
        PlanYearEnum baseTypeEnums[] = PlanYearEnum.values();
        for(PlanYearEnum baseTypeEnum : baseTypeEnums){
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

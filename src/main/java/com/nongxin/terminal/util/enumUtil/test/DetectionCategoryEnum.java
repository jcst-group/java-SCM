package com.nongxin.terminal.util.enumUtil.test;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DetectionCategoryEnum implements BaseEnum<DetectionCategoryEnum, Short>, IEnum<Short> {
    STANDDETE((short)1,"STANDDETE","检测标准项目"),
    PESTRES((short)2,"PESTRES","农残"),
    HEAVYMETAL((short)3,"HEAVYMETAL","重金属");

    private Short value;
    private String code;
    private String displayName;

    DetectionCategoryEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static DetectionCategoryEnum getByValue(Short value){
        DetectionCategoryEnum envStandardsEnums[] = DetectionCategoryEnum.values();
        for(DetectionCategoryEnum e : envStandardsEnums){
            if(e.getValue().equals(value)){
                return e;
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

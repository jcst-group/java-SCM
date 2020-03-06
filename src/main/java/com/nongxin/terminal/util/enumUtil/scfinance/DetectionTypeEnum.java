package com.nongxin.terminal.util.enumUtil.scfinance;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DetectionTypeEnum implements IEnum<Short> {
    BASE_DETECTION(new Short("1"),"BASE_DETECTION","基地环境检测"),
    SEED_DETECTION(new Short("2"),"SEED_DETECTION","种苗检测"),
    RECOVERY_DETECTION(new Short("3"),"RECOVERY_DETECTION","采收检测"),
    INIT_DETECTION(new Short("4"),"INIT_DETECTION","初加工检测");
    private Short value;
    private String code;
    private String displayName;

    DetectionTypeEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static DetectionTypeEnum getByValue(Short value){
        DetectionTypeEnum enums[] = DetectionTypeEnum.values();
        for(DetectionTypeEnum e : enums){
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

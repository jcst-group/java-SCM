package com.nongxin.terminal.util.enumUtil.scfinance;


import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DetectionStatusEnum implements IEnum<Short> {
    SAVE(new Short("1"),"SAVE","已保存"),
    DETECT_CONFIRM(new Short("2"),"DETECT_CONFIRM","检测机构确认中"),
    COOP_CONFIRM(new Short("3"),"COOP_CONFIRM","合作社确认中"),
    DETECT_DEALING(new Short("4"),"DETECT_DEALING","检测中"),
    FINISH(new Short("5"),"FINISH","已完成"),
    CANCEL(new Short("6"),"CANCEL","取消申请"),
    FAIL_APPLY(new Short("7"),"FAIL_APPLY","申请失败");
    private Short value;
    private String code;
    private String displayName;

    DetectionStatusEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static DetectionStatusEnum getByValue(Short value){
        DetectionStatusEnum enums[] = DetectionStatusEnum.values();
        for(DetectionStatusEnum e : enums){
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

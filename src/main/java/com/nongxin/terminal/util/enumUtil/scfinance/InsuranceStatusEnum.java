package com.nongxin.terminal.util.enumUtil.scfinance;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum InsuranceStatusEnum  implements IEnum<Short> {
    SAVE(new Short("1"),"SAVE","已保存"),
    APPLYING(new Short("2"),"APPLYING","申请中"),
    ACCEPT(new Short("3"),"ACCEPT","接受投保"),
    FINISH(new Short("4"),"FINISH","投保完成"),
    REJECT(new Short("5"),"REJECT","拒绝投保"),
    CANCEL(new Short("6"),"CANCEL","取消申请"),
    EXPIRE(new Short("7"),"EXPIRE","保险过期");
    private Short value;
    private String code;
    private String displayName;

    InsuranceStatusEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static InsuranceStatusEnum getByValue(Short value){
        InsuranceStatusEnum enums[] = InsuranceStatusEnum.values();
        for(InsuranceStatusEnum e : enums){
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

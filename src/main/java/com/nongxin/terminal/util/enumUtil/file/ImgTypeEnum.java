package com.nongxin.terminal.util.enumUtil.file;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ImgTypeEnum implements BaseEnum<ImgTypeEnum, Short>, IEnum<Short> {

    LOCAL(new Short("1"),"LOCAL","本地"),
    OSS(new Short("2"),"OSS","oss");

    private Short value;
    private String code;
    private String displayName;

    ImgTypeEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static ImgTypeEnum getByValue(Short value){
        ImgTypeEnum imgTypeEnums[] = ImgTypeEnum.values();
        for(ImgTypeEnum imgTypeEnum : imgTypeEnums){
            if(imgTypeEnum.getValue().equals(value)){
                return imgTypeEnum;
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

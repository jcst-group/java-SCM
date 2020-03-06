package com.nongxin.terminal.util.enumUtil.solar;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SolarTermsEnum implements BaseEnum<SolarTermsEnum, Short>, IEnum<Short> {
    LICHUN((short)1,"LICHUN","立春"), YUSHUI((short)2,"YUSHUI","雨水"),
    JINGZHE((short)3,"JINGZHE","惊蛰"), CHUNFEN((short)4,"CHUNFEN","春分"),
    QINGMING((short)5,"QINGMING","清明"), GUYU((short)6,"GUYU","谷雨"),
    LIXIA((short)7,"LIXIA","立夏"), XIAOMAN((short)8, "XIAOMAN","小满"),
    MANGZHONG((short)9, "MANGZHONG","芒种"), XIAZHI((short)10, "XIAZHI","夏至"),
    XIAOSHU((short)11,"XIAOSHU","小暑"), DASHU((short)12,"DASHU", "大暑"),
    LIQIU((short)13,"LIQIU", "立秋"), CHUSHU((short)14, "CHUSHU","处暑"),
    BAILU((short)15,"BAILU", "白露"), QIUFEN((short)16,"QIUFEN", "秋分"),
    HANLU((short)17,"HANLU","寒露"), SHUANGJIANG((short)18, "SHUANGJIANG","霜降"),
    LIDONG((short)19, "LIDONG","立冬"), XIAOXUE((short)20, "XIAOXUE","小雪"),
    DAXUE((short)21, "DAXUE","大雪"), DONGZHI((short)22, "DONGZHI","冬至"),
    XIAOHAN((short)23,"XIAOHAN","小寒"), DAHAN((short)24,"DAHAN","大寒");


    private Short value;
    private String code;
    private String displayName;

    SolarTermsEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static SolarTermsEnum getByValue(Short value){
        SolarTermsEnum solarTermsEnums[] = SolarTermsEnum.values();
        for(SolarTermsEnum solarTermsEnum : solarTermsEnums){
            if(solarTermsEnum.getValue().equals(value)){
                return solarTermsEnum;
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



package com.nongxin.terminal.util.enumUtil.base;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CategoryEnum implements BaseEnum<CategoryEnum, Short>, IEnum<Short> {

    PRODUCTION_BASE(new Short("1"),"PRODUCTION_BASE","生产基地"),
    GROW_SEEDLINGS_BASE(new Short("2"),"GROW_SEEDLINGS_BASE","育苗基地"),
    SEED_BASE(new Short("3"),"SEED_BASE","种子基地"),
    TEST_FIELD(new Short("4"),"TEST_FIELD","试验田");

    private Short value;
    private String code;
    private String displayName;

    CategoryEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }


    public static CategoryEnum getByValue(Short value){
        CategoryEnum categoryEnums[] = CategoryEnum.values();
        for(CategoryEnum categoryEnum : categoryEnums){
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

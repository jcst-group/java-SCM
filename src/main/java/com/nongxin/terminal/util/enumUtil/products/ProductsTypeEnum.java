package com.nongxin.terminal.util.enumUtil.products;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ProductsTypeEnum implements BaseEnum<ProductsTypeEnum, Short>, IEnum<Short> {

    MAIN_PRODUCTS(new Short("1"),"MAIN_PRODUCTS","主产品"),
    SIDE_PRODUCTS(new Short("2"),"SIDE_PRODUCTS","副产品"),
    SEEDLING(new Short("3"),"SEEDLING","种苗");

    private Short value;
    private String code;
    private String displayName;

    ProductsTypeEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static ProductsTypeEnum getByValue(Short value){
        ProductsTypeEnum categoryEnums[] = ProductsTypeEnum.values();
        for(ProductsTypeEnum categoryEnum : categoryEnums){
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

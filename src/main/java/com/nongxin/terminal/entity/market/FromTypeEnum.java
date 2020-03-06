package com.nongxin.terminal.entity.market;

public enum FromTypeEnum {
    AUDIT_FAILED(1,"MARKET","市场"),
    AUDIT_APPROVAL(2,"AREA","产地");

    private Integer value;
    private String code;
    private String fromTypeName;

    FromTypeEnum(Integer value, String code, String fromTypeName) {
        this.value = value;
        this.code = code;
        this.fromTypeName = fromTypeName;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFromTypeName() {
        return fromTypeName;
    }

    public void setFromTypeName(String fromTypeName) {
        this.fromTypeName = fromTypeName;
    }
}

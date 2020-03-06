package com.nongxin.terminal.vo;

public class SortVo {

    private String fieldName;
    private String sortord;

    public SortVo() {
    }

    public SortVo(String fieldName, String sortord) {
        this.fieldName = fieldName;
        this.sortord = sortord;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getSortord() {
        return sortord;
    }

    public void setSortord(String sortord) {
        this.sortord = sortord;
    }
}

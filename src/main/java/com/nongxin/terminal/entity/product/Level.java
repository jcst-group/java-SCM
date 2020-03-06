package com.nongxin.terminal.entity.product;

import javax.validation.constraints.NotEmpty;

public class Level {
    private Integer id;

    @NotEmpty(message = "等级名称不能为空")
    private String levelName;

    @NotEmpty(message = "等级描述不能为空")
    private String levelDescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    public String getLevelDescribe() {
        return levelDescribe;
    }

    public void setLevelDescribe(String levelDescribe) {
        this.levelDescribe = levelDescribe == null ? null : levelDescribe.trim();
    }
}
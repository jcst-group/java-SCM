package com.nongxin.terminal.entity.envmonitor;


import com.nongxin.terminal.vo.app.ContrastVo;

import java.util.Date;

public class WarnRecord {
    private Integer id;

    private String content;

    private Integer equipmentId;

    private String value;

    private String unit;

    private String type;

    private Date warnTime;

    private Integer item;

    private ContrastVo contrastVo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getWarnTime() {
        return warnTime;
    }

    public void setWarnTime(Date warnTime) {
        this.warnTime = warnTime;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public ContrastVo getContrastVo() {
        return contrastVo;
    }

    public void setContrastVo(ContrastVo contrastVo) {
        this.contrastVo = contrastVo;
    }
}
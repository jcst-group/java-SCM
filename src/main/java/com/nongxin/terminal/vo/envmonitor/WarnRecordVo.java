package com.nongxin.terminal.vo.envmonitor;

import com.nongxin.terminal.entity.envmonitor.WarnRecord;

import java.util.Date;
import java.util.List;

public class WarnRecordVo {

    private Date warnTime;

    private Integer baseId;

    private String baseName;

    private Integer equipmentId;

    private String equipmentName;

    private List<WarnRecord> warnRecord;

    public Date getWarnTime() {
        return warnTime;
    }

    public void setWarnTime(Date warnTime) {
        this.warnTime = warnTime;
    }

    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public List<WarnRecord> getWarnRecord() {
        return warnRecord;
    }

    public void setWarnRecord(List<WarnRecord> warnRecord) {
        this.warnRecord = warnRecord;
    }
}

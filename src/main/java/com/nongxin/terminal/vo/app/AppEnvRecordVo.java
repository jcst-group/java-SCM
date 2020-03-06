package com.nongxin.terminal.vo.app;

import com.nongxin.terminal.entity.envmonitor.WarnRecord;

import java.util.Date;
import java.util.List;

public class AppEnvRecordVo {

    private Date warnTime;

    private Integer baseId;

    private String baseName;

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

    public List<WarnRecord> getWarnRecord() {
        return warnRecord;
    }

    public void setWarnRecord(List<WarnRecord> warnRecord) {
        this.warnRecord = warnRecord;
    }

}

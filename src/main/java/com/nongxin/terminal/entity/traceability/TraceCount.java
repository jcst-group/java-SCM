package com.nongxin.terminal.entity.traceability;

import java.util.Date;

public class TraceCount {
    private Integer id;

    private String retroCode;

    private Integer totalCount;

    private Date firstTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRetroCode() {
        return retroCode;
    }

    public void setRetroCode(String retroCode) {
        this.retroCode = retroCode;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }
}
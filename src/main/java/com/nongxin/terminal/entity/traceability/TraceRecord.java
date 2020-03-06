package com.nongxin.terminal.entity.traceability;

import java.util.Date;

public class TraceRecord {
    private Integer id;

    private String ip;

    private String retroCode;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getRetroCode() {
        return retroCode;
    }

    public void setRetroCode(String retroCode) {
        this.retroCode = retroCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
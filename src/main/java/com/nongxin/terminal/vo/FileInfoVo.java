package com.nongxin.terminal.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class FileInfoVo implements Serializable {
    public FileInfoVo(String path){
        this.path = path;
    }

    public FileInfoVo(String path, BigDecimal fileSize, String fileName) {
        this.path = path;
        this.fileSize = fileSize;
        this.fileName = fileName;
    }

    public FileInfoVo() {
    }

    private String path;

    //文件大小
    private BigDecimal fileSize;

    //文件名称
    private String fileName;

    private BigDecimal duration;

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public BigDecimal getFileSize() {
        return fileSize;
    }

    public void setFileSize(BigDecimal fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

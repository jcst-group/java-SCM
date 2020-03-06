package com.nongxin.terminal.vo.initPro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.processing.ProcessingMethods;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class RetroInitPro {

    private Integer id;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date initTime;

    private String initCode;

    private String realName;

    private PictureInfo detectionPic;

    private List<ProcessingMethods> initMethod;

    private Integer detectionId;

    public Integer getDetectionId() {
        return detectionId;
    }

    public void setDetectionId(Integer detectionId) {
        this.detectionId = detectionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInitTime() {
        return initTime;
    }

    public void setInitTime(Date initTime) {
        this.initTime = initTime;
    }

    public String getInitCode() {
        return initCode;
    }

    public void setInitCode(String initCode) {
        this.initCode = initCode;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public PictureInfo getDetectionPic() {
        return detectionPic;
    }

    public void setDetectionPic(PictureInfo detectionPic) {
        this.detectionPic = detectionPic;
    }

    public List<ProcessingMethods> getInitMethod() {
        return initMethod;
    }

    public void setInitMethod(List<ProcessingMethods> initMethod) {
        this.initMethod = initMethod;
    }
}

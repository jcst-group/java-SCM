package com.nongxin.terminal.vo.recovery;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.file.PictureInfo;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class RetroRecovery {

    private Integer id;

    private String recoveryCode;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date harvestingTime;

    private String baseName;

    private PictureInfo detectionPic;

    private PictureInfo detectionResultPic;

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

    public String getRecoveryCode() {
        return recoveryCode;
    }

    public void setRecoveryCode(String recoveryCode) {
        this.recoveryCode = recoveryCode;
    }

    public Date getHarvestingTime() {
        return harvestingTime;
    }

    public void setHarvestingTime(Date harvestingTime) {
        this.harvestingTime = harvestingTime;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public PictureInfo getDetectionPic() {
        return detectionPic;
    }

    public void setDetectionPic(PictureInfo detectionPic) {
        this.detectionPic = detectionPic;
    }

    public PictureInfo getDetectionResultPic() {
        return detectionResultPic;
    }

    public void setDetectionResultPic(PictureInfo detectionResultPic) {
        this.detectionResultPic = detectionResultPic;
    }
}

package com.nongxin.terminal.entity.testing;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.plant.PlantingPlan;
import com.nongxin.terminal.entity.recovery.RecoveryBatch;
import com.nongxin.terminal.vo.detection.DetectionVo;
import com.nongxin.terminal.vo.recovery.BaseRecoveryVo;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class RecoveryDetection {
    private Integer id;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date detectionTime;

    private String samplingCriteria;

    private Short samplingQuantity;

    private Integer planId;

    @NotNull(message = "检测数据不能为空")
    private List<DetectionRel> detectionRelList;

    private PictureInfo detectionPic;

    private PictureInfo detectionResultPic;

    private List<RecDetRel> recDetRelList;

    private List<DetectionVo> detectionVoList;

    private List<BaseRecoveryVo> recoveryList;

    private PlantingPlan plantingPlan;

    public PlantingPlan getPlantingPlan() {
        return plantingPlan;
    }

    public void setPlantingPlan(PlantingPlan plantingPlan) {
        this.plantingPlan = plantingPlan;
    }

    public List<BaseRecoveryVo> getRecoveryList() {
        return recoveryList;
    }

    public void setRecoveryList(List<BaseRecoveryVo> recoveryList) {
        this.recoveryList = recoveryList;
    }

    public List<DetectionVo> getDetectionVoList() {
        return detectionVoList;
    }

    public void setDetectionVoList(List<DetectionVo> detectionVoList) {
        this.detectionVoList = detectionVoList;
    }

    public List<RecDetRel> getRecDetRelList() {
        return recDetRelList;
    }

    public void setRecDetRelList(List<RecDetRel> recDetRelList) {
        this.recDetRelList = recDetRelList;
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

    public List<DetectionRel> getDetectionRelList() {
        return detectionRelList;
    }

    public void setDetectionRelList(List<DetectionRel> detectionRelList) {
        this.detectionRelList = detectionRelList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDetectionTime() {
        return detectionTime;
    }

    public void setDetectionTime(Date detectionTime) {
        this.detectionTime = detectionTime;
    }

    public String getSamplingCriteria() {
        return samplingCriteria;
    }

    public void setSamplingCriteria(String samplingCriteria) {
        this.samplingCriteria = samplingCriteria == null ? null : samplingCriteria.trim();
    }

    public Short getSamplingQuantity() {
        return samplingQuantity;
    }

    public void setSamplingQuantity(Short samplingQuantity) {
        this.samplingQuantity = samplingQuantity;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }
}
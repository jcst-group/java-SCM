package com.nongxin.terminal.entity.testing;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.plant.PlantingPlan;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.vo.detection.DetectionVo;
import com.nongxin.terminal.vo.initPro.InitProVo;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class InitproDetection {
    private Integer id;

    private Integer planId;

    private String samplingCriteria;

    private Short samplingQuantity;

    @NotNull(message = "检测时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date detectionTime;

    private PictureInfo detectionPic;

    private List<DetectionVo> detectionVoList;

    //初加工检测与初加工批次关联关系
    private List<InitproDetRel> initproDetRelList;

    @NotNull(message = "检测数据不能为空")
    private List<DetectionRel> detectionRelList;

    private Integer userId;

    private User user;

    private List<InitProVo> initProVoList;

    private PlantingPlan plantingPlan;

    public PlantingPlan getPlantingPlan() {
        return plantingPlan;
    }

    public void setPlantingPlan(PlantingPlan plantingPlan) {
        this.plantingPlan = plantingPlan;
    }

    public List<InitProVo> getInitProVoList() {
        return initProVoList;
    }

    public void setInitProVoList(List<InitProVo> initProVoList) {
        this.initProVoList = initProVoList;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<DetectionRel> getDetectionRelList() {
        return detectionRelList;
    }

    public void setDetectionRelList(List<DetectionRel> detectionRelList) {
        this.detectionRelList = detectionRelList;
    }

    public PictureInfo getDetectionPic() {
        return detectionPic;
    }

    public void setDetectionPic(PictureInfo detectionPic) {
        this.detectionPic = detectionPic;
    }

    public List<DetectionVo> getDetectionVoList() {
        return detectionVoList;
    }

    public void setDetectionVoList(List<DetectionVo> detectionVoList) {
        this.detectionVoList = detectionVoList;
    }

    public List<InitproDetRel> getInitproDetRelList() {
        return initproDetRelList;
    }

    public void setInitproDetRelList(List<InitproDetRel> initproDetRelList) {
        this.initproDetRelList = initproDetRelList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
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

    public Date getDetectionTime() {
        return detectionTime;
    }

    public void setDetectionTime(Date detectionTime) {
        this.detectionTime = detectionTime;
    }
}
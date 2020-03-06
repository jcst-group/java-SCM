package com.nongxin.terminal.entity.testing;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.base.BaseInfo;
import com.nongxin.terminal.entity.batch.SeedBatch;
import com.nongxin.terminal.entity.crop.Crop;
import com.nongxin.terminal.entity.crop.CropBatch;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.vo.detection.DetectionVo;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class SeedDetection {
    private Integer id;

    @NotNull(message = "作物不能为空")
    private Integer cropId;

    @NotNull(message = "种子/种苗不能为空")
    private Integer seedBatchId;

    @NotNull(message = "检查时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date detectionTime;

    private PictureInfo detectionPic;

    private PictureInfo detectionResultPic;

    @NotNull(message = "检测数据不能为空")
    private List<DetectionRel> detectionRelList;

    private SeedBatch seedBatch;

    private Crop crop;

    private Integer userId;

    private User user;

    private List<DetectionVo> detectionVoList;

    private BaseInfo baseInfo;

    private CropBatch cropBatch;

    public CropBatch getCropBatch() {
        return cropBatch;
    }

    public void setCropBatch(CropBatch cropBatch) {
        this.cropBatch = cropBatch;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public List<DetectionVo> getDetectionVoList() {
        return detectionVoList;
    }

    public void setDetectionVoList(List<DetectionVo> detectionVoList) {
        this.detectionVoList = detectionVoList;
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

    public SeedBatch getSeedBatch() {
        return seedBatch;
    }

    public void setSeedBatch(SeedBatch seedBatch) {
        this.seedBatch = seedBatch;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
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

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public Integer getSeedBatchId() {
        return seedBatchId;
    }

    public void setSeedBatchId(Integer seedBatchId) {
        this.seedBatchId = seedBatchId;
    }

    public Date getDetectionTime() {
        return detectionTime;
    }

    public void setDetectionTime(Date detectionTime) {
        this.detectionTime = detectionTime;
    }
}
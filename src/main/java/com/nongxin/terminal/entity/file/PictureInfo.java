package com.nongxin.terminal.entity.file;

import com.nongxin.terminal.util.enumUtil.file.ImgRelationTypeEnum;
import com.nongxin.terminal.util.enumUtil.file.ImgTypeEnum;

import java.util.Date;

public class PictureInfo {
    private Integer id;

    private String pictureLabel;

    private String pictureUrl;

    private Integer relationId;

    /*private Short relationType;*/
    private ImgRelationTypeEnum relationType;

    private Date createTime;

    private Integer createManId;

    private Date updateTime;

    private Integer updateManId;

    /*private Short type;*/
    private ImgTypeEnum type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPictureLabel() {
        return pictureLabel;
    }

    public void setPictureLabel(String pictureLabel) {
        this.pictureLabel = pictureLabel == null ? null : pictureLabel.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateManId() {
        return createManId;
    }

    public void setCreateManId(Integer createManId) {
        this.createManId = createManId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateManId() {
        return updateManId;
    }

    public void setUpdateManId(Integer updateManId) {
        this.updateManId = updateManId;
    }

    public ImgRelationTypeEnum getRelationType() {
        return relationType;
    }

    public void setRelationType(ImgRelationTypeEnum relationType) {
        this.relationType = relationType;
    }

    public ImgTypeEnum getType() {
        return type;
    }

    public void setType(ImgTypeEnum type) {
        this.type = type;
    }
}
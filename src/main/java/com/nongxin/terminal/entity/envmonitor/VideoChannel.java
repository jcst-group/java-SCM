package com.nongxin.terminal.entity.envmonitor;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class VideoChannel {
    private Integer id;

    @NotEmpty(message = "通道名称不能为空")
    @Length(max=10, message = "通道名称不得高于10")
    private String channelName;

    private Integer channelNo;

    private Integer serialId;

    private Date createTime;

    private Integer baseId;

    private VideoEquipment videoEquipment;

    private String baseName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(Integer channelNo) {
        this.channelNo = channelNo;
    }

    public Integer getSerialId() {
        return serialId;
    }

    public void setSerialId(Integer serialId) {
        this.serialId = serialId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    public VideoEquipment getVideoEquipment() {
        return videoEquipment;
    }

    public void setVideoEquipment(VideoEquipment videoEquipment) {
        this.videoEquipment = videoEquipment;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }
}
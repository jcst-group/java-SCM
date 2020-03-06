package com.nongxin.terminal.entity.envmonitor;

import java.util.Date;
import java.util.List;

public class VideoEquipment {
    private Integer id;

    private String serialNumber;

    private String videoName;

    private Date createTime;

    private List<VideoChannel> videoChannel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<VideoChannel> getVideoChannel() {
        return videoChannel;
    }

    public void setVideoChannel(List<VideoChannel> videoChannel) {
        this.videoChannel = videoChannel;
    }
}
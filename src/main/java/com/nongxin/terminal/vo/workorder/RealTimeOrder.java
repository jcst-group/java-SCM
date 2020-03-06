package com.nongxin.terminal.vo.workorder;

import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.util.enumUtil.plan.WorkOrderStatusEnum;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class RealTimeOrder {

    private Integer id;

    private Date subTime;

    private String farmingName;

    private String orderContent;

    private User user;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private WorkOrderStatusEnum status;

    public WorkOrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(WorkOrderStatusEnum status) {
        this.status = status;
    }

    private List<PictureInfo> pictureInfoList;

    public List<PictureInfo> getPictureInfoList() {
        return pictureInfoList;
    }

    public void setPictureInfoList(List<PictureInfo> pictureInfoList) {
        this.pictureInfoList = pictureInfoList;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSubTime() {
        return subTime;
    }

    public void setSubTime(Date subTime) {
        this.subTime = subTime;
    }

    public String getFarmingName() {
        return farmingName;
    }

    public void setFarmingName(String farmingName) {
        this.farmingName = farmingName;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

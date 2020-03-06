package com.nongxin.terminal.service.envmonitor;

import com.nongxin.terminal.entity.envmonitor.VideoEquipment;

import java.util.List;

public interface VideoEquipmentService {

    boolean insertSelective(VideoEquipment videoEquipment);

    boolean update(VideoEquipment videoEquipment);

    boolean delete(Integer id);

    List<VideoEquipment> getList(VideoEquipment videoEquipment);

    VideoEquipment checkSerialNumber(String serialNumber);
}

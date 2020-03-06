package com.nongxin.terminal.dao.envmonitor;

import com.nongxin.terminal.entity.envmonitor.VideoEquipment;

import java.util.List;

public interface VideoEquipmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VideoEquipment record);

    int insertSelective(VideoEquipment record);

    VideoEquipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VideoEquipment record);

    int updateByPrimaryKey(VideoEquipment record);

    List<VideoEquipment> getList(VideoEquipment videoEquipment);

    List<VideoEquipment> getVideoEquipByBaseId(Integer baseId);

    VideoEquipment checkSerialNumber(String serialNumber);
}
package com.nongxin.terminal.service.envmonitor.impl;

import com.nongxin.terminal.dao.envmonitor.VideoEquipmentMapper;
import com.nongxin.terminal.entity.envmonitor.VideoEquipment;
import com.nongxin.terminal.service.envmonitor.VideoEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoEquipmentServiceImpl implements VideoEquipmentService {

    @Autowired
    private VideoEquipmentMapper dao;

    @Override
    public boolean insertSelective(VideoEquipment videoEquipment) {
        return dao.insertSelective(videoEquipment) == 1;
    }

    @Override
    public boolean update(VideoEquipment videoEquipment) {
        return dao.updateByPrimaryKeySelective(videoEquipment) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return dao.deleteByPrimaryKey(id) == 1;
    }

    @Override
    public List<VideoEquipment> getList(VideoEquipment videoEquipment) {
        return dao.getList(videoEquipment);
    }

    @Override
    public VideoEquipment checkSerialNumber(String serialNumber) {
        return dao.checkSerialNumber(serialNumber);
    }
}

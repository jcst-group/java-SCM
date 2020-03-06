package com.nongxin.terminal.service.envmonitor.impl;

import com.nongxin.terminal.dao.envmonitor.VideoChannelMapper;
import com.nongxin.terminal.entity.envmonitor.VideoChannel;
import com.nongxin.terminal.service.envmonitor.VideoChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VideoChannelServiceImpl implements VideoChannelService {

    @Autowired
    private VideoChannelMapper dao;


    @Override
    public boolean insertSelective(VideoChannel record) {
        return dao.insertSelective(record) == 1;
    }

    @Override
    public boolean updateByPrimaryKeySelective(VideoChannel record) {
        return dao.updateByPrimaryKeySelective(record) == 1;
    }

    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id) == 1;
    }

    @Override
    public List<VideoChannel> getChannelList(String serialNumber,Integer baseId) {
        return dao.getChannelList(serialNumber,baseId);
    }

    @Override
    public VideoChannel checkChannel(Integer serialId, Integer channelNo) {
        return dao.checkChannel(serialId,channelNo);
    }
}

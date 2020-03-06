package com.nongxin.terminal.service.envmonitor;

import com.nongxin.terminal.entity.envmonitor.VideoChannel;

import java.util.List;

public interface VideoChannelService {

    boolean insertSelective(VideoChannel record);

    boolean updateByPrimaryKeySelective(VideoChannel record);

    boolean deleteByPrimaryKey(Integer id);

    List<VideoChannel> getChannelList(String serialNumber,Integer baseId);

    VideoChannel checkChannel(Integer serialId,Integer channelNo);
}

package com.nongxin.terminal.dao.envmonitor;

import com.nongxin.terminal.entity.envmonitor.VideoChannel;

import java.util.List;

public interface VideoChannelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VideoChannel record);

    int insertSelective(VideoChannel record);

    VideoChannel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VideoChannel record);

    int updateByPrimaryKey(VideoChannel record);

    List<VideoChannel> getChannelList(String serialNumber,Integer baseId);

    List<VideoChannel> getAllList();

    List<VideoChannel> getVideoEquipByBaseId(Integer baseId);

    VideoChannel getBaseIdVideo(String serialNumber,Integer channelNo);

    List<VideoChannel> getChannelBySerialId(Integer serialId);

    VideoChannel checkChannel(Integer serialId,Integer channelNo);
}
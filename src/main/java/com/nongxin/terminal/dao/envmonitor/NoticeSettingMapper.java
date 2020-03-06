package com.nongxin.terminal.dao.envmonitor;

import com.nongxin.terminal.entity.envmonitor.NoticeSetting;

import java.util.List;

public interface NoticeSettingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NoticeSetting record);

    int insertSelective(NoticeSetting record);

    NoticeSetting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NoticeSetting record);

    int updateByPrimaryKey(NoticeSetting record);

    List<NoticeSetting> getList();

    //根据设备id查询
    NoticeSetting getByEquipmentId(Integer equipmentId);
}
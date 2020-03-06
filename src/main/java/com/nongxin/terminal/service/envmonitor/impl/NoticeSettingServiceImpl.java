package com.nongxin.terminal.service.envmonitor.impl;

import com.nongxin.terminal.dao.envmonitor.NoticeSettingMapper;
import com.nongxin.terminal.entity.envmonitor.NoticeSetting;
import com.nongxin.terminal.service.envmonitor.NoticeSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeSettingServiceImpl implements NoticeSettingService {

    @Autowired
    private NoticeSettingMapper noticeSettingDao;

    @Override
    public boolean insert(NoticeSetting noticeSetting) {
        return noticeSettingDao.insertSelective(noticeSetting) == 1;
    }

    @Override
    public boolean update(NoticeSetting noticeSetting) {
        return noticeSettingDao.updateByPrimaryKeySelective(noticeSetting) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return noticeSettingDao.deleteByPrimaryKey(id) == 1;
    }

    @Override
    public List<NoticeSetting> getList() {
        return noticeSettingDao.getList();
    }
}

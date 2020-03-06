package com.nongxin.terminal.service.envmonitor;

import com.nongxin.terminal.entity.envmonitor.NoticeSetting;

import java.util.List;

public interface NoticeSettingService {

    boolean insert(NoticeSetting noticeSetting);

    boolean update(NoticeSetting noticeSetting);

    boolean delete(Integer id);

    List<NoticeSetting> getList();
}

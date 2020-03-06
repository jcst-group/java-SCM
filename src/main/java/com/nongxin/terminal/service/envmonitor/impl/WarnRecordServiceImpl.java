package com.nongxin.terminal.service.envmonitor.impl;

import com.nongxin.terminal.dao.envmonitor.WarnRecordMapper;
import com.nongxin.terminal.entity.envmonitor.WarnRecord;
import com.nongxin.terminal.service.envmonitor.WarnRecordService;
import com.nongxin.terminal.vo.app.AppEnvRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WarnRecordServiceImpl implements WarnRecordService {

    @Autowired
    private WarnRecordMapper warnRecordDao;

    @Override
    public boolean insertSelective(WarnRecord record) {
        return warnRecordDao.insertSelective(record) == 1;
    }

    @Override
    public List<WarnRecord> getWarnRecordByTime(Integer typeId, Integer baseId) {
        return warnRecordDao.getWarnRecordByTime(typeId,baseId);
    }

    @Override
    public List<AppEnvRecordVo> getRecordByTime(Date time) {
        return warnRecordDao.getRecordByTime(time);
    }

    @Override
    public List<WarnRecord> getRecordList(Integer equipmentId, Integer baseId, Date startTime, Date endTime) {
        return warnRecordDao.getRecordList(equipmentId,baseId,startTime,endTime);
    }


}

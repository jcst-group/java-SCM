package com.nongxin.terminal.service.envmonitor.impl;

import com.nongxin.terminal.dao.envmonitor.WarnEnvMapper;
import com.nongxin.terminal.entity.envmonitor.WarnEnv;
import com.nongxin.terminal.service.envmonitor.WarnEnvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarnEnvServiceImpl implements WarnEnvService {

    @Autowired
    private WarnEnvMapper warnEnvDao;

    @Override
    public boolean insertSelective(WarnEnv record) {
        return warnEnvDao.insertSelective(record) == 1;
    }

    @Override
    public boolean updateByPrimaryKeySelective(WarnEnv record) {
        return warnEnvDao.updateByPrimaryKeySelective(record) == 1;
    }

    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        return warnEnvDao.deleteByPrimaryKey(id) == 1;
    }

    @Override
    public List<WarnEnv> getWarnEnvList() {
        return warnEnvDao.getWarnEnvList();
    }

    @Override
    public WarnEnv getWarnEnvByEquipmentId(Integer equipmentId) {
        return warnEnvDao.getWarnEnvByEquipmentId(equipmentId);
    }

    @Override
    public boolean updateStatus(Integer id,Integer status) {
        return warnEnvDao.updateStatus(id,status) == 1;
    }

    @Override
    public boolean updateByEquipmentId(WarnEnv warnEnv) {
        return warnEnvDao.updateByEquipmentId(warnEnv) == 1;
    }

}

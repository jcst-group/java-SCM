package com.nongxin.terminal.service.base.impl;

import com.nongxin.terminal.dao.base.EnvStandardsMapper;
import com.nongxin.terminal.dao.common.UnitMapper;
import com.nongxin.terminal.entity.base.EnvStandards;
import com.nongxin.terminal.entity.common.Unit;
import com.nongxin.terminal.service.base.EnvStandardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnvStandardsServiceImpl implements EnvStandardsService {

    @Autowired(required = false)
    private EnvStandardsMapper envStandardsMapper;
    @Autowired(required = false)
    private UnitMapper unitMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(EnvStandards envStandards) {
        Unit unit = unitMapper.selectByDisplayName(envStandards.getUnit().getDisplayName());
        if (unit == null){
            unit = new Unit();
            unit.setDisplayName(envStandards.getUnit().getDisplayName());
            unitMapper.insertSelective(unit);
        }
        envStandards.setUnit(unit);
        return envStandardsMapper.insertSelective(envStandards)==1;
    }

    @Override
    public boolean delete(Integer id) {
        return envStandardsMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(EnvStandards envStandards) {
        Unit unit = unitMapper.selectByDisplayName(envStandards.getUnit().getDisplayName());
        if (unit == null){
            unit = new Unit();
            unit.setDisplayName(envStandards.getUnit().getDisplayName());
            unitMapper.insertSelective(unit);
        }
        envStandards.setUnit(unit);
        return envStandardsMapper.updateByPrimaryKeySelective(envStandards)==1;
    }

    @Override
    public List<EnvStandards> getEnvStandards(EnvStandards envStandards) {
        return envStandardsMapper.getEnvStandards(envStandards);
    }
}

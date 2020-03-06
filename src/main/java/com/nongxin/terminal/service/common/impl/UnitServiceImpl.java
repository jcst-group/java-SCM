package com.nongxin.terminal.service.common.impl;

import com.nongxin.terminal.dao.common.UnitMapper;
import com.nongxin.terminal.entity.common.Unit;
import com.nongxin.terminal.service.common.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitMapper unitMapper;

    @Override
    public List<Unit> getUnit(String displayName) {
        return unitMapper.getUnit(displayName);
    }

}

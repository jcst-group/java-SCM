package com.nongxin.terminal.service.system.impl;

import com.nongxin.terminal.dao.system.ConstantStorageMapper;
import com.nongxin.terminal.entity.system.ConstantStorage;
import com.nongxin.terminal.service.system.ConstantStorageService;
import com.nongxin.terminal.util.enumUtil.system.ConstantTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConstantStorageServiceImpl implements ConstantStorageService {

    @Autowired(required = false)
    private ConstantStorageMapper constantStorageMapper;

    @Override
    public ConstantStorage selectByType(ConstantTypeEnum type) {
        return constantStorageMapper.selectByType(type);
    }
}

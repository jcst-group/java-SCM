package com.nongxin.terminal.service.push.impl;

import com.nongxin.terminal.dao.push.PushRelMapper;
import com.nongxin.terminal.entity.push.PushRel;
import com.nongxin.terminal.service.push.PushRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PushRelServiceImpl implements PushRelService {

    @Autowired
    private PushRelMapper pushRelMapper;

    @Override
    public boolean insertSelective(PushRel record) {
        return pushRelMapper.insertSelective(record) == 1;
    }

    @Override
    public boolean deleteByUidAndCid(PushRel record) {
        return pushRelMapper.deleteByUidAndCid(record) == 1;
    }

    @Override
    public PushRel isExist(PushRel record) {
        return pushRelMapper.selectByUidAndCid(record);
    }


}

package com.nongxin.terminal.service.illness.impl;

import com.nongxin.terminal.dao.illness.IllnessMapper;
import com.nongxin.terminal.entity.illness.Illness;
import com.nongxin.terminal.service.illness.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IllnessServiceImpl implements IllnessService {

    @Autowired(required = false)
    private IllnessMapper illnessMapper;

    @Override
    public List<Illness> getAll(String illnessName) {
        return illnessMapper.getAll(illnessName);
    }
}

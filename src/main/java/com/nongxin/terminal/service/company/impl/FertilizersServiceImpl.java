package com.nongxin.terminal.service.company.impl;

import com.nongxin.terminal.dao.company.FertilizersMapper;
import com.nongxin.terminal.entity.company.Fertilizers;
import com.nongxin.terminal.service.company.FertilizersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FertilizersServiceImpl implements FertilizersService {

    @Autowired
    private FertilizersMapper dao;

    @Override
    public boolean insertSelective(Fertilizers fertilizers) {
        return dao.insertSelective(fertilizers) == 1;
    }

    @Override
    public boolean updateByPrimaryKeySelective(Fertilizers fertilizers) {
        return dao.updateByPrimaryKeySelective(fertilizers) == 1;
    }

    @Override
    public Fertilizers selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id) == 1;
    }

    @Override
    public List<Fertilizers> getFertilizersList(Fertilizers fertilizers) {
        return dao.getFertilizersList(fertilizers);
    }

    @Override
    public List<Fertilizers> getFertilizersByCompanyId(Integer companyId) {
        return dao.getFertilizersByCompanyId(companyId);
    }
}

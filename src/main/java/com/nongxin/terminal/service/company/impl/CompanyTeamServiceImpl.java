package com.nongxin.terminal.service.company.impl;

import com.nongxin.terminal.dao.company.CompanyTeamMapper;
import com.nongxin.terminal.entity.company.CompanyTeam;
import com.nongxin.terminal.service.company.CompanyTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyTeamServiceImpl implements CompanyTeamService {

    @Autowired
    private CompanyTeamMapper dao;
    @Override
    public boolean insertSelective(CompanyTeam companyTeam) {
        return dao.insertSelective(companyTeam) == 1;
    }

    @Override
    public boolean updateByPrimaryKeySelective(CompanyTeam companyTeam) {
        return dao.updateByPrimaryKeySelective(companyTeam) == 1;
    }

    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id) == 1;
    }

    @Override
    public List<CompanyTeam> getList(CompanyTeam companyTeam) {
        return dao.getList(companyTeam);
    }

    @Override
    public List<CompanyTeam> getTeam() {
        return dao.getTeam();
    }
}

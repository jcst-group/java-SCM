package com.nongxin.terminal.service.company;

import com.nongxin.terminal.entity.company.CompanyTeam;

import java.util.List;

public interface CompanyTeamService {

    boolean insertSelective(CompanyTeam companyTeam);

    boolean updateByPrimaryKeySelective(CompanyTeam companyTeam);

    boolean deleteByPrimaryKey(Integer id);

    List<CompanyTeam> getList(CompanyTeam companyTeam);

    List<CompanyTeam> getTeam();
}

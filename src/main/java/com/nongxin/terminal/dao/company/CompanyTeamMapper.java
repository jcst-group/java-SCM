package com.nongxin.terminal.dao.company;

import com.nongxin.terminal.entity.company.CompanyTeam;

import java.util.List;

public interface CompanyTeamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyTeam record);

    int insertSelective(CompanyTeam record);

    CompanyTeam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyTeam record);

    int updateByPrimaryKey(CompanyTeam record);

    List<CompanyTeam> getList(CompanyTeam companyTeam);

    List<CompanyTeam> getTeam();
}
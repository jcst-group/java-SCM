package com.nongxin.terminal.dao.company;

import com.nongxin.terminal.entity.company.Fertilizers;

import java.util.List;

public interface FertilizersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fertilizers record);

    int insertSelective(Fertilizers record);

    Fertilizers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fertilizers record);

    int updateByPrimaryKey(Fertilizers record);

    List<Fertilizers> getFertilizersList(Fertilizers fertilizers);

    List<Fertilizers> getFertilizersByCompanyId(Integer companyId);
}
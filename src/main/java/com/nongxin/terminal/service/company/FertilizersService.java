package com.nongxin.terminal.service.company;

import com.nongxin.terminal.entity.company.Fertilizers;

import java.util.List;

public interface FertilizersService {

    boolean insertSelective(Fertilizers fertilizers);

    boolean updateByPrimaryKeySelective(Fertilizers fertilizers);

    Fertilizers selectByPrimaryKey(Integer id);

    boolean deleteByPrimaryKey(Integer id);

    List<Fertilizers> getFertilizersList(Fertilizers fertilizers);

    List<Fertilizers> getFertilizersByCompanyId(Integer companyId);
}

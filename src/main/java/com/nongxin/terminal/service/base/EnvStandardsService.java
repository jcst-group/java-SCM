package com.nongxin.terminal.service.base;

import com.nongxin.terminal.entity.base.EnvStandards;

import java.util.List;

public interface EnvStandardsService {

    boolean add(EnvStandards envStandards);

    boolean delete(Integer id);

    boolean update(EnvStandards envStandards);

    //获取所有基地环境标准
    List<EnvStandards> getEnvStandards(EnvStandards envStandards);

}

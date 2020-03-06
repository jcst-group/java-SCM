package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.FarmingRole;

public interface FarmingRoleMapper {
    int insert(FarmingRole record);

    int insertSelective(FarmingRole record);

    int deleteByFarmingId(Integer farmingId);
}
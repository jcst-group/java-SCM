package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.MaterialInfo;

import java.util.List;

public interface MaterialInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MaterialInfo record);

    int insertSelective(MaterialInfo record);

    MaterialInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterialInfo record);

    int updateByPrimaryKey(MaterialInfo record);

    List<MaterialInfo> selectByFarmingId(Integer farmingId);
}
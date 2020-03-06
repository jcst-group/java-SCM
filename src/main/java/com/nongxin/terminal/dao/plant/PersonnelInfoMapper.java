package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.PersonnelInfo;

import java.util.List;

public interface PersonnelInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonnelInfo record);

    int insertSelective(PersonnelInfo record);

    PersonnelInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonnelInfo record);

    int updateByPrimaryKey(PersonnelInfo record);

    List<PersonnelInfo> selectByFarmingId(Integer farmingId);
}
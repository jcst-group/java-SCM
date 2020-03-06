package com.nongxin.terminal.service.plan;

import com.nongxin.terminal.entity.plant.Farming;
import com.nongxin.terminal.entity.plant.PersonnelInfo;

import java.util.List;

public interface PersonnelInfoService {

    boolean add(PersonnelInfo personnelInfo);

    boolean delete(Integer id);

    boolean update(PersonnelInfo personnelInfo);

    List<PersonnelInfo> selectByFarmingId(Integer farmingId);

}

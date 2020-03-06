package com.nongxin.terminal.service.plan;

import com.nongxin.terminal.entity.plant.Farming;
import com.nongxin.terminal.util.enumUtil.plan.FarmingTypeEnum;

import java.util.List;

public interface FarmingService {

    boolean add(Farming farming);

    boolean delete(Integer id);

    boolean update(Farming farming);

    List<Farming> getFarmingList(Integer planYearId, String farmingName, FarmingTypeEnum type);

    boolean updateSequExecute(Integer id,boolean sequExecute);

}

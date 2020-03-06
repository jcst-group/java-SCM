package com.nongxin.terminal.service.plan;

import com.nongxin.terminal.entity.plant.Farming;
import com.nongxin.terminal.entity.plant.MaterialInfo;

import java.util.List;

public interface MaterialInfoService {

    boolean add(MaterialInfo materialInfo);

    boolean delete(Integer id);

    boolean update(MaterialInfo materialInfo);

    List<MaterialInfo> selectByFarmingId(Integer farmingId);

}

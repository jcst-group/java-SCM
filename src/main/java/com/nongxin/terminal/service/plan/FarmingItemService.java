package com.nongxin.terminal.service.plan;

import com.nongxin.terminal.entity.plant.FarmingItem;

import java.util.List;

public interface FarmingItemService {

    boolean add(FarmingItem farmingItem);

    boolean delete(Integer id);

    boolean update(FarmingItem farmingItem);

    //带条件查询农事项目
    List<FarmingItem> getFarmingItemList(Integer cropId);

    //查询所有农事项目
    List<FarmingItem> getAllFarmingItem();

    //根据作物查询农事项目
    List<FarmingItem> getFarmingItemByCropId(Integer cropId);

    //根据id查询农事项目
    FarmingItem selectByPrimaryKey(Integer id);

}

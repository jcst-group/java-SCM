package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.FarmingItem;
import com.nongxin.terminal.vo.lookboard.FarmingItemVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FarmingItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FarmingItem record);

    int insertSelective(FarmingItem record);

    FarmingItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FarmingItem record);

    int updateByPrimaryKey(FarmingItem record);

    List<FarmingItem> getFarmingItemList(@Param("cropId") Integer cropId);

    List<FarmingItem> getAllFarmingItem();

    FarmingItem getIdAndName(Integer id);

    List<FarmingItem> getFarmingItemByCropId(Integer cropId);

    List<FarmingItemVo> getFarmingItemBoard(Integer id);
}
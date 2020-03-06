package com.nongxin.terminal.dao.crop;

import com.nongxin.terminal.entity.crop.CropProduct;

import java.util.List;

public interface CropProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CropProduct record);

    int insertSelective(CropProduct record);

    CropProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CropProduct record);

    int updateByPrimaryKey(CropProduct record);

    List<CropProduct> getCropProductByHarvestedId(Integer harvestedId);

    int deleteByHarvestedId(Integer harvestedId);
}
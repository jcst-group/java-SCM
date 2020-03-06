package com.nongxin.terminal.dao.crop;

import com.nongxin.terminal.entity.crop.HarvestedProduct;

import java.util.List;
import java.util.Map;

public interface HarvestedProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HarvestedProduct record);

    int insertSelective(HarvestedProduct record);

    HarvestedProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HarvestedProduct record);

    int updateByPrimaryKey(HarvestedProduct record);

    int deleteByCropId(Integer cropId);

    List<HarvestedProduct> getHarvestedByCropId(Integer cropId);

    HarvestedProduct getIdAndName(Integer id);

    List<Map<String,Object>> getHarvestedByBatchId(Integer batchId);
}
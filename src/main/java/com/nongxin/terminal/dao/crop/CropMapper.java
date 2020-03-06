package com.nongxin.terminal.dao.crop;

import com.nongxin.terminal.entity.crop.Crop;

import java.util.List;

public interface CropMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Crop record);

    int insertSelective(Crop record);

    Crop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Crop record);

    int updateByPrimaryKey(Crop record);

    List<Crop> getCropList();

    List<Crop> getAllCropList();

    Crop getIdAndNameById(Integer id);

    Crop selectByBatchId(Integer batchId);

    Crop selectByRetroCode(String retroCode);
}
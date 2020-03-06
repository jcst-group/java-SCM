package com.nongxin.terminal.dao.testing;

import com.nongxin.terminal.entity.testing.SeedDetection;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SeedDetectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SeedDetection record);

    int insertSelective(SeedDetection record);

    SeedDetection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SeedDetection record);

    int updateByPrimaryKey(SeedDetection record);

    List<SeedDetection> getSeedDetection(@Param("startTime")Date startTime,@Param("endTime")Date endTime,@Param("baseId")Integer baseId);

    SeedDetection selectBySeedBatchId(Integer seedBatchId);

}
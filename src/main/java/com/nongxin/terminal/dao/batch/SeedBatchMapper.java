package com.nongxin.terminal.dao.batch;

import com.nongxin.terminal.entity.batch.SeedBatch;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SeedBatchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SeedBatch record);

    int insertSelective(SeedBatch record);

    SeedBatch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SeedBatch record);

    int updateByPrimaryKey(SeedBatch record);

    List<SeedBatch> getSeedList(@Param("cropName")String cropName,@Param("supplier")String supplier);

    List<SeedBatch> getAllSeed(@Param("cropId") Integer cropId);

    SeedBatch getIdAndCodeById(Integer id);

    SeedBatch selectByRetroCode(String retroCode);

    List<Map<String,Object>> getSeedAndBatch(@Param("cropId") Integer cropId,@Param("condition") String condition);
}
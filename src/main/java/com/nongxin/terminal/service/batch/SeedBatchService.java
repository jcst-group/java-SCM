package com.nongxin.terminal.service.batch;

import com.nongxin.terminal.entity.batch.SeedBatch;

import java.util.List;
import java.util.Map;

public interface SeedBatchService {

    boolean add(SeedBatch seedBatch);

    boolean delete(Integer id);

    boolean update(SeedBatch seedBatch);

    List<SeedBatch> getSeedList(String cropName,String supplier);

    List<SeedBatch> getAllSeed(Integer cropId);

    //根据追溯码查询种子/种苗信息
    SeedBatch selectByRetroCode(String retroCode);

    //查询种子批次和种植批次
    List<Map<String,Object>> getSeedAndBatch(Integer cropId,String condition);

}

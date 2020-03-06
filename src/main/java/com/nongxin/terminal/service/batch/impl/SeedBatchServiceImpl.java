package com.nongxin.terminal.service.batch.impl;

import com.nongxin.terminal.dao.batch.SeedBatchMapper;
import com.nongxin.terminal.entity.batch.SeedBatch;
import com.nongxin.terminal.service.batch.SeedBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SeedBatchServiceImpl implements SeedBatchService {

    @Autowired(required = false)
    private SeedBatchMapper seedBatchMapper;

    @Override
    public boolean add(SeedBatch seedBatch) {
        return seedBatchMapper.insertSelective(seedBatch)==1;
    }

    @Override
    public boolean delete(Integer id) {
        return seedBatchMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(SeedBatch seedBatch) {
        return seedBatchMapper.updateByPrimaryKeySelective(seedBatch)==1;
    }

    @Override
    public List<SeedBatch> getSeedList(String cropName, String supplier) {
        return seedBatchMapper.getSeedList(cropName,supplier);
    }

    @Override
    public List<SeedBatch> getAllSeed(Integer cropId) {
        return seedBatchMapper.getAllSeed(cropId);
    }

    @Override
    public SeedBatch selectByRetroCode(String retroCode) {
        return seedBatchMapper.selectByRetroCode(retroCode);
    }

    @Override
    public List<Map<String, Object>> getSeedAndBatch(Integer cropId, String condition) {
        return seedBatchMapper.getSeedAndBatch(cropId,condition);
    }
}

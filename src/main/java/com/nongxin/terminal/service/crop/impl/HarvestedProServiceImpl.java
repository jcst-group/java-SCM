package com.nongxin.terminal.service.crop.impl;

import com.nongxin.terminal.dao.crop.HarvestedProductMapper;
import com.nongxin.terminal.entity.crop.HarvestedProduct;
import com.nongxin.terminal.service.crop.HarvestedProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarvestedProServiceImpl implements HarvestedProService {

    @Autowired(required = false)
    private HarvestedProductMapper harvestedProductMapper;

    @Override
    public List<HarvestedProduct> getHarvestedByCropId(Integer cropId) {
        return harvestedProductMapper.getHarvestedByCropId(cropId);
    }

    @Override
    public boolean delete(Integer id) {
        return harvestedProductMapper.deleteByPrimaryKey(id)==1;
    }
}

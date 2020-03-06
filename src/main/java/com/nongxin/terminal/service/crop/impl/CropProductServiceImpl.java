package com.nongxin.terminal.service.crop.impl;

import com.nongxin.terminal.dao.crop.CropProductMapper;
import com.nongxin.terminal.entity.crop.CropProduct;
import com.nongxin.terminal.service.crop.CropProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropProductServiceImpl implements CropProductService {

    @Autowired(required = false)
    private CropProductMapper cropProductMapper;

    @Override
    public List<CropProduct> getCropProductByHarvestedId(Integer harvestedId) {
        return cropProductMapper.getCropProductByHarvestedId(harvestedId);
    }
}

package com.nongxin.terminal.service.crop;

import com.nongxin.terminal.entity.crop.CropProduct;

import java.util.List;

public interface CropProductService {

    List<CropProduct> getCropProductByHarvestedId(Integer harvestedId);

}

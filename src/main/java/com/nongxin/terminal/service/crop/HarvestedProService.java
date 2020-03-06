package com.nongxin.terminal.service.crop;

import com.nongxin.terminal.entity.crop.HarvestedProduct;

import java.util.List;

public interface HarvestedProService {

    List<HarvestedProduct> getHarvestedByCropId(Integer cropId);

    boolean delete(Integer id);

}

package com.nongxin.terminal.service.finance;

import com.nongxin.terminal.entity.finance.FertilizerPurchase;

import java.util.List;
import java.util.Map;

public interface FertilizerPurchaseService {

    boolean add(FertilizerPurchase fertilizerPurchase);

    boolean delete(Integer id);

    boolean update(FertilizerPurchase fertilizerPurchase);

    List<FertilizerPurchase> getFertilizerPurchaseList(Integer yearId);

    //获取看板金融板块物料数据
    List<Map<String,Object>> getBoardFertilizerPurchase();

}

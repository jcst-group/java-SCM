package com.nongxin.terminal.service.finance;

import com.nongxin.terminal.entity.finance.PledgeGoods;

import java.util.List;
import java.util.Map;

public interface PledgeGoodsService {

    boolean add(PledgeGoods pledgeGoods);

    boolean delete(Integer id);

    boolean update(PledgeGoods pledgeGoods);

    List<PledgeGoods> getPledgeGoodsList(Integer yearId);

    //看板金融板块质押物权数据
    Map<String,Object> getBoardPledgeGoods(Integer baseId);

}

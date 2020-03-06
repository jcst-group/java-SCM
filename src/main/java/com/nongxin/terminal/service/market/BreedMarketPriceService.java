package com.nongxin.terminal.service.market;


import com.nongxin.terminal.dao.market.MarketPriceMapper;
import com.nongxin.terminal.entity.market.FromTypeEnum;
import com.nongxin.terminal.entity.market.MarketPrice;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Service
public class BreedMarketPriceService {

    @Autowired
    private MarketPriceMapper marketPriceDao;


    public List<MarketPrice>  queryMaidongPrice(Integer breedId,
                                                Integer fromType,
                                                Integer areaId,
                                                Integer specId,
                                                Integer dateType,
                                                Date startTime,
                                                Date endTime){
        List<MarketPrice> dataByParams = marketPriceDao.getDataByParams(breedId, fromType, areaId, specId, dateType, startTime, endTime);


        return dataByParams;
    }

}

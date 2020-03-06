package com.nongxin.terminal.controller.maket;

import com.nongxin.terminal.dao.market.MarketGoodMapper;
import com.nongxin.terminal.dao.market.MarketOrderMapper;
import com.nongxin.terminal.entity.market.FromTypeEnum;
import com.nongxin.terminal.entity.market.MarketGood;
import com.nongxin.terminal.entity.market.MarketOrder;
import com.nongxin.terminal.entity.market.MarketPrice;
import com.nongxin.terminal.service.market.BreedMarketPriceService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/market")
public class BreedMarketPriceController {

    @Autowired
    private BreedMarketPriceService bmpService;

    @Autowired
    private MarketOrderMapper orderDao;

    @Autowired
    private MarketGoodMapper goodDao;

    @GetMapping("/queryMaidong")
    @ApiOperation(value = "查询麦冬价格信息",notes = "")
    public Result  queryMaidongPrice(@RequestParam(defaultValue = "1") Integer breedId,
                                                  @RequestParam(defaultValue = "1") Integer fromType,
                                                  @RequestParam(defaultValue = "1") Integer areaId,
                                                  @RequestParam(defaultValue = "1") Integer specId,
                                                  @RequestParam(defaultValue = "1") Integer dateType,
                                                  Date startTime,
                                                  Date endTime
                                                  ){
        Result<List<MarketPrice>> result = new Result<>();
        if(endTime == null){
            endTime = new Date();
        }
        if(startTime == null){
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            if(dateType==1){
                c.add(Calendar.YEAR, -1);
            }else{
                c.add(Calendar.YEAR, -5);
            }
            startTime = c.getTime();
        }

        List<MarketPrice> marketPrices = bmpService.queryMaidongPrice(breedId, fromType, areaId, specId, dateType, startTime, endTime);


        if(marketPrices == null) {
            marketPrices = new ArrayList<>();
        }

        result.setSuccessResult(marketPrices);

        return result;
    }

    @GetMapping("/queryOrders")
    @ApiOperation(value = "查询麦冬订单信息",notes = "")
    public Result  queryOrders(){
        List<MarketOrder> marketOrders = orderDao.selectByExample(null);
        Result result = new Result<>();

        if(marketOrders == null) {
            marketOrders = new ArrayList<>();
        }
        result.setSuccessResult(marketOrders);
        return result;
    }

    @GetMapping("/queryGoods")
    @ApiOperation(value = "查询麦冬订单信息",notes = "")
    public Result  queryGoods(){
        List<MarketGood> marketGoods = goodDao.selectByExample(null);
        Result result = new Result<>();

        if(marketGoods == null) {
            marketGoods = new ArrayList<>();
        }
        result.setSuccessResult(marketGoods);
        return result;
    }
}

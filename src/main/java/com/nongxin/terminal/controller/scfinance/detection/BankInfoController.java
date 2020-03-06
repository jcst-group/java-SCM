package com.nongxin.terminal.controller.scfinance.detection;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nongxin.terminal.dao.scfinance.detection.FinanceCominfoMapper;
import com.nongxin.terminal.dao.scfinance.system.FinanceRoleResourceMapper;
import com.nongxin.terminal.service.scfinance.detection.IBankInfoService;
import com.nongxin.terminal.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author clover
 * @since 2019-12-10
 */
@RestController
@RequestMapping("/bank-info")
public class BankInfoController {

    @Autowired
    private IBankInfoService bankInfoService;

    @Autowired
    private FinanceRoleResourceMapper mapper;


    @Autowired
    private FinanceCominfoMapper cominfoMapper;


    private FinanceRoleResourceMapper financeRoleResourceMapper;

    @GetMapping("xx")
    public Result xx(){
        Result result = new Result();

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",5);
        result.setSuccessResult(cominfoMapper.queryFinanceCominfo(queryWrapper));

        return result;
    }

    @GetMapping("xx2")
    public Result xx2(){
        Result result = new Result();

        result.setSuccessResult(mapper.getFinanceResourceByUid(1,1));

        return result;
    }

}

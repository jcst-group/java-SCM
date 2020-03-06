package com.nongxin.terminal.controller.backstage.finance;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.finance.ContractYear;
import com.nongxin.terminal.service.finance.ContractYearService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contractYear")
public class ContractYearController {

    @Autowired
    private ContractYearService contractYearService;

    @GetMapping("/all")
    @ApiOperation(value = "查询合同年份")
    public Result getList(){
        Result result = new Result<>();
        result.setSuccessResult(contractYearService.getContractYear());
        return result;
    }

}

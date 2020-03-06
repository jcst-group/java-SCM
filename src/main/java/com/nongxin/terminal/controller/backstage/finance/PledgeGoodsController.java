package com.nongxin.terminal.controller.backstage.finance;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.finance.OrderContract;
import com.nongxin.terminal.entity.finance.PledgeGoods;
import com.nongxin.terminal.service.finance.OrderContractService;
import com.nongxin.terminal.service.finance.PledgeGoodsService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pledgeGoods")
public class PledgeGoodsController {

    @Autowired
    private PledgeGoodsService pledgeGoodsService;

    @PostMapping("/add")
    @ApiOperation("添加质押物权合同")
    public Result add(@Validated @RequestBody PledgeGoods pledgeGoods){
        Result result = new Result();
        boolean isSuccess = pledgeGoodsService.add(pledgeGoods);
        if (isSuccess){
            result.setMessage("添加质押物权合同成功");
        }else {
            result.setMessage("添加质押物权合同失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除质押物权合同")
    public Result delete(Integer id){
        Result result = new Result();
        boolean isSuccess = pledgeGoodsService.delete(id);
        if (isSuccess){
            result.setMessage("删除质押物权合同成功");
        }else {
            result.setMessage("删除质押物权合同失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改质押物权合同")
    public Result update(@RequestBody PledgeGoods pledgeGoods){
        Result result = new Result();
        boolean isSuccess = pledgeGoodsService.update(pledgeGoods);
        if (isSuccess){
            result.setMessage("修改质押物权合同成功");
        }else {
            result.setMessage("修改质押物权合同失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页查询质押物权合同")
    public Result<PageInfo> getList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                    @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                    Integer yearId){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<PledgeGoods> list = pledgeGoodsService.getPledgeGoodsList(yearId);
        PageInfo pageInfo = new PageInfo(list);
        result.setSuccessResult(pageInfo);
        return result;
    }

}

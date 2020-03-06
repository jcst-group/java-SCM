package com.nongxin.terminal.controller.backstage.crop;

import com.nongxin.terminal.entity.crop.HarvestedProduct;
import com.nongxin.terminal.service.crop.HarvestedProService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/harvestedPro")
public class HarvestedProController {

    @Autowired
    private HarvestedProService harvestedProService;

    @GetMapping("/getHarvestedByCropId")
    @ApiOperation("根据作物id查询采收物")
    public Result<List<HarvestedProduct>> getHarvestedByCropId(Integer cropId){
        Result<List<HarvestedProduct>> result = new Result<List<HarvestedProduct>>();
        result.setSuccessResult(harvestedProService.getHarvestedByCropId(cropId));
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除产成品")
    public Result deleteHarvested(Integer id){
        Result result = new Result();
        boolean isSuccess = harvestedProService.delete(id);
        if (isSuccess){
            result.setMessage("删除产成品成功");
        }else {
            result.setMessage("删除产成品失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

}

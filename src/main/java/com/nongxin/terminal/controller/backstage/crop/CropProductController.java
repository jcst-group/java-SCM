package com.nongxin.terminal.controller.backstage.crop;

import com.nongxin.terminal.entity.crop.CropProduct;
import com.nongxin.terminal.service.crop.CropProductService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cropPro")
public class CropProductController {

    @Autowired
    private CropProductService cropProductService;

    @GetMapping("/getCropProductByHarvestedId")
    @ApiOperation("根据采收品id查询产成品")
    public Result<List<CropProduct>> getCropProductByHarvestedId(Integer harvestedId){
        Result<List<CropProduct>> result = new Result<List<CropProduct>>();
        result.setSuccessResult(cropProductService.getCropProductByHarvestedId(harvestedId));
        return result;
    }

}

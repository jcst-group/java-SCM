package com.nongxin.terminal.controller.backstage.crop;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.crop.Crop;
import com.nongxin.terminal.service.crop.CropService;
import com.nongxin.terminal.util.CodeUtil;
import com.nongxin.terminal.util.enumUtil.common.CodeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crop")
public class CropController {

    @Autowired
    private CropService cropService;

    @PostMapping("/add")
    @ApiOperation("添加作物")
    public Result addCrop(@Validated @RequestBody Crop crop){
        Result result = new Result();
        crop.setCropCode(CodeUtil.getCode(CodeEnum.CROP));
        boolean isSuccess = cropService.add(crop);
        if (isSuccess){
            result.setMessage("添加作物成功");
        }else {
            result.setMessage("添加作物失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除作物")
    public Result deleteCrop(Integer id){
        Result result = new Result();
        boolean isSuccess = cropService.delete(id);
        if (isSuccess){
            result.setMessage("删除作物成功");
        }else {
            result.setMessage("删除作物失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改作物")
    public Result updateCrop(@RequestBody Crop crop){
        Result result = new Result();
        boolean isSuccess = cropService.update(crop);
        if (isSuccess){
            result.setMessage("修改作物成功");
        }else {
            result.setMessage("修改作物失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询作物")
    public Result<PageInfo> getCropList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                        @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<Crop> lotList = cropService.getCropList();
        PageInfo pageInfo = new PageInfo(lotList);
        result.setSuccessResult(pageInfo);
        return result;
    }

    @GetMapping("/all")
    @ApiOperation("获取所有作物作物")
    public Result getAllCropList(){
        Result result = new Result();
        result.setSuccessResult(cropService.getAllCropList());
        return result;
    }

    @GetMapping("/getIdAndNameById")
    @ApiOperation("根据作物id获取作物")
    public Result getIdAndNameById(Integer id){
        Result result = new Result();
        result.setSuccessResult(cropService.getIdAndNameById(id));
        return result;
    }

}

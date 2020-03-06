package com.nongxin.terminal.controller.backstage.company;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.company.Fertilizers;
import com.nongxin.terminal.service.company.FertilizersService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fertilizers")
public class FertilizersController {

    @Autowired
    private FertilizersService fertilizersService;

    @PostMapping("/insert")
    @ApiOperation(value="添加用肥情况", notes = "POST添加用肥情况")
    public Result<Fertilizers> insert(@RequestBody Fertilizers fertilizers){
        Result<Fertilizers> result = new Result<>();
        boolean isInsertSuccess = fertilizersService.insertSelective(fertilizers);
        if(isInsertSuccess){
            result.setMessage("添加成功");
        }else{
            result.setMessage("添加失败");
        }
        result.setSuccess(isInsertSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation(value="修改用肥情况", notes = "POST修改用肥情况")
    public Result<Fertilizers> updateCompanyInfo(@RequestBody Fertilizers fertilizers){
        Result<Fertilizers> result = new Result<>();
        boolean isUpdateSuccess = fertilizersService.updateByPrimaryKeySelective(fertilizers);
        if(isUpdateSuccess){
            result.setMessage("修改成功");
        }else{
            result.setMessage("修改失败");
        }
        result.setSuccess(isUpdateSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation(value="删除数据", notes = "GET删除用肥情况数据")
    public Result<Fertilizers> delete(Integer id){
        Result<Fertilizers> result = new Result<>();
        boolean isDelSuccess = fertilizersService.deleteByPrimaryKey(id);
        if(isDelSuccess){
            result.setMessage("删除成功");
        }else{
            result.setMessage("删除失败");
        }
        result.setSuccess(isDelSuccess);
        return result;
    }

    @GetMapping("/getFatById")
    @ApiOperation(value="查询用肥情况数据", notes = "GET根据id查询用肥情况数据")
    public Result<Fertilizers> getFertilizersById(Integer id){
        Result<Fertilizers> result = new Result<>();
        Fertilizers fertilizers = fertilizersService.selectByPrimaryKey(id);
        result.setResult(fertilizers);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询用肥情况",notes = "GET分页模糊查询用肥情况")
    public Result<PageInfo> getCompanyList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                           @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                            Fertilizers fertilizers){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<Fertilizers> list = fertilizersService.getFertilizersList(fertilizers);
        if(list!=null){
            PageInfo pageInfo = new PageInfo(list);
            result.setResult(pageInfo);
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }


}

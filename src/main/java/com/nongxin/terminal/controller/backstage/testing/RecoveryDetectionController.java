package com.nongxin.terminal.controller.backstage.testing;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.entity.testing.RecoveryDetection;
import com.nongxin.terminal.entity.testing.SeedDetection;
import com.nongxin.terminal.service.system.UserService;
import com.nongxin.terminal.service.testing.RecoveryDetectionService;
import com.nongxin.terminal.service.testing.SeedDetectionService;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.constant.DefContants;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/recoveryDetection")
public class RecoveryDetectionController {

    @Autowired
    private RecoveryDetectionService recoveryDetectionService;

    @PostMapping("/add")
    @ApiOperation("添加采收检测")
    public Result addRecoveryDetection(@Validated @RequestBody RecoveryDetection recoveryDetection){
        Result result = new Result();
        boolean isSuccess = recoveryDetectionService.add(recoveryDetection);
        if (isSuccess){
            result.setMessage("添加采收检测成功");
        }else {
            result.setMessage("添加采收检测失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除采收检测")
    public Result deleteRecoveryDetection(Integer id){
        Result result = new Result();
        boolean isSuccess = recoveryDetectionService.delete(id);
        if (isSuccess){
            result.setMessage("删除采收检测成功");
        }else {
            result.setMessage("删除采收检测失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改采收检测")
    public Result updateRecoveryDetection(@RequestBody RecoveryDetection recoveryDetection){
        Result result = new Result();
        boolean isSuccess = recoveryDetectionService.update(recoveryDetection);
        if (isSuccess){
            result.setMessage("修改采收检测成功");
        }else {
            result.setMessage("修改采收检测失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询采收检测")
    public Result<PageInfo> getRecoveryDetection(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                                 Integer planId,Date startTime,Date endTime){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<RecoveryDetection> recoveryDetectionList = recoveryDetectionService.getRecoveryDetection(planId,startTime,endTime);
        PageInfo pageInfo = new PageInfo(recoveryDetectionList);
        result.setSuccessResult(pageInfo);
        return result;
    }

}

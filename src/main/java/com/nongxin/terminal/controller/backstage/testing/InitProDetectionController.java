package com.nongxin.terminal.controller.backstage.testing;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.entity.testing.InitproDetection;
import com.nongxin.terminal.service.system.UserService;
import com.nongxin.terminal.service.testing.InitProDetectionService;
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
@RequestMapping("/initProDetectio")
public class InitProDetectionController {

    @Autowired
    private InitProDetectionService initProDetectionService;
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @ApiOperation("添加初加工检测")
    public Result addRecoveryDetection(@Validated @RequestBody InitproDetection initproDetection, HttpServletRequest request){
        Result result = new Result();
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);
        User user = userService.getUserByUserName(username,null);
        initproDetection.setUserId(user.getUid());
        boolean isSuccess = initProDetectionService.add(initproDetection);
        if (isSuccess){
            result.setMessage("添加初加工检测成功");
        }else {
            result.setMessage("添加初加工检测失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除初加工检测")
    public Result deleteRecoveryDetection(Integer id){
        Result result = new Result();
        boolean isSuccess = initProDetectionService.delete(id);
        if (isSuccess){
            result.setMessage("删除初加工检测成功");
        }else {
            result.setMessage("删除初加工检测失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改初加工检测")
    public Result updateRecoveryDetection(@RequestBody InitproDetection initproDetection){
        Result result = new Result();
        boolean isSuccess = initProDetectionService.update(initproDetection);
        if (isSuccess){
            result.setMessage("修改初加工检测成功");
        }else {
            result.setMessage("修改初加工检测失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询初加工检测")
    public Result<PageInfo> getInitproDetection(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                                 Integer planId,Date startTime,Date endTime){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<InitproDetection> initproDetectionList = initProDetectionService.getInitproDetection(planId,startTime,endTime);
        PageInfo pageInfo = new PageInfo(initproDetectionList);
        result.setSuccessResult(pageInfo);
        return result;
    }

}

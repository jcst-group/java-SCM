package com.nongxin.terminal.controller.app.batch;

import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.service.crop.CropBatchService;
import com.nongxin.terminal.service.system.UserService;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.constant.DefContants;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/app/batch")
public class AppBatchController {

    @Autowired
    private CropBatchService cropBatchService;
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @ApiOperation("获取所有批次，用于下拉列表选择")
    public Result getAllCropBatch(){
        Result result = new Result();
        result.setSuccessResult(cropBatchService.getAllCropBatch(null,null,null));
        return result;
    }

    @GetMapping("/getBatchByUid")
    @ApiOperation("根据用户id查询批次")
    public Result getBatchByPlanId(HttpServletRequest request){
        Result result = new Result();
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        String username = JwtUtil.getUsername(token);
        User user = userService.getUserAndRoleByUserName(username);
        result.setSuccessResult(cropBatchService.getBatchByUid(user.getUid()));
        return result;
    }

}

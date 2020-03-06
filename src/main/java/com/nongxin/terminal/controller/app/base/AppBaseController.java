package com.nongxin.terminal.controller.app.base;

import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.service.base.BaseInfoService;
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
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app/base")
public class AppBaseController {

    @Autowired
    private BaseInfoService baseInfoService;
    @Autowired
    private UserService userService;


    @GetMapping("/getBaseByUid")
    @ApiOperation("根据用户id查询对应基地")
    public Result<List<Map<String,Object>>> getBaseByUid(HttpServletRequest request){
        Result result = new Result();
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        String username = JwtUtil.getUsername(token);
        User user = userService.getUserAndRoleByUserName(username);
        result.setSuccessResult(baseInfoService.getBaseByUid(user.getUid()));
        return result;
    }

    @GetMapping("/getBaseTreeByUid")
    @ApiOperation("查询用户对应基地以及批次")
    public Result getBaseTreeByUid(HttpServletRequest request){
        Result result = new Result();
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        String username = JwtUtil.getUsername(token);
        User user = userService.getUserAndRoleByUserName(username);
        result.setSuccessResult(baseInfoService.getBaseTreeByUid(user.getUid()));
        return result;
    }

    @GetMapping("/getBaseByUidAndEqui")
    @ApiOperation("根据用户id查询对应且有设备的基地")
    public Result<List<Map<String,Object>>> getBaseByUidAndEqui(HttpServletRequest request){
        Result result = new Result();
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        String username = JwtUtil.getUsername(token);
        User user = userService.getUserAndRoleByUserName(username);
        result.setSuccessResult(baseInfoService.getBaseByUidAndEqui(user.getUid()));
        return result;
    }

}

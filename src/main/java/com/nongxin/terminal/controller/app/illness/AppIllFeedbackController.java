package com.nongxin.terminal.controller.app.illness;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.illness.IllFeedback;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.service.illness.IllFeedbackService;
import com.nongxin.terminal.service.system.UserService;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.util.enumUtil.illness.IllFeedbackStatusEnum;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.constant.DefContants;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/app/illFeedback")
public class AppIllFeedbackController {

    @Autowired
    private IllFeedbackService illFeedbackService;
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @ApiOperation("添加病虫害反馈")
    public Result addIllFeedback(@Validated @RequestBody IllFeedback illFeedback,HttpServletRequest request){
        Result result = new Result();
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        String username = JwtUtil.getUsername(token);
        User user = userService.getUserAndRoleByUserName(username);
        illFeedback.setStatus(IllFeedbackStatusEnum.UNTREATED);
        illFeedback.setUserId(user.getUid());
        boolean isSuccess = illFeedbackService.add(illFeedback);
        if (isSuccess){
            result.setMessage("添加病虫害反馈成功");
        }else {
            result.setMessage("添加病虫害反馈失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation("查询病虫害反馈")
    public Result addIllFeedback(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                 @RequestParam(name = "pageSize" ,defaultValue = "5") Integer pageSize,
                                 HttpServletRequest request, Integer baseId){
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        String username = JwtUtil.getUsername(token);
        User user = userService.getUserAndRoleByUserName(username);
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<IllFeedback> list = illFeedbackService.getUserIllFeedback(user.getUid(),baseId);
        PageInfo pageInfo = new PageInfo(list);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

}

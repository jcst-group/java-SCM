package com.nongxin.terminal.controller.backstage.testing;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.entity.testing.SeedDetection;
import com.nongxin.terminal.service.system.UserService;
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
@RequestMapping("/seedDetection")
public class SeedDetectionController {

    @Autowired
    private SeedDetectionService seedDetectionService;
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @ApiOperation("添加种子/种苗检测")
    public Result addSeedDetection(@Validated @RequestBody SeedDetection seedDetection, HttpServletRequest request){
        Result result = new Result();
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);
        User user = userService.getUserByUserName(username,null);
        seedDetection.setUserId(user.getUid());
        boolean isSuccess = seedDetectionService.add(seedDetection);
        if (isSuccess){
            result.setMessage("添加种子/种苗检测成功");
        }else {
            result.setMessage("添加种子/种苗检测失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除种子/种苗检测")
    public Result deleteSeedDetection(Integer id){
        Result result = new Result();
        boolean isSuccess = seedDetectionService.delete(id);
        if (isSuccess){
            result.setMessage("删除种子/种苗检测成功");
        }else {
            result.setMessage("删除种子/种苗检测失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改种子/种苗检测")
    public Result updateSeedDetection(@RequestBody SeedDetection seedDetection){
        Result result = new Result();
        boolean isSuccess = seedDetectionService.update(seedDetection);
        if (isSuccess){
            result.setMessage("修改种子/种苗检测成功");
        }else {
            result.setMessage("修改种子/种苗检测失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询种子/种苗检测")
    public Result<PageInfo> getSeedDetection(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                                Date startTime,Date endTime,Integer baseId){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<SeedDetection> plantingPlanList = seedDetectionService.getSeedDetection(startTime,endTime,baseId);
        PageInfo pageInfo = new PageInfo(plantingPlanList);
        result.setSuccessResult(pageInfo);
        return result;
    }

}

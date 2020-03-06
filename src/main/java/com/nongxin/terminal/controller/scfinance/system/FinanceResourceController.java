package com.nongxin.terminal.controller.scfinance.system;

import com.nongxin.terminal.entity.scfinance.system.FinanceUser;
import com.nongxin.terminal.service.scfinance.system.impl.FinanceRoleServiceImpl;
import com.nongxin.terminal.service.scfinance.system.impl.FinanceUserRoleServiceImpl;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/finance/role")
public class FinanceResourceController {

    @Autowired
    private FinanceRoleServiceImpl roleService;

    @Autowired
    private FinanceUserRoleServiceImpl financeUserRoleService;

    @GetMapping("/all")
    @ApiOperation("查询所有角色")
    public Result getAllRole(){
        Result result = new Result();
        result.setSuccessResult(roleService.list());
        return result;
    }
    @PostMapping("/addRoleToUser")
    @ApiOperation("保存用户角色")
    public Result addRoleToUser(@RequestBody  FinanceUser financeUser){
        Result result = new Result();
        boolean b = financeUserRoleService.addRoleToUser(financeUser);
        if(b){
            result.setSuccessResult("保存用户角色成功");
        }else{
            result.setMessage("保存失败");
        }

        return result;
    }

}

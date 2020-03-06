package com.nongxin.terminal.controller.backstage.envmonitor;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.dao.envmonitor.MonitorLackMapper;
import com.nongxin.terminal.entity.envmonitor.MonitorLack;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/monitorLack")
public class MonitorLackController {

    @Autowired
    private MonitorLackMapper monitorLackDao;

    @GetMapping("/list")
    @ApiOperation(value = "查询数据缺失内容")
    public Result<PageInfo> getList(@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                    @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
                                    Integer equipmentId, Integer baseId, Date startTime, Date endTime){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<MonitorLack> list = monitorLackDao.getList(equipmentId,baseId,startTime,endTime);
        PageInfo pageInfo = new PageInfo(list);
        result.setSuccessResult(pageInfo);
        return result;
    }
}

package com.nongxin.terminal.controller.backstage.envmonitor;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.envmonitor.WarnRecord;
import com.nongxin.terminal.service.envmonitor.WarnRecordService;
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
@RequestMapping("/warnRecord")
public class WarnRecordController {

    @Autowired
    private WarnRecordService warnRecordService;

    @GetMapping("/getWarnRecord")
    @ApiOperation(value = "获取预警记录信息")
    public Result<PageInfo> getWarnRecord(@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                          @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
                                          Integer equipmentId, Integer baseId, Date startTime, Date endTime){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<WarnRecord> recordList = warnRecordService.getRecordList(equipmentId,baseId,startTime,endTime);
        PageInfo pageInfo = new PageInfo(recordList);
        result.setSuccessResult(pageInfo);
        return result;
    }
}

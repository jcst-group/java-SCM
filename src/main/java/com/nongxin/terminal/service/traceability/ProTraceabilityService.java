package com.nongxin.terminal.service.traceability;

import com.nongxin.terminal.entity.traceability.ProTraceability;
import com.nongxin.terminal.vo.traceability.PictureVo;

import java.util.Map;

public interface ProTraceabilityService {

    Object selectByBatchId(Integer batchId);

    boolean add(ProTraceability proTraceability);

    Map<String,Object> getBatchAndBase(Integer batchId);

    //根据追溯码查询产品信息
    Object selectByRetroCode(String retroCode);

    //根据追溯码查询批次和基地信息
    Map<String,Object> getBatchAndBaseByRetroCode(String retroCode);

    //获取溯源相关检测图片
    PictureVo getDetectionPicByBatchId(Integer batchId);

}

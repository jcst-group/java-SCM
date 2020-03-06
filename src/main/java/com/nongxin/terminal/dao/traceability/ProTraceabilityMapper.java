package com.nongxin.terminal.dao.traceability;

import com.nongxin.terminal.entity.traceability.ProTraceability;
import com.nongxin.terminal.vo.traceability.PictureVo;

import java.util.Map;

public interface ProTraceabilityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProTraceability record);

    int insertSelective(ProTraceability record);

    ProTraceability selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProTraceability record);

    int updateByPrimaryKey(ProTraceability record);

    ProTraceability selectByBatchId(Integer batchId);

    Map<String,Object> getBatchAndBase(Integer batchId);

    ProTraceability selectByRetroCode(String retroCode);

    Map<String,Object> getBatchAndBaseByRetroCode(String retroCode);

    //获取溯源相关检测图片
    PictureVo getDetectionPicByBatchId(Integer batchId);
}
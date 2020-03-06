package com.nongxin.terminal.service.retrospective;

import com.nongxin.terminal.entity.retrospective.RetroCoding;
import com.nongxin.terminal.util.enumUtil.retrospective.RetroCodingTypeEnum;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.traceability.PictureVo;

import java.util.List;
import java.util.Map;

public interface RetroCodingService {

    Result add(RetroCoding retroCoding);

    List<RetroCoding> getRetroCoding(RetroCodingTypeEnum type,String relationCode, String retroCode);

    //根据追溯码批次类型查询批次（采收或初加工）
    List<Map<String,Object>> getBatchByType(RetroCodingTypeEnum type,String conditio);

    Object getResidualOutput(Integer id,RetroCodingTypeEnum type);

    //根据追溯码查询追溯码相关图片
    PictureVo getRetroPic(String retroCode);

    List<Map<String,Object>> getRetroByRetroCode(String relationCode,RetroCodingTypeEnum type);

}

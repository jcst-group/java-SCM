package com.nongxin.terminal.dao.retrospective;

import com.nongxin.terminal.entity.retrospective.RetroCoding;
import com.nongxin.terminal.util.enumUtil.retrospective.RetroCodingTypeEnum;
import com.nongxin.terminal.vo.retrospective.RetroCodeVo;
import com.nongxin.terminal.vo.traceability.PictureVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RetroCodingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RetroCoding record);

    int insertSelective(RetroCoding record);

    RetroCoding selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RetroCoding record);

    int updateByPrimaryKey(RetroCoding record);

    List<RetroCoding> getRetroCoding(@Param("type") RetroCodingTypeEnum type, @Param("relationCode")String relationCode, @Param("retroCode")String retroCode);

    PictureVo getRetroPic(String retroCode);

    List<Map<String,Object>> getRetroByRetroCode(@Param("relationCode") String relationCode,@Param("type") RetroCodingTypeEnum type);

}
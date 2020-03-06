package com.nongxin.terminal.dao.testing;

import com.nongxin.terminal.util.enumUtil.test.DetectionCategoryEnum;
import com.nongxin.terminal.entity.testing.DetectionRel;
import com.nongxin.terminal.util.enumUtil.test.DetectionStageEnum;
import com.nongxin.terminal.vo.detection.DetectionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DetectionRelMapper {
    int insert(DetectionRel record);

    int insertSelective(DetectionRel record);

    int deleteByRelation(@Param("relationId") Integer relationId, @Param("type") DetectionStageEnum type);

    List<DetectionVo> getSeedDetectionVo(Integer relationId);

    List<DetectionVo> getRecoveryDetectionVo(Integer relationId);

    List<DetectionVo> getInitProDetectionVo(Integer relationId);

    List<Map<String,Object>> getDetectionByRelationId(@Param("relationId")Integer relationId,@Param("type")DetectionStageEnum type, @Param("category")DetectionCategoryEnum category);

}
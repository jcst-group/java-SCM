package com.nongxin.terminal.dao.testing;

import com.nongxin.terminal.entity.testing.DetectionItems;
import com.nongxin.terminal.util.enumUtil.test.DetectionStageEnum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DetectionItemsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DetectionItems record);

    int insertSelective(DetectionItems record);

    DetectionItems selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DetectionItems record);

    int updateByPrimaryKey(DetectionItems record);

    List<DetectionItems> getDetectionItemsList(@Param("stage") DetectionStageEnum stage, @Param("cropId") Integer cropId);

    List<DetectionItems> selectByStage(@Param("stage") DetectionStageEnum stage,@Param("cropId")Integer cropId);

}
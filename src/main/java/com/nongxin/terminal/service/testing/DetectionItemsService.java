package com.nongxin.terminal.service.testing;

import com.nongxin.terminal.util.enumUtil.test.DetectionCategoryEnum;
import com.nongxin.terminal.entity.testing.DetectionItems;
import com.nongxin.terminal.util.enumUtil.test.DetectionStageEnum;

import java.util.List;
import java.util.Map;

public interface DetectionItemsService {

    boolean add(DetectionItems detectionItems);

    boolean delete(Integer id);

    boolean update(DetectionItems detectionItems);

    List<DetectionItems> getDetectionItemsList(DetectionStageEnum stage, Integer cropId);

    List<DetectionItems> selectByStage(DetectionStageEnum stage,Integer cropId);

    //获取追溯码种子/种苗检测数据
    List<Map<String,Object>> getDetectionByRelationId(Integer relationId,DetectionStageEnum type,DetectionCategoryEnum category);
}

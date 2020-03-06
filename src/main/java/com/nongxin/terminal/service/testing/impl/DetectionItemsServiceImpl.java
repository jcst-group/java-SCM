package com.nongxin.terminal.service.testing.impl;

import com.nongxin.terminal.dao.common.UnitMapper;
import com.nongxin.terminal.dao.testing.DetectionItemsMapper;
import com.nongxin.terminal.dao.testing.DetectionRelMapper;
import com.nongxin.terminal.entity.common.Unit;
import com.nongxin.terminal.util.enumUtil.test.DetectionCategoryEnum;
import com.nongxin.terminal.entity.testing.DetectionItems;
import com.nongxin.terminal.util.enumUtil.test.DetectionStageEnum;
import com.nongxin.terminal.service.testing.DetectionItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class DetectionItemsServiceImpl implements DetectionItemsService {

    @Autowired(required = false)
    private DetectionItemsMapper detectionItemsMapper;
    @Autowired(required = false)
    private DetectionRelMapper detectionRelMapper;
    @Autowired(required = false)
    private UnitMapper unitMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(DetectionItems detectionItems) {
        Unit unit = unitMapper.selectByDisplayName(detectionItems.getUnit().getDisplayName());
        if (unit == null){
            unit = new Unit();
            unit.setDisplayName(detectionItems.getUnit().getDisplayName());
            unitMapper.insertSelective(unit);
        }
        detectionItems.setUnit(unit);
        return detectionItemsMapper.insertSelective(detectionItems)==1;
    }

    @Override
    public boolean delete(Integer id) {
        return detectionItemsMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(DetectionItems detectionItems) {
        Unit unit = unitMapper.selectByDisplayName(detectionItems.getUnit().getDisplayName());
        if (unit == null){
            unit = new Unit();
            unit.setDisplayName(detectionItems.getUnit().getDisplayName());
            unitMapper.insertSelective(unit);
        }
        detectionItems.setUnit(unit);
        return detectionItemsMapper.updateByPrimaryKeySelective(detectionItems)==1;
    }

    @Override
    public List<DetectionItems> getDetectionItemsList(DetectionStageEnum stage, Integer cropId) {
        return detectionItemsMapper.getDetectionItemsList(stage,cropId);
    }

    @Override
    public List<DetectionItems> selectByStage(DetectionStageEnum stage,Integer cropId) {
        return detectionItemsMapper.selectByStage(stage,cropId);
    }

    @Override
    public List<Map<String, Object>> getDetectionByRelationId(Integer relationId,DetectionStageEnum type ,DetectionCategoryEnum category) {
        return detectionRelMapper.getDetectionByRelationId(relationId,type,category);
    }
}

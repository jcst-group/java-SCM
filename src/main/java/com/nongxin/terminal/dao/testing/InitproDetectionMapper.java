package com.nongxin.terminal.dao.testing;

import com.nongxin.terminal.entity.testing.InitproDetection;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface InitproDetectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InitproDetection record);

    int insertSelective(InitproDetection record);

    InitproDetection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InitproDetection record);

    int updateByPrimaryKey(InitproDetection record);

    List<InitproDetection> getInitproDetection(@Param("planId")Integer planId, @Param("startTime") Date startTime, @Param("endTime")Date endTime);

    String getInitDetectionPic(@Param("batchId")Integer batchId);
}
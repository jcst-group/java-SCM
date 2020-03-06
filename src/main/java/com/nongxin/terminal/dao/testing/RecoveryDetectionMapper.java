package com.nongxin.terminal.dao.testing;

import com.nongxin.terminal.entity.testing.RecoveryDetection;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface RecoveryDetectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecoveryDetection record);

    int insertSelective(RecoveryDetection record);

    RecoveryDetection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecoveryDetection record);

    int updateByPrimaryKey(RecoveryDetection record);

    List<RecoveryDetection> getRecoveryDetection(@Param("planId")Integer planId,@Param("startTime") Date startTime, @Param("endTime")Date endTime);
}
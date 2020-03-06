package com.nongxin.terminal.dao.envmonitor;

import com.nongxin.terminal.entity.envmonitor.WarnRecord;
import com.nongxin.terminal.vo.app.AppEnvRecordVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface WarnRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WarnRecord record);

    int insertSelective(WarnRecord record);

    WarnRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WarnRecord record);

    int updateByPrimaryKey(WarnRecord record);

    List<WarnRecord> getWarnRecordByTime(Integer typeId, Integer baseId);

    List<AppEnvRecordVo> getRecordByTime(Date time);

    List<WarnRecord> getRecordList(Integer equipmentId, Integer baseId, Date startTime, Date endTime);
}
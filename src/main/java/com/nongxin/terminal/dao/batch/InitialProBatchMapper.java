package com.nongxin.terminal.dao.batch;

import com.nongxin.terminal.entity.batch.InitialProBatch;
import com.nongxin.terminal.vo.initPro.InitProVo;
import com.nongxin.terminal.vo.initPro.RetroInitPro;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface InitialProBatchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InitialProBatch record);

    int insertSelective(InitialProBatch record);

    InitialProBatch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InitialProBatch record);

    int updateByPrimaryKey(InitialProBatch record);

    List<InitialProBatch> selectProBatchs(@Param("planId")Integer planId, @Param("startTime") Date startTime, @Param("endTime")Date endTime,@Param("recoveryId")Integer recoveryId);

    //根据初加工检测查询初加工批次
    List<InitProVo> getInitProVoByDetectionId(Integer detectionId);

    //根据种植计划查询初加工批次
    List<InitProVo> getInitProVoByPlanId(Integer planId);

    //查询采收批次，若剩余产量为0，则不展示
    List<Map<String, Object>> getInitialProByOutput(@Param("condition") String condition);

    //根据id获取剩余产量
    InitialProBatch getResidualOutput(Integer id);

    //根据追溯码查询初加工
    RetroInitPro selectByRetroCode(String retroCode);
}
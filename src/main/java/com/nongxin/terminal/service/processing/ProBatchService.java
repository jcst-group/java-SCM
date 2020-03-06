package com.nongxin.terminal.service.processing;

import com.nongxin.terminal.entity.batch.InitialProBatch;
import com.nongxin.terminal.vo.initPro.InitProVo;
import com.nongxin.terminal.vo.initPro.RetroInitPro;

import java.util.Date;
import java.util.List;

public interface ProBatchService {

    boolean add(InitialProBatch proBatch);

    boolean delete(Integer id);

    boolean update(InitialProBatch proBatch);

    List<InitialProBatch> selectProBatchs(Integer planId, Date startTime, Date endTime,Integer recoveryId);

    //根据种植计划查询初加工批次
    List<InitProVo> getInitProVoByPlanId(Integer planId);

    //根据追溯码查询初加工
    RetroInitPro selectByRetroCode(String retroCode);
}

package com.nongxin.terminal.dao.envmonitor;

import com.nongxin.terminal.entity.envmonitor.EnvMonitor;
import com.nongxin.terminal.vo.app.AppNorEnvMonitor;
import com.nongxin.terminal.vo.app.EnvDayAvg;
import com.nongxin.terminal.vo.zishan.MonitorVo;
import com.nongxin.terminal.vo.zishan.RainVo;
import com.nongxin.terminal.vo.zishan.WsdVo;

import java.util.Date;
import java.util.List;

public interface EnvMonitorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvMonitor record);

    int insertSelective(EnvMonitor record);

    EnvMonitor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvMonitor record);

    int updateByPrimaryKey(EnvMonitor record);

    List<EnvMonitor> selectByEquipIdAndMeasureTime(EnvMonitor record);

    List<EnvMonitor> getLastMonitor();

    List<EnvMonitor> getLastMonitor2(Integer equipmentId);

    List<EnvMonitor> getEnvMonitorList(Integer equipmentId,Integer baseId, Date startTime,Date endTime);

    List<EnvMonitor> getEnvChart(Integer equipmentId,Integer baseId, Date startTime,Date endTime);
    //App环控中心
    List<EnvMonitor> getTodayEnv(Integer baseId);

    //根据设备表id
    EnvDayAvg getEnvMonitorByEveryDayAvg(Integer equipmentId);

    //返回给预警信息中的正常值
    AppNorEnvMonitor getEnvInfo(Integer baseId,String time);

    //统计时间段的数据量
    int getCount(Integer equipmentId, String startTime, String endTime);

    List<MonitorVo> getAtmosphereData(Integer type, Integer equipmentId);

    List<MonitorVo> getSoilData(Integer type,Integer equipmentId);

    RainVo getRainData(Integer equipmentId);

    //日
    List<String> getRainDataDay(Integer equipmentId);

    //月
    List<String> getRainDataMonth(Integer equipmentId);

    //年
    List<String> getRainDataYear(Integer equipmentId);

    List<WsdVo> getWSpeedDay(Integer equipmentId);

    List<WsdVo> getWSpeedMonth(Integer equipmentId);

    List<WsdVo> getWSpeedYear(Integer equipmentId);
}
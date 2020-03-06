package com.nongxin.terminal.schedule;

import com.nongxin.terminal.dao.envmonitor.EnvMonitorDayAvgMapper;
import com.nongxin.terminal.dao.envmonitor.EnvMonitorMapper;
import com.nongxin.terminal.dao.envmonitor.EquipmentMapper;
import com.nongxin.terminal.entity.envmonitor.EnvMonitorDayAvg;
import com.nongxin.terminal.entity.envmonitor.Equipment;
import com.nongxin.terminal.vo.app.EnvDayAvg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Configuration
@EnableScheduling
public class EnvMonitorDayTask {

    @Autowired
    private EquipmentMapper equipmentDao;

    @Autowired
    private EnvMonitorMapper envMonitorDao;

    @Autowired
    private EnvMonitorDayAvgMapper envMonitorDayAvgDao;

    /**
     * 每天23点58分统计当天的采集数据平均值
     */
    @Scheduled(cron = "0 58 23 * * ?")
    private void configure(){
        List<Equipment> equipments = equipmentDao.getEquipmentList(new Equipment());
        for(int i=0; i< equipments.size();i++){
            Integer id = equipments.get(i).getId();  //设备表的id
            EnvDayAvg envDayAvg = envMonitorDao.getEnvMonitorByEveryDayAvg(id);//取得当天的均值
            if(envDayAvg!=null) {
                EnvMonitorDayAvg envMonitorDayAvg = new EnvMonitorDayAvg();
                envMonitorDayAvg.setAvgAirTemperature(envDayAvg.getAirTemperatureAvg());
                envMonitorDayAvg.setAvgAirHumidity(envDayAvg.getAirHumidityAvg());
                envMonitorDayAvg.setAvgAirPressure(envDayAvg.getAirPressureAvg());
                envMonitorDayAvg.setAvgWindSpeed(envDayAvg.getWindSpeedAvg());
                envMonitorDayAvg.setAvgWindDirection(envDayAvg.getWindDirectionAvg());
                envMonitorDayAvg.setAvgRainfall(envDayAvg.getRainfallAvg());
                envMonitorDayAvg.setAvgIllIntensity(envDayAvg.getIllIntensityAvg());
                envMonitorDayAvg.setAvgCo2Value(envDayAvg.getCo2ValueAvg());
                envMonitorDayAvg.setAvgPm25Value(envDayAvg.getPm25ValueAvg());
                envMonitorDayAvg.setAvgPm10Value(envDayAvg.getPm10ValueAvg());
                envMonitorDayAvg.setAvgSoilTemperature(envDayAvg.getSoilTemperatureAvg());
                envMonitorDayAvg.setAvgSoilHumidity(envDayAvg.getSoilHumidityAvg());
                envMonitorDayAvg.setAvgSoilPh(envDayAvg.getSoilPhAvg());
                envMonitorDayAvg.setAvgSoilEc(envDayAvg.getSoilEcAvg());
                envMonitorDayAvg.setAvgSoilS(envDayAvg.getSoilSAvg());
                envMonitorDayAvg.setEquipmentId(id);
                envMonitorDayAvg.setFactoryId(equipmentDao.getFactoryId(id));
                envMonitorDayAvgDao.insertSelective(envMonitorDayAvg);
            }
        }
    }
}

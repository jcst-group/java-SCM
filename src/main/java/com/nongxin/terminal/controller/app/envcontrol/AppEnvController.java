package com.nongxin.terminal.controller.app.envcontrol;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.dao.envmonitor.EnvMonitorMapper;
import com.nongxin.terminal.entity.envmonitor.EnvMonitor;
import com.nongxin.terminal.entity.envmonitor.WarnRecord;
import com.nongxin.terminal.service.envmonitor.EnvDayAvgService;
import com.nongxin.terminal.service.envmonitor.EnvMonitorService;
import com.nongxin.terminal.service.envmonitor.WarnRecordService;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.app.AppEnvRecordVo;
import com.nongxin.terminal.vo.app.AppEnvVo;
import com.nongxin.terminal.vo.app.AppNorEnvMonitor;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/app/env")
public class AppEnvController {

    @Autowired
    private EnvMonitorService envMonitorService;

    @Autowired
    private EnvDayAvgService envDayAvgService;

    @Autowired
    private WarnRecordService warnRecordService;

    @Autowired
    private EnvMonitorMapper envMonitorDao;

    @GetMapping("/getTodayEnv")
    @ApiOperation(value = "查询本月(3)，本周(2)，当天(1)环境监测数据")
    public Result<AppEnvVo> getTodayEnv(Integer typeId,Integer baseId){
        Result<AppEnvVo> result = new Result<>();

        List<EnvMonitor> envMonitorList = null;  // 从数据库取得相应（本月，周，天）数据
        if(typeId==1){ //当天
            envMonitorList = envMonitorService.getTodayEnv(baseId);
        }
        if(typeId==2){ //本周
            envMonitorList = envDayAvgService.getWeekEnv(baseId);
        }
        if(typeId==3){ //本月
            envMonitorList = envDayAvgService.getMonthEnv(baseId);
        }
        //返回的数据集
        List<EnvMonitor> envMonitor = new ArrayList<>();
        if(envMonitorList != null && envMonitorList.size() != 0){
            for (int i = 0; i<envMonitorList.size(); i++){
                envMonitor.add(envMonitorList.get(i));
            }
        }
        int count = envMonitor.size();
        String[] monitorTime = new String[count];

        String[]  soilTemperature = new String[count];
        String[]  soilHumidity = new String[count];
        String[]  soilPh = new String[count];
        String[]  soilEc = new String[count];
        String[]  soilS = new String[count];

        String[]  airTemperature = new String[count];
        String[]  airHumidity = new String[count];
        String[]  airPressure = new String[count];
        String[]  windSpeed = new String[count];
        String[]  windDirection = new String[count];
        String[] illIntensity = new String[count];
        String[] co2 = new String[count];
        String[] pm25 = new String[count];
        String[] pm10 = new String[count];

        String[]  rainfall = new String[count];
        for(int i=0; i<envMonitor.size();i++){
            monitorTime[i] = getDateFormat(typeId,envMonitor.get(i).getMonitorTime());
            soilTemperature[i] = getBigDecimal(envMonitor.get(i).getSoilTemperature());
            soilHumidity[i] =getBigDecimal(envMonitor.get(i).getSoilHumidity());
            soilPh[i] = getBigDecimal(envMonitor.get(i).getSoilPh());
            soilEc[i] = getBigDecimal(envMonitor.get(i).getSoilEc());
            soilS[i] = getBigDecimal(envMonitor.get(i).getSoilS());

            airTemperature[i] = getBigDecimal(envMonitor.get(i).getAirTemperature());
            airHumidity[i] = getBigDecimal(envMonitor.get(i).getAirHumidity());
            airPressure[i] = getBigDecimal(envMonitor.get(i).getAirPressure());
            windSpeed[i] = getBigDecimal(envMonitor.get(i).getWindSpeed());
            windDirection[i] = getBigDecimal(envMonitor.get(i).getWindDirection());

            illIntensity[i] = getBigDecimal(envMonitor.get(i).getIllIntensity());
            co2[i] = getBigDecimal(envMonitor.get(i).getCo2Value());
            pm25[i] = getBigDecimal(envMonitor.get(i).getPm25Value());
            pm10[i] = getBigDecimal(envMonitor.get(i).getPm10Value());

            rainfall[i] = getBigDecimal(envMonitor.get(i).getRainfall());
        }
        AppEnvVo appEnvVo = new AppEnvVo();
        appEnvVo.setMonitorTime(monitorTime);
        appEnvVo.setAirTemperature(airTemperature);
        appEnvVo.setAirHumidity(airHumidity);
        appEnvVo.setAirPressure(airPressure);
        appEnvVo.setSoilTemperature(soilTemperature);
        appEnvVo.setSoilHumidity(soilHumidity);
        appEnvVo.setSoilPh(soilPh);
        appEnvVo.setSoilEc(soilEc);
        appEnvVo.setSoilS(soilS);
        appEnvVo.setCo2(co2);
        appEnvVo.setPm25(pm25);
        appEnvVo.setPm10(pm10);
        appEnvVo.setIllIntensity(illIntensity);
        appEnvVo.setRainfall(rainfall);
        appEnvVo.setWindSpeed(windSpeed);
        appEnvVo.setWindDirection(windDirection);
        result.setSuccessResult(appEnvVo);
        return result;
    }

    public String getDateFormat(Integer typeId,Date date){
        String dateString =null;
        if(typeId==1){ //今天
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            dateString = formatter.format(date);
        }
        if(typeId==2||typeId==3){ //本周或本月
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            dateString = formatter.format(date);
        }
        return dateString;
    }

    public String getBigDecimal(BigDecimal bigDecimal){
        String result = "null";
        if(bigDecimal!=null){
            result = String.valueOf(bigDecimal.setScale(1, RoundingMode.HALF_UP));
        }
        return result;
    }
    @GetMapping("/getWarnRecord")
    @ApiOperation(value = "获取预警记录信息")
    public Result<PageInfo> getWarnRecord(@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                          @RequestParam(name="pageSize", defaultValue="5") Integer pageSize,
                                          Integer typeId, Integer baseId){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<WarnRecord> recordList = warnRecordService.getWarnRecordByTime(typeId,baseId);
        PageInfo pageInfo = new PageInfo(recordList);
        result.setSuccessResult(pageInfo);
        return result;
    }

    @GetMapping("/getNormalEnv")
    @ApiOperation(value = "获取正常采集数据")
    public Result<AppNorEnvMonitor> getNorEnvMonitor(Integer baseId,String time){
        Result<AppNorEnvMonitor> result = new Result<>();
        AppNorEnvMonitor appNorEnvMonitor = envMonitorDao.getEnvInfo(baseId,time);
        result.setResult(appNorEnvMonitor);
        result.setSuccess(true);
        return result;
    }
}

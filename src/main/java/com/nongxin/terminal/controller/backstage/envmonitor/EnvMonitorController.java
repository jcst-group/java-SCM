package com.nongxin.terminal.controller.backstage.envmonitor;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.envmonitor.EnvMonitor;
import com.nongxin.terminal.service.envmonitor.EnvMonitorService;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.app.AppEnvVo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/envmonitor")
public class EnvMonitorController {

    @Autowired
    private EnvMonitorService envMonitorService;

    private static final Logger LOGGER = LoggerFactory.getLogger(EnvMonitorController.class);

    @GetMapping("/list")
    @ApiOperation(value = "获取实时数据列表",notes = "GET获取实时环境监测信息")
    public Result<PageInfo> getEnvMonitorList(@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                              @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
                                              Integer equipmentId, Integer baseId, Date startTime, Date endTime){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<EnvMonitor> list = envMonitorService.getEnvMonitorList(equipmentId,baseId,startTime,endTime);
        PageInfo pageInfo = new PageInfo(list);
        result.setSuccessResult(pageInfo);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除实时数据",notes = "根据ID删除实时信息")
    public Result<String> deleteEnvMonitor(@RequestParam Integer id){
        Result<String> result = new Result<>();
        boolean delete = envMonitorService.delete(id);
        if(delete){
            result.setSuccessResult("删除数据成功");
            result.setMessage("删除数据成功");
        }else{
            result.setSuccess(false);
            result.setMessage("数据不存在");
        }
        return result;
    }

    @GetMapping("/getEnvChart")
    @ApiOperation(value = "图表类型监测数据")
    public Result<AppEnvVo> getEnvChart(Integer equipmentId,Integer baseId,Date startTime,Date endTime){
        Result<AppEnvVo> result = new Result<>();

        List<EnvMonitor> envMonitorList = envMonitorService.getEnvChart(equipmentId,baseId,startTime,endTime);

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
            monitorTime[i] = getDateFormat(envMonitor.get(i).getMonitorTime());
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

    public String getBigDecimal(BigDecimal bigDecimal){
        String result = "null";
        if(bigDecimal!=null){
            result = String.valueOf(bigDecimal.setScale(1, RoundingMode.HALF_UP));
        }
        return result;
    }

    public String getDateFormat(Date date){
        String dateString =null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateString = formatter.format(date);
        return dateString;
    }
}

package com.nongxin.terminal.controller.lookboard;

import com.nongxin.terminal.dao.base.BaseTestingMapper;
import com.nongxin.terminal.dao.envmonitor.EnvMonitorMapper;
import com.nongxin.terminal.dao.envmonitor.EquipmentMapper;
import com.nongxin.terminal.dao.envmonitor.VideoChannelMapper;
import com.nongxin.terminal.dao.lookboard.BoardMapper;
import com.nongxin.terminal.entity.base.BaseInfo;
import com.nongxin.terminal.entity.company.CompanyInfo;
import com.nongxin.terminal.entity.company.CompanyTeam;
import com.nongxin.terminal.entity.company.Fertilizers;
import com.nongxin.terminal.entity.envmonitor.EnvMonitor;
import com.nongxin.terminal.entity.envmonitor.VideoChannel;
import com.nongxin.terminal.entity.envmonitor.VideoEquipment;
import com.nongxin.terminal.service.base.BaseInfoService;
import com.nongxin.terminal.service.base.LotService;
import com.nongxin.terminal.service.company.CompanyInfoService;
import com.nongxin.terminal.service.company.CompanyTeamService;
import com.nongxin.terminal.service.company.FertilizersService;
import com.nongxin.terminal.service.envmonitor.VideoEquipmentService;
import com.nongxin.terminal.service.plan.WorkOrderService;
import com.nongxin.terminal.service.system.UserService;
import com.nongxin.terminal.service.testing.InitProDetectionService;
import com.nongxin.terminal.util.wind.SpeedAndDirect;
import com.nongxin.terminal.util.wind.WindDirectEnum;
import com.nongxin.terminal.util.wind.WindSpeedUtil;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.lookboard.*;
import com.nongxin.terminal.vo.zishan.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/board")
public class HomeController {

    @Autowired
    private CompanyInfoService companyInfoService;
    @Autowired
    private BaseInfoService baseInfoService;
    @Autowired
    private FertilizersService fertilizersService;
    @Autowired
    private LotService lotService;
    @Autowired
    private BaseTestingMapper baseTestingDao;
    @Autowired
    private BoardMapper boardMapper;
    @Autowired
    private EnvMonitorMapper envMonitorMapper;
    @Autowired
    private EquipmentMapper equipmentMapper;
    @Autowired
    private VideoChannelMapper videoChannelMapper;
    @Autowired
    private CompanyTeamService companyTeamService;
    @Autowired
    private WorkOrderService workOrderService;
    @Autowired
    private UserService userService;
    @Autowired
    private VideoEquipmentService videoEquipmentService;
    @Autowired
    private InitProDetectionService initProDetectionService;

    private String wdd_fqy ="0.00";
    private String wds_fqy ="0.00";

    @GetMapping("/getCompanyInfoById")
    @ApiOperation(value = "查询公司信息",notes = "GET根据id查询公司信息")
    public Result<CompanyInfo> getCompanyList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                           @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                           @RequestParam(defaultValue = "1") Integer id){
        Result<CompanyInfo> result = new Result<>();
        CompanyInfo companyInfo = companyInfoService.selectByPrimaryKey(id);
        if(companyInfo!=null){
            result.setResult(companyInfo);
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }

    @GetMapping("/getAllBase")
    @ApiOperation(value = "获取所有基地")
    public Result<List<BaseInfo>> getBaseList(BaseInfo baseInfo){
        Result<List<BaseInfo>> result = new Result<>();
        List<BaseInfo> baseList = baseInfoService.getBaseInfoList(baseInfo);
        if(baseList!=null){
            result.setResult(baseList);
            result.setSuccess(true);
            result.setMessage("获取基地信息成功");
        }else {
            result.setSuccess(false);
        }
        return result;
    }

    @GetMapping("/getFertilizers")
    @ApiOperation(value = "查询用肥情况",notes = "GET分页模糊查询用肥情况")
    public Result<List<Fertilizers>> getCompanyList(Fertilizers fertilizers){
        Result<List<Fertilizers>> result = new Result<>();
        List<Fertilizers> fertilizersList = fertilizersService.getFertilizersList(fertilizers);
        if(fertilizersList!=null){
            result.setResult(fertilizersList);
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }

    @GetMapping("/getFatByCompanyId")
    public Result<List<Fertilizers>> getByCompanyId(Integer companyId){
        Result<List<Fertilizers>> result = new Result<>();
        List<Fertilizers> list = fertilizersService.getFertilizersByCompanyId(companyId);
        result.setResult(list);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/getAllTesting")
    @ApiOperation(value = "获取基地土壤金属检测")
    public Result<List<BaseTestingAvg>> getAllTestingAvg(){
        Result<List<BaseTestingAvg>> result = new Result<>();
        List<BaseTestingAvg> baseTesting = baseTestingDao.getAllTestingAvg();
        result.setResult(baseTesting);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/getBaseInfoById")
    @ApiOperation(value = "获取基地信息",notes = "根据baseId获取基地信息")
    public Result<BaseInfoVo> getBaseInfo(Integer baseId){
        Result<BaseInfoVo> result = new Result<>();
        BaseInfoVo baseInfo = baseInfoService.getBaseInfoById(baseId);
        result.setResult(baseInfo);
        result.setMessage("获取基地信息成功");
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/getLotInfoById")
    @ApiOperation(value = "获取地块信息",notes = "根据lotId获取地块信息")
    public Result<LotTwoVo> getLotInfo(Integer lotId){
        Result<LotTwoVo> result = new Result<>();
        LotTwoVo lotVo = lotService.getLotInBoard(lotId);
        result.setResult(lotVo);
        result.setSuccess(true);
        result.setMessage("获取地块信息成功");
        return result;
    }

    @GetMapping("/getDetectionData")
    @ApiOperation(value = "获取检测数据",notes = "根据地块id和检测类型id获取检测数据")
        public Result<List<DetectionValueVo>> getDetectionData(Integer batchId, Integer typeId){
        Result<List<DetectionValueVo>> result = new Result<>();
        List<DetectionValueVo> list = boardMapper.getDetectionValue(batchId,typeId);
        result.setResult(list);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/getDetectionData1")
    @ApiOperation(value = "获取检测数据",notes = "根据地块id和检测类型id获取检测数据")
    public Result<List<DetectionValueVo>> getDetectionData1(Integer lotId, Integer typeId){
        Result<List<DetectionValueVo>> result = new Result<>();
        List<DetectionValueVo> list = boardMapper.getDetectionValue1(lotId,typeId);
        result.setResult(list);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/getRecoveryData")
    @ApiOperation(value = "获取采收产量数据")
    public Result<List<RecoveryDataVo>> get(Integer lotId){
        Result<List<RecoveryDataVo>> result = new Result<>();
        List<RecoveryDataVo> recoverylist = boardMapper.getRecoveryData(lotId);
        if(recoverylist!=null){
            result.setResult(recoverylist);
            result.setSuccess(true);
            result.setMessage("获取采收数据成功");
        }else{
            result.setSuccess(false);
        }
        return result;
    }
    @GetMapping("/getLastMonitor")
    @ApiOperation(value = "获取最新的采集数据")
    public Result<List<EnvMonitor>> getListLastMonitor(){
        Result<List<EnvMonitor>> result = new Result();
        List<EnvMonitor> envMonitorList = envMonitorMapper.getLastMonitor();
        result.setResult(envMonitorList);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/getBaseIdVideo")
    @ApiOperation(value = "获取视频监控所在基地id")
    public Result<VideoChannel> getBaseId(String serialNumber,Integer channelNo){
        Result<VideoChannel> result = new Result<>();
        VideoChannel videoChannel = videoChannelMapper.getBaseIdVideo(serialNumber,channelNo);
        if (videoChannel!=null){
            result.setResult(videoChannel);
            result.setSuccess(true);
        }else {
            result.setSuccess(false);
            result.setMessage("该通道没有对应的基地");
        }
        return result;
    }

    @GetMapping("/getVideoList")
    @ApiOperation(value = "视频列表")
    public Result<List<VideoEquipment>> getVideoList(){
        Result<List<VideoEquipment>> result = new Result<>();
        List<VideoEquipment> list = videoEquipmentService.getList(new VideoEquipment());
        result.setResult(list);
        result.setMessage("获取成功");
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/getChannelList")
    @ApiOperation(value = "获取通道列表")
    public Result<List<VideoChannel>> getChannelList(){
        Result<List<VideoChannel>> result = new Result<>();
        List<VideoChannel> list = videoChannelMapper.getAllList();
        result.setResult(list);
        result.setMessage("获取成功");
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/getTeam")
    @ApiOperation(value = "获取服务团队信息")
    public Result<List<CompanyTeam>> getTeam(){
        Result<List<CompanyTeam>> result = new Result<>();
        List<CompanyTeam> list = companyTeamService.getTeam();
        result.setResult(list);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/getCropBatch")
    @ApiOperation(value = "根据地块id查询种植批次")
    public Result<List<CropBatchVo>> getCropBatch(Integer lotId){
        Result<List<CropBatchVo>> result = new Result<>();
        List<CropBatchVo> list = boardMapper.getCropBatch(lotId);
        if(list!=null){
            result.setResult(list);
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }

    @GetMapping("/getRealTimeOrder")
    @ApiOperation("获取实时工单")
    public Result getRealTimeOrder(){
        Result result = new Result();
        result.setSuccessResult(workOrderService.getRealTimeOrder());
        return result;
    }

    @GetMapping("/getUserAndManageArea")
    @ApiOperation("获取用户总数和总管理面积")
    public Result getUserAndManageArea(){
        Result result = new Result();
        result.setSuccessResult(userService.getUserCount());
        return result;
    }

    @GetMapping("/getRoleAndUserCount")
    @ApiOperation("获取各角色类型对应的用户数量")
    public Result getRoleAndUserCount(){
        Result result = new Result();
        result.setSuccessResult(userService.getRoleAndUserCount());
        return result;
    }

    @GetMapping("/getCompleteOrder")
    @ApiOperation("获取近三天完成的工单")
    public Result getCompleteOrder(){
        Result result = new Result();
        result.setSuccessResult(workOrderService.getCompleteOrder());
        return result;
    }

    @GetMapping("/getLookOrder")
    @ApiOperation("获取最近20条待审核或审核通过工单")
    public Result getLookOrder(){
        Result result = new Result();
        result.setSuccessResult(workOrderService.getLookOrder());
        return result;
    }

    @GetMapping("/getEquipmentLng")
    @ApiOperation("获取设备经纬度")
    public Result<List<EquipmentLngVo>> getEquipmentLng(){
        Result<List<EquipmentLngVo>> result = new Result<>();
        result.setSuccessResult(equipmentMapper.getEquipmentLng());
        return result;
    }

    /* 紫杉*/
    @GetMapping("/getAtmosphereData")
    @ApiOperation("获取大气数据")
    public Result<List<MonitorVo>> getAtmosphereData(Integer type, Integer equipmentId){
        Result<List<MonitorVo>> result = new Result<>();
        List<MonitorVo> list = envMonitorMapper.getAtmosphereData(type,equipmentId);
        result.setSuccessResult(list);
        return result;
    }

    @GetMapping("/getSoilData")
    @ApiOperation("获取土壤数据")
    public Result<List<MonitorVo>> getSoilData(Integer type,Integer equipmentId){
        Result<List<MonitorVo>> result = new Result<>();
        List<MonitorVo> list =envMonitorMapper.getSoilData(type,equipmentId);
        result.setSuccessResult(list);
        return result;
    }

    @GetMapping("/getRainData")
    @ApiOperation("获取雨量数据")
    public Result<RainVo> getRainData(Integer equipmentId){
        Result<RainVo> result = new Result<>();
        RainVo rainVo= envMonitorMapper.getRainData(equipmentId);
        result.setSuccessResult(rainVo);
        return result;
    }

    @GetMapping("/chartWsrose")
    @ApiOperation("获取风向玫瑰图数据")
    public Result<WsRoseVo> getWsRose(Integer type,Integer equipmentId){
        Result<WsRoseVo> result = new Result<>();
        WsRoseVo wsRoseVo = new WsRoseVo();
        List<AngleVo> day = new ArrayList<>(16);
        List<AngleVo> month = new ArrayList<>(16);
        List<AngleVo> year = new ArrayList<>(16);

        List<WsGradeVo> wsGradeVoListDay = new ArrayList<>();

        for(int k = 1;k<5;k++) {  //设置1-4级
            WsGradeVo wsGradeVo = new WsGradeVo();
            wsGradeVo.setWds_grade(String.valueOf(k));
            wsGradeVo.setWdd_fqy(wdd_fqy);
            wsGradeVo.setWds_fqy(wds_fqy);
            wsGradeVoListDay.add(wsGradeVo);
        }
        for(int j=1;j<=16;j++){  //设置16个风向风速频率
            AngleVo e = new AngleVo();
            e.setW_angle(WindDirectEnum.getbycode(j));
            e.setGrade(wsGradeVoListDay);
            day.add(e);
            month.add(e);
            year.add(e);
        }

        List<WsdVo> dayList = envMonitorMapper.getWSpeedDay(equipmentId);  //取得当天的风速、风向数据
        List<WsdVo> monthList = envMonitorMapper.getWSpeedMonth(equipmentId);
        List<WsdVo> yearList = envMonitorMapper.getWSpeedYear(equipmentId);

        this.setValue(dayList,day);
        this.setValue(monthList,month);
        this.setValue(yearList,year);
        wsRoseVo.setEquipmentId(equipmentId);
        wsRoseVo.setDay(day);
        wsRoseVo.setMonth(month);
        wsRoseVo.setYear(year);
        result.setSuccessResult(wsRoseVo);
        return result;
    }

    @GetMapping("/getLastMonitor2")
    @ApiOperation(value = "获取最新的采集数据")
    public Result<List<EnvMonitor>> getListLastMonitor2(Integer equipmentId){
        Result<List<EnvMonitor>> result = new Result();
        List<EnvMonitor> envMonitorList = envMonitorMapper.getLastMonitor2(equipmentId);
        result.setResult(envMonitorList);
        result.setSuccess(true);
        return result;
    }

    public void setValue(List<WsdVo> typeList,List<AngleVo> timeType){  //第一个参数：查询的数据，第二个参数：返回时间类型的数据
        List<SpeedAndDirect> sad = new ArrayList<>();
        for(int i = 0;i<typeList.size();i++){
            if(typeList.get(i)!=null){
                sad.add(SpeedAndDirect.newInstance(typeList.get(i).getSpeed(), typeList.get(i).getDirect()));
            }
        }
        //风速
        Map<String, Map<Integer, Double>> stringMapMap = WindSpeedUtil.calSpeed(sad);
        String ws_fqy = "0.00";
        for (Map.Entry<String, Map<Integer, Double>> one: stringMapMap.entrySet()) {
            int index0 = WindDirectEnum.getIndex(one.getKey());  //1
            AngleVo e = null;
            Map<Integer, Double> map0 = one.getValue();
            List<WsGradeVo> setWsGrade = new ArrayList<>(4);

            for (Map.Entry<Integer, Double> two : map0.entrySet()) {
                int level = two.getKey(); //风力等级 0 1 2 3
                Double fqy = two.getValue();
                ws_fqy = String.format("%.2f", fqy);

                WsGradeVo wsGradeVo = new WsGradeVo();
                wsGradeVo.setWds_grade(String.valueOf(level + 1));
                wsGradeVo.setWds_fqy(ws_fqy);

                Map<String, Double> stringDoubleMap = WindSpeedUtil.calDirectBySad(sad);
                AngleVo directA = null;
                for (Map.Entry<String, Double> direct : stringDoubleMap.entrySet()) {
                    int indexD = WindDirectEnum.getIndex(direct.getKey());  //方位序号1-16
                    Double value = direct.getValue();
                    String wd_fqy = String.format("%.2f",value);
                    directA = new AngleVo();

                    if(indexD == index0){
                        wsGradeVo.setWdd_fqy(wd_fqy);
                    }else{
                        double a=new Random().nextInt(4)*0.1;
                        wsGradeVo.setWdd_fqy(String.format("%.2f",a));
                    }
                }
                setWsGrade.add(wsGradeVo);
                e = new AngleVo();
                e.setW_angle(timeType.get(index0 - 1).getW_angle());
                e.setGrade(setWsGrade);
                timeType.set(index0 - 1, e);
            }
        }
        //风向玫瑰图数据

    }

    @GetMapping("/getInitDetectionPic")
    @ApiOperation("获取初加工检测图片")
    public Result aa(@RequestParam(required = true)Integer batchId){
        Result result = new Result();
        result.setSuccessResult(initProDetectionService.getInitDetectionPic(batchId));
        return result;
    }

}

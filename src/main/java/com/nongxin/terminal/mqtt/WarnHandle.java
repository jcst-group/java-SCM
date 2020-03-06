package com.nongxin.terminal.mqtt;

import com.alibaba.fastjson.JSONObject;
import com.nongxin.terminal.dao.envmonitor.MonitorLackMapper;
import com.nongxin.terminal.dao.envmonitor.NoticeMapper;
import com.nongxin.terminal.dao.envmonitor.WarnEnvMapper;
import com.nongxin.terminal.dao.envmonitor.WarnRecordMapper;
import com.nongxin.terminal.entity.envmonitor.*;
import com.nongxin.terminal.util.notice.SmsUtil;
import com.nongxin.terminal.vo.annotation.FieldAnnotation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class WarnHandle {

    @Autowired
    private WarnEnvMapper warnEnvDao;

    @Autowired
    private WarnRecordMapper warnRecordDao;

    @Autowired
    private MonitorLackMapper monitorLackDao;

    @Autowired
    private NoticeMapper noticeDao;

    @Autowired
    private SmsUtil smsUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(WarnHandle.class);

    public void compare(EnvMonitor envMonitor){
        WarnEnv warnEnv = warnEnvDao.getWarnEnvByEquipmentId(envMonitor.getEquipmentId());
        WarnRecord warnRecord = new WarnRecord();
        if(warnEnv!=null && warnEnv.getStatus() == 1){  //预警为开启状态
            highHandel(warnRecord,warnEnv,envMonitor,envMonitor.getMonitorTime());
            lowHandle(warnRecord,warnEnv,envMonitor,envMonitor.getMonitorTime());
        }
    }

    /**
     * 高于 预警值处理
     * @param warnRecord  预警记录
     * @param warnEnv     预警值
     * @param envMonitor  采集值
     */
    public void highHandel(WarnRecord warnRecord,WarnEnv warnEnv,EnvMonitor envMonitor,Date time){
        if(warnEnv!=null) {
            if (compareHigh(envMonitor.getAirTemperature(), warnEnv.getMaxairtemperature())) {
                String content = "空气温度过高";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getAirTemperature()),"℃",1,
                        "airTemperature",time);
            }
            if (compareHigh(envMonitor.getAirHumidity(), warnEnv.getMaxairhumidity())) {
                String content = "空气湿度过高";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getAirHumidity()),"%",2,
                        "airHumidity",time);
            }
            if (compareHigh(envMonitor.getSoilTemperature(), warnEnv.getMaxsoiltemperature())) {
                String content = "土壤温度过高";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getSoilTemperature()),"℃",3,
                        "soilTemperature",time);
            }
            if (compareHigh(envMonitor.getSoilHumidity(), warnEnv.getMaxsoilhumidity())) {
                String content = "土壤湿度过高";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getSoilHumidity()),"%",4,
                        "soilHumidity",time);
            }
            if (compareHigh(envMonitor.getSoilPh(), warnEnv.getMaxsoilph())) {
                String content = "土壤PH值过高";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getSoilPh()),"",5,
                        "soilPh",time);
            }
            if (compareHigh(envMonitor.getIllIntensity(), warnEnv.getMaxillIntensity())) {
                String content = "光照强度过高";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getIllIntensity()),"Lux",6,
                        "illIntensity",time);
            }
            if (compareHigh(envMonitor.getRainfall(), warnEnv.getMaxrainfall())) {
                String content = "降雨量过高";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getRainfall()),"mm",7,
                        "rainfall",time);
            }
            if (compareHigh(envMonitor.getCo2Value(), warnEnv.getMaxco2())) {
                String content = "CO2浓度过高";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getCo2Value()),"ppm",8,
                        "co2Value",time);
            }
            if (compareHigh(envMonitor.getPm25Value(), warnEnv.getMaxpm25())) {
                String content = "PM2.5值过高";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getPm25Value()),"ug/m3",9,
                        "pm25Value",time);
            }
            if (compareHigh(envMonitor.getPm10Value(), warnEnv.getMaxpm10())) {
                String content = "PM10值过高";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getPm10Value()),"ug/m3",10,
                        "pm10Value",time);
            }
            if (compareHigh(envMonitor.getWindSpeed(), warnEnv.getMaxwindspeed())) {
                String content = "风速过大";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getWindSpeed()),"m/s",11,
                        "windSpeed",time);
            }
            if (compareHigh(envMonitor.getSoilEc(), warnEnv.getMaxsoilec())) {
                String content = "土壤EC值过高";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getSoilEc()),"uS/cm",12,
                        "soilEc",time);
            }
            if (compareHigh(envMonitor.getSoilS(), warnEnv.getMaxsoils())) {
                String content = "土壤盐分值过高";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getSoilS()),"ppm",13,
                        "soilS",time);
            }

        }
    }

    public void lowHandle(WarnRecord warnRecord,WarnEnv warnEnv,EnvMonitor envMonitor,Date time){
        if(warnEnv!=null) {
            if(compareLow(envMonitor.getAirTemperature(),warnEnv.getMinairtemperature())){
                String content = "空气温度偏低";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getAirTemperature()),"℃",1,
                        "airTemperature",time);
            }
            if(compareLow(envMonitor.getAirHumidity(),warnEnv.getMinairhumidity())){
                String content = "空气湿度偏低";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getAirHumidity()),"%",2,
                        "airHumidity",time);
            }
            if (compareLow(envMonitor.getSoilTemperature(), warnEnv.getMinsoiltemperature())) {
                String content = "土壤温度偏低";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getSoilTemperature()),"℃",3,
                        "soilTemperature",time);
            }
            if (compareLow(envMonitor.getSoilHumidity(), warnEnv.getMinsoilhumidity())) {
                String content = "土壤湿度偏低";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getSoilHumidity()),"%",4,
                        "soilHumidity",time);
            }
            if (compareLow(envMonitor.getSoilPh(), warnEnv.getMinsoilph())) {
                String content = "土壤PH值偏低";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getSoilPh()),"",5,
                        "soilPh",time);
            }
            if(compareLow(envMonitor.getIllIntensity(),warnEnv.getMinillIntensity())){
                String content = "光照强度偏低";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getIllIntensity()),"Lux",6,
                        "illIntensity",time);
            }
            if(compareLow(envMonitor.getCo2Value(),warnEnv.getMinco2())){
                String content = "CO2浓度偏低";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getCo2Value()),"ppm",8,
                        "co2Value",time);
            }
            if(compareLow(envMonitor.getPm25Value(),warnEnv.getMinpm25())){
                String content = "PM2.5偏低";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getPm25Value()),"ug/m3",9,
                        "pm25Value",time);
            }
            if(compareLow(envMonitor.getPm10Value(),warnEnv.getMinpm10())){
                String content = "PM10偏低";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getPm10Value()),"ug/m3",10,
                        "pm10Value",time);
            }
            if (compareLow(envMonitor.getSoilEc(), warnEnv.getMinsoilec())) {
                String content = "土壤EC值偏低";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getSoilEc()),"uS/cm",12,
                        "soilEc",time);
            }
            if (compareLow(envMonitor.getSoilS(), warnEnv.getMinsoils())) {
                String content = "土壤盐分值偏低";
                saveWarnRecord(warnRecord,envMonitor.getEquipmentId(),content, String.valueOf(envMonitor.getSoilS()),"ppm",13,
                        "soilS",time);
            }
        }
    }

    //大于 比较
    public Boolean compareHigh(BigDecimal a,BigDecimal b){
        boolean result = false;
        if(b!=null&&a!=null){
            if(a.compareTo(b)==1){
                result = true;
            }
        }
        return result;
    }

    //小于比较
    public Boolean compareLow(BigDecimal a,BigDecimal b){
        boolean result = false;
        if(b!=null&&a!=null){
            if(a.compareTo(b) == -1){
                result = true;
            }
        }
        return result;
    }

    //保存预警记录信息
    public void saveWarnRecord(WarnRecord warnRecord,Integer equipmentId,String content,String value,String unit,Integer item,String type,Date time){
        warnRecord.setEquipmentId(equipmentId);
        warnRecord.setContent(content);
        warnRecord.setValue(value);
        warnRecord.setUnit(unit);
        warnRecord.setItem(item);
        warnRecord.setType(type);
        warnRecord.setWarnTime(time);
        warnRecordDao.insertSelective(warnRecord);
    }

    //数据缺失处理
    public void lackHandle(Object object,Integer equipmentId,Date monitorTime) throws Exception {
        Field[] fs = object.getClass().getDeclaredFields();
        List<String> list = new ArrayList<String>();
        List<String> smsList = new ArrayList<String>();
        List<String> resultList = new ArrayList<String>();
        String[] special = {"id","equipment","lng","lat"};
        List<String> specialList = Arrays.asList(special);
        for(Field field:fs){
            field.setAccessible(true);
            if(field.get(object)==null){  //如数据项空，则放入list中
                String name = field.getName();
                if(!specialList.contains(name)){
                    list.add(name);
                    FieldAnnotation fieldAnnotation = field.getAnnotation(FieldAnnotation.class);  //获取字段上的注解
                    smsList.add(fieldAnnotation.value());
                }
            }
        }
        if(list.size()>0) {
            MonitorLack monitorLack = new MonitorLack();
            monitorLack.setContent(StringUtils.strip(list.toString(), "[]"));
            monitorLack.setEquipmentId(equipmentId);
            monitorLack.setMonitorTime(monitorTime);
            monitorLackDao.insertSelective(monitorLack);

            List<List<String>> chopped = fixedGrouping(smsList, 3);
            if(chopped.size()>0){
                Notice notice = noticeDao.selectByPrimaryKey(1);
                if(notice!=null&&notice.getStatus()==1){
                    for (List<String> relist : chopped) {
                        JSONObject json = new JSONObject();
                        json.put("equipmentId", equipmentId);
                        json.put("item",StringUtils.strip(relist.toString(), "[]"));
                        smsUtil.setRequest(json.toString(),notice.getPhone(),"SMS_174650935");
                    }
                }

            }

        }
    }

    //拆分List，短信一个变量  仅支持长度最大20的字符串
    public static <T> List<List<T>> fixedGrouping(List<T> source, int n) {

        if (null == source || source.size() == 0 || n <= 0)
            return null;
        List<List<T>> result = new ArrayList<List<T>>();

        int sourceSize = source.size();
        int size = (source.size() / n) + 1;
        for (int i = 0; i < size; i++) {
            List<T> subset = new ArrayList<T>();
            for (int j = i * n; j < (i + 1) * n; j++) {
                if (j < sourceSize) {
                    subset.add(source.get(j));
                }
            }
            result.add(subset);
        }
        return result;
    }
}

package com.nongxin.terminal.schedule;

import com.alibaba.fastjson.JSONObject;
import com.nongxin.terminal.dao.envmonitor.EnvMonitorMapper;
import com.nongxin.terminal.dao.envmonitor.EquipmentMapper;
import com.nongxin.terminal.dao.envmonitor.NoticeSettingMapper;
import com.nongxin.terminal.entity.envmonitor.Equipment;
import com.nongxin.terminal.entity.envmonitor.NoticeSetting;
import com.nongxin.terminal.util.notice.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Component
@Configuration
@EnableScheduling
public class CheckMonitorTask {

    @Autowired
    private EquipmentMapper equipmentDao;

    @Autowired
    private EnvMonitorMapper envMonitorDao;

    @Autowired
    private NoticeSettingMapper noticeSettingDao;

    @Autowired
    private SmsUtil smsUtil;

    /**
     * 周一至周六 8点--18点  检查每小时的采集到的数据量
     */
    @Scheduled(cron = "0 0 8-18 ? * MON-SAT")
    private void configure(){

        List<Equipment> equipments = equipmentDao.getEquipmentList(new Equipment());
        for(int i=0; i< equipments.size();i++) {
            Integer id = equipments.get(i).getId();  //设备表的id
            NoticeSetting noticeSetting = noticeSettingDao.getByEquipmentId(id);
            if(noticeSetting!=null){
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                SimpleDateFormat current = new SimpleDateFormat("HH:mm:ss");
                Date currentTime = null;
                try {
                    currentTime = current.parse(current.format(new Date()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //找出一个小时的采集数量
                Integer count = envMonitorDao.getCount(id,df.format(calendar.getTime()),df.format(new Date()));

                if(noticeSetting.getStatus()==1 && count < noticeSetting.getSize()){ //通知状态为1时
                    if(currentTime.getTime() >noticeSetting.getStartTime().getTime()
                            && currentTime.getTime() < noticeSetting.getEndTime().getTime()){

                        JSONObject json = new JSONObject();
                        json.put("equipmentId", id);
                        json.put("startTime", df.format(calendar.getTime()));
                        json.put("endTime",df.format(new Date()));
                        json.put("count",count);
                        json.put("size",noticeSetting.getSize());
                        smsUtil.setRequest(json.toString(),noticeSetting.getPhone(),"SMS_174807983");
                    }

                }
            }
        }
    }
}

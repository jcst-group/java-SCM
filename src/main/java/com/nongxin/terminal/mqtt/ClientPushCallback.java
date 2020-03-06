package com.nongxin.terminal.mqtt;

import com.alibaba.fastjson.JSONObject;
import com.nongxin.terminal.dao.envmonitor.EnvMonitorMapper;
import com.nongxin.terminal.dao.envmonitor.EquipmentMapper;
import com.nongxin.terminal.dao.envmonitor.NoticeMapper;
import com.nongxin.terminal.entity.envmonitor.EnvMonitor;
import com.nongxin.terminal.entity.envmonitor.Equipment;
import com.nongxin.terminal.entity.envmonitor.Notice;
import com.nongxin.terminal.util.notice.SmsUtil;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Component(value = "clientPushCallback")
@Configuration
public class ClientPushCallback implements MqttCallback {

    private static Logger logger = LoggerFactory.getLogger(ClientPushCallback.class);

    private String recieve = null;   //接收到的消息
    private String Topic = null; //主题
    private static final String TOPIC1 = "stds/up/CL/865650042818399";
    private static final String TOPIC2 = "stds/up/CL/865650042735262";
    private static final String TOPIC3 = "stds/up/CL/865650042732889";
    private static final String TOPIC4 = "stds/up/CL/865650042739009";

    //设备上线topic
    private static final String TOPIC5 = "$SYS/brokers/emqx@127.0.0.1/clients/865650042818399/connected";
    private static final String TOPIC6 = "$SYS/brokers/emqx@127.0.0.1/clients/865650042735262/connected";
    private static final String TOPIC7 = "$SYS/brokers/emqx@127.0.0.1/clients/865650042732889/connected";
    private static final String TOPIC8 = "$SYS/brokers/emqx@127.0.0.1/clients/865650042739009/connected";

    //设备下线topic
    private static final String TOPIC9 =  "$SYS/brokers/emqx@127.0.0.1/clients/865650042818399/disconnected";
    private static final String TOPIC10 = "$SYS/brokers/emqx@127.0.0.1/clients/865650042735262/disconnected";
    private static final String TOPIC11 = "$SYS/brokers/emqx@127.0.0.1/clients/865650042732889/disconnected";
    private static final String TOPIC12 = "$SYS/brokers/emqx@127.0.0.1/clients/865650042739009/disconnected";

    private static Integer init = 0;
    private Date startTime;
    private String equipmentId = null;

    @Resource(name = "clientMqtt")
    private ClientMqtt clientMqtt;

    @Autowired
    private EnvMonitorMapper envMonitorDao;
    @Autowired
    private EquipmentMapper equipmentDao;
    @Autowired
    private WarnHandle warnHandle;

    private EnvMonitor envMonitor = new EnvMonitor();

    @Autowired
    private NoticeMapper noticeDao;

    @Autowired
    private SmsUtil smsUtil;

    @Override
    public void connectionLost(Throwable throwable) {
        logger.error("连接断开，正常尝试重连 -> ", throwable);
        logger.error(Topic+": "+recieve);
        clientMqtt.startReconnect();
    }

    @Override
    public void messageArrived(String topic, MqttMessage message){
        Topic = topic;
        recieve = new String(message.getPayload());
        if(recieve!=null&&!recieve.equals("close")){
            switch (topic){
                case TOPIC1:
                    equipmentId = "865650042818399";
                    recieve(recieve,equipmentId);   //解析数据
                    insert();   //数据入库
                    break;
                case TOPIC2:
                    equipmentId = "865650042735262";
                    recieve(recieve,equipmentId);
                    insert();
                    break;
                case TOPIC3:
                    equipmentId = "865650042732889";
                    recieve(recieve,equipmentId);
                    insert();
                    break;
                case TOPIC4:
                    equipmentId = "865650042739009";
                    recieve(recieve,equipmentId);
                    insert();
                    break;
                case TOPIC5:
                    equipmentId = "865650042818399";
                    connected(equipmentId);
                    break;
                case TOPIC6:
                    equipmentId = "865650042735262";
                    connected(equipmentId);
                    break;
                case TOPIC7:
                    equipmentId = "865650042732889";
                    connected(equipmentId);
                    break;
                case TOPIC8:
                    equipmentId = "865650042739009";
                    connected(equipmentId);
                    break;
                case TOPIC9:
                    equipmentId = "865650042818399";
                    disconnected(equipmentId);
                    break;
                case TOPIC10:
                    equipmentId = "865650042735262";
                    disconnected(equipmentId);
                    break;
                case TOPIC11:
                    equipmentId = "865650042732889";
                    disconnected(equipmentId);
                    break;
                case TOPIC12:
                    equipmentId = "865650042739009";
                    disconnected(equipmentId);
                    break;
            }
        }
    }


    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        logger.info("消息发送成功 -> ", token.isComplete());
    }

    //根据设备表id和时间判断是否有记录
    public boolean exist(int devId, Date date){
        EnvMonitor envMonitor = new EnvMonitor();
        envMonitor.setMonitorTime(date);
        envMonitor.setEquipmentId(devId);
        List<EnvMonitor>  envMonitors= envMonitorDao.selectByEquipIdAndMeasureTime(envMonitor);
        if(envMonitors.size()>0){
            return true;
        }
        return false;
    }

    //由设备编号取得设备表id
    public int getEquMentId(String devId){
        Equipment equipment = equipmentDao.selectByEquipmentId(devId);
        if(equipment!=null){
            return equipment.getId();
        }else{
            return 0;
        }
    }

    public void insert(){
        if(init==0){
            ExecutorService pool = Executors.newFixedThreadPool(10);
            pool.execute(new MyExecution());
            init++;
            startTime = new Date();
        }
    }

    //接收赛通设备数据
    public void recieve(String data,String equipmentId){
        JSONObject jsonObject = JSONObject.parseObject(data);
        if (jsonObject.containsKey("soilT")){
            envMonitor.setSoilTemperature(BigDecimal.valueOf(getDoubleData(jsonObject,"soilT")/10));
            envMonitor.setSoilHumidity(BigDecimal.valueOf(getDoubleData(jsonObject,"soilH")/10));
            envMonitor.setSoilEc(BigDecimal.valueOf(getDoubleData(jsonObject,"soilC")));
            envMonitor.setSoilS(BigDecimal.valueOf(getDoubleData(jsonObject,"soilS")));
        }
        if(jsonObject.containsKey("dPH")){
            envMonitor.setSoilPh(BigDecimal.valueOf(getDoubleData(jsonObject,"dPH")/10));
        }
        if(jsonObject.containsKey("airT")){
            envMonitor.setAirTemperature(BigDecimal.valueOf(getDoubleData(jsonObject,"airT")/10));
            envMonitor.setAirHumidity(BigDecimal.valueOf(getDoubleData(jsonObject,"airH")/10));
            envMonitor.setIllIntensity(BigDecimal.valueOf(getDoubleData(jsonObject,"ill")));
            envMonitor.setCo2Value(BigDecimal.valueOf(getDoubleData(jsonObject,"co2")));
        }
        if(jsonObject.containsKey("atm")){
            envMonitor.setAirPressure(BigDecimal.valueOf(getDoubleData(jsonObject,"atm")/100));
        }
        if(jsonObject.containsKey("pm25")){
            envMonitor.setPm25Value(BigDecimal.valueOf(getDoubleData(jsonObject,"pm25")));
            envMonitor.setPm10Value(BigDecimal.valueOf(getDoubleData(jsonObject,"pm10")));
        }
        if(jsonObject.containsKey("windS")){
            envMonitor.setWindSpeed(BigDecimal.valueOf(getDoubleData(jsonObject,"windS")/10));
        }
        if(jsonObject.containsKey("rainF")){
            envMonitor.setRainfall(BigDecimal.valueOf(getDoubleData(jsonObject,"rainF")/10));
        }
        if(jsonObject.containsKey("windD")){
            envMonitor.setWindDirection(BigDecimal.valueOf(getDoubleData(jsonObject,"windD")/10));
        }
    }

    public Double getDoubleData(JSONObject item,String key){
        Double data = null;
        try {
            data = item.getDoubleValue(key);
        } catch (Exception e) {
        }
        return data;
    }

    class MyExecution implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(15000);  //等待15秒，防止网络阻塞时，数据丢失
            }catch (Exception e){
            }
            envMonitor.setEquipmentId(getEquMentId(equipmentId));
            envMonitor.setFactoryId(FactoryEnum.SAITONG.getFactoryId());
            envMonitor.setMonitorTime(startTime);
            if(!exist(getEquMentId(equipmentId),startTime)){
                envMonitorDao.insertSelective(envMonitor);
                warnHandle.compare(envMonitor);
                try {
                    warnHandle.lackHandle(envMonitor,envMonitor.getEquipmentId(),envMonitor.getMonitorTime());
                    envMonitor.setSoilPh(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            init=0;
        }
    }

    public String getDateFormat(Date date){
        String dateString =null;

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        dateString = formatter.format(date);

        return dateString;
    }

    //设备上线通知处理
    public void connected(String equipmentId){
        JSONObject json = new JSONObject();
        json.put("equipmentId", equipmentId);
        json.put("Name",equipmentDao.selectByEquipmentId(equipmentId).getEquipmentName());
        json.put("time",getDateFormat(new Date()));
        Notice notice = noticeDao.selectByPrimaryKey(1);
        smsUtil.setRequest(json.toString(),notice.getPhone(),"SMS_174808521");
    }

    //设备离线通知处理
    public void disconnected(String equipmentId){
        JSONObject json = new JSONObject();
        json.put("equipmentId", equipmentId);
        json.put("Name",equipmentDao.selectByEquipmentId(equipmentId).getEquipmentName());
        json.put("time",getDateFormat(new Date()));
        Notice notice = noticeDao.selectByPrimaryKey(1);
        smsUtil.setRequest(json.toString(),notice.getPhone(),"SMS_174808526");
    }
}

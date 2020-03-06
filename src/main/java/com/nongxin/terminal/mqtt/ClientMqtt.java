package com.nongxin.terminal.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component(value = "clientMqtt")
public class ClientMqtt {

    private static Logger logger = LoggerFactory.getLogger(ClientMqtt.class);

    //接收消息的topic
    private static final String TOPIC = "stds/up/CL/#";

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

    private static MqttClient client;
    private static MqttConnectOptions options;

    @Value("${mqtt.client.host}")
    public String host;
    @Value("${mqtt.client.clientid}")
    private String clientid;
    @Value("${mqtt.client.username}")
    private String username;
    @Value("${mqtt.client.password}")
    private String password;
    @Resource(name = "clientPushCallback")
    private ClientPushCallback clientPushCallback;

    /**
     * 部署服务器时，开启注解，接收数据
     */
    //@PostConstruct
    public void start() {
        try {
            // host: 服务器地址
            // clientid: 客户端ID(连接mqtt服务的唯一标识，用来区分不同的客户端)
            // MemoryPersistence: 设置clientid的保存形式，默认以内存保存
            client = new MqttClient(host, clientid, new MemoryPersistence());
            options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            // 设置是否清空session
            // false: 表示服务器会保留客户端的连接记录，true: 表示每次连接到服务器都以新的身份连接
            options.setCleanSession(true);
            options.setUserName(username);
            options.setPassword(password.toCharArray());
            // 设置超时时间
            options.setConnectionTimeout(0);
            // 设置会话心跳时间
            options.setKeepAliveInterval(60);
            // 设置回调
            client.setCallback(clientPushCallback);
            client.connect(options);
            // 订阅消息
            subscribe();

        } catch (Exception e) {
            logger.error("mqtt启动失败 -> ", e);
        }
    }

    /**
     * 订阅消息
     */
    private static void subscribe() {
        try {
            int[] qos = {1};
            String[] topics = {TOPIC,TOPIC5,TOPIC6,TOPIC7,TOPIC8,TOPIC9,TOPIC10,TOPIC11,TOPIC12};
            for(int i=0;i<topics.length;i++){
                String[] topic = {topics[i]};
                client.subscribe(topic, qos);
            }

        } catch (Exception e) {
            logger.error("mqtt订阅消息失败 -> ", e);
        }
    }

    /**
     * 重新连接
     */
    public synchronized void startReconnect() {
        if (!client.isConnected()) {
            while (!client.isConnected()) {
                logger.info("mqtt开始尝试重连");
                try {
                    TimeUnit.SECONDS.sleep(15);
                    client.connect(options);
                    subscribe();
                    logger.info("mqtt重连成功");
                    break;
                } catch (Exception e) {
                    logger.error("mqtt重连失败，继续重连中");
                }
            }
        } else {
            logger.info("mqtt已经连接，无需重连");
        }
    }

}

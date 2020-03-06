package com.nongxin.terminal.util.push;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.style.Style0;
import com.gexin.rp.sdk.template.style.Style6;
import com.nongxin.terminal.mqtt.ClientPushCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PushUtil {

    private static Logger logger = LoggerFactory.getLogger(ClientPushCallback.class);

    // STEP1：获取应用基本信息
    private static String appId = "KWzsJ0m8Cd8PPL1GWUfkl";
    private static String appKey = "jJYMf7G9tz932VMYmgIMT6";
    private static String masterSecret = "mxYNMqfwCgAQnpeUr5oenA";
    private static String url = "http://sdk.open.api.igexin.com/apiex.htm";

    static String CID = "0448b7639080c1b3d696d124fc127854";
    // 别名推送方式
    static String host = "http://sdk.open.api.igexin.com/apiex.htm";

    public void push(String CID,String pushMessage){
        IGtPush push = new IGtPush(host, appKey, masterSecret);
        NotificationTemplate template = getNotificationTemplate(pushMessage);
        SingleMessage message = new SingleMessage();
        message.setOffline(true);
        // 离线有效时间，单位为毫秒
        message.setOfflineExpireTime(24 * 3600 * 1000);
        message.setData(template);
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);
        Target target = new Target();
        target.setAppId(appId);
        target.setClientId(CID);
        //target.setAlias(Alias);
        IPushResult ret = null;
        try {
            ret = push.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            ret = push.pushMessageToSingle(message, target, e.getRequestId());
        }
        if (ret != null) {
            logger.info(ret.getResponse().toString());
        } else {
            logger.info("服务器响应异常");
        }
    }

    public static NotificationTemplate getNotificationTemplate(String pushMessage) {
        NotificationTemplate template = new NotificationTemplate();
        // 设置APPID与APPKEY
        template.setAppId(appId);
        template.setAppkey(appKey);

        Style6 style = new Style6();
        // 设置通知栏标题与内容
        style.setTitle("工单执行");
        style.setText(pushMessage);
        // 配置通知栏图标
        style.setLogo("icon.png");
        // 配置通知栏网络图标
        style.setLogoUrl("");
        // 设置通知是否响铃，震动，或者可清除
        style.setRing(true);
        style.setVibrate(true);
        style.setClearable(true);
        style.setChannelLevel(3); //设置通知渠道重要性
        style.setBigStyle2(pushMessage);
        template.setStyle(style);

        template.setTransmissionType(1);  // 透传消息接受方式设置，1：立即启动APP，2：客户端收到消息后需要自行处理
        //template.setTransmissionContent("请输入您要透传的内容");
        return template;
    }
}

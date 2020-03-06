package com.nongxin.terminal.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nongxin.terminal.vo.constant.CommonConstant;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@PropertySource("classpath:application.yml")
public class YsClient {

    @Autowired
    private RedisUtil redisUtil;

    @Value("${ys.appKey}")
    private String appKey;
    @Value("${ys.appSecret}")
    private String appSecret;

    public String HttpClientPost(){

        String accessToken= (String) redisUtil.get(CommonConstant.PREFIX_YS_ACCESS_TOKEN);
        if (accessToken==null || accessToken.equals("")){
            CloseableHttpResponse response = null;
            // 获取默认的请求客户端
            CloseableHttpClient client = HttpClients.createDefault();
            // 通过HttpPost来发送post请求
            HttpPost httpPost = new HttpPost("https://open.ys7.com/api/lapp/token/get");
            // 添加参数
            List<NameValuePair> list = new ArrayList<>();
            BasicNameValuePair basicNameValuePair = new BasicNameValuePair("appKey", appKey);
            BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("appSecret", appSecret);
            list.add(basicNameValuePair);
            list.add(basicNameValuePair2);

            try {
                UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(list);
                formEntity.setContentType("application/x-www-form-urlencoded");
                // 第一步：通过setEntity 将我们的entity对象传递过去
                httpPost.setEntity(formEntity);
                // HttpEntity
                // 是一个中间的桥梁，在httpClient里面，是连接我们的请求与响应的一个中间桥梁，所有的请求参数都是通过HttpEntity携带过去的
                // 通过client来执行请求，获取一个响应结果
                response = client.execute(httpPost);
                HttpEntity entity = response.getEntity();
                JSONObject data = JSON.parseObject(JSON.parseObject(EntityUtils.toString(entity, "UTF-8")).getString("data"));
                String token = data.getString("accessToken");
                //计算token超时时间
                Long expireTime = (Long.valueOf(data.getString("expireTime"))-System.currentTimeMillis())/1000;
                redisUtil.set(CommonConstant.PREFIX_YS_ACCESS_TOKEN, token);
                //设置超时时间
                redisUtil.expire(CommonConstant.PREFIX_YS_ACCESS_TOKEN, expireTime);
                return token;
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }finally {
                if (response != null){
                    try {
                        response.close();
                    }catch (Exception e){}
                }
            }
        }
        return accessToken;
    }

}

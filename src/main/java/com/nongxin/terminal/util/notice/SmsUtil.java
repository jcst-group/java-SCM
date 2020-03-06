package com.nongxin.terminal.util.notice;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.stereotype.Component;

@Component
public class SmsUtil {


    DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou","LTAIwIXlxJpTRslY","qQ28WMXIs1doY2V0VSFCC5WVdEn7x5");
    IAcsClient client = new DefaultAcsClient(profile);

    CommonRequest request = new CommonRequest();

    public void setRequest(String templateJson,String phoneNumber,String templateCode) {
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", "农芯");
        request.putQueryParameter("TemplateCode", templateCode);//短信模板code: 如：SMS_174650935
        request.putQueryParameter("TemplateParam", templateJson);
        try {
            CommonResponse response = client.getCommonResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}

package com.nongxin.terminal.util.notice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil {

    private final Logger logger = LoggerFactory.getLogger(getClass());

//    @Value("${mail.host}")
    private String host;
//    @Value("${mail.username}")
    private String sendMail;
//    @Value("${mail.password}")
    private String password;  //授权码


    public void sendMail(String title, String content,String toEmail) throws Exception {
        final Properties prop = new Properties();
        prop.setProperty("mail.host", host);
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.user", sendMail);
        prop.put("mail.password",password);

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、授权码
                String username = prop.getProperty("mail.user");
                String password = prop.getProperty("mail.password");
                return new PasswordAuthentication(username,password);
            }
        };
        Session session = Session.getInstance(prop,authenticator);
        //创建邮件
        Message message = new MimeMessage(session);
        //创建发送邮箱
        Address sender = new InternetAddress(sendMail);
        message.setFrom(sender);
        //创建接收邮箱
        Address to = new InternetAddress(toEmail);
        message.setRecipient(MimeMessage.RecipientType.TO, to);

        message.setSubject(title);
        message.setText(content);

        Transport.send(message);
    }
}

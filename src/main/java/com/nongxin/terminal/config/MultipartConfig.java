package com.nongxin.terminal.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;
import java.io.File;

@Configuration
public class MultipartConfig {

    MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        String localtion = System.getProperty("user.dir") + "/data/tmp";
        File tmpFile = new File(localtion);
        if(!tmpFile.exists()){
            tmpFile.mkdirs();
        }
        factory.setLocation(localtion);
        return factory.createMultipartConfig();
    }

}

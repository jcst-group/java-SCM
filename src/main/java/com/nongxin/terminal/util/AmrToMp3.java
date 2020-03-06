package com.nongxin.terminal.util;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import ws.schild.jave.*;

import java.io.File;
import java.math.BigDecimal;

public class AmrToMp3 {

    public static BigDecimal amrToMp3(MultipartFile multipartFile, String path, String suffixName){
        File target = new File(path);   //目标文件
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");
        attrs.setAudioAttributes(audio);
        Encoder encoder = new Encoder();
        try {
            File saveFile = new File(path);
            FileCopyUtils.copy(multipartFile.getBytes(), saveFile);

            final File excelFile = File.createTempFile(System.currentTimeMillis()+"", suffixName);
            multipartFile.transferTo(excelFile);
            MultimediaObject multimediaObject  = new MultimediaObject(excelFile);

            encoder.encode(multimediaObject,target, attrs);
            BigDecimal duration = new BigDecimal((multimediaObject.getInfo().getDuration())).
                    divide(new BigDecimal(1000),0,BigDecimal.ROUND_HALF_UP);
            if (excelFile.exists()) {
                excelFile.delete();
            }
            //返回音频时长
            return duration;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

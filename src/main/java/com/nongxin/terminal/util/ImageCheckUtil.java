package com.nongxin.terminal.util;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;

public class ImageCheckUtil {

    /**
     * 根据文件内容判断是否为图片
     * @param
     * @return
     */
    public static boolean checkImage(InputStream inputStream){
        try {
            return (ImageIO.read(inputStream) != null);
        } catch(IOException ex) {
            return false;
        }
    }

    /**
     * 判断是否为允许的上传文件类型,true表示允许
     */
    public static boolean checkFile(String suffix) {
        //设置允许上传文件类型
        String suffixList = "jpg,gif,png,ico,bmp,jpeg";

        if (suffixList.contains(suffix.trim().toLowerCase())) {
            return true;
        }
        return false;
    }

    public static boolean checkFile1(String suffix) {
        //设置允许上传文件类型
        String suffixList = "doc,docx,pdf,zip,rar,mp3,wav,ogg,mp4,amr";

        if (suffixList.contains(suffix.trim().toLowerCase())) {
            return true;
        }
        return false;
    }

}

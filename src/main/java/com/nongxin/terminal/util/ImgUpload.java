package com.nongxin.terminal.util;

import com.nongxin.terminal.vo.FileInfoVo;
import com.nongxin.terminal.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@PropertySource("classpath:application.yml")
public class ImgUpload {

    //private static final Logger LOGGER = LoggerFactory.getLogger(ImgUpload.class);

    @Value("${fileSize.img}")
    private Integer imgSize;

    private final ResourceLoader resourceLoader;

    @Autowired
    public ImgUpload(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    public Result<FileInfoVo> listSample(MultipartFile file) {
        Result<FileInfoVo> result = new Result<>();
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf(".")+1);

        if (file.isEmpty()) {
            result.error500("文件不能为空");
            result.setMessage("文件不能为空");
            return result;
        }
        if(file.getSize()>imgSize*1024*1024){
            result.error500("文件大小不能大于"+imgSize+"M");
            result.setMessage("文件大小不能大于"+imgSize+"M");
            return result;
        }

        try {

            boolean isImage = ImageCheckUtil.checkFile(suffixName);
            if(!isImage){
                result.error500("文件不为图片，无法上传");
                result.setMessage("文件不为图片，无法上传");
                return result;
            }

            File upload = getUploadFile();
            if(!upload.exists()){
                //upload.mkdir(); 创建单层文件夹static，报错
                upload.mkdirs();
            }
            String showName =fileName;
            fileName = fileName.substring(0,fileName.lastIndexOf("."))+System.currentTimeMillis()+"."+suffixName;
            String savePath = upload.getPath()+File.separator+fileName;
            File saveFile = new File(savePath);
            FileCopyUtils.copy(file.getBytes(), saveFile);
            //返回文件名，用户预览时可用
            FileInfoVo fileInfoVo = new FileInfoVo();
            fileInfoVo.setFileName(showName);
            fileInfoVo.setPath(fileName);
            result.setResult(fileInfoVo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            result.error500("上传文件路径错误");
            result.setMessage("上传文件路径错误");
            return result;
        }catch (IOException e) {
            e.printStackTrace();
            result.error500("上传出错");
            result.setMessage("上传出错");
            return result;
        }
        result.setSuccess(true);
        return result;
    }


    /**
     * 查看图片地址
     * @return
     */
    public String getPath(String fileName){
        try {
            return getUploadPath()+ fileName;
        } catch (Exception e) {
            return null;
        }
    }

    private File getUploadFile() throws IOException{

        //如果上传目录为/static/images/upload/,则可以如下获取
        File upload=new File(getUploadPath());
        return upload;
    }

    private String getUploadPath() throws IOException{
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()){
            path=new File("");
        }
        String upLoadPath = path.getAbsolutePath()+File.separator+"static/images/uplaod/";
        return upLoadPath;
    }

    /**
     * 添加app工单执行图片
     * @param file
     * @return
     */
    public Result<FileInfoVo> addWatermarkPic(MultipartFile file,String watermark) {
        Result<FileInfoVo> result = new Result<>();
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf(".")+1);

        if (file.isEmpty()) {
            result.error500("文件不能为空");
            result.setMessage("文件不能为空");
            return result;
        }
        if(file.getSize()>imgSize*1024*1024){
            result.error500("文件大小不能大于"+imgSize+"M");
            result.setMessage("文件大小不能大于"+imgSize+"M");
            return result;
        }

        try {

            boolean isImage = ImageCheckUtil.checkFile(suffixName);
            if(!isImage){
                result.error500("文件不为图片，无法上传");
                result.setMessage("文件不为图片，无法上传");
                return result;
            }

            File upload = getUploadFile();
            if(!upload.exists()){
                //upload.mkdir(); 创建单层文件夹static，报错
                upload.mkdirs();
            }
            String showName =fileName;
            fileName = fileName.substring(0,fileName.lastIndexOf("."))+System.currentTimeMillis()+"."+suffixName;
            String savePath = upload.getPath()+File.separator+fileName;

            //添加水印，并保存
            String[] watermarks = {new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),watermark};
            Color color=new Color(255, 255, 255);
            addWatermark(file,savePath,watermarks,color,null);

            //返回文件名，用户预览时可用
            FileInfoVo fileInfoVo = new FileInfoVo();
            fileInfoVo.setFileName(showName);
            fileInfoVo.setPath(fileName);
            result.setResult(fileInfoVo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            result.error500("上传文件路径错误");
            result.setMessage("上传文件路径错误");
            return result;
        }catch (IOException e) {
            e.printStackTrace();
            result.error500("上传出错");
            result.setMessage("上传出错");
            return result;
        }
        result.setSuccess(true);
        return result;
    }


    /** 设置文字水印
     * @param file 源图片文件
     * @param targetImg 保存的图片路径
     * @param watermarks 水印内容
     * @param color 水印颜色
     * @param degree 水印旋转角度
     * @throws IOException
     */
    public static void addWatermark(MultipartFile file,String targetImg, String[] watermarks, Color color, Integer degree) throws IOException {
        Image srcImg = ImageIO.read(file.getInputStream());
        int srcImgWidth = srcImg.getWidth(null);
        int srcImgHeight = srcImg.getHeight(null);
        BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bufImg.createGraphics();
        g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
        g.setColor(color);
        //设置字体
        g.setFont(new Font("Microsoft YaHei", Font.PLAIN, srcImgWidth/300*10));
        for (int i = 0;i < watermarks.length;i++) {
            //设置水印的坐标
            int x = srcImgWidth - (g.getFontMetrics(g.getFont()).charsWidth(watermarks[i].toCharArray(), 0, watermarks[i].length())+20);
            //int x = 10;
            int y = (int) (srcImgHeight*(1-(watermarks.length-i)*0.05));
            if (null != degree) {
                g.rotate(Math.toRadians(degree),x,y);
            }
            g.drawString(watermarks[i], x, y);  //加水印
        }
        g.dispose();
        // 输出图片
        FileOutputStream outImgStream = new FileOutputStream(targetImg);
        ImageIO.write(bufImg, "jpg", outImgStream);
        outImgStream.flush();
        outImgStream.close();
    }

}

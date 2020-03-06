package com.nongxin.terminal.util;

import com.nongxin.terminal.vo.FileInfoVo;
import com.nongxin.terminal.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;

@Component
public class FileUpload {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUpload.class);

    private final ResourceLoader resourceLoader;

    @Value("${fileSize.file}")
    private Integer fileSize;

    @Autowired
    public FileUpload(ResourceLoader resourceLoader) {
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
        if(file.getSize()>fileSize*1024*1024){
            result.error500("文件大小不能大于"+fileSize+"M");
            result.setMessage("文件大小不能大于"+fileSize+"M");
            return result;
        }
        boolean isFile = ImageCheckUtil.checkFile1(suffixName);
        if(!isFile){
            result.error500("文件不为doc,docx,pdf,mp3,wav,ogg,amr,zip,rar，无法上传");
            result.setMessage("文件不为doc,docx,pdf,mp3,wav,ogg,amr,zip,rar，无法上传");
            return result;
        }

        try {
            File upload = getUploadFile();
            if(!upload.exists()){
                upload.mkdirs();
            }
            String showName = fileName;
            fileName = (fileName.substring(0,fileName.lastIndexOf("."))+System.currentTimeMillis()+"."+suffixName).replace(" ", "");
            String savePath = upload.getPath()+File.separator+fileName;

            //音频文件时长
            BigDecimal duration = null;

            LOGGER.info(suffixName);
            if (suffixName.equals("amr")){
                fileName = (fileName.substring(0,fileName.lastIndexOf("."))+System.currentTimeMillis()+".mp3").replace(" ", "");
                savePath = upload.getPath()+File.separator+fileName;
                showName = showName.substring(0,showName.indexOf("."))+".mp3";
                duration = AmrToMp3.amrToMp3(file,savePath,suffixName);
            }else {
                File saveFile = new File(savePath);
                FileCopyUtils.copy(file.getBytes(), saveFile);
            }

            //返回文件名，用户预览时可用
            FileInfoVo fileInfoVo = new FileInfoVo(fileName,new BigDecimal(file.getSize()/1024),showName);
            fileInfoVo.setDuration(duration);
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
     * 查看文件地址
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
        LOGGER.info("uplload classpath:"+path.getAbsolutePath());
        String upLoadPath = path.getAbsolutePath()+File.separator+"static/file/uplaod/";
        return upLoadPath;
    }

    //文件下载
    public boolean downloadFile(String fileUrl,String fileName, HttpServletResponse response){
        if (fileUrl != null){
            String realPath = getPath(fileUrl);
            LOGGER.info("目录："+ realPath);
            File file = new File(realPath);
            LOGGER.info(file.getPath());
            LOGGER.info("文件是否存在"+file.exists());
            if (file.exists()){
                // 设置强制下载不打开
                response.setContentType("application/force-download");
                //设置文件名
                LOGGER.info(fileUrl);
                //response.setHeader("Content-Disposition","attachment;fileName="+fileUrl);
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try{
                    response.setHeader("Content-Disposition","attachment;fileName="+new String(fileName.getBytes("UTF-8"),"iso-8859-1"));
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i!=-1){
                        os.write(buffer,0,i);
                        i =bis.read(buffer);
                    }
                    return true;
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if (bis !=null){
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null){
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return false;
    }

    //音频播放
    public void getAudio(String fileUrl,HttpServletResponse response) throws Exception{
        //获取路径
        String path = getPath(fileUrl);
        //输出 wav IO流
        FileInputStream fis = null;
        OutputStream out = null;
        response.setHeader("Content-Type", "audio/mpeg;charset=UTF-8");
        File file = new File(path);
        byte[] buf = new byte[2048];
        fis = new FileInputStream(file);
        out = response.getOutputStream();
        int len = 0;
        while ((len = fis.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        if (out != null){
            out.flush();
            out.close();
        }
        if (fis != null){
            fis.close();
        }
    }

    //视频播放
    public void getVideo(String fileUrl,HttpServletResponse response)throws Exception{
        //获取路径
        String path = getPath(fileUrl);
        //输出IO流
        FileInputStream fis = null;
        OutputStream out = null;
        response.setHeader("Content-Type", "video/mp4;charset=UTF-8");

        File file = new File(path);
        byte[] buf = new byte[2048];
        fis = new FileInputStream(file);
        out = response.getOutputStream();
        int len = 0;
        while ((len = fis.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        if (out != null){
            out.flush();
            out.close();
        }
        if (fis != null){
            fis.close();
        }
    }


}

package com.nongxin.terminal.controller.app.common;

import com.nongxin.terminal.service.file.PictureInfoService;
import com.nongxin.terminal.util.ImgUpload;
import com.nongxin.terminal.util.enumUtil.file.ImgRelationTypeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/app/pictureInfo")
public class AppPictureInfoController {

    private Logger logger = LoggerFactory.getLogger(AppPictureInfoController.class);
    @Autowired
    private PictureInfoService pictureInfoService;
    @Autowired
    private ImgUpload imgUpload;

    private final ResourceLoader resourceLoader;
    @Autowired
    public AppPictureInfoController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/delete")
    @ApiOperation("删除图片")
    public Result deletePic(@RequestParam(required = true)Integer id){
        Result result = new Result();
        boolean isSuccess = pictureInfoService.delete(id);
        if (isSuccess){
            result.setMessage("删除图片成功");
        }else {
            result.setMessage("删除图片失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/addOrderPic")
    @ApiOperation("添加工单图片")
    public Result addOrderPic(MultipartFile file,Integer recordId,String watermark,boolean isLocal){
        if (isLocal){
            return pictureInfoService.addWatermarkPic(file,recordId, ImgRelationTypeEnum.WORKORDER,watermark);
        }
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.WORKORDER);
    }

    @PostMapping("/addFeedBackPic")
    @ApiOperation("添加巡视反馈图片")
    public Result addFeedBackPic(MultipartFile file,Integer recordId){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.FEEDBACK);
    }

    @PostMapping("/addIllFeedbackPic")
    @ApiOperation("添加病虫害反馈图片")
    public Result addIllFeedbackPic(MultipartFile file,Integer recordId){
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.ILL_FEEDBACK);
    }

    /**
     * 显示单张图片(本地，rest请求)
     * @return
     */
    @GetMapping(value="/show/{fileName}")
    @ApiOperation(value = "查看本地图片",notes = "根据文件名查看图片")
    public ResponseEntity showPhoto(@PathVariable String fileName){
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + imgUpload.getPath(fileName)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 显示单张图片(本地，rest请求，压缩)
     * @return
     */
    @GetMapping(value="/show/compression/{fileName}/{width}/{height}")
    @ApiOperation(value = "查看本地压缩图片",notes = "根据文件名查看图片")
    public ResponseEntity showCompressionPhoto(@PathVariable String fileName,@PathVariable Integer width,@PathVariable Integer height){
        try {
            logger.info(imgUpload.getPath(fileName));
            ByteArrayOutputStream byteArrayOutputStreamut = new ByteArrayOutputStream();
            Thumbnails.of(imgUpload.getPath(fileName))
                    .size(width,height)    //图片尺寸
                    .outputQuality(1f)      //图片质量
                    .toOutputStream(byteArrayOutputStreamut);
            logger.info("压缩后文件大小：" + byteArrayOutputStreamut.toByteArray().length / 1024 + "kb;");
            return ResponseEntity.ok(byteArrayOutputStreamut.toByteArray());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}

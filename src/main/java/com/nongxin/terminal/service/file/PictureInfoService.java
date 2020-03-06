package com.nongxin.terminal.service.file;

import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.util.enumUtil.file.ImgRelationTypeEnum;
import com.nongxin.terminal.vo.Result;
import org.springframework.web.multipart.MultipartFile;

public interface PictureInfoService {

    //新增图片信息
    Result<PictureInfo> add(MultipartFile file, Integer relationId, ImgRelationTypeEnum imgRelationTypeEnum);

    //新增图片信息
    Result<PictureInfo> addWatermarkPic(MultipartFile file, Integer relationId, ImgRelationTypeEnum imgRelationTypeEnum,String watermark);

    //删除图片信息
    boolean delete(Integer id);

}

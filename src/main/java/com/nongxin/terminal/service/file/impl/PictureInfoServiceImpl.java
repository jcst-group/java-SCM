package com.nongxin.terminal.service.file.impl;

import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.service.file.PictureInfoService;
import com.nongxin.terminal.util.ImgUpload;
import com.nongxin.terminal.util.enumUtil.file.ImgRelationTypeEnum;
import com.nongxin.terminal.util.enumUtil.file.ImgTypeEnum;
import com.nongxin.terminal.vo.FileInfoVo;
import com.nongxin.terminal.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class PictureInfoServiceImpl implements PictureInfoService {

    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired
    private ImgUpload imgUpload;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result add(MultipartFile file, Integer relationId, ImgRelationTypeEnum imgRelationTypeEnum) {
        Result<PictureInfo> result = new Result<>();
        Result<FileInfoVo> result1 = imgUpload.listSample(file);
        if (result1.isSuccess()){
            try {
                PictureInfo pictureInfo = new PictureInfo();
                pictureInfo.setPictureUrl(result1.getResult().getPath());
                pictureInfo.setRelationType(imgRelationTypeEnum);
                pictureInfo.setType(ImgTypeEnum.LOCAL);
                pictureInfo.setRelationId(relationId);
                result.setSuccess(pictureInfoMapper.insertSelective(pictureInfo)==1);
                result.setResult(pictureInfo);
                result.setMessage("新增图片成功");
                return result;
            }catch (Exception e){
                String path = imgUpload.getPath(result1.getResult().getPath());
                File file1 = new File(path);
                if (file1.exists()){
                    file1.delete();
                }
                e.printStackTrace();
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return result1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addWatermarkPic(MultipartFile file, Integer relationId, ImgRelationTypeEnum imgRelationTypeEnum,String watermark) {
        Result<PictureInfo> result = new Result<>();
        Result<FileInfoVo> result1 = imgUpload.addWatermarkPic(file,watermark);
        if (result1.isSuccess()){
            try {
                PictureInfo pictureInfo = new PictureInfo();
                pictureInfo.setPictureUrl(result1.getResult().getPath());
                pictureInfo.setRelationType(imgRelationTypeEnum);
                pictureInfo.setType(ImgTypeEnum.LOCAL);
                pictureInfo.setRelationId(relationId);
                result.setSuccess(pictureInfoMapper.insertSelective(pictureInfo)==1);
                result.setResult(pictureInfo);
                result.setMessage("新增图片成功");
                return result;
            }catch (Exception e){
                String path = imgUpload.getPath(result1.getResult().getPath());
                File file1 = new File(path);
                if (file1.exists()){
                    file1.delete();
                }
                e.printStackTrace();
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return result1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer id) {
        boolean flag = false;
        try {
            PictureInfo pictureInfo = pictureInfoMapper.selectByPrimaryKey(id);
            int delCount = pictureInfoMapper.deleteByPrimaryKey(id);
            if (delCount==1){
                String path = imgUpload.getPath(pictureInfo.getPictureUrl());
                File file = new File(path);
                file.delete();
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return flag;
    }

}

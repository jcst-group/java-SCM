package com.nongxin.terminal.service.traceability.impl;

import com.nongxin.terminal.dao.crop.CropMapper;
import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.dao.traceability.ProTraceabilityMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.traceability.ProTraceability;
import com.nongxin.terminal.service.traceability.ProTraceabilityService;
import com.nongxin.terminal.util.CodeUtil;
import com.nongxin.terminal.util.ImgUpload;
import com.nongxin.terminal.util.enumUtil.common.CodeEnum;
import com.nongxin.terminal.util.enumUtil.file.ImgRelationTypeEnum;
import com.nongxin.terminal.util.enumUtil.file.ImgTypeEnum;
import com.nongxin.terminal.vo.traceability.PictureVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class ProTraceabilityServiceImpl implements ProTraceabilityService {

    @Autowired(required = false)
    private ProTraceabilityMapper proTraceabilityMapper;
    @Autowired(required = false)
    private CropMapper cropMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired
    private ImgUpload imgUpload;


    @Override
    public Object selectByBatchId(Integer batchId) {
        ProTraceability proTraceability = proTraceabilityMapper.selectByBatchId(batchId);
        if (proTraceability == null){
            return cropMapper.selectByBatchId(batchId);
        }
        return proTraceability;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(ProTraceability proTraceability) {
        try {
            ProTraceability proTraceability1 = proTraceabilityMapper.selectByBatchId(proTraceability.getBatchId());
            if (proTraceability1 == null){
                proTraceability.setCropCode(CodeUtil.getCode(CodeEnum.PROTRACEABILITY));
                proTraceabilityMapper.insertSelective(proTraceability);
                //溯源药材图片
                List<PictureInfo> cropPic = proTraceability.getCropPic();
                for (PictureInfo pictureInfo : cropPic) {
                    if (pictureInfo.getPictureUrl() != null){
                        String path = pictureInfo.getPictureUrl();
                        String suffixName = path.substring(path.lastIndexOf(".")+1);
                        File file = new File(imgUpload.getPath(path));
                        String url = (System.currentTimeMillis() +(int)((Math.random()*9+1)*1000)+suffixName);
                        File saveFile = new File(imgUpload.getPath(url));
                        FileCopyUtils.copy(file, saveFile);
                        pictureInfo.setPictureUrl(url);
                        pictureInfo.setRelationId(proTraceability.getId());
                        pictureInfo.setRelationType(ImgRelationTypeEnum.PRO_CROP);
                        pictureInfo.setType(ImgTypeEnum.LOCAL);
                        pictureInfoMapper.insertSelective(pictureInfo);
                    }else {
                        pictureInfo.setRelationId(proTraceability.getId());
                        pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
                    }
                }
                return true;
            }else {
                List<PictureInfo> cropPic = proTraceability.getCropPic();
                for (PictureInfo pictureInfo : cropPic) {
                    pictureInfo.setRelationId(proTraceability.getId());
                    pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
                }
            }
            return proTraceabilityMapper.updateByPrimaryKeySelective(proTraceability)==1;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public Map<String, Object> getBatchAndBase(Integer batchId) {
        return proTraceabilityMapper.getBatchAndBase(batchId);
    }

    @Override
    public Object selectByRetroCode(String retroCode) {
        ProTraceability proTraceability = proTraceabilityMapper.selectByRetroCode(retroCode);
        if (proTraceability == null){
            return cropMapper.selectByRetroCode(retroCode);
        }
        return proTraceability;
    }

    @Override
    public Map<String, Object> getBatchAndBaseByRetroCode(String retroCode) {
        return proTraceabilityMapper.getBatchAndBaseByRetroCode(retroCode);
    }

    @Override
    public PictureVo getDetectionPicByBatchId(Integer batchId) {
        return proTraceabilityMapper.getDetectionPicByBatchId(batchId);
    }
}

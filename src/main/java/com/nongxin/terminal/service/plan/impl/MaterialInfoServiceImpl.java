package com.nongxin.terminal.service.plan.impl;

import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.dao.plant.MaterialInfoMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.plant.MaterialInfo;
import com.nongxin.terminal.service.plan.MaterialInfoService;
import com.nongxin.terminal.util.ImgUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.File;
import java.util.List;

@Service
public class MaterialInfoServiceImpl implements MaterialInfoService {

    @Autowired(required = false)
    private MaterialInfoMapper materialInfoMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired
    private ImgUpload imgUpload;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(MaterialInfo materialInfo) {
        try {
            materialInfoMapper.insertSelective(materialInfo);
            PictureInfo pictureInfo = materialInfo.getPictureInfo();
            if (pictureInfo != null){
                pictureInfo.setRelationId(materialInfo.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer id) {
        try {
            PictureInfo pictureInfo = pictureInfoMapper.getMaterialInfoPic(id);
            if (pictureInfo != null){
                File file = new File(imgUpload.getPath(pictureInfo.getPictureUrl()));
                file.delete();
                pictureInfoMapper.deleteByPrimaryKey(pictureInfo.getId());
            }
            materialInfoMapper.deleteByPrimaryKey(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(MaterialInfo materialInfo) {
        try {
            PictureInfo pictureInfo = materialInfo.getPictureInfo();
            if (pictureInfo != null){
                PictureInfo oldPic = pictureInfoMapper.getMaterialInfoPic(materialInfo.getId());
                if (oldPic != null){
                    File file = new File(imgUpload.getPath(oldPic.getPictureUrl()));
                    file.delete();
                    pictureInfoMapper.deleteByPrimaryKey(oldPic.getId());
                }
                pictureInfo.setRelationId(materialInfo.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
            }
            materialInfoMapper.updateByPrimaryKeySelective(materialInfo);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public List<MaterialInfo> selectByFarmingId(Integer farmingId) {
        return materialInfoMapper.selectByFarmingId(farmingId);
    }
}

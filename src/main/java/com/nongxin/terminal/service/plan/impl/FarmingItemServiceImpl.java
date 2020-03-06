package com.nongxin.terminal.service.plan.impl;

import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.dao.plant.FarmingItemMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.plant.FarmingItem;
import com.nongxin.terminal.service.plan.FarmingItemService;
import com.nongxin.terminal.util.ImgUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.File;
import java.util.List;

@Service
public class FarmingItemServiceImpl implements FarmingItemService {

    @Autowired(required = false)
    private FarmingItemMapper farmingItemMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired
    private ImgUpload imgUpload;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(FarmingItem farmingItem) {
        try {
            farmingItemMapper.insertSelective(farmingItem);
            List<PictureInfo> list = farmingItem.getPictureInfoList();
            if (list != null && !list.isEmpty()){
                for (PictureInfo pictureInfo : list){
                    pictureInfo.setRelationId(farmingItem.getId());
                    pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
                }
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
    public boolean delete(Integer id){
        try {
            boolean isSuccess = farmingItemMapper.deleteByPrimaryKey(id)==1;
            List<PictureInfo> list = pictureInfoMapper.getFarmingItemPic(id);
            if (isSuccess){
                if (list != null && !list.isEmpty()){
                    for (PictureInfo pictureInfo : list){
                        File file = new File(imgUpload.getPath(pictureInfo.getPictureUrl()));
                        file.delete();
                        pictureInfoMapper.deleteByPrimaryKey(pictureInfo.getId());
                    }
                }
            }
            return true;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw e;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(FarmingItem farmingItem) {
        try {
            //新图片
            List<PictureInfo> list = farmingItem.getPictureInfoList();
            //删除旧图片
            List<PictureInfo> oldList = pictureInfoMapper.getFarmingItemPic(farmingItem.getId());
            if (oldList != null && !oldList.isEmpty()){
                for (PictureInfo pictureInfo : oldList){
                    boolean isDelete = true;
                    for (PictureInfo pictureInfo1 : list){
                        if (pictureInfo.getId().equals(pictureInfo1.getId())){
                            isDelete = false;
                        }
                    }
                    if (isDelete){
                        File file = new File(imgUpload.getPath(pictureInfo.getPictureUrl()));
                        file.delete();
                        pictureInfoMapper.deleteByPrimaryKey(pictureInfo.getId());
                    }
                }
            }

            //绑定新图片
            if (list != null && !list.isEmpty()){
                for (PictureInfo pictureInfo : list){
                    pictureInfo.setRelationId(farmingItem.getId());
                    pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
                }
            }

            farmingItemMapper.updateByPrimaryKeySelective(farmingItem);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public List<FarmingItem> getFarmingItemList(Integer cropId) {
        return farmingItemMapper.getFarmingItemList(cropId);
    }

    @Override
    public List<FarmingItem> getAllFarmingItem() {
        return farmingItemMapper.getAllFarmingItem();
    }

    @Override
    public List<FarmingItem> getFarmingItemByCropId(Integer cropId) {
        return farmingItemMapper.getFarmingItemByCropId(cropId);
    }

    @Override
    public FarmingItem selectByPrimaryKey(Integer id) {
        return farmingItemMapper.selectByPrimaryKey(id);
    }
}

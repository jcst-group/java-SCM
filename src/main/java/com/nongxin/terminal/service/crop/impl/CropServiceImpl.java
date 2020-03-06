package com.nongxin.terminal.service.crop.impl;

import com.nongxin.terminal.dao.crop.CropMapper;
import com.nongxin.terminal.dao.crop.CropProductMapper;
import com.nongxin.terminal.dao.crop.HarvestedProductMapper;
import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.dao.product.LevelMapper;
import com.nongxin.terminal.dao.product.ProLevelRelMapper;
import com.nongxin.terminal.dao.product.ProductsMapper;
import com.nongxin.terminal.entity.crop.Crop;
import com.nongxin.terminal.entity.crop.CropProduct;
import com.nongxin.terminal.entity.crop.HarvestedProduct;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.product.Level;
import com.nongxin.terminal.entity.product.ProLevelRel;
import com.nongxin.terminal.entity.product.Products;
import com.nongxin.terminal.service.crop.CropService;
import com.nongxin.terminal.util.ImgUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class CropServiceImpl implements CropService {

    @Autowired(required = false)
    private CropMapper cropMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired(required = false)
    private HarvestedProductMapper harvestedProductMapper;
    @Autowired(required = false)
    private CropProductMapper cropProductMapper;
    @Autowired(required = false)
    private ImgUpload imgUpload;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(Crop crop) {
        try {
            cropMapper.insertSelective(crop);
            PictureInfo cropPic = crop.getCropPic();
            cropPic.setRelationId(crop.getId());
            pictureInfoMapper.updateByPrimaryKeySelective(cropPic);

            PictureInfo ediblePic = crop.getEdiblePic();
            ediblePic.setRelationId(crop.getId());
            pictureInfoMapper.updateByPrimaryKeySelective(ediblePic);

            PictureInfo medicinalPic = crop.getMedicinalPic();
            medicinalPic.setRelationId(crop.getId());
            pictureInfoMapper.updateByPrimaryKeySelective(medicinalPic);

            if (crop.getHarvestedProductList()!=null){
                for (HarvestedProduct harvestedProduct : crop.getHarvestedProductList()) {
                    harvestedProduct.setCropId(crop.getId());
                    harvestedProductMapper.insertSelective(harvestedProduct);
                    List<CropProduct> cropProductList = harvestedProduct.getCropProductList();
                    if (cropProductList != null && !cropProductList.isEmpty()){
                        for (CropProduct cropProduct : harvestedProduct.getCropProductList()) {
                            cropProduct.setHarvestedId(harvestedProduct.getId());
                            cropProductMapper.insertSelective(cropProduct);
                        }
                    }
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
    public boolean delete(Integer id) {
        return cropMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(Crop crop) {
        try {
            cropMapper.updateByPrimaryKeySelective(crop);
            /*harvestedProductMapper.deleteByCropId(crop.getId());*/
            for (HarvestedProduct harvestedProduct : crop.getHarvestedProductList()) {
                harvestedProduct.setCropId(crop.getId());
                if (harvestedProduct.getId() == null){
                    harvestedProductMapper.insertSelective(harvestedProduct);
                }else{
                    harvestedProductMapper.updateByPrimaryKeySelective(harvestedProduct);
                }
                List<CropProduct> cropProductList = harvestedProduct.getCropProductList();
                cropProductMapper.deleteByHarvestedId(harvestedProduct.getId());
                if (cropProductList != null && !cropProductList.isEmpty()){
                    for (CropProduct cropProduct : harvestedProduct.getCropProductList()) {
                        cropProduct.setHarvestedId(harvestedProduct.getId());
                        cropProductMapper.insertSelective(cropProduct);
                    }
                }
            }

            PictureInfo cropPic = crop.getCropPic();
            if (cropPic!=null){
                PictureInfo oldCropPic = pictureInfoMapper.getCropPic(crop.getId());
                if (oldCropPic != null){
                    File file = new File(imgUpload.getPath(oldCropPic.getPictureUrl()));
                    file.delete();
                    pictureInfoMapper.deleteByPrimaryKey(oldCropPic.getId());
                }
                cropPic.setRelationId(crop.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(cropPic);
            }

            PictureInfo ediblePic = crop.getEdiblePic();
            if (ediblePic!=null){
                PictureInfo oldEdiblePic = pictureInfoMapper.getEdiblePic(crop.getId());
                if (oldEdiblePic != null){
                    File file = new File(imgUpload.getPath(oldEdiblePic.getPictureUrl()));
                    file.delete();
                    pictureInfoMapper.deleteByPrimaryKey(oldEdiblePic.getId());
                }
                ediblePic.setRelationId(crop.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(ediblePic);
            }

            PictureInfo medicinalPic = crop.getMedicinalPic();
            if (medicinalPic!=null){
                PictureInfo oldMedicinalPic = pictureInfoMapper.getMedicinalPic(crop.getId());
                if (oldMedicinalPic != null){
                    File file = new File(imgUpload.getPath(oldMedicinalPic.getPictureUrl()));
                    file.delete();
                    pictureInfoMapper.deleteByPrimaryKey(oldMedicinalPic.getId());
                }
                medicinalPic.setRelationId(crop.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(medicinalPic);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public List<Crop> getCropList() {
        return cropMapper.getCropList();
    }

    @Override
    public List<Crop> getAllCropList() {
        return cropMapper.getAllCropList();
    }

    @Override
    public Crop getIdAndNameById(Integer id) {
        return cropMapper.getIdAndNameById(id);
    }
}

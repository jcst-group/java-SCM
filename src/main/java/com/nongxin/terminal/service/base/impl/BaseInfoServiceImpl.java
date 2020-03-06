package com.nongxin.terminal.service.base.impl;

import com.nongxin.terminal.dao.address.AddressMapper;
import com.nongxin.terminal.dao.base.BaseInfoMapper;
import com.nongxin.terminal.dao.base.BaseTestingMapper;
import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.entity.address.Address;
import com.nongxin.terminal.entity.base.BaseInfo;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.service.base.BaseInfoService;
import com.nongxin.terminal.util.ImgUpload;
import com.nongxin.terminal.util.enumUtil.base.BaseTypeEnum;
import com.nongxin.terminal.util.enumUtil.base.CategoryEnum;
import com.nongxin.terminal.util.enumUtil.common.AddressRelateTypeEnum;
import com.nongxin.terminal.vo.TreeNodeVo;
import com.nongxin.terminal.vo.lookboard.BaseInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class BaseInfoServiceImpl implements BaseInfoService {

    @Autowired(required = false)
    private BaseInfoMapper baseInfoMapper;
    @Autowired(required = false)
    private BaseTestingMapper baseTestingMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired(required = false)
    private AddressMapper addressMapper;
    @Autowired
    private ImgUpload imgUpload;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(BaseInfo baseInfo) {
        try {
            baseInfoMapper.insertSelective(baseInfo);
            if (baseInfo.getBaseTestingVoList()!=null && !baseInfo.getBaseTestingVoList().isEmpty()){
                baseTestingMapper.addBaseTesting(baseInfo.getBaseTestingVoList(),baseInfo.getId());
            }
            PictureInfo basePic = baseInfo.getBasePic();
            basePic.setRelationId(baseInfo.getId());
            pictureInfoMapper.updateByPrimaryKeySelective(basePic);

            PictureInfo soilPic = baseInfo.getSoilPic();
            soilPic.setRelationId(baseInfo.getId());
            pictureInfoMapper.updateByPrimaryKeySelective(soilPic);

            PictureInfo airPic = baseInfo.getAirPic();
            airPic.setRelationId(baseInfo.getId());
            pictureInfoMapper.updateByPrimaryKeySelective(airPic);

            PictureInfo waterPic = baseInfo.getWaterPic();
            waterPic.setRelationId(baseInfo.getId());
            pictureInfoMapper.updateByPrimaryKeySelective(waterPic);

            Address address = baseInfo.getAddress();
            address.setRelateId(baseInfo.getId());
            address.setRelateType(AddressRelateTypeEnum.BASE_ADDRESS);
            addressMapper.insertSelective(address);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return baseInfoMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(BaseInfo baseInfo) {
        try {
            baseInfoMapper.updateByPrimaryKeySelective(baseInfo);
            Address address = baseInfo.getAddress();
            if (address != null){
                address.setRelateId(baseInfo.getId());
                address.setRelateType(AddressRelateTypeEnum.BASE_ADDRESS);
                addressMapper.updateByPrimaryKeySelective(address);
            }
            if (baseInfo.getBaseTestingVoList()!=null && !baseInfo.getBaseTestingVoList().isEmpty()){
                baseTestingMapper.deleteByBaseId(baseInfo.getId());
                baseTestingMapper.addBaseTesting(baseInfo.getBaseTestingVoList(),baseInfo.getId());
            }

            PictureInfo basePic = baseInfo.getBasePic();
            if (basePic!=null){
                PictureInfo oldBasePic = pictureInfoMapper.getBasePic(baseInfo.getId());
                if (oldBasePic != null){
                    File file = new File(imgUpload.getPath(oldBasePic.getPictureUrl()));
                    file.delete();
                    pictureInfoMapper.deleteByPrimaryKey(oldBasePic.getId());
                }
                basePic.setRelationId(baseInfo.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(basePic);
            }

            PictureInfo soilPic = baseInfo.getSoilPic();
            if (soilPic!=null){
                PictureInfo oldSoilPic = pictureInfoMapper.getSoilPic(baseInfo.getId());
                if (oldSoilPic != null){
                    File file = new File(imgUpload.getPath(oldSoilPic.getPictureUrl()));
                    file.delete();
                    pictureInfoMapper.deleteByPrimaryKey(oldSoilPic.getId());
                }
                soilPic.setRelationId(baseInfo.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(soilPic);
            }

            PictureInfo airPic = baseInfo.getAirPic();
            if (airPic!=null){
                PictureInfo oldAirPic = pictureInfoMapper.getAirPic(baseInfo.getId());
                if (oldAirPic != null){
                    File file = new File(imgUpload.getPath(airPic.getPictureUrl()));
                    file.delete();
                    pictureInfoMapper.deleteByPrimaryKey(oldAirPic.getId());
                }
                airPic.setRelationId(baseInfo.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(airPic);
            }

            PictureInfo waterPic = baseInfo.getWaterPic();
            if (waterPic!=null){
                PictureInfo oldWaterPic = pictureInfoMapper.getWaterPic(baseInfo.getId());
                if (oldWaterPic != null){
                    File file = new File(imgUpload.getPath(oldWaterPic.getPictureUrl()));
                    file.delete();
                    pictureInfoMapper.deleteByPrimaryKey(oldWaterPic.getId());
                }
                waterPic.setRelationId(baseInfo.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(waterPic);
            }

            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public List<BaseInfo> getBaseInfoList(BaseInfo baseInfo) {
        return baseInfoMapper.getBaseInfoList(baseInfo);
    }

    @Override
    public List<BaseInfo> getAllBaseInfo(CategoryEnum category, BaseTypeEnum baseType, String baseName) {
        return baseInfoMapper.getAllBaseInfo(category,baseType,baseName);
    }

    @Override
    public List<BaseInfo> getBaseByType(Integer baseType) {
        return baseInfoMapper.getBaseByType(baseType);
    }

    @Override
    public List<BaseInfo> getBaseWithoutUser() {
        return baseInfoMapper.getBaseWithoutUser();
    }

    @Override
    public BaseInfo selectByPrimaryKey(Integer id) {
        return baseInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public BaseInfoVo getBaseInfoById(Integer baseId) {
        return baseInfoMapper.getBaseInfoById(baseId);
    }

    @Override
    public List<TreeNodeVo> getBaseTreeByUid(Integer uid) {
        return baseInfoMapper.getBaseTreeByUid(uid);
    }

    @Override
    public List<BaseInfo> getBaseEquipment() {
        return baseInfoMapper.getBaseEquipment();
    }

    @Override
    public List<Map<String, Object>> getBaseByUidAndEqui(Integer uid) {
        return baseInfoMapper.getBaseByUidAndEqui(uid);
    }

    @Override
    public BaseInfo getBaseById(Integer id) {
        return baseInfoMapper.getBaseById(id);
    }

    @Override
    public List<Map<String, Object>> getBaseByUid(Integer uid) {
        return baseInfoMapper.getBaseByUid(uid);
    }

}

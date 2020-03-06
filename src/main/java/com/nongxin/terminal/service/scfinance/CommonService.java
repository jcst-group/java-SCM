package com.nongxin.terminal.service.scfinance;

import com.nongxin.terminal.dao.address.AddressMapper;
import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.entity.address.Address;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.service.file.PictureInfoService;
import com.nongxin.terminal.util.ImgUpload;
import com.nongxin.terminal.util.enumUtil.common.AddressRelateTypeEnum;
import com.nongxin.terminal.util.enumUtil.file.ImgRelationTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommonService {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private PictureInfoMapper pictureInfoMapper;

    @Autowired
    private PictureInfoService pictureInfoService;

    @Autowired
    private ImgUpload imgUpload;

    public boolean saveOrUpdateAddress(Address address,Integer relateId, AddressRelateTypeEnum addressRelateTypeEnum ) {



        if(address!=null ){
            address.setRelateId(relateId);
            address.setRelateType(addressRelateTypeEnum);

            int i = addressMapper.deleteAddress(relateId, addressRelateTypeEnum.getValue().toString());
            addressMapper.insertSelective(address);
        }
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("id",entity.getId());
//        FinanceCominfo financeCominfo = financeCominfoMapper.queryFinanceCominfo(queryWrapper);

        return true;
    }



    /**
     * 删除图片文件
     * @param pics
     * @return
     */
    public boolean deletePics(List<String> pics){

        try {
            pics = pics==null?new ArrayList():pics;
            for(String s : pics){
                String path = imgUpload.getPath(s);
                File file = new File(path);
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
        return true;


    }


    public boolean savePictures(List<PictureInfo> pictureInfos, Integer relateId, ImgRelationTypeEnum imgRelationTypeEnum){


        pictureInfos = pictureInfos==null? new ArrayList():pictureInfos;

        List<PictureInfo> deletePics = new ArrayList<>();

        List<PictureInfo> oldPictureInfos = pictureInfoMapper.selectByRelation(relateId, imgRelationTypeEnum.getValue().intValue());

        //遍历所有旧图片，找出已经被删除的图片
        for(PictureInfo p:oldPictureInfos){
            //判断旧图片p是否在新图片pictureInfos里，在的话代表不存要删除
            List<PictureInfo> collect = pictureInfos.stream().filter(x -> x.getId().equals(p.getId())).collect(Collectors.toList());
            if(collect.size()==0){
                deletePics.add(p);
            }
        }

        for(PictureInfo p:deletePics){
            pictureInfoService.delete(p.getId());
        }

        //pictureInfoMapper.deleteByRelation()

        //传过来的图片只有ID
        for(PictureInfo p:pictureInfos){
            Integer id = p.getId();
            if(id != null){
                PictureInfo pictureInfo = pictureInfoMapper.selectByPrimaryKey(id);
                pictureInfo.setRelationId(relateId);
                pictureInfo.setRelationType(imgRelationTypeEnum);
                pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
            }

        }

        return true;
    }



}

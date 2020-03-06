package com.nongxin.terminal.service.finance.impl;

import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.dao.finance.BasePurchaseMapper;
import com.nongxin.terminal.dao.finance.ContractYearMapper;
import com.nongxin.terminal.dao.system.ConstantStorageMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.finance.BasePurchase;
import com.nongxin.terminal.entity.finance.ContractYear;
import com.nongxin.terminal.service.finance.BasePurchaseService;
import com.nongxin.terminal.support.BaseException;
import com.nongxin.terminal.util.ImgUpload;
import com.nongxin.terminal.util.enumUtil.system.ConstantTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BasePurchaseServiceImpl implements BasePurchaseService {

    @Autowired(required = false)
    private BasePurchaseMapper basePurchaseMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired(required = false)
    private ConstantStorageMapper constantStorageMapper;
    @Autowired
    private ImgUpload imgUpload;
    @Autowired(required = false)
    private ContractYearMapper contractYearMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(BasePurchase basePurchase) {
        String year = new SimpleDateFormat("yyyy").format(basePurchase.getSignTime());
        ContractYear contractYear = contractYearMapper.selectByYear(year);
        if (contractYear != null){
            basePurchase.setYearId(contractYear.getId());
        }else {
            contractYear = new ContractYear();
            contractYear.setYear(year+"年");
            contractYearMapper.insertSelective(contractYear);
            basePurchase.setYearId(contractYear.getId());
        }
        basePurchaseMapper.insertSelective(basePurchase);
        List<PictureInfo> list = basePurchase.getPictureInfos();
        if (list != null && !list.isEmpty()){
            for (PictureInfo pictureInfo : list){
                pictureInfo.setRelationId(basePurchase.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer id) {
        List<PictureInfo> pictureInfos = pictureInfoMapper.getBasePurchasePic(id);
        if (pictureInfos != null && !pictureInfos.isEmpty()){
            for (PictureInfo pictureInfo : pictureInfos) {
                File file = new File(imgUpload.getPath(pictureInfo.getPictureUrl()));
                file.delete();
                pictureInfoMapper.deleteByPrimaryKey(pictureInfo.getId());
            }
        }
        return basePurchaseMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(BasePurchase basePurchase) {
        String year = new SimpleDateFormat("yyyy").format(basePurchase.getSignTime());
        ContractYear contractYear = contractYearMapper.selectByYear(year);
        if (contractYear != null){
            basePurchase.setYearId(contractYear.getId());
        }else {
            contractYear = new ContractYear();
            contractYear.setYear(year+"年");
            contractYearMapper.insertSelective(contractYear);
            basePurchase.setYearId(contractYear.getId());
        }
        return basePurchaseMapper.updateByPrimaryKeySelective(basePurchase)==1;
    }

    @Override
    public List<BasePurchase> getBasePurchaseList(Integer yearId) {
        return basePurchaseMapper.getBasePurchase(yearId);
    }

    @Override
    public Map<String, Object> boardBasePurchase(Integer baseId){
        Map<String,Object> map = new HashMap<>();
        BigDecimal acreage = basePurchaseMapper.getAcreageSum(baseId);
        if (acreage == null){
            return null;
        }
        //预估价格
        BigDecimal estimatedPrice = new BigDecimal(constantStorageMapper.selectByType(ConstantTypeEnum.ESTIMATED_PRICE).getConstant());
        //亩产量
        BigDecimal output = new BigDecimal(constantStorageMapper.selectByType(ConstantTypeEnum.OUTPUT_MU).getConstant());
        //预估产量
        BigDecimal estimatedOutput = acreage.multiply(output);
        map.put("acreage",acreage);
        map.put("estimatedPrice",estimatedPrice);
        map.put("estimatedOutput",estimatedOutput);
        map.put("estimatedValue",estimatedOutput.multiply(estimatedPrice));
        return map;
    }
}

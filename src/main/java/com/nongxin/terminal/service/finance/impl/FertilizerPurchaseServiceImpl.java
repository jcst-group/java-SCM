package com.nongxin.terminal.service.finance.impl;

import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.dao.finance.ContractYearMapper;
import com.nongxin.terminal.dao.finance.FertilizerPurchaseMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.finance.ContractYear;
import com.nongxin.terminal.entity.finance.FertilizerPurchase;
import com.nongxin.terminal.service.finance.FertilizerPurchaseService;
import com.nongxin.terminal.util.ImgUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class FertilizerPurchaseServiceImpl implements FertilizerPurchaseService {

    @Autowired(required = false)
    private FertilizerPurchaseMapper fertilizerPurchaseMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired
    private ImgUpload imgUpload;
    @Autowired(required = false)
    private ContractYearMapper contractYearMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(FertilizerPurchase fertilizerPurchase) {
        String year = new SimpleDateFormat("yyyy").format(fertilizerPurchase.getSignTime());
        ContractYear contractYear = contractYearMapper.selectByYear(year);
        if (contractYear != null){
            fertilizerPurchase.setYearId(contractYear.getId());
        }else {
            contractYear = new ContractYear();
            contractYear.setYear(year+"年");
            contractYearMapper.insertSelective(contractYear);
            fertilizerPurchase.setYearId(contractYear.getId());
        }
        fertilizerPurchaseMapper.insertSelective(fertilizerPurchase);
        List<PictureInfo> list = fertilizerPurchase.getPictureInfos();
        if (list != null && !list.isEmpty()){
            for (PictureInfo pictureInfo : list){
                pictureInfo.setRelationId(fertilizerPurchase.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer id) {
        List<PictureInfo> pictureInfos = pictureInfoMapper.getFertilizerPurchasePic(id);
        if (pictureInfos != null && !pictureInfos.isEmpty()){
            for (PictureInfo pictureInfo : pictureInfos) {
                File file = new File(imgUpload.getPath(pictureInfo.getPictureUrl()));
                file.delete();
                pictureInfoMapper.deleteByPrimaryKey(pictureInfo.getId());
            }
        }
        return fertilizerPurchaseMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(FertilizerPurchase fertilizerPurchase) {
        String year = new SimpleDateFormat("yyyy").format(fertilizerPurchase.getSignTime());
        ContractYear contractYear = contractYearMapper.selectByYear(year);
        if (contractYear != null){
            fertilizerPurchase.setYearId(contractYear.getId());
        }else {
            contractYear = new ContractYear();
            contractYear.setYear(year+"年");
            contractYearMapper.insertSelective(contractYear);
            fertilizerPurchase.setYearId(contractYear.getId());
        }
        return fertilizerPurchaseMapper.updateByPrimaryKeySelective(fertilizerPurchase)==1;
    }

    @Override
    public List<FertilizerPurchase> getFertilizerPurchaseList(Integer yearId) {
        return fertilizerPurchaseMapper.getFertilizerPurchase(yearId);
    }

    @Override
    public List<Map<String, Object>> getBoardFertilizerPurchase() {
        return fertilizerPurchaseMapper.getBoardFertilizerPurchase();
    }
}

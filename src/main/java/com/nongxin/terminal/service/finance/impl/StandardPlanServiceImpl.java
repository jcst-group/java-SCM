package com.nongxin.terminal.service.finance.impl;

import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.dao.finance.ContractYearMapper;
import com.nongxin.terminal.dao.finance.StandardPlanMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.finance.ContractYear;
import com.nongxin.terminal.entity.finance.StandardPlan;
import com.nongxin.terminal.service.finance.StandardPlanService;
import com.nongxin.terminal.support.BaseException;
import com.nongxin.terminal.util.ImgUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class StandardPlanServiceImpl implements StandardPlanService {

    @Autowired(required = false)
    private StandardPlanMapper standardPlanMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired
    private ImgUpload imgUpload;
    @Autowired(required = false)
    private ContractYearMapper contractYearMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(StandardPlan standardPlan) throws BaseException {
        int count = standardPlanMapper.getCount(standardPlan.getPartyB(), standardPlan.getYearId(), null);
        if (count > 0){
            throw new BaseException(500,"该基地已被托管，无法重复添加！！");
        }
        String year = new SimpleDateFormat("yyyy").format(standardPlan.getSignTime());
        ContractYear contractYear = contractYearMapper.selectByYear(year);
        if (contractYear != null){
            standardPlan.setYearId(contractYear.getId());
        }else {
            contractYear = new ContractYear();
            contractYear.setYear(year+"年");
            contractYearMapper.insertSelective(contractYear);
            standardPlan.setYearId(contractYear.getId());
        }
        standardPlanMapper.insertSelective(standardPlan);
        List<PictureInfo> list = standardPlan.getPictureInfos();
        if (list != null && !list.isEmpty()){
            for (PictureInfo pictureInfo : list){
                pictureInfo.setRelationId(standardPlan.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer id) {
        List<PictureInfo> pictureInfos = pictureInfoMapper.getStandardPlanPic(id);
        if (pictureInfos != null && !pictureInfos.isEmpty()){
            for (PictureInfo pictureInfo : pictureInfos) {
                File file = new File(imgUpload.getPath(pictureInfo.getPictureUrl()));
                file.delete();
                pictureInfoMapper.deleteByPrimaryKey(pictureInfo.getId());
            }
        }
        return standardPlanMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(StandardPlan standardPlan) throws BaseException {
        int count = standardPlanMapper.getCount(standardPlan.getPartyB(), standardPlan.getYearId(), standardPlan.getId());
        if (count > 0){
            throw new BaseException(500,"该基地已被托管，无法重复添加！！");
        }
        String year = new SimpleDateFormat("yyyy").format(standardPlan.getSignTime());
        ContractYear contractYear = contractYearMapper.selectByYear(year);
        if (contractYear != null){
            standardPlan.setYearId(contractYear.getId());
        }else {
            contractYear = new ContractYear();
            contractYear.setYear(year+"年");
            contractYearMapper.insertSelective(contractYear);
            standardPlan.setYearId(contractYear.getId());
        }
        return standardPlanMapper.updateByPrimaryKeySelective(standardPlan)==1;
    }

    @Override
    public List<StandardPlan> getStandardPlanList(Integer yearId) {
        return standardPlanMapper.getStandardPlan(yearId);
    }

    @Override
    public Map<String, Object> getBoardStandardPlan(Integer baseId) {
        return standardPlanMapper.getBoardStandardPlan(baseId);
    }
}

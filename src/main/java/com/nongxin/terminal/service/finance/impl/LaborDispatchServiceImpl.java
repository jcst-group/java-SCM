package com.nongxin.terminal.service.finance.impl;

import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.dao.finance.ContractYearMapper;
import com.nongxin.terminal.dao.finance.LaborDispatchMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.finance.ContractYear;
import com.nongxin.terminal.entity.finance.LaborDispatch;
import com.nongxin.terminal.service.finance.LaborDispatchService;
import com.nongxin.terminal.util.ImgUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class LaborDispatchServiceImpl implements LaborDispatchService {

    @Autowired(required = false)
    private LaborDispatchMapper laborDispatchMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired
    private ImgUpload imgUpload;
    @Autowired(required = false)
    private ContractYearMapper contractYearMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(LaborDispatch laborDispatch) {
        String year = new SimpleDateFormat("yyyy").format(laborDispatch.getSignTime());
        ContractYear contractYear = contractYearMapper.selectByYear(year);
        if (contractYear != null){
            laborDispatch.setYearId(contractYear.getId());
        }else {
            contractYear = new ContractYear();
            contractYear.setYear(year+"年");
            contractYearMapper.insertSelective(contractYear);
            laborDispatch.setYearId(contractYear.getId());
        }
        laborDispatchMapper.insertSelective(laborDispatch);
        List<PictureInfo> list = laborDispatch.getPictureInfos();
        if (list != null && !list.isEmpty()){
            for (PictureInfo pictureInfo : list){
                pictureInfo.setRelationId(laborDispatch.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer id) {
        List<PictureInfo> pictureInfos = pictureInfoMapper.getLaborDispatchPic(id);
        if (pictureInfos != null && !pictureInfos.isEmpty()){
            for (PictureInfo pictureInfo : pictureInfos) {
                File file = new File(imgUpload.getPath(pictureInfo.getPictureUrl()));
                file.delete();
                pictureInfoMapper.deleteByPrimaryKey(pictureInfo.getId());
            }
        }
        return laborDispatchMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(LaborDispatch laborDispatch) {
        String year = new SimpleDateFormat("yyyy").format(laborDispatch.getSignTime());
        ContractYear contractYear = contractYearMapper.selectByYear(year);
        if (contractYear != null){
            laborDispatch.setYearId(contractYear.getId());
        }else {
            contractYear = new ContractYear();
            contractYear.setYear(year+"年");
            contractYearMapper.insertSelective(contractYear);
            laborDispatch.setYearId(contractYear.getId());
        }
        return laborDispatchMapper.updateByPrimaryKeySelective(laborDispatch)==1;
    }

    @Override
    public List<LaborDispatch> getLaborDispatchList(Integer yearId) {
        return laborDispatchMapper.getLaborDispatch(yearId);
    }

    @Override
    public Map<String, Object> getBoardLaborDispatch() {
        return laborDispatchMapper.getBoardLaborDispatch();
    }
}

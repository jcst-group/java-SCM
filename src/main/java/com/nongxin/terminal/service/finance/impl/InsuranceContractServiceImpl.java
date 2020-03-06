package com.nongxin.terminal.service.finance.impl;

import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.dao.finance.InsuranceContractMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.finance.InsuranceContract;
import com.nongxin.terminal.service.finance.InsuranceContractService;
import com.nongxin.terminal.util.ImgUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class InsuranceContractServiceImpl implements InsuranceContractService {

    @Autowired(required = false)
    private InsuranceContractMapper insuranceContractMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired
    private ImgUpload imgUpload;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(InsuranceContract insuranceContract) {
        insuranceContractMapper.insertSelective(insuranceContract);
        List<PictureInfo> list = insuranceContract.getPictureInfos();
        if (list != null && !list.isEmpty()){
            for (PictureInfo pictureInfo : list){
                pictureInfo.setRelationId(insuranceContract.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer id) {
        List<PictureInfo> pictureInfos = pictureInfoMapper.getInsuranceContractPic(id);
        if (pictureInfos != null && !pictureInfos.isEmpty()){
            for (PictureInfo pictureInfo : pictureInfos) {
                File file = new File(imgUpload.getPath(pictureInfo.getPictureUrl()));
                file.delete();
                pictureInfoMapper.deleteByPrimaryKey(pictureInfo.getId());
            }
        }
        return insuranceContractMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(InsuranceContract insuranceContract) {
        return insuranceContractMapper.updateByPrimaryKeySelective(insuranceContract)==1;
    }

    @Override
    public List<InsuranceContract> getInsuranceContractList(Integer yearId) {
        return insuranceContractMapper.getInsuranceContract(yearId);
    }

    @Override
    public Map<String, Object> getBoardInsuranceContract(Integer baseId) {
        return insuranceContractMapper.getBoardInsuranceContract(baseId);
    }
}

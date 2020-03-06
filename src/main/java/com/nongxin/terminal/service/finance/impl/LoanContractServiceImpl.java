package com.nongxin.terminal.service.finance.impl;

import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.dao.finance.LoanContractMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.finance.LoanContract;
import com.nongxin.terminal.service.finance.LoanContractService;
import com.nongxin.terminal.util.ImgUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class LoanContractServiceImpl implements LoanContractService {

    @Autowired(required = false)
    private LoanContractMapper loanContractMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired
    private ImgUpload imgUpload;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(LoanContract loanContract) {
        loanContractMapper.insertSelective(loanContract);
        List<PictureInfo> list = loanContract.getPictureInfos();
        if (list != null && !list.isEmpty()){
            for (PictureInfo pictureInfo : list){
                pictureInfo.setRelationId(loanContract.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer id) {
        List<PictureInfo> pictureInfos = pictureInfoMapper.getLoanContractPic(id);
        if (pictureInfos != null && !pictureInfos.isEmpty()){
            for (PictureInfo pictureInfo : pictureInfos) {
                File file = new File(imgUpload.getPath(pictureInfo.getPictureUrl()));
                file.delete();
                pictureInfoMapper.deleteByPrimaryKey(pictureInfo.getId());
            }
        }
        return loanContractMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(LoanContract loanContract) {
        return loanContractMapper.updateByPrimaryKeySelective(loanContract)==1;
    }

    @Override
    public List<LoanContract> getLoanContractList(Integer yearId) {
        return loanContractMapper.getLoanContract(yearId);
    }

    @Override
    public List<Map<String, Object>> getBoardLoanContract() {
        return loanContractMapper.getBoardLoanContract();
    }
}

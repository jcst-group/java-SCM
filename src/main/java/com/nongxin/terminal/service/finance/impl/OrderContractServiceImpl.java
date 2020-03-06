package com.nongxin.terminal.service.finance.impl;

import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.dao.finance.ContractYearMapper;
import com.nongxin.terminal.dao.finance.OrderContractMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.finance.ContractYear;
import com.nongxin.terminal.entity.finance.OrderContract;
import com.nongxin.terminal.service.finance.OrderContractService;
import com.nongxin.terminal.util.ImgUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class OrderContractServiceImpl implements OrderContractService {

    @Autowired(required = false)
    private OrderContractMapper orderContractMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired
    private ImgUpload imgUpload;
    @Autowired(required = false)
    private ContractYearMapper contractYearMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(OrderContract orderContract) {
        String year = new SimpleDateFormat("yyyy").format(orderContract.getSignTime());
        ContractYear contractYear = contractYearMapper.selectByYear(year);
        if (contractYear != null){
            orderContract.setYearId(contractYear.getId());
        }else {
            contractYear = new ContractYear();
            contractYear.setYear(year+"年");
            contractYearMapper.insertSelective(contractYear);
            orderContract.setYearId(contractYear.getId());
        }
        orderContractMapper.insertSelective(orderContract);
        List<PictureInfo> list = orderContract.getPictureInfos();
        if (list != null && !list.isEmpty()){
            for (PictureInfo pictureInfo : list){
                pictureInfo.setRelationId(orderContract.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer id) {
        List<PictureInfo> pictureInfos = pictureInfoMapper.getOrderContractPic(id);
        if (pictureInfos != null && !pictureInfos.isEmpty()){
            for (PictureInfo pictureInfo : pictureInfos) {
                File file = new File(imgUpload.getPath(pictureInfo.getPictureUrl()));
                file.delete();
                pictureInfoMapper.deleteByPrimaryKey(pictureInfo.getId());
            }
        }
        return orderContractMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(OrderContract orderContract) {
        String year = new SimpleDateFormat("yyyy").format(orderContract.getSignTime());
        ContractYear contractYear = contractYearMapper.selectByYear(year);
        if (contractYear != null){
            orderContract.setYearId(contractYear.getId());
        }else {
            contractYear = new ContractYear();
            contractYear.setYear(year+"年");
            contractYearMapper.insertSelective(contractYear);
            orderContract.setYearId(contractYear.getId());
        }
        return orderContractMapper.updateByPrimaryKeySelective(orderContract)==1;
    }

    @Override
    public List<OrderContract> getOrderContractList(Integer yearId) {
        return orderContractMapper.getOrderContract(yearId);
    }

    @Override
    public List<Map<String, Object>> getBoardOrderContract() {
        return orderContractMapper.getBoardOrderContract();
    }
}

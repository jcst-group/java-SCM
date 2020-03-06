package com.nongxin.terminal.service.finance.impl;

import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.dao.finance.PledgeGoodsMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.finance.PledgeGoods;
import com.nongxin.terminal.service.finance.PledgeGoodsService;
import com.nongxin.terminal.util.ImgUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class PledgeGoodsServiceImpl implements PledgeGoodsService {

    @Autowired(required = false)
    private PledgeGoodsMapper pledgeGoodsMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired
    private ImgUpload imgUpload;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(PledgeGoods pledgeGoods) {
        pledgeGoodsMapper.insertSelective(pledgeGoods);
        List<PictureInfo> list = pledgeGoods.getPictureInfos();
        if (list != null && !list.isEmpty()){
            for (PictureInfo pictureInfo : list){
                pictureInfo.setRelationId(pledgeGoods.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer id) {
        List<PictureInfo> pictureInfos = pictureInfoMapper.getPledgeGoodsPic(id);
        if (pictureInfos != null && !pictureInfos.isEmpty()){
            for (PictureInfo pictureInfo : pictureInfos) {
                File file = new File(imgUpload.getPath(pictureInfo.getPictureUrl()));
                file.delete();
                pictureInfoMapper.deleteByPrimaryKey(pictureInfo.getId());
            }
        }
        return pledgeGoodsMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(PledgeGoods pledgeGoods) {
        return pledgeGoodsMapper.updateByPrimaryKeySelective(pledgeGoods)==1;
    }

    @Override
    public List<PledgeGoods> getPledgeGoodsList(Integer yearId) {
        return pledgeGoodsMapper.getPledgeGoods(yearId);
    }

    @Override
    public Map<String, Object> getBoardPledgeGoods(Integer baseId) {
        return pledgeGoodsMapper.getBoardPledgeGoods(baseId);
    }
}

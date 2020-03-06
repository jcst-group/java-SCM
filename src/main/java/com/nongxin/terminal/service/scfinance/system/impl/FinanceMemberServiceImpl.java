package com.nongxin.terminal.service.scfinance.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.dao.scfinance.system.FinanceMemberMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.scfinance.system.FinanceMember;
import com.nongxin.terminal.service.scfinance.CommonService;
import com.nongxin.terminal.service.scfinance.system.IFinanceMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author clover
 * @since 2019-12-13
 */
@Service
public class FinanceMemberServiceImpl extends ServiceImpl<FinanceMemberMapper, FinanceMember> implements IFinanceMemberService {

    @Autowired
    private CommonService commonService;

    @Autowired
    private PictureInfoMapper pictureInfoMapper;

    @Autowired
    private FinanceMemberMapper financeMemberMapper;


    @Transactional(rollbackFor = Exception.class)
    public boolean deleteAndPics(Integer id){

        boolean success = false;
        try {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("id",id);
            FinanceMember member = financeMemberMapper.queryFinanceMemberOne(queryWrapper);
            if(member==null){
                return false;
            }


            List<PictureInfo> headPictureInfos = member.getHeadPictureInfos();
            List<PictureInfo> idPictureInfos = member.getIdPictureInfos();
            List<PictureInfo> concPictureInfos = member.getConcPictureInfos();

            List<String> picFiles = new ArrayList<>();

            for(PictureInfo p:headPictureInfos){
                picFiles.add(p.getPictureUrl());
                int delCount = pictureInfoMapper.deleteByPrimaryKey(id);
            }
            for(PictureInfo p:idPictureInfos){
                picFiles.add(p.getPictureUrl());
                int delCount = pictureInfoMapper.deleteByPrimaryKey(id);
            }
            for(PictureInfo p:concPictureInfos){
                picFiles.add(p.getPictureUrl());
                int delCount = pictureInfoMapper.deleteByPrimaryKey(id);
            }
            boolean b = removeById(id);
            //删除图片文件，成功或失败都没关系
            commonService.deletePics(picFiles);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }


        return success;
    }

}

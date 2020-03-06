package com.nongxin.terminal.service.processing.impl;

import com.nongxin.terminal.dao.batch.InitialProBatchMapper;
import com.nongxin.terminal.dao.batch.InitproBatchRelMapper;
import com.nongxin.terminal.dao.batch.ProBatchMethodRelMapper;
import com.nongxin.terminal.dao.batch.ProItemMapper;
import com.nongxin.terminal.dao.processing.ProcessingMethodsMapper;
import com.nongxin.terminal.entity.batch.InitialProBatch;
import com.nongxin.terminal.entity.batch.InitproBatchRel;
import com.nongxin.terminal.entity.batch.ProBatchMethodRel;
import com.nongxin.terminal.entity.batch.ProItem;
import com.nongxin.terminal.service.processing.ProBatchService;
import com.nongxin.terminal.util.CodeUtil;
import com.nongxin.terminal.util.enumUtil.common.CodeEnum;
import com.nongxin.terminal.vo.initPro.InitProVo;
import com.nongxin.terminal.vo.initPro.RetroInitPro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProBatchServiceImpl implements ProBatchService {

    @Autowired(required = false)
    private InitialProBatchMapper proBatchDao;

    @Autowired(required = false)
    private InitproBatchRelMapper initproBatchRelDao;

    @Autowired(required = false)
    private ProItemMapper proItemDao;

    @Autowired(required = false)
    private ProBatchMethodRelMapper proBatchMethodRelDao;



    @Override
    public boolean add(InitialProBatch proBatch) {

        proBatch.setInitialProcessingCode(CodeUtil.getCode(CodeEnum.InitPro));
        int insert = proBatchDao.insert(proBatch);
        int proBatchId = proBatch.getId();


        //添加加工方法关联数据
        List<Integer> methodIds = proBatch.getMethodIds();
        if(methodIds!=null) {
            for (int i = 0; i < methodIds.size(); i++) {
                Integer methodId = methodIds.get(i);
                ProBatchMethodRel rel = new ProBatchMethodRel();
                rel.setProBatchId(proBatchId);
                rel.setProMethodId(methodId);
                proBatchMethodRelDao.insert(rel);
            }
        }


        //添加批次关联数据
        List<Integer> recoveryBatchIds = proBatch.getRecoveryBatchIds();
        //List<InitproBatchRel> proItemList = proBatch.getProItemList();
        if(recoveryBatchIds!=null) {
            for (int i = 0; i < recoveryBatchIds.size(); i++) {
                int recoveryBatchId = recoveryBatchIds.get(i);
                InitproBatchRel rel = new InitproBatchRel();
                rel.setInitProId(proBatchId);
                rel.setRecoveBatchId(recoveryBatchId);
                initproBatchRelDao.insert(rel);
            }
        }

        //添加关联的作物采收数据
        List<ProItem> proItemList = proBatch.getProItemList();
        if(proItemList!=null) {
            for (int i = 0; i < proItemList.size(); i++) {
                ProItem proItem = proItemList.get(i);
                proItem.setInitproBatchId(proBatchId);
                proItemDao.insert(proItem);
            }
        }

        return insert==1;
    }

    @Override
    public boolean delete(Integer id) {
        int i = proBatchDao.deleteByPrimaryKey(id);
        deleteRelate(id);
        return i==1;
    }

    private void deleteRelate(Integer proBatchId){
        //删除关联方法
        proBatchMethodRelDao.deleteByProBatchId(proBatchId);

        //删除关联的批次关联
        initproBatchRelDao.deleteByProBatchId(proBatchId);

        //删除关联的作物采收数据
        proItemDao.deleteByProBathId(proBatchId);
    }

    @Override
    public boolean update(InitialProBatch proBatch) {
        //int deleteCount = proBatchDao.updateByPrimaryKeySelective(proBatch);
        /*int proBatchId = proBatch.getId();

        deleteRelate(proBatchId);*/

        //添加加工方法关联数据
        /*List<Integer> methodIds = proBatch.getMethodIds();
        if(methodIds!=null) {
            for (int i = 0; i < methodIds.size(); i++) {
                Integer methodId = methodIds.get(i);
                ProBatchMethodRel rel = new ProBatchMethodRel();
                rel.setProBatchId(proBatchId);
                rel.setProMethodId(methodId);
                proBatchMethodRelDao.insert(rel);
            }
        }*/

        //添加批次关联数据
        /*List<Integer> recoveryBatchIds = proBatch.getRecoveryBatchIds();
        if(recoveryBatchIds!=null) {
            for (int i = 0; i < recoveryBatchIds.size(); i++) {
                int recoveryBatchId = recoveryBatchIds.get(i);
                InitproBatchRel rel = new InitproBatchRel();
                rel.setInitProId(proBatchId);
                rel.setRecoveBatchId(recoveryBatchId);
                initproBatchRelDao.insert(rel);
            }
        }
*/
        proBatchDao.updateByPrimaryKeySelective(proBatch);
        //添加关联的作物采收数据
        List<ProItem> proItemList = proBatch.getProItemList();
        if(proItemList!=null) {
            //删除关联的作物采收数据
            proItemDao.deleteByProBathId(proBatch.getId());
            for (int i = 0; i < proItemList.size(); i++) {
                ProItem proItem = proItemList.get(i);
                proItem.setInitproBatchId(proBatch.getId());
                proItemDao.insert(proItem);
            }
        }

        return true;
    }

    @Override
    public List<InitialProBatch> selectProBatchs(Integer planId, Date startTime, Date endTime,Integer recoveryId) {
        List<InitialProBatch> initialProBatches = proBatchDao.selectProBatchs(planId,startTime,endTime,recoveryId);
        return initialProBatches;
    }

    @Override
    public List<InitProVo> getInitProVoByPlanId(Integer planId) {
        return proBatchDao.getInitProVoByPlanId(planId);
    }

    @Override
    public RetroInitPro selectByRetroCode(String retroCode) {
        return proBatchDao.selectByRetroCode(retroCode);
    }
}

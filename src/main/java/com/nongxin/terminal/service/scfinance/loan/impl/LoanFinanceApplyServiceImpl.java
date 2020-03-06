package com.nongxin.terminal.service.scfinance.loan.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nongxin.terminal.dao.scfinance.loan.LoanFinanceApplyMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.scfinance.insurance.LoanBatchInfo;
import com.nongxin.terminal.entity.scfinance.insurance.LoanFarmItem;
import com.nongxin.terminal.entity.scfinance.insurance.LoanFinanceApply;
import com.nongxin.terminal.service.scfinance.CommonService;
import com.nongxin.terminal.service.scfinance.loan.ILoanFinanceApplyService;
import com.nongxin.terminal.util.FinanceCodeUtil;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.util.enumUtil.common.CodeEnum;
import com.nongxin.terminal.util.enumUtil.file.ImgRelationTypeEnum;
import com.nongxin.terminal.util.enumUtil.scfinance.LoanApplyStatusEnum;
import com.nongxin.terminal.util.enumUtil.scfinance.LoanApplyTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author clover
 * @since 2019-12-18
 */
@Service
public class LoanFinanceApplyServiceImpl extends ServiceImpl<LoanFinanceApplyMapper, LoanFinanceApply> implements ILoanFinanceApplyService {


    /**
     * 申请单关联批次service
     */
    @Autowired
    private LoanBatchInfoServiceImpl loanBatchInfoService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private LoanFarmItemServiceImpl loanFarmItemService;

    @Transactional(rollbackFor = Exception.class)
    public synchronized boolean  saveOrUpdateLoanApply(LoanFinanceApply loanFinanceApply){
        boolean success = false;

        Integer applyId = loanFinanceApply.getId();
        if (applyId == null) {
            Integer fnanceUserId = JwtUtil.queryFnanceUserId();
            loanFinanceApply.setFinanceUserId(fnanceUserId);
            loanFinanceApply.setTenantId(fnanceUserId);
            loanFinanceApply.setStatus(LoanApplyStatusEnum.SAVE);
            loanFinanceApply.setLoanOrderCode(FinanceCodeUtil.getCode(CodeEnum.LOAN));
        }



        //保存基本信息
        success = saveOrUpdate(loanFinanceApply);

        //保存后，数据肯定有ID
        applyId = loanFinanceApply.getId();
        //保存申请材料图片
        List<PictureInfo> relatePics = loanFinanceApply.getRelatePics();
        boolean b = commonService.savePictures(relatePics, applyId, ImgRelationTypeEnum.LOAN_RELATE_PICTURE);

        //保存关联数据和社员
        LoanApplyTypeEnum loadType = loanFinanceApply.getLoadType();
        LoanBatchInfo loanBatchInfo = loanFinanceApply.getLoanBatchInfo();
        if(loanBatchInfo.getId()==null){
            loanBatchInfo.setLoanApplyId(applyId);
        }

        boolean b1 = loanBatchInfoService.saveOrUpdateLoanBatchInfo(loanBatchInfo);

        //保存相关信息，比如金额细项
        if(loadType.equals(LoanApplyTypeEnum.PLANT)){
            Integer loanBatchInfoId = loanBatchInfo.getId();
            //删除旧有数据
            QueryWrapper deleteWrapper = new QueryWrapper();
            deleteWrapper.eq("loan_batch_id",loanBatchInfoId);
            boolean remove = loanFarmItemService.remove(deleteWrapper);

            //新增新的
            List<LoanFarmItem> loanFarmItems = loanBatchInfo.getLoanFarmItems();
            for(LoanFarmItem i:loanFarmItems){
                i.setId(null);
                //设置贷款细项关联 batchInfo的ID
                i.setLoanBatchId(loanBatchInfo.getId());
                loanFarmItemService.save(i);
            }
        }

        return success;
    }

}

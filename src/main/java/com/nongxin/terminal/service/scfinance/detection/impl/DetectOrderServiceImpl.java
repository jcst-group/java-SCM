package com.nongxin.terminal.service.scfinance.detection.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nongxin.terminal.dao.scfinance.detection.DetectOrderMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.scfinance.insurance.DetectOrder;
import com.nongxin.terminal.service.scfinance.CommonService;
import com.nongxin.terminal.service.scfinance.detection.IDetectOrderService;
import com.nongxin.terminal.util.FinanceCodeUtil;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.util.enumUtil.common.CodeEnum;
import com.nongxin.terminal.util.enumUtil.file.ImgRelationTypeEnum;
import com.nongxin.terminal.util.enumUtil.scfinance.DetectionStatusEnum;
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
 * @since 2019-12-24
 */
@Service
public class DetectOrderServiceImpl extends ServiceImpl<DetectOrderMapper, DetectOrder> implements IDetectOrderService {


    @Autowired
    private CommonService commonService;





    @Transactional(rollbackFor = Exception.class)
    public synchronized boolean  saveOrUpdateApply(DetectOrder detectOrder){
        boolean success = false;

        Integer applyId = detectOrder.getId();
        if (applyId == null) {
            Integer fnanceUserId = JwtUtil.queryFnanceUserId();
            //detectOrder
            detectOrder.setTenantId(fnanceUserId);
            detectOrder.setDetectStatus(DetectionStatusEnum.SAVE);
            detectOrder.setOrderCode(FinanceCodeUtil.getCode(CodeEnum.DETECT));
        }

        //保存基本信息
        success = saveOrUpdate(detectOrder);

        //保存后，数据肯定有ID
        applyId = detectOrder.getId();
        //保存申请材料图片
        List<PictureInfo> relatePics =  detectOrder.getRelatePics();
        boolean b = commonService.savePictures(relatePics, applyId, ImgRelationTypeEnum.DETETCT_APPLY_PIC);

        return success;
    }
}

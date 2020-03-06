package com.nongxin.terminal.util.notify;

import com.nongxin.terminal.entity.scfinance.insurance.DetectOrder;
import com.nongxin.terminal.entity.scfinance.insurance.InsuranceOrderMessage;
import com.nongxin.terminal.service.scfinance.detection.impl.DetectOrderServiceImpl;
import com.nongxin.terminal.util.enumUtil.scfinance.DetectionStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Component
public class DetectFindUserIdStrategy implements FindUserIdStrategy{

    private static final List<DetectionStatusEnum> notifyCoopUserEnum =  new ArrayList<DetectionStatusEnum>(Arrays.asList(
            DetectionStatusEnum.COOP_CONFIRM,
            DetectionStatusEnum.FINISH
    ));

    private static final List<DetectionStatusEnum> notifyDetectUserEnum =  new ArrayList<DetectionStatusEnum>(Arrays.asList(
            DetectionStatusEnum.DETECT_CONFIRM
    ));

    private static final List<DetectionStatusEnum> notifyOrderUserEnum =  new ArrayList<DetectionStatusEnum>(Arrays.asList(
            DetectionStatusEnum.FAIL_APPLY,
            DetectionStatusEnum.FINISH
    ));


    @Autowired
    private DetectOrderServiceImpl detectOrderService;

    @Override
    public List<Integer> getUserId(InsuranceOrderMessage message) {
        List<Integer> notifyIds = new ArrayList<>();


        Integer relateId = Optional.ofNullable(message.getRelateId()).orElse(0);
        DetectOrder detectOrder = detectOrderService.getById(relateId);

        if(detectOrder!=null){
            DetectionStatusEnum detectStatus = detectOrder.getDetectStatus();
            if(notifyOrderUserEnum.contains(detectStatus)){
                notifyIds.add(Optional.ofNullable(detectOrder.getOrderUserId()).orElse(SearchUserIdContext.UNNITIFY_CODE));
            }
            if(notifyDetectUserEnum.contains(detectStatus)){
                notifyIds.add(Optional.ofNullable(detectOrder.getDetectUserId()).orElse(SearchUserIdContext.UNNITIFY_CODE));
            }
            if(notifyCoopUserEnum.contains(detectStatus)){
                notifyIds.add(Optional.ofNullable(detectOrder.getFinanceUserId()).orElse(SearchUserIdContext.UNNITIFY_CODE));
            }

        }

        return notifyIds;

    }
}

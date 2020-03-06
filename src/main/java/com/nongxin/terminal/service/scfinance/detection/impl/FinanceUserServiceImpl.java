package com.nongxin.terminal.service.scfinance.detection.impl;

import com.nongxin.terminal.entity.scfinance.system.FinanceUser;
import com.nongxin.terminal.dao.scfinance.detection.FinanceUserMapper;
import com.nongxin.terminal.service.scfinance.detection.IFinanceUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author clover
 * @since 2019-12-10
 */
@Service
public class FinanceUserServiceImpl extends ServiceImpl<FinanceUserMapper, FinanceUser> implements IFinanceUserService {

}

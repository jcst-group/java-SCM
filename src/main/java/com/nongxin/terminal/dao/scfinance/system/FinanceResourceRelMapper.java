package com.nongxin.terminal.dao.scfinance.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nongxin.terminal.entity.scfinance.system.FinanceResourceRel;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author clover
 * @since 2019-12-10
 */
public interface FinanceResourceRelMapper extends BaseMapper<FinanceResourceRel> {
    List<FinanceResourceRel> selectByResourceId(Integer resourceId);
}

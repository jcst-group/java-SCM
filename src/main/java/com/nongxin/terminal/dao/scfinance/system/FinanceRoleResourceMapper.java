package com.nongxin.terminal.dao.scfinance.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nongxin.terminal.entity.scfinance.system.FinanceResource;
import com.nongxin.terminal.entity.scfinance.system.FinanceRoleResource;

import java.util.List;

/**
 * <p>
 * 资源角色关联表 Mapper 接口
 * </p>
 *
 * @author clover
 * @since 2019-12-10
 */
public interface FinanceRoleResourceMapper extends BaseMapper<FinanceRoleResource> {
    List<FinanceResource> getFinanceResourceByUid(Integer uid, Integer type);
}

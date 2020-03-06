package com.nongxin.terminal.entity.scfinance.insurance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.nongxin.terminal.entity.crop.CropBatch;
import com.nongxin.terminal.entity.scfinance.system.FinanceMember;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author clover
 * @since 2019-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LoanBatchInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer loanApplyId;

    private Integer batchId;

    private Integer tenantId;

    private BigDecimal loanSum;

    private BigDecimal loanArea;

    @TableField(exist = false,select = false)
    private CropBatch cropBatch;


    @TableField(exist = false,select = false)
    private List<FinanceMember> financeMembers;

    @TableField(exist = false,select = false)
    private List<LoanFarmItem> loanFarmItems;


}

package com.nongxin.terminal.entity.scfinance.insurance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2019-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InsurancePlantInfo implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer insuranceId;

    private BigDecimal insuranceArea;

    private String insuranceUnit;

    private Integer tenantId;

    @TableField(exist = false,select = false)
    private List<FinanceMember> financeMembers;


}

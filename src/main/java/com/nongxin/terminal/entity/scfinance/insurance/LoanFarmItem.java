package com.nongxin.terminal.entity.scfinance.insurance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.plant.FarmingItem;
import com.nongxin.terminal.entity.plant.WorkOrder;
import com.nongxin.terminal.util.enumUtil.plan.PrepareTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
public class LoanFarmItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 准备项目id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 批次id
     */
    private Integer loanBatchId;

    /**
     * 农事项目id
     */
    private Integer farmingItemId;

    private Integer farmingId;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    /**
     * 最少人数
     */
    private Integer minPerson;

    /**
     * 物资名称
     */
    private String materialName;

    /**
     * 单位
     */
    private String company;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 预算费用
     */
    private BigDecimal budgetCosts;

    /**
     * 到位日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date inplaceTime;

    /**
     * 工单id
     */
    private Integer workOrderId;

    /**
     * 类型 1:人资  2:物料  3:设备
     */
    private PrepareTypeEnum itemType;

    @TableField(exist = false,select = false)
    private WorkOrder workOrder;


    @TableField(exist = false,select = false)
    private FarmingItem farmingItem;


}

package com.nongxin.terminal.vo.scfinance;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.plant.FarmingItem;
import com.nongxin.terminal.util.enumUtil.plan.PrepareTypeEnum;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class PrepareItemVo {

    private Integer farmingItemId;

    @NotNull(message = "开始时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startTime;

    @NotNull(message = "结束时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endTime;

    private Short minPerson;

    private String materialName;

    private String company;

    private Integer num;

    private BigDecimal budgetCosts;

    @NotNull(message = "到位日期不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date inplaceTime;

    private FarmingItem farmingItem;

    private Integer workOrderId;

    private PrepareTypeEnum type;

    private BigDecimal unitPrice;




}

package com.nongxin.terminal.entity.scfinance.insurance;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author clover
 * @since 2019-12-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DetectFeeItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer detectOrderId;

    private String itemName;

    private String itemUnit;

    private BigDecimal itemPrice;

    private BigDecimal itemSum;

    private String charOne;

    private BigDecimal numOne;

    private Integer intOne;

    private Integer tenantId;


}

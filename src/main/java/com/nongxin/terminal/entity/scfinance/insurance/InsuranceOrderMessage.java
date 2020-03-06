package com.nongxin.terminal.entity.scfinance.insurance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.nongxin.terminal.util.enumUtil.scfinance.MessageRelateTypeEnum;
import com.nongxin.terminal.util.enumUtil.scfinance.MessageStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author clover
 * @since 2019-12-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InsuranceOrderMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer relateId;

    private MessageRelateTypeEnum relateType;

    private MessageStatusEnum messageStatus;

    private Integer relateUserId;

    private Integer financeUserId;


    private Date createTime;

    private String commont;

    private String charTwo;

    private String charOne;

    private BigDecimal numTwo;

    private Integer intOne;

    private Integer intTwo;

    private Integer tenantId;


}

package com.nongxin.terminal.entity.scfinance.detection;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2019-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ddwb_detection_apply")
public class DetectionApply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String detecOrderCode;

    private Integer detecType;

    private Integer financeUserId;

    private Integer relateId;

    private String email;

    private Integer status;

    private Date applyTime;

    private String comment;

    private Date createTime;

    private String charOne;

    private String charTwo;

    private BigDecimal numOne;

    private BigDecimal numTwo;

    private Integer intOne;

    private Integer intTwo;

    private Integer tenantId;


}

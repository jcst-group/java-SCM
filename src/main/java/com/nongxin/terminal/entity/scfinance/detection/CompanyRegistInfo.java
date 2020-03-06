package com.nongxin.terminal.entity.scfinance.detection;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.nongxin.terminal.entity.address.Address;
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
@TableName("ddwb_company_regist_info")
public class CompanyRegistInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer financeUserId;

    private BigDecimal registSum;

    private String registAreacode;

    private String registAreadetail;

    private String businessAreacode;

    private String businessAreadetail;

    private BigDecimal businessIncome;

    private Date createTime;

    private String charOne;

    private String charTwo;

    private BigDecimal numOne;

    private BigDecimal numTwo;

    private Integer intOne;

    private Integer intTwo;

    private Integer tenantId;

    private String areacode;

    @TableField(exist = false,select = false)
    private Address registAddress;

    @TableField(exist = false,select = false)
    private Address businessAddress;


}

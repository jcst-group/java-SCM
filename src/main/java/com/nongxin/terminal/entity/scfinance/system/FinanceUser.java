package com.nongxin.terminal.entity.scfinance.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.nongxin.terminal.entity.base.BaseInfo;
import com.nongxin.terminal.entity.scfinance.detection.CompanyLegalPerson;
import com.nongxin.terminal.entity.scfinance.detection.CompanyRegistInfo;
import com.nongxin.terminal.entity.scfinance.detection.FinanceCominfo;
import com.nongxin.terminal.util.enumUtil.scfinance.FinanceUserTypeEnum;
import com.nongxin.terminal.util.enumUtil.system.UserStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
@TableName("ddwb_finance_user")
public class FinanceUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String salt;

    private String email;

    private String telPhone;

    private UserStatusEnum status;

    private FinanceUserTypeEnum userType;

    private Date createTime;

    private String charOne;

    private String charTwo;

    private BigDecimal numOne;

    private BigDecimal numTwo;

    private Integer intOne;

    private Integer intTwo;

    private Integer tenantId;

    @TableField(exist = false)
    private FinanceCominfo cominfo;

    @TableField(exist = false)
    private List<BaseInfo> bases;

    @TableField(exist = false)
    private CompanyRegistInfo registInfo;

    @TableField(exist = false)
    private CompanyLegalPerson legalPerson;

    @TableField(exist = false)
    private List<FinanceRole> financeRoles;

}

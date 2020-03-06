package com.nongxin.terminal.entity.scfinance.detection;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.address.Address;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.util.enumUtil.scfinance.CompanyTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

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
@TableName(value = "ddwb_finance_cominfo")
public class FinanceCominfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private Integer financeUserId;


    private CompanyTypeEnum companyType;

    private String creditCode;

    private String businessLience;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date businessRegistDate;

    private String taxId;

    private Integer stuffNum;

    @TableField("Asset_count")
    private BigDecimal assetCount;

    private Date createTime;

    private String charOne;

    private String charTwo;

    private BigDecimal numOne;

    private BigDecimal numTwo;

    private Integer intOne;
    @TableField(select = false)
    private Integer intTwo;

    private Integer tenantId;

    private String areacode;

    private String areadetail;

    @TableField(exist = false,select = false)
    private List<PictureInfo> pictureInfos;

    @TableField(exist = false,select = false)
    private Address address;


}

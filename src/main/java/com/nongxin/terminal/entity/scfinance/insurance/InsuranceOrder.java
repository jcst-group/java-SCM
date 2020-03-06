package com.nongxin.terminal.entity.scfinance.insurance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.file.FileInfo;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.scfinance.system.FinanceUser;
import com.nongxin.terminal.util.enumUtil.scfinance.InsuranceStatusEnum;
import com.nongxin.terminal.util.enumUtil.scfinance.InsuranceTypeEnum;
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
 * @since 2019-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InsuranceOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    private String insuranceOrder;

    private Integer insuranceId;

    private Integer financeUserId;

    @TableField(exist = false,select = false)
    private FinanceUser insuranceUser;

    @TableField(exist = false,select = false)
    private FinanceUser coperativeUser;



    /**
     * 保险订单类型
     */
    private InsuranceTypeEnum insuranceType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    private Date applyTime;

    private Integer insuranceCompid;

    /**
     * 联系电话
     */
    private String contractNum;

    /**
     * 保险订单状态
     */
    private InsuranceStatusEnum orderStatus;

    private Date createTime;

    private String comment;

    private String charTwo;

    private BigDecimal numOne;

    private BigDecimal numTwo;


    private Integer intTwo;

    private Integer tenantId;

    private Integer relatePlant;

    private Integer relatePrice;

    private Integer relateOne;

    private Integer relateTwo;

    private Integer relateNormal;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date actualStartTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date actualEndTime;


    /**
     * 种植险相关信息
     */
    @TableField(exist = false,select = false)
    private InsurancePlantInfo plantInfo;


    @TableField(exist = false,select = false)
    private List<InsuranceOrderMessage> messages;

    /**
     * 保单信息
     */
    @TableField(exist = false,select = false)
    private List<PictureInfo> orderPics;

    @TableField(exist = false,select = false)
    private List<FileInfo> orderFiles;

}

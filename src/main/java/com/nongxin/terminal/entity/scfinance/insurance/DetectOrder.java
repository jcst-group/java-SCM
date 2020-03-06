package com.nongxin.terminal.entity.scfinance.insurance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.file.FileInfo;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.scfinance.system.FinanceMember;
import com.nongxin.terminal.entity.scfinance.system.FinanceUser;
import com.nongxin.terminal.util.enumUtil.scfinance.DetectionStatusEnum;
import com.nongxin.terminal.util.enumUtil.scfinance.DetectionTypeEnum;
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
 * @since 2019-12-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DetectOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String orderCode;

    /**
     * 订单用户ID
     */
    private Integer orderUserId;

    /**
     * 合作社ID
     */
    private Integer financeUserId;

    /**
     * 检测机构ID
     */
    private Integer detectUserId;

    /**
     * 检测类型 不过名字取错了
     */
    private DetectionTypeEnum insuranceType;

    /**
     * 社员ID
     */
    private Integer numberId;

    private DetectionStatusEnum detectStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private String charOne;

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

    @TableField(exist = false,select = false)
    private List<DetectionStatusEnum> statusEnums;

    @TableField(exist = false,select = false)
    private List<DetectFeeItem> feeItems;

    @TableField(exist = false,select = false)
    private FinanceMember financeMember;

    /**
     * 订单企业
     */
    @TableField(exist = false,select = false)
    private FinanceUser orderUser;

    /**
     * 合作社
     */
    @TableField(exist = false,select = false)
    private FinanceUser financeUser;

    /**
     * 检测机构
     */
    @TableField(exist = false,select = false)
    private FinanceUser detectUser;

    @TableField(exist = false,select = false)
    private List<PictureInfo> relatePics;

    @TableField(exist = false,select = false)
    private List<PictureInfo> resultPics;

    @TableField(exist = false,select = false)
    private List<InsuranceOrderMessage> messages;


    @TableField(exist = false,select = false)
    private String dealMessage;

    @TableField(exist = false,select = false)
    private List<FileInfo> applyFiles;

    @TableField(exist = false,select = false)
    private List<FileInfo> resultFiles;
}

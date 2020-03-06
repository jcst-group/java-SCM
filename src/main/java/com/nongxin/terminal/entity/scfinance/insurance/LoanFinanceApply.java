package com.nongxin.terminal.entity.scfinance.insurance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.file.FileInfo;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.scfinance.system.FinanceUser;
import com.nongxin.terminal.util.enumUtil.scfinance.CommonTrueFalseEnum;
import com.nongxin.terminal.util.enumUtil.scfinance.LoanApplyStatusEnum;
import com.nongxin.terminal.util.enumUtil.scfinance.LoanApplyTypeEnum;
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
 * @since 2019-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LoanFinanceApply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String loanOrderCode;

    private Integer financeUserId;

    /**
     * 担保方ID
     */
    private Integer guaranteeId;

    private Integer bankId;

    /**
     * 保险类型
     */
    private LoanApplyTypeEnum loadType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date applyTime;

    private Integer insuranceCompid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private String charOne;

    private String charTwo;

    private BigDecimal numOne;

    private BigDecimal numTwo;

    private Integer intOne;

    private Integer intTwo;

    private Integer tenantId;

    private Integer relateLoan;

    private Integer relatePrice;

    private Integer relateOne;

    private CommonTrueFalseEnum ifguarantee;

    private Integer relateNormal;

    private LoanApplyStatusEnum status;



    @TableField(exist = false,select = false)
    private List<InsuranceOrderMessage> messages;

    /**
     * 相关信息
     */
    @TableField(exist = false,select = false)
    private LoanBatchInfo loanBatchInfo;

    /**
     * 银行信息
     */
    @TableField(exist = false,select = false)
    private FinanceUser bankUser;

    /**
     * 担保用户
     */
    @TableField(exist = false,select = false)
    private FinanceUser guaranteeUser;

    /**
     * 合作社
     */
    @TableField(exist = false,select = false)
    private FinanceUser coperativeUser;

    //申请资料相关图片
    @TableField(exist = false,select = false)
    List<PictureInfo> relatePics;

    //担保审核图片
    @TableField(exist = false,select = false)
    List<PictureInfo> warrantApplyedPics;

    //贷款审核图片
    @TableField(exist = false,select = false)
    List<PictureInfo> loanApplyedPics;

    //担保审批图片
    @TableField(exist = false,select = false)
    List<PictureInfo> warrantApprovedPics;

    //贷款审批图片
    @TableField(exist = false,select = false)
    List<PictureInfo> loanApprovedPics;

    @TableField(exist = false,select = false)
    List<FileInfo>  relateFiles;

    @TableField(exist = false,select = false)
    List<FileInfo>  warrantApplyFiles;

    @TableField(exist = false,select = false)
    List<FileInfo>  loanApplyFiles;

    @TableField(exist = false,select = false)
    List<FileInfo>  warrantApproveFiles;

    @TableField(exist = false,select = false)
    List<FileInfo>  loanAproveFiles;
}

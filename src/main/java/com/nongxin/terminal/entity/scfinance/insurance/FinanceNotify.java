package com.nongxin.terminal.entity.scfinance.insurance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.nongxin.terminal.util.enumUtil.scfinance.MessageRelateTypeEnum;
import com.nongxin.terminal.util.enumUtil.scfinance.TrueOrFalseEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author clover
 * @since 2019-12-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FinanceNotify implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer financeUserId;

    private TrueOrFalseEnum ifRead;

    private MessageRelateTypeEnum messageType;

    private String titile;

    private String content;

    private Date createTime;

    private Integer intOne;

    private String charOne;

    private String charTwo;

    private String charThree;


}

package com.nongxin.terminal.entity.scfinance.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.address.Address;
import com.nongxin.terminal.entity.file.PictureInfo;
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
public class FinanceMember implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * uid,用户账号,主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer financeUserId;

    /**
     * 用户真名
     */
    private String realName;

    private String memberCode;

    /**
     * 电话号码(唯一)
     */
    private String phone;

    /**
     * 身份证
     */
    private String identifyCode;

    /**
     * 邮件地址(唯一)
     */
    private String email;

    private BigDecimal blockArea;

    private String blockInfo;

    /**
     * 性别(1.男 2.女)
     */
    private Integer sex;

    /**
     * 账户状态(1，已启用，2，未启用）
     */
    private Integer status;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("UPDATE_TIME")
    private Date updateTime;

    /**
     * 创建来源(1.web 2.android 3.ios 4.win 5.macos 6.ubuntu)
     */

    @TableField("CREATE_WHERE")
    private Integer createWhere;

    private Integer tenantId;

    /**
     * 头像图片
     */
    @TableField(exist = false)
    private List<PictureInfo> headPictureInfos;

    /**
     * 身份证图片
     */
    @TableField(exist = false)
    private List<PictureInfo> idPictureInfos;


    /**
     * 入社协议图片
     */
    @TableField(exist = false)
    private List<PictureInfo> concPictureInfos;

    @TableField(exist = false)
    private Address address;

}

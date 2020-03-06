package com.nongxin.terminal.entity.plant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.file.FileInfo;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.util.enumUtil.plan.AgreeEnum;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class OrderApply {
    private Integer id;

    @NotNull(message = "工单id不能为空")
    private Integer orderId;

    private String applyContent;

    private AgreeEnum agree;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date subTime;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date processTime;

    private String remark;

    private FileInfo fileInfo;

    private Integer userId;

    private User user;
}
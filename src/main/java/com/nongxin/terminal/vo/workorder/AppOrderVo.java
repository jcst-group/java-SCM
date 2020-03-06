package com.nongxin.terminal.vo.workorder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.plant.DeviceAct;
import com.nongxin.terminal.entity.plant.FarmingItem;
import com.nongxin.terminal.entity.plant.MaterialAct;
import com.nongxin.terminal.entity.plant.PersonnelAct;
import com.nongxin.terminal.util.enumUtil.plan.AgreeEnum;
import com.nongxin.terminal.util.enumUtil.plan.WorkOrderStatusEnum;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class AppOrderVo {

    private Integer id;

    private String batchName;

    private String baseName;

    private String remark;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date executionTime;

    private FarmingItem farmingItem;

    private List<DeviceAct> deviceActList;

    private List<MaterialAct> materialActList;

    private List<PersonnelAct> personnelActList;

    private WorkOrderStatusEnum status;

    //提交时间
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date subTime;

    //审核时间
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date examineTime;

    //结束时间
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endTime;

    private boolean allowedExecute;

    private boolean sequExecute;

    private AgreeEnum agree;
}

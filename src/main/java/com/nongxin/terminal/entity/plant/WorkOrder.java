package com.nongxin.terminal.entity.plant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.crop.CropBatch;
import com.nongxin.terminal.entity.file.FileInfo;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.system.Role;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.util.enumUtil.plan.WorkOrderStatusEnum;
import com.nongxin.terminal.util.enumUtil.plan.WorkOrderTypeEnum;
import com.nongxin.terminal.util.enumUtil.solar.SolarTermsEnum;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class WorkOrder {
    private Integer id;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date executionTime;

    private SolarTermsEnum solarTerm;

    private Integer cropBatchId;

    private Integer farmingItemId;

    private Integer userId;

    private WorkOrderStatusEnum status;

    private WorkOrderTypeEnum type;

    private List<Role> roleList;

    private List<PictureInfo> pictureInfoList;

    private List<DeviceAct> deviceActList;

    private List<MaterialAct> materialActList;

    private List<PersonnelAct> personnelActList;

    private CropBatch cropBatch;

    private User user;

    private List<User> orderExecutor;

    private FarmingItem farmingItem;

    private FileInfo fileInfo;

    private String remark;

    private Integer farmingId;

    private OrderContent orderContent;

    //提交时间
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date subTime;

    //审核时间
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date examineTime;

    private boolean allowedExecute;

    //结束时间
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endTime;

    private boolean sequExecute;
}
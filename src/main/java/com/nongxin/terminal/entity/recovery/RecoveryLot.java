package com.nongxin.terminal.entity.recovery;

import com.nongxin.terminal.entity.base.Lot;
import com.nongxin.terminal.util.enumUtil.common.UnitEnum;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RecoveryLot {
    private Integer id;

    private Integer recoveryBatchId;

    @NotNull(message = "地块不能为空")
    private Integer lotId;

    @NotNull(message = "产量不能为空")
    private BigDecimal yield;

    private UnitEnum unit;

    private Lot lot;

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecoveryBatchId() {
        return recoveryBatchId;
    }

    public void setRecoveryBatchId(Integer recoveryBatchId) {
        this.recoveryBatchId = recoveryBatchId;
    }

    public Integer getLotId() {
        return lotId;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public BigDecimal getYield() {
        return yield;
    }

    public void setYield(BigDecimal yield) {
        this.yield = yield;
    }

    public UnitEnum getUnit() {
        return unit;
    }

    public void setUnit(UnitEnum unit) {
        this.unit = unit;
    }
}
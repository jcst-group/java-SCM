package com.nongxin.terminal.vo.workorder;

public class TemporaryOrder {

    private int[] batchIds;

    private int[] farmingIds;

    public int[] getBatchIds() {
        return batchIds;
    }

    public void setBatchIds(int[] batchIds) {
        this.batchIds = batchIds;
    }

    public int[] getFarmingIds() {
        return farmingIds;
    }

    public void setFarmingIds(int[] farmingIds) {
        this.farmingIds = farmingIds;
    }
}

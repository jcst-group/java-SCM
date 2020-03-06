package com.nongxin.terminal.vo.recovery;

import com.nongxin.terminal.entity.base.Lot;
import com.nongxin.terminal.entity.crop.Crop;
import com.nongxin.terminal.entity.crop.HarvestedProduct;
import com.nongxin.terminal.entity.product.Products;

import java.util.List;

public class RecoveryVo {

    private Integer batchId;

    private List<Lot> lotList;

    private Crop crop;

    private List<HarvestedProduct> harvestedProductList;

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public List<Lot> getLotList() {
        return lotList;
    }

    public void setLotList(List<Lot> lotList) {
        this.lotList = lotList;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public List<HarvestedProduct> getHarvestedProductList() {
        return harvestedProductList;
    }

    public void setHarvestedProductList(List<HarvestedProduct> harvestedProductList) {
        this.harvestedProductList = harvestedProductList;
    }
}

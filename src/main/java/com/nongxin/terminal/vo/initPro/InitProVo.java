package com.nongxin.terminal.vo.initPro;

import com.nongxin.terminal.entity.batch.ProItem;

import java.util.List;

public class InitProVo {

    private Integer id;
    private String initialProcessingCode;
    private String initialName;
    private List<ProItem> proItemList;

    public String getInitialName() {
        return initialName;
    }

    public void setInitialName(String initialName) {
        this.initialName = initialName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInitialProcessingCode() {
        return initialProcessingCode;
    }

    public void setInitialProcessingCode(String initialProcessingCode) {
        this.initialProcessingCode = initialProcessingCode;
    }

    public List<ProItem> getProItemList() {
        return proItemList;
    }

    public void setProItemList(List<ProItem> proItemList) {
        this.proItemList = proItemList;
    }
}

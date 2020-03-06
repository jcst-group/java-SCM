package com.nongxin.terminal.vo.retrospective;
import java.util.List;
import java.util.Map;

public class RetroCodeVo {

    private String traceabilityUrl;

    private List<Map<String,Object>> retroCodeList;

    public String getTraceabilityUrl() {
        return traceabilityUrl;
    }

    public void setTraceabilityUrl(String traceabilityUrl) {
        this.traceabilityUrl = traceabilityUrl;
    }

    public List<Map<String, Object>> getRetroCodeList() {
        return retroCodeList;
    }

    public void setRetroCodeList(List<Map<String, Object>> retroCodeList) {
        this.retroCodeList = retroCodeList;
    }
}

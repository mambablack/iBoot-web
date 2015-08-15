package com.ai.model;

public class SysParamDetail extends SysParamDetailKey {
    private String pDesc;

    private String pPValue;

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc == null ? null : pDesc.trim();
    }

    public String getpPValue() {
        return pPValue;
    }

    public void setpPValue(String pPValue) {
        this.pPValue = pPValue == null ? null : pPValue.trim();
    }
}
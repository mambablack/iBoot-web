package com.ai.model;

public class SysParamDetailKey {
    private String pKey;

    private String pValue;

    public String getpKey() {
        return pKey;
    }

    public void setpKey(String pKey) {
        this.pKey = pKey == null ? null : pKey.trim();
    }

    public String getpValue() {
        return pValue;
    }

    public void setpValue(String pValue) {
        this.pValue = pValue == null ? null : pValue.trim();
    }
}
package com.bsoft.transaction.entity;

/**
 * 接口返回实体类-与医保接口兼容
 * @author wangruix
 */
public class ReturnResult {

    /**
     * 交易返回码
     */
    private String xxfhm;

    /**
     * 返回消息
     */
    private String fhxx;


    public String getXxfhm() {
        return xxfhm;
    }

    public void setXxfhm(String xxfhm) {
        this.xxfhm = xxfhm;
    }

    public String getFhxx() {
        return fhxx;
    }

    public void setFhxx(String fhxx) {
        this.fhxx = fhxx;
    }

    @Override
    public String toString() {
        return "ReturnResult{" +
                "xxfhm='" + xxfhm + '\'' +
                ", fhxx='" + fhxx + '\'' +
                '}';
    }
}

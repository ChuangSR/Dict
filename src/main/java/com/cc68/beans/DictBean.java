package com.cc68.beans;

import java.util.HashMap;
/**
 * 一个属于字典的bean，用于组合在MessageBean中返回前端
 * */
public class DictBean {
    //数据名称
    private String data;

    //方言相关的具体数据
    private DialectBean dialect;

    //详情数据
    private HashMap<String,String> details;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DialectBean getDialect() {
        return dialect;
    }

    public void setDialect(DialectBean dialect) {
        this.dialect = dialect;
    }

    public HashMap<String, String> getDetails() {
        return details;
    }

    public void setDetails(HashMap<String, String> details) {
        this.details = details;
    }

    public DictBean() {
    }

    public DictBean(String data, DialectBean dialect, HashMap<String, String> details) {
        this.data = data;
        this.dialect = dialect;
        this.details = details;
    }
}

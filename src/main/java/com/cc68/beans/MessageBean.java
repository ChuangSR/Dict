package com.cc68.beans;

import java.util.HashMap;
/**
 * 前后端交互的数据类型
 * 用户传输交互的数据
 * */
public class MessageBean {
    //操作类型
    private String type;

    //携带的具体参数
    private HashMap<String,Object> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    public MessageBean() {
    }

    public MessageBean(String type, HashMap<String, Object> data) {
        this.type = type;
        this.data = data;
    }
}

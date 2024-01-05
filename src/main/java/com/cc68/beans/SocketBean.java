package com.cc68.beans;

import java.util.HashMap;

public class SocketBean {
    private String type;
    private HashMap<String,String> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, String> getMap() {
        return data;
    }

    public void setMap(HashMap<String, String> data) {
        this.data = data;
    }

    public SocketBean() {
    }

    public SocketBean(String type, HashMap<String, String> data) {
        this.type = type;
        this.data = data;
    }
}

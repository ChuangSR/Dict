package com.cc68.beans;

import java.util.HashMap;

public class SocketBean {
    private String type;
    private HashMap<String,String> map;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }

    public SocketBean() {
    }

    public SocketBean(String type, HashMap<String, String> map) {
        this.type = type;
        this.map = map;
    }

}

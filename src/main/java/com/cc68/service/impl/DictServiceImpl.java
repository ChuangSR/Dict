package com.cc68.service.impl;

import com.cc68.beans.DialectBean;
import com.cc68.beans.MessageBean;
import com.cc68.beans.SocketBean;
import com.cc68.dao.DictDao;
import com.cc68.dao.impl.DictDaoArray;
import com.cc68.service.DictService;
import com.cc68.socket.ScriptSocket;

import java.util.HashMap;

/**
 * 对于逻辑的具体处理
 * */
public class DictServiceImpl implements DictService {
    private DictDao dao;
    public DictServiceImpl() {
        this.dao = new DictDaoArray();
    }

    public MessageBean search(String dialect, String character) {
        DialectBean dialectBean = dao.select(dialect, character);
        SocketBean socketBean = ScriptSocket.search(character);
        HashMap<String,Object> data = new HashMap<>();
        data.put("dialect",dialectBean);
        data.put("character",socketBean);
        MessageBean messageBean = new MessageBean("reply",data);
        return messageBean;
    }

    @Override
    public MessageBean add(String dialect, DialectBean bean) {
//        return dao.add(dialect,bean);
        return null;
    }

    @Override
    public MessageBean delete(String dialect, String data) {
        return null;
//        return dao.delete(dialect,data);
    }

    @Override
    public MessageBean renew(String dialect, DialectBean bean, String old) {
//        return dao.renew(dialect,bean,old);
        return null;
    }

    @Override
    public MessageBean getDialects() {
        HashMap<String,Object> data = new HashMap<>();
        data.put("data",dao.getDialects());
        MessageBean bean = new MessageBean("dialectLoad",data);
        return bean;
    }
}

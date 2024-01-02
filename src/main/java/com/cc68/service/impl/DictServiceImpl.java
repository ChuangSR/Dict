package com.cc68.service.impl;

import com.cc68.beans.DialectBean;
import com.cc68.beans.MessageBean;
import com.cc68.dao.DictDao;
import com.cc68.dao.impl.DictDaoArray;
import com.cc68.service.DictService;

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
        DialectBean dictBean = dao.select(dialect, character);
        MessageBean messageBean = new MessageBean();
        HashMap<String,Object> data = new HashMap<>();


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
}

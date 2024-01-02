package com.cc68.dao.impl;

import com.cc68.beans.DialectBean;
import com.cc68.dao.DictDao;
import com.cc68.dialect.Dialect;

import java.util.HashMap;
/**
 * 对于数据持久化的实现
 * */
public class DictDaoArray implements DictDao {
    //所有方言组成的map
    private HashMap<String, Dialect> map;
    @Override
    public DialectBean select(String dialect,String data) {
        return map.get(dialect).search(data);
    }

    @Override
    public boolean add(String dialect, DialectBean bean) {
        return map.get(dialect).add(bean);
    }

    @Override
    public boolean delete(String dialect, String data) {
        return map.get(dialect).delete(data);
    }

    @Override
    public boolean renew(String dialect, DialectBean bean, String old) {
        return map.get(dialect).renew(bean,old);
    }
}

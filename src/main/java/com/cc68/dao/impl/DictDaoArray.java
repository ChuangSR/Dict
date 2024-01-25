package com.cc68.dao.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.cc68.beans.DialectBean;
import com.cc68.dao.DictDao;
import com.cc68.dialect.Dialect;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * 对于数据持久化的实现
 * */
public class DictDaoArray implements DictDao, Serializable {
    //所有方言组成的map
    private HashMap<String, Dialect> map;

    public DictDaoArray() {
        ObjectInputStream stream = null;
        try {
//            System.getProperty("user.dir")+"\\..\\webapps\\Dict\\WEB-INF\\classes\\datas\\data.dialect"
            stream = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir")+"\\..\\webapps\\Dict\\WEB-INF\\classes\\datas\\data.dialect"));
            Object o = stream.readObject();
            if (o instanceof HashMap<?,?>){
                map = (HashMap<String, Dialect>)o;
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (stream!=null){
                try {
                    stream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public DictDaoArray(HashMap<String, Dialect> map) {
        this.map = map;
    }

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

    @Override
    public HashMap<String,String[]> getDialects() {
        Set<String> keys = map.keySet();
        HashMap<String,String[]> replyMap = new HashMap<>();
        for (String key:keys){
            Dialect dialect = map.get(key);
            ArrayList<DialectBean> characters = dialect.getCharacters();
//            ArrayList<String> temp = new ArrayList<>(1000);
            String[] temp = new String[characters.size()];
            for (int i =0;i < characters.size();i++){
                temp[i] = characters.get(i).getData();
            }
            replyMap.put(key,temp);
        }
        return replyMap;
    }
}

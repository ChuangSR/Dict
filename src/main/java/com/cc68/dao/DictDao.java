package com.cc68.dao;

import com.cc68.beans.DialectBean;

public interface DictDao {
    DialectBean select(String dialect, String data);

    boolean add(String dialect,DialectBean bean);

    boolean delete(String dialect,String data);

    boolean renew(String dialect,DialectBean bean,String old);
}

package com.cc68.service;

import com.cc68.beans.DialectBean;
import com.cc68.beans.MessageBean;

public interface DictService {
    MessageBean search(String dialect, String data);

    MessageBean add(String dialect, DialectBean bean);

    MessageBean delete(String dialect,String data);

    MessageBean renew(String dialect,DialectBean bean,String old);
}

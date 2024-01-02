package com.cc68.dialect;

import com.cc68.beans.DialectBean;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 定义用于存储每一个方言的数据结构，后续可能删除
 *
 * */
public class Dialect implements Serializable {
    private ArrayList<DialectBean> characters;
    private ArrayList<DialectBean> words;
    private ArrayList<DialectBean> sentences;

    public DialectBean search(String data){
        int hash = data.hashCode();
        ArrayList<DialectBean> temp = getType(data);
        int index = search(hash, temp,false).getIndex();
        DialectBean bean = new DialectBean();
        if (index != -1){
            bean = temp.get(index);
        }
        return bean;
    }

    //查找算法,此处的status表示是否返回非数据的下标，在插入数据进行排序时为true
    private SearchStatus search(int hash,ArrayList<DialectBean> list,boolean status){
        int right = 0;
        int left = list.size();
        while (right <= left){
            int index = (right+left)/2;
            int dataHash = list.get(index).hashCode();
            if (hash < dataHash){
                left = index - 1;
            }else if (hash > dataHash){
                right = index + 1;
            }else {
                return new SearchStatus(index,false);
            }
        }

        return new SearchStatus(status ? right:-1,status);
    }
    //用于补充查询状态的类
    private class SearchStatus{
        private int index;
        private boolean status;

        public SearchStatus(int index, boolean status) {
            this.index = index;
            this.status = status;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }
    //获取数据的类型
    private ArrayList<DialectBean> getType(String data){
        ArrayList<DialectBean> temp = null;
        if (data.length() == 1){
            temp = characters;
        }else if (data.length() < 5){
            temp = words;
        }else {
            temp = sentences;
        }
        return temp;
    }
    //添加数据
    public boolean add(DialectBean bean){
        String data = bean.getData();
        ArrayList<DialectBean> temp = getType(data);
        SearchStatus search = search(data.hashCode(), temp, true);
        if (search.isStatus()){
            return false;
        }
        int index = search.getIndex();
        ArrayList<DialectBean> t = new ArrayList<>(temp.subList(index,temp.size()));
        temp.removeAll(t);
        temp.add(bean);
        temp.addAll(t);
        return true;
    }

    public boolean delete(String data) {
        ArrayList<DialectBean> temp = getType(data);
        int index = search(data.hashCode(), temp,false).getIndex();
        if (index!=-1){
            return false;
        }
        temp.remove(index);
        return true;
    }

    public boolean renew(DialectBean bean, String old) {
        ArrayList<DialectBean> temp = getType(old);
        int index = search(old.hashCode(), temp,false).getIndex();
        if (index!=-1){
            return false;
        }
        temp.set(index,bean);
        return true;
    }
}

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.cc68.beans.DialectBean;
import com.cc68.dao.impl.DictDaoArray;
import com.cc68.dialect.Dialect;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class test01 {
    public static void main(String[] args) throws IOException {
        String p1 = "F:\\temp\\main\\Dialect-Info";
        String p2 = "F:\\temp\\main\\other";
        File f1 = new File(p1);
        File f2 = new File(p2);

        String[] l1 = f1.list();
        String[] l2 = f2.list();
        HashMap<String,Dialect> map = new HashMap<>();
        for (int i = 0; i < l1.length;i++){
            ArrayList<DialectBean> beans = new ArrayList<>(1000);
            String path = p1+"\\"+l1[i];
            FileReader reader = new FileReader(path);
            StringBuffer buffer = new StringBuffer();
            char[] data = new char[1024*1024];
            int length = 0;
            while ((length = reader.read(data))!=-1){
                buffer.append(data,0,length);
            }
            HashMap hashMap = JSON.parseObject(buffer.toString(), HashMap.class);
            String type = (String)hashMap.get("type");
            JSONArray data1 = (JSONArray)hashMap.get("data");

            BufferedReader reader1 = new BufferedReader(new FileReader(p2+"\\"+l2[i]));
            String s = null;
            ArrayList<String> list = new ArrayList<>();
            while ((s = reader1.readLine())!=null){
                list.add(s);
            }
            for (int j =0;j < data1.size();j++){
                ((JSONArray)data1.get(j)).add(list.get(j));
            }
//            ["浴","Ǿøʔ5","","DialectVideo\\04fff76ad76c346719097c9de6fb59bc\\浴.mp3"]
            for (Object o:data1){
                JSONArray array = (JSONArray)o;
                DialectBean bean = new DialectBean(type,array.get(0).toString(),array.get(3).toString(),array.get(1).toString(),array.get(2).toString());
                beans.add(bean);
            }
            beans.sort(new Comparator<DialectBean>() {
                @Override
                public int compare(DialectBean o1, DialectBean o2) {
                    return o1.getData().hashCode() - o2.getData().hashCode();
                }
            });
            Dialect dialect  = new Dialect(beans,null,null);
            map.put(type,dialect);
//            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(type+".dialect"));
//            stream.writeObject(beans);
//            stream.flush();
//            stream.close();
        }
//        DictDaoArray array = new DictDaoArray(map);
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("data.dialect"));
        stream.writeObject(map);
        stream.flush();
        stream.close();
    }
}

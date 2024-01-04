import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class test01 {
    public static void main(String[] args) throws IOException {
        String p1 = "E:\\temp\\main\\Dialect-Info";
        String p2 = "E:\\temp\\main\\other";
        File f1 = new File(p1);
        File f2 = new File(p2);

        String[] l1 = f1.list();
        String[] l2 = f2.list();
        for (int i = 0; i < l1.length;i++){
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
            System.out.println(data1.size());
            System.out.println(list.size());
//            for (int j =0;j < data1.size();j++){
//                System.out.println(data1.get(j));
//                System.out.println(list.get(j));
//            }
//            for (Object o:data1){
//                System.out.println(o);
//            }
        }

    }
}

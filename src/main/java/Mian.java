import com.alibaba.fastjson2.JSON;
import com.cc68.beans.DialectBean;

import java.io.*;
import java.util.*;

public class Mian {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        DialectBean bean = new DialectBean("福建","草","xxx","xxx","");
//        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("./bean"));
//        stream.writeObject(bean);
//        stream.flush();
//        stream.close();

        ObjectInputStream stream = new ObjectInputStream(new FileInputStream("./bean"));
        Object o = stream.readObject();
        DialectBean bean = null;
        if (o instanceof DialectBean){
            bean = (DialectBean)o;
        }
        System.out.println(JSON.toJSONString(bean));
//        String temp = "{\"a\":\"1\"}";
//        HashMap parse = (HashMap)JSON.parse(temp);
//        System.out.println(parse.get("a"));
//        Base64.getDecoder()
//        String encoded = Base64.getEncoder().encodeToString(temp.getBytes());
//        System.out.println("Base 64 加密后：" + encoded);
//
//        byte[] decoded = Base64.getDecoder().decode(encoded);
//
//        String decodeStr = new String(decoded);
//        System.out.println("Base 64 解密后：" + decodeStr);
//
//        System.out.println(System.getProperty("user.dir"));

    }
}

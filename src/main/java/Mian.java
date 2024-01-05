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

        ObjectInputStream stream = new ObjectInputStream(new FileInputStream("datas/02G41-莆田.dialect"));
        Object o = stream.readObject();
        ArrayList<DialectBean> bean = null;
        if (o instanceof ArrayList<?>){
            bean = (ArrayList<DialectBean>) o;
        }
        for (DialectBean a:bean){
            System.out.println(a);
        }
//        String temp = "{\"a.txt\":\"1\"}";
//        HashMap parse = (HashMap)JSON.parse(temp);
//        System.out.println(parse.get("a.txt"));
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

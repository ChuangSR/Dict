import com.alibaba.fastjson2.JSON;

import java.io.*;
import java.util.*;

public class Mian {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String temp = "{\"a\":\"1\"}";
//        HashMap parse = (HashMap)JSON.parse(temp);
//        System.out.println(parse.get("a"));
//        Base64.getDecoder()
        String encoded = Base64.getEncoder().encodeToString(temp.getBytes());
        System.out.println("Base 64 加密后：" + encoded);

        byte[] decoded = Base64.getDecoder().decode(encoded);

        String decodeStr = new String(decoded);
        System.out.println("Base 64 解密后：" + decodeStr);

    }
}

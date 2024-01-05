import com.alibaba.fastjson2.JSON;
import com.cc68.beans.SocketBean;

import java.util.HashMap;

public class test02 {
    public static void main(String[] args) {
        String s = "{\"data\":{\"character\":\"好\",\"dialect\":\"02197-三明\"},\"type\":\"search\"}";
//        String s = "{\"type\":\"search\",\"data\":{\"dialect\":\"02197-三明\",\"character\"\"好\"}}";
//        MessageBean bean = JSON.parseObject(s, MessageBean.class);
//
//        JSON.parseObject(s, MessageBean.class);
//        System.out.println(JSON.toJSONString(bean));
        HashMap<String, String> data = new HashMap<>();
        SocketBean bean = new SocketBean("aa",data);
        System.out.println(JSON.toJSONString(bean));

    }
}

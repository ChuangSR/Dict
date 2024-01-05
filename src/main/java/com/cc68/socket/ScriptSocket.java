package com.cc68.socket;

import com.alibaba.fastjson2.JSON;
import com.cc68.beans.SocketBean;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class ScriptSocket {
    private static String serverIp;
    private static int port;

    private ScriptSocket() {
    }

    public static void init(String serverIp, int port){
        ScriptSocket.serverIp = serverIp;
        ScriptSocket.port = port;
    }
    public static SocketBean search(String character){
        HashMap<String,String> data = new HashMap<>();
        data.put("character",character);
        SocketBean bean = new SocketBean("search",data);
        System.out.println(JSON.toJSONString(bean));
        return send(bean);
    }
    
    private static SocketBean send(SocketBean bean){
        Socket client = null;
        BufferedReader reader = null;
        BufferedWriter writer = null;
        SocketBean reply = null;
        try {
            client = new Socket(serverIp,port);
            writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            writer.write(JSON.toJSONString(bean));
            writer.flush();
            client.shutdownOutput();
            
            String data;
            StringBuilder buffer = new StringBuilder();
            while ((data = reader.readLine())!=null){
                buffer.append(data);
            }

            reply = JSON.parseObject(buffer.toString(), SocketBean.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (client!=null){
                try {
                    client.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return reply;
    }
}

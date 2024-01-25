package com.cc68.web;

import com.alibaba.fastjson2.JSON;
import com.cc68.beans.DictBean;
import com.cc68.beans.MessageBean;
import com.cc68.service.DictService;
import com.cc68.service.impl.DictServiceImpl;
import com.cc68.socket.ScriptSocket;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

/**
 * web展示页面
 * */
@WebServlet({"/search","/dialectLoad","/add","/getDialect"})
public class Web extends HttpServlet {
    private DictService service;

    @Override
    public void init() throws ServletException {
        service = new DictServiceImpl();
        ScriptSocket.init("127.0.0.1",10068);

//        System.out.println(System.getProperty("user.dir"));
//        File f = new File(System.getProperty("user.dir")+"\\..\\webapps");
//        String[] list = f.list();
//        for (String i :list){
//            System.out.println(i);
//        }
//        System.out.println();
    }
//    F:\java\servlet\apache-tomcat-11.0.0-M1\bin


    @Override
    public void destroy() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MessageBean dataBean = JSON.parseObject(req.getParameter("data"), MessageBean.class);
        String type = dataBean.getType();
        if ("search".equals(type)) {
            search(req,resp,dataBean);
        }else if ("add".equals(type)){

        }else if ("dialectLoad".equals(type)){
            dialectLoad(req,resp,dataBean);
        }else if ("getDialect".equals(type)){
            getDialect(req,resp,dataBean);
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp,MessageBean dataBean) throws IOException {
        HashMap<String,Object> data = dataBean.getData();
        String dialect = (String)data.get("dialect");
        String character = (String) data.get("character");
        DictBean replyBean = service.search(dialect, character);
        System.out.println(JSON.toJSONString(replyBean));
        resp.getWriter().print(JSON.toJSONString(replyBean));
    }
    private void dialectLoad(HttpServletRequest req, HttpServletResponse resp,MessageBean dataBean) throws IOException{
        MessageBean replyBean = service.getDialects();
        resp.getWriter().print(JSON.toJSONString(replyBean));
    }
    private void getDialect(HttpServletRequest req, HttpServletResponse resp,MessageBean dataBean) throws IOException{
        MessageBean bean = service.getDialects();
        HashMap<String,String[]> temp = (HashMap<String,String[]>)bean.getData().get("data");
        HashMap<String, Object> map = new HashMap<>();
        map.put("data",temp.keySet().toArray());
        MessageBean replyBean = new MessageBean("dialects",map);
        resp.getWriter().print(JSON.toJSONString(replyBean));
    }
    private void add(HttpServletRequest req, HttpServletResponse resp,MessageBean dataBean) throws IOException{
        String word = req.getParameter("word");
        String pronunciation = req.getParameter("pronunciation");
        String notes = req.getParameter("notes");
        String select = req.getParameter("select");
//        if ()

    }
}

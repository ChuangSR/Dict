package com.cc68.web;

import com.alibaba.fastjson2.JSON;
import com.cc68.beans.MessageBean;
import com.cc68.service.DictService;
import com.cc68.service.impl.DictServiceImpl;
import com.cc68.socket.ScriptSocket;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * web展示页面
 * */
@WebServlet({"/search","/dialectLoad"})
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        MessageBean duo = service.search("02G41-莆田", "多");
        resp.getWriter().print(JSON.toJSONString(duo));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MessageBean dataBean = JSON.parseObject(req.getParameter("data"), MessageBean.class);
//        MessageBean dataBean = (MessageBean) req.getAttribute("data");
        String type = dataBean.getType();
        HashMap<String,Object> data = dataBean.getData();

        MessageBean replyBean = null;
        if ("search".equals(type)) {
            String dialect = (String)data.get("dialect");
            String character = (String) data.get("character");
//            bean = service.search(dialect,character);
            replyBean = service.search(dialect,character);
        }else if ("add".equals(type)){
            String old = req.getParameter("old");
            String dialect = req.getParameter("dialect");
//            bean = service.add(dialect,null);
        }else if ("dialectLoad".equals(type)){
            replyBean = service.getDialects();
        }
        resp.getWriter().print(JSON.toJSONString(replyBean));
    }
}

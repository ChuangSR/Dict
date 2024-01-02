package com.cc68.web;

import com.alibaba.fastjson2.JSON;
import com.cc68.beans.MessageBean;
import com.cc68.service.DictService;
import com.cc68.service.impl.DictServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

/**
 * web展示页面
 * */
public class Web extends HttpServlet {
    private DictService service;
    @Override
    public void init() throws ServletException {
        service = new DictServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MessageBean dataBean = (MessageBean) req.getAttribute("data");
        String type = dataBean.getType();
        HashMap<String,Object> data = dataBean.getData();

        MessageBean replyBean = null;
        if ("search".equals(type)) {
            String dialect = (String)data.get("dialect");
            String character = (String) data.get("character");
//            bean = service.search(dialect,character);
            replyBean = service.search(dialect,character);
        }if ("add".equals(type)){
            String old = req.getParameter("old");
            String dialect = req.getParameter("dialect");
//            bean = service.add(dialect,null);
        }
        resp.getWriter().print(JSON.toJSONString(replyBean));
    }
}

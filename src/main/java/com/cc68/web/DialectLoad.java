package com.cc68.web;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.cc68.beans.MessageBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet("/dialectLoad")
//public class DialectLoad extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String data = req.getParameter("data");
//        MessageBean bean = JSON.parseObject(data, MessageBean.class);
//        System.out.println(JSON.toJSONString(bean));
//        resp.getWriter().print("ok");
//    }
//}

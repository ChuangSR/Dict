package com.cc68.filter;

import com.alibaba.fastjson2.JSON;
import com.cc68.beans.MessageBean;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Base64;

//@WebFilter()
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //进行base64解码
        byte[] bytes = servletRequest.getParameter("data").getBytes();
        byte[] decode = Base64.getDecoder().decode(bytes);

        //使用FastJSON2库将数据转为JSON
        MessageBean bean = JSON.parseObject(new String(decode), MessageBean.class);

        //将数据存储到request域中
        servletRequest.setAttribute("data",bean);

        //请求操作判断
        if ("search".equals(bean.getType())){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpSession session = request.getSession(false);
            //登录判断
            if (session == null){
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                //拒绝访问请求返回403
                response.sendError(403);
            }else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }
}

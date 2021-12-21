package com.lingDream.interceptors;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-06-28 16:07
 */

public class Interceptor implements HandlerInterceptor {
    //预先处理
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        setResponseHeader(response);
        try {
            return HandlerInterceptor.super.preHandle(request, response, handler);
        } catch (Exception e) {
            return false;
        }
    }

    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "content-type, token");
        response.setHeader("Access-Control-Allow-Methods", " GET,POST,OPTIONS,PUT,DELETE");
    }
}

package com.ay.web;

import com.ay.model.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("AuthorizationInterceptor preHandle --> ");

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            System.out.println("AuthorizationInterceptor 拦截请求 --> ");
            request.setAttribute("message", "请先登陆再访问网站");
            request.getRequestDispatcher("/loginForm").forward(request, response);
            return false;
        } else {
            System.out.println("AuthorizationInterceptor 放行请求 --> ");
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("AuthorizationInterceptor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("AuthorizationInterceptor afterCompletion --> ");
    }
}

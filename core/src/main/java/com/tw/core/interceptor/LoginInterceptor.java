package com.tw.core.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xim on 7/15/15.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) {
        if (request.getServletPath().startsWith("/login")) {
            return true;
        }

        if (request.getSession().getAttribute("loginStatus") !=null) {
            return true;
        }
        try {
            Cookie cookie = new Cookie("currentURL", request.getRequestURI());
            cookie.setPath("/");
            response.addCookie(cookie);
            response.sendRedirect("/web/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
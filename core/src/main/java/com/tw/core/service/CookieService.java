package com.tw.core.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vivi on 7/14/15.
 */

@Service
public class CookieService {

    public String selectURLCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies) {
            if (cookie.getName().equals("currentURL")) {
                return cookie.getValue().substring(4);
                //return cookie.getValue();
            }
        }
        return null;
    }

    public void updateURLCookie(HttpServletRequest request,HttpServletResponse response) {
        String currentURL = request.getRequestURI();
        Cookie cookie = new Cookie("currentURL",currentURL);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public String checkURLCookie(HttpServletRequest request) {return selectURLCookie(request);}

    public void deleteURLCookie(){
        Cookie cookie = new Cookie("currentURL",null);
        cookie.setMaxAge(0);
    }
}

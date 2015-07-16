package com.tw.core.service;

import com.tw.core.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vivi on 7/13/15.
 */

@Service
public class LoginService {

    private ModelAndView modelAndView = new ModelAndView();

    @Autowired
    private UserService userService;

    @Autowired
    private MD5Util md5Util;

    @Autowired
    private CookieService cookieService;

    public ModelAndView userLoginCheck(HttpServletRequest request,HttpServletResponse response) {
        String inputName = request.getParameter("inputName");
        String inputPassword = request.getParameter("inputPassword");
        String inputEncodePassword = md5Util.MD5Encode(inputPassword);
        String adminName = "admin";
        String adminPassword = "admin";
        String adminEncodePassword = md5Util.MD5Encode(adminPassword);

        if (inputName.equals(adminName) && inputEncodePassword.equals(adminEncodePassword)) {
            request.getSession().setAttribute("loginStatus", "true");
            String currentURL = cookieService.checkURLCookie(request);
            cookieService.deleteURLCookie(response);
            if (currentURL == null || currentURL.isEmpty()) {
                modelAndView = userService.showUsers();
            }
            else {
                modelAndView.setViewName("redirect:"+currentURL);
            }
        }
        else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    public ModelAndView userLogout(HttpServletRequest request,HttpServletResponse response) {
        request.getSession().setAttribute("loginStatus", null);
        cookieService.deleteURLCookie(response);
        modelAndView.setViewName("/login");
        return modelAndView;
    }

}

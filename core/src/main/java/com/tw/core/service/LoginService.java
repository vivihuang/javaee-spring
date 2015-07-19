package com.tw.core.service;

import com.tw.core.dao.UserDao;
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

    @Autowired
    private UserDao userDao;

    public boolean userLoginCheck(HttpServletRequest request) {
        String inputName = request.getParameter("inputName");
        String inputPassword = request.getParameter("inputPassword");
        //String inputEncodePassword = md5Util.MD5Encode(inputPassword);
        String adminEncodePassword = userDao.getUserPassword(inputName);

        if (adminEncodePassword != null && adminEncodePassword.equals(inputPassword)) {
            request.getSession().setAttribute("loginStatus", "true");
            return true;
        }
        return false;
    }

    public void userLogout(HttpServletRequest request,HttpServletResponse response) {
        request.getSession().setAttribute("loginStatus", null);
        cookieService.deleteURLCookie(response);
    }

    public String getCurrentURL(HttpServletRequest request,HttpServletResponse response){
        String currentURL = cookieService.selectURLCookie(request);
        cookieService.deleteURLCookie(response);
        return currentURL;
    }

}

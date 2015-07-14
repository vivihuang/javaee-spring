package com.tw.core.service;
import com.tw.core.dao.*;
import com.tw.core.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vivi on 7/13/15.
 */
@Service
public class UserService {

    @Autowired
    private CookieService cookieService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private User user;
    @Autowired
    private LoginService loginService;

    private ModelAndView modelAndView = new ModelAndView();

    public ModelAndView showUsers(){
        modelAndView.setViewName("index");
        modelAndView.addObject("userList", userDao.getUsers());
        return modelAndView;
    }

    public ModelAndView userPage(HttpServletRequest request,HttpServletResponse response){
        if (loginService.isLogged(request)) {
            return showUsers();
        }
        else {
            cookieService.updateURLCookie(request,response);
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    public ModelAndView userAddPage(HttpServletRequest request,HttpServletResponse response){
        if (loginService.isLogged(request)) {
            modelAndView.setViewName("user");
            modelAndView.addObject("user", null);
        }
        else {
            cookieService.updateURLCookie(request, response);
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    public ModelAndView userEditPage(HttpServletRequest request,HttpServletResponse response,String userId) {
        if (loginService.isLogged(request)) {
            modelAndView.setViewName("user");
            modelAndView.addObject("user", userDao.getUserById(Integer.parseInt(userId)));
        }
        else{
            cookieService.updateURLCookie(request, response);
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    public ModelAndView deleteUser(HttpServletRequest request,HttpServletResponse response,String userId) {
        if (loginService.isLogged(request)) {
            userDao.deleteUser(Integer.parseInt(userId));
            modelAndView.setViewName("index");
            modelAndView.addObject("userList", userDao.getUsers());
        }
        else {
            cookieService.updateURLCookie(request, response);
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }


    public ModelAndView editUser(HttpServletRequest request) {
        if (loginService.isLogged(request)) {
            String userId = request.getParameter("id");
            user.setName(request.getParameter("name"));
            user.setSex(request.getParameter("sex"));
            user.setEmail(request.getParameter("email"));
            user.setAge(Integer.parseInt(request.getParameter("age")));

            if (userId == null || userId.isEmpty()) {
                userDao.addUser(user);
            } else {
                user.setId(Integer.parseInt(userId));
                userDao.updateUser(user);
            }

            modelAndView.setViewName("index");
            modelAndView.addObject("userList", userDao.getUsers());
        }
        else {
            modelAndView.setViewName("login");
        }

        return modelAndView;
    }

}

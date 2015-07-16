package com.tw.core.service;
import com.tw.core.dao.*;
import com.tw.core.entity.User;
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

    public ModelAndView userPage(){
        return showUsers();
    }

    public ModelAndView userAddPage(HttpServletRequest request,HttpServletResponse response){
        modelAndView.setViewName("user");
        modelAndView.addObject("user", null);
        return modelAndView;
    }

    public ModelAndView userEditPage(HttpServletRequest request,HttpServletResponse response,String userId) {
        modelAndView.setViewName("user");
        modelAndView.addObject("user", userDao.getUserById(Integer.parseInt(userId)));
        return modelAndView;
    }

    public ModelAndView deleteUser(HttpServletRequest request,HttpServletResponse response,String userId) {
        userDao.deleteUser(Integer.parseInt(userId));
        modelAndView.setViewName("index");
        modelAndView.addObject("userList", userDao.getUsers());
        return modelAndView;
    }


    public ModelAndView editUser(HttpServletRequest request) {
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

        return modelAndView;
    }

}

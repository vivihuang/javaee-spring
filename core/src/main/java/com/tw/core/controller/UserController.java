package com.tw.core.controller;

import com.tw.core.dao.UserDao;
import com.tw.core.entity.User;
import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vivi on 7/13/15.
 */

@Controller
@RequestMapping(value = "//user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private User user;

    private ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView userPage() {
        modelAndView.setViewName("user");
        modelAndView.addObject("userList", userDao.getUsers());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView editUser(HttpServletRequest request,HttpServletResponse response) {
        userService.editUser(request);
        modelAndView.setViewName("redirect://user");
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView addUser() {
        modelAndView.setViewName("modify_user");
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public ModelAndView updateUser(@PathVariable("id")String userId){
        user = userDao.getUserById(Integer.parseInt(userId));
        modelAndView.setViewName("modify_user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id")String userId) {
        userDao.deleteUser(Integer.parseInt(userId));
        modelAndView.setViewName("redirect://user");
        return modelAndView;
    }
}

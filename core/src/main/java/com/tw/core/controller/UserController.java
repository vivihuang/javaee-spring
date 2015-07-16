package com.tw.core.controller;

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
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView userPage() {
        return userService.userPage();
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView userAddPage(HttpServletRequest request,HttpServletResponse response) {
        return userService.userAddPage(request,response);
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public ModelAndView userEditPage(@PathVariable("id")String userId,HttpServletRequest request,HttpServletResponse response) {
        return userService.userEditPage(request,response,userId);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id")String userId,HttpServletRequest request,HttpServletResponse response){
        return userService.deleteUser(request,response,userId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView editUser(HttpServletRequest request) {
        return userService.editUser(request);
    }
}

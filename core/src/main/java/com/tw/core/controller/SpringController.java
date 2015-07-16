package com.tw.core.controller;

import com.tw.core.dao.UserDao;

import com.tw.core.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SpringController {

    UserDao userDao = new UserDao();
    ModelAndView modelAndView = new ModelAndView();
    LoginService loginService = new LoginService();

//    @RequestMapping("/")
//    public ModelAndView loginPage(){
//
//        return new ModelAndView("login");
//    }
//
//    @RequestMapping("/login")
//    public ModelAndView loginController(@CookieValue(value = "login",defaultValue = "admin")String loginCookie,@RequestParam("name")String name,@RequestParam("password")String password){
//
//        return new ModelAndView("index");
//    }


}

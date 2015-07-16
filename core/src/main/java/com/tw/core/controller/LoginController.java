package com.tw.core.controller;

import com.tw.core.dao.UserDao;
import com.tw.core.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.*;

/**
 * Created by Vivi on 7/13/15.
 */

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    public ModelAndView welcomePage(){ return new ModelAndView("index");
    }

    @RequestMapping("/index")
    public ModelAndView indexPage(){
        return new ModelAndView("index","userList",userDao.getUsers());
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView loginPage(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView loginController(HttpServletRequest request,HttpServletResponse response){
        return loginService.userLoginCheck(request, response);
    }

    @RequestMapping("/logout")
    public ModelAndView logoutController(HttpServletRequest request,HttpServletResponse response) {
        return loginService.userLogout(request, response);
    }

}

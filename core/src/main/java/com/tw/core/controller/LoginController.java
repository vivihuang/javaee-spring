package com.tw.core.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.tw.core.service.*;
import com.tw.core.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.*;

/**
 * Created by Vivi on 7/13/15.
 */

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/")
    public ModelAndView loginPage(HttpServletRequest request,HttpServletResponse response){
        loginService.setSession(request);
            return new ModelAndView("login");
    }

    @RequestMapping(value = "/login")
    public ModelAndView loginController(HttpServletRequest request){
        return loginService.userLoginCheck(request);
    }

    @RequestMapping("/logout")
    public ModelAndView logoutController(HttpServletRequest request) {
        return loginService.userLogout(request);
    }

    @RequestMapping("/encode")
    public ModelAndView login2Encode(HttpServletRequest request){ return loginService.login2Encode(request);}
}

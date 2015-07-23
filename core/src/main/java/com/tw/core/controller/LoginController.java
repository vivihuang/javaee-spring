package com.tw.core.controller;

import com.tw.core.dao.*;
import com.tw.core.entity.Coach;
import com.tw.core.entity.Course;
import com.tw.core.entity.Customer;
import com.tw.core.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.*;
import java.util.List;

/**
 * Created by Vivi on 7/13/15.
 */

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserDao userDao;


    ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView loginPage(HttpServletRequest request,HttpServletResponse response){
//        request.getSession().setAttribute("loginStatus", "true");
        return new ModelAndView("login");
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView loginController(HttpServletRequest request,HttpServletResponse response){
        if (loginService.userLoginCheck(request)) {
            String currentURL = loginService.getCurrentURL(request,response);
            if (currentURL == null) {
                modelAndView.setViewName("redirect:/index");
            }
            else {
                modelAndView.setViewName("redirect:" + currentURL);
            }
        }
        else {
            modelAndView.setViewName("redirect:/login");
        }
        return modelAndView;
    }

    @RequestMapping("/logout")
    public ModelAndView logoutController(HttpServletRequest request,HttpServletResponse response) {
        loginService.userLogout(request, response);
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }

}

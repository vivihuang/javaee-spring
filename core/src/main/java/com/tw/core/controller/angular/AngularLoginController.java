package com.tw.core.controller.angular;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vivi on 7/30/15.
 */
@Controller
@ResponseBody
@RequestMapping(value = "/angular/")
public class AngularLoginController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public void loginPage(HttpServletRequest request,HttpServletResponse response){

    }
}

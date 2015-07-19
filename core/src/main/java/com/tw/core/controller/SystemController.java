package com.tw.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Vivi on 7/18/15.
 */
@Controller
public class SystemController {

    private ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(value = "/system",method = RequestMethod.GET)
    public ModelAndView indexPage(){
        modelAndView.setViewName("redirect:index");
        return modelAndView;
    }
}

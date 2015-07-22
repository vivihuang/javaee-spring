package com.tw.core.controller;

import com.tw.core.dao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Vivi on 7/18/15.
 */
@Controller
public class SystemController {

    @Autowired
    private CourseDao courseDao;

    private ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView welcomePage(){
        modelAndView.setViewName("redirect:index");
        return modelAndView;
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView indexPage(){
        modelAndView.setViewName("index");
        modelAndView.addObject("courseList",courseDao.getPublicCourses());
        return modelAndView;
    }

}

package com.tw.core.controller;

import com.tw.core.dao.CoachDao;
import com.tw.core.dao.CourseDao;
import com.tw.core.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vivi on 7/18/15.
 */

@Controller
@RequestMapping(value = "/system/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private CoachDao coachDao;

    private ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showCoachCoursePage(){
        modelAndView.setViewName("/course");
        modelAndView.addObject("courseList",courseDao.getCourses());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView modifyCourse(HttpServletRequest request,HttpServletResponse response){
        courseService.editCourse(request,response);
        modelAndView.setViewName("/course");
        modelAndView.addObject("courseList",courseDao.getCourses());
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView addCourse(){
        modelAndView.setViewName("modify_course");
        modelAndView.addObject("coachList",coachDao.getCoaches());
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public ModelAndView updateCourse(@PathVariable("id")String courseId){
        modelAndView.setViewName("modify_course");
        modelAndView.addObject("course", courseDao.getCourseById(Integer.parseInt(courseId)));
        modelAndView.addObject("coachList",coachDao.getCoaches());
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public ModelAndView deleteCourse(@PathVariable("id")String courseId) {
        courseDao.deleteCourse(Integer.parseInt(courseId));
        modelAndView.setViewName("redirect:/system/course");
        return modelAndView;
    }
}

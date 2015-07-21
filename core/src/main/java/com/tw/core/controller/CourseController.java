package com.tw.core.controller;

import com.tw.core.dao.CoachDao;
import com.tw.core.dao.CourseDao;
import com.tw.core.dao.CustomerDao;
import com.tw.core.dao.DateRelationDao;
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
@RequestMapping
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private CoachDao coachDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private DateRelationDao dateRelationDao;

    private ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(value = "/course",method = RequestMethod.GET)
    public ModelAndView showCoachCoursePage(){
        modelAndView.setViewName("/course");
        modelAndView.addObject("courseList",courseDao.getCourses());
        return modelAndView;
    }

    @RequestMapping(value = "/course",method = RequestMethod.POST)
    public ModelAndView modifyCourse(HttpServletRequest request,HttpServletResponse response){
        courseService.editCourse(request,response);
        modelAndView.setViewName("/course");
        modelAndView.addObject("courseList",courseDao.getCourses());
        return modelAndView;
    }

    @RequestMapping(value = "/course/add",method = RequestMethod.GET)
    public ModelAndView addCourse(){
        modelAndView.setViewName("modify_course");
        modelAndView.addObject("coachList",coachDao.getCoaches());
        return modelAndView;
    }

    @RequestMapping(value = "/course/update/{id}",method = RequestMethod.GET)
    public ModelAndView updateCourse(@PathVariable("id")String courseId){
        modelAndView.setViewName("modify_course");
        modelAndView.addObject("course", courseDao.getCourseById(Integer.parseInt(courseId)));
        modelAndView.addObject("coachList",coachDao.getCoaches());
        return modelAndView;
    }

    @RequestMapping(value = "/course/delete/{id}",method = RequestMethod.GET)
    public ModelAndView deleteCourse(@PathVariable("id")String courseId) {
        courseDao.deleteCourse(Integer.parseInt(courseId));
        modelAndView.setViewName("redirect:/course");
        return modelAndView;
    }

    @RequestMapping(value = "/course_arrangement",method = RequestMethod.GET)
    public ModelAndView showCourseArrangement() {
        modelAndView.setViewName("course_arrangement");
        modelAndView.addObject("course_arrangement_list", dateRelationDao.getCourseArrangement());
        return modelAndView;
    }

    @RequestMapping(value = "/course_arrangement",method = RequestMethod.POST)
    public ModelAndView editCourseArrangement(HttpServletRequest request){
        courseService.editCourseArrangement(request);
        modelAndView.setViewName("redirect:/course_arrangement");
        return modelAndView;
    }

    @RequestMapping(value = "/course_arrangement/add",method = RequestMethod.GET)
    public ModelAndView addCourseArrangement() {
        modelAndView.setViewName("modify_course_arrangement");
        modelAndView.addObject("dateRelation", null);
        modelAndView.addObject("courseList", courseDao.getCourses());
        modelAndView.addObject("customerList", customerDao.getCustomers());
        return modelAndView;
    }

    @RequestMapping(value = "/course_arrangement/update/{id}",method = RequestMethod.GET)
    public ModelAndView updateCourseArrangement(@PathVariable("id")String arrangementId){
        modelAndView.setViewName("modify_course_arrangement");
        modelAndView.addObject("dateRelation",dateRelationDao.getCourseArrangementById(Integer.parseInt(arrangementId)));
        return modelAndView;
    }

    @RequestMapping(value = "/course_arrangement/delete/{id}",method = RequestMethod.GET)
    public ModelAndView deleteCourseArrangement(@PathVariable("id")String arrangementId) {
        dateRelationDao.deleteCourseArrangement(Integer.parseInt(arrangementId));
        modelAndView.setViewName("redirect:/course_arrangement");
        return modelAndView;
    }
}

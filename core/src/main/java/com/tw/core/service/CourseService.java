package com.tw.core.service;

import com.tw.core.dao.CoachDao;
import com.tw.core.dao.CourseDao;
import com.tw.core.entity.Coach;
import com.tw.core.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vivi on 7/18/15.
 */
@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private Course course;

    @Autowired
    private CoachDao coachDao;

    @Autowired
    private Coach coach;

    public void editCourse(HttpServletRequest request,HttpServletResponse response){
        String courseId = request.getParameter("id");
        course.setName(request.getParameter("course_name"));
        int coachId = Integer.parseInt(request.getParameter("coach_id"));
        coach = coachDao.getCoachById(coachId);
        course.setCoach(coach);


        if (courseId == null || courseId.isEmpty()) {
            courseDao.addCourse(course);
        } else {
            course.setId(Integer.parseInt(courseId));
            courseDao.updateCourse(course);
        }
    }
}

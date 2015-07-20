package com.tw.core.service;

import com.tw.core.dao.*;
import com.tw.core.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.*;
import java.text.*;
import java.util.Date;

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
    @Autowired
    private DateRelationDao dateRelationDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Customer customer;

    DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();


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

    public void editCourseArrangement(HttpServletRequest request){
        String dateString = request.getParameter("date");
        String customerId = request.getParameter("customer_id");
        String courseId = request.getParameter("course_id");
        try {
                date = sdf.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        if (courseId.equals("null") || dateRelationDao.checkedCourseExists(dateString,courseId,customerId)) {
            return;
        }

        course = courseDao.getCourseById(Integer.parseInt(courseId));
        if (customerId.equals("null")) {
            customer = null;
        }
        else {
            customer = customerDao.getCustomerById(Integer.parseInt(customerId));
        }
        dateRelationDao.addCourseArrangementByDate(date,course,customer);
    }
}

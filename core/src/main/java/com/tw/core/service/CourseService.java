package com.tw.core.service;

import com.tw.core.dao.*;
import com.tw.core.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private DateRelation dateRelation;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Customer customer;

    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();

    public Course editCourse(HttpServletRequest request,HttpServletResponse response){
        String courseId = request.getParameter("id");
        course.setName(request.getParameter("courseName"));
        int coachId = Integer.parseInt(request.getParameter("coachId"));
        coach = coachDao.getCoachById(coachId);
        course.setCoach(coach);


        if (courseId == null || courseId.isEmpty()) {
            courseDao.addCourse(course);
        } else {
            course.setId(Integer.parseInt(courseId));
            courseDao.updateCourse(course);
        }
        return course;
    }

    public void editCourseArrangement(HttpServletRequest request){
        String courseType = request.getParameter("course_type");
        String dateString = request.getParameter("date");
        String customerId = request.getParameter("customer_id");
        String courseId = request.getParameter("course_id");

        if (dateString.equals("")){
            return;
        }

        if (!courseId.equals("null")) {
            coach = coachDao.getCoachByCourse(courseId);
        }
        else if (!customerId.equals("null")) {
            coach = coachDao.getCoachByCustomer(customerId);
        }

        if (checkCoachExistsByDate(date,coach)) {
            return;
        }


        if (courseType.equals("public")) {
            editPublicCourseArrangement(dateString, courseId);
        }
       else {
            editPersonalCourseArrangement(dateString, customerId);
        }
    }

    public void editPublicCourseArrangement(String dateString,String courseId){
        try {
          date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        course = courseDao.getCourseById(Integer.parseInt(courseId));

        if (courseId.equals("null") || dateRelationDao.checkPublicCourseExists(date,courseId)) {
            return;
        }

        customer = null;
        dateRelationDao.addCourseArrangementByDate(date,course,customer);
    }

    public void editPersonalCourseArrangement(String dateString,String customerId) {
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        customer = customerDao.getCustomerById(Integer.parseInt(customerId));
        course = courseDao.getPersonalCourseByCustomer(customer);
        if (customerId.equals("null") || dateRelationDao.checkPersonalCourseExists(date,customer.getId(),course.getId())) {
            return;
        }

        dateRelationDao.addCourseArrangementByDate(date, course, customer);
    }

    public boolean checkCoachExistsByDate(Date date,Coach coach) {
        List<DateRelation> dateRelationList = dateRelationDao.getCourseArrangementByDate(date);
        Coach currentCoach = new Coach();

        for (int i=0;i<dateRelationList.size();i++) {
            currentCoach = dateRelationList.get(i).getCourse().getCoach();
            if (currentCoach.getId() == coach.getId()) {
                return true;
            }
        }
        return false;
    }
}

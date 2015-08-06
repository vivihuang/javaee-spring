package com.tw.core.dao;

import com.tw.core.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Vivi on 7/19/15.
 */
@Repository
@Transactional
public class DateRelationDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private DateRelation dateRelation;
    @Autowired
    private Course course;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private Customer customer;
    @Autowired
    private CustomerDao customerDao;

    private List<DateRelation> dateRelationList = new ArrayList<DateRelation>();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    public void addCourseArrangementByDate(Date date,Course course,Customer customer) {
        dateRelation.setDateRelation(date, course, customer);
        Session session = sessionFactory.getCurrentSession();
        session.save(dateRelation);
    }

    public boolean checkPublicCourseExists(Date date,String courseId) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "select * from date_course_customer where date=" +simpleDateFormat.format(date)+" AND customer_id IS NULL AND course_id="+courseId;
        dateRelationList = session.createSQLQuery(sql).addEntity(DateRelation.class).list();

        if (dateRelationList.size() == 0) {
            return false;
        }

        return true;
    }

    public boolean checkPersonalCourseExists(Date date,int customerId,int courseId) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "select * from date_course_customer where date=" + simpleDateFormat.format(date)+" AND course_id="+courseId+" AND customer_id="+customerId;
        dateRelationList = session.createSQLQuery(sql).addEntity(DateRelation.class).list();

        if (dateRelationList.size() == 0) {
            return false;
        }

        return true;
    }

    public List<DateRelation> getCourseArrangement(){
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM date_course_customer";
        dateRelationList = session.createSQLQuery(sql).addEntity(DateRelation.class).list();
        return dateRelationList;
    }

    public DateRelation getCourseArrangementById(int arrangementId) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM date_course_customer WHERE id="+arrangementId;
        dateRelationList = session.createSQLQuery(sql).addEntity(DateRelation.class).list();
        dateRelation = dateRelationList.get(0);
        return dateRelation;
    }

    public void deleteCourseArrangement(int id) {
        Session session = sessionFactory.getCurrentSession();
        dateRelation = getCourseArrangementById(id);
        dateRelation.setCourse(null);
        dateRelation.setCustomer(null);
        System.out.println(dateRelation.getCourse()+"~~~~~~~~~~~~~~~~~~");
        session.delete(dateRelation);
    }

    public List<DateRelation> getCourseArrangementByDate(Date date) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "select * from date_course_customer where date=" + simpleDateFormat.format(date);
        dateRelationList = session.createSQLQuery(sql).addEntity(DateRelation.class).list();
        return dateRelationList;
    }

    public List<DateRelation> getPersonalCourses(String customerId) {
        List<DateRelation> dateRelationList = new ArrayList<DateRelation>();
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM date_course_customer WHERE customer_id="+customerId;
        dateRelationList = session.createSQLQuery(sql).addEntity(DateRelation.class).list();
        return dateRelationList;
    }

    public DateRelation updateCourseArrangement(int id,String dateString,String courseId,String customerId){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = sdf.parse(dateString);
        }catch (Exception e) {
            e.printStackTrace();
        }
        dateRelation = getCourseArrangementById(id);
        if (customerId!=null) {
            customer = customerDao.getCustomerById(Integer.parseInt(customerId));
        }
        else {
            customer=null;
        }
        course = courseDao.getCourseById(Integer.parseInt(courseId));
        dateRelation.setDateRelation(date, course, customer);
        Session session = sessionFactory.getCurrentSession();
        session.update(dateRelation);
        return dateRelation;
    }

    public DateRelation addAngularCourseArrangementByDate(String dateString,String courseId,String customerId){
        course = courseDao.getCourseById(Integer.parseInt(courseId));
        if (customerId != null) {
            customer = customerDao.getCustomerById(Integer.parseInt(customerId));
        }
        else {
            customer = null;
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = sdf.parse(dateString);
        }catch (Exception e) {
            e.printStackTrace();
        }
        dateRelation.setDateRelation(date,course,customer);
        Session session = sessionFactory.getCurrentSession();
        session.save(dateRelation);
        return dateRelation;
    }
}

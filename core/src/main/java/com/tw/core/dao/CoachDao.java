package com.tw.core.dao;

import com.tw.core.entity.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vivi on 7/17/15.
 */
@Repository
@Transactional
@EnableTransactionManagement
public class CoachDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private Coach coach;

    private List<Coach> coachList = new ArrayList<Coach>();
    private List<Course> courseList = new ArrayList<Course>();
    private List<Customer> customerList = new ArrayList<Customer>();

    public Coach getCoachById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("select * from employee WHERE id ="+id).addEntity(Coach.class);
        coachList = query.list();
        coach = coachList.get(0);
        return coach;
    }

    public List<Coach> getCoaches(){
        Session session = sessionFactory.getCurrentSession();
        String sql = "select * from employee where role = 'coach'";
        Query query = session.createSQLQuery(sql).addEntity(Coach.class);
        coachList = query.list();
        return coachList;
    }

    public Coach getCoachByCourse(String courseId) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM course WHERE id="+courseId;
        courseList = session.createSQLQuery(sql).addEntity(Course.class).list();
        coach = courseList.get(0).getCoach();
        return coach;
    }

    public Coach getCoachByCustomer(String customerId) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM customer WHERE id="+customerId;
        customerList = session.createSQLQuery(sql).addEntity(Customer.class).list();
        coach = customerList.get(0).getCoach();
        return coach;
    }


}

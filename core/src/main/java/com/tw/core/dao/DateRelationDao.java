package com.tw.core.dao;

import com.tw.core.entity.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Vivi on 7/19/15.
 */
@Service
public class DateRelationDao {

    @Autowired
    private DateRelation dateRelation;

    private Configuration cfg = new Configuration().configure();
    private SessionFactory factory = cfg.buildSessionFactory();
    private List<DateRelation> dateRelationList = new ArrayList<DateRelation>();

    public void addCourseArrangementByDate(Date date,Course course,Customer customer) {
        dateRelation.setDate(date);
        dateRelation.setCourse(course);
        dateRelation.setCustomer(customer);

        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(dateRelation);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }
    }

    public boolean checkedCourseExists(String date,String courseId,String customerId) {
        Session session = null;
        String sql;
        try {
            session = factory.openSession();
            if (customerId.equals("null")) {
                sql = "select * from date_course_customer where date=" + date+" AND course_id="+courseId+" AND customer_id IS NULL";
            }
            else {
                sql = "select * from date_course_customer where date=" + date + " AND course_id=" + courseId + " And customer_id=" + customerId;
            }
            dateRelationList = session.createSQLQuery(sql).addEntity(DateRelation.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }

        if (dateRelationList.size() == 0) {
            return false;
        }
        return true;
    }
}

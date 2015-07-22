package com.tw.core.dao;

import com.tw.core.entity.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.text.SimpleDateFormat;
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
    @Autowired
    private CoachDao coachDao;
    @Autowired
    private Coach coach;
    @Autowired
    private Course course;

    private Configuration cfg = new Configuration().configure();
    private SessionFactory factory = cfg.buildSessionFactory();
    private List<DateRelation> dateRelationList = new ArrayList<DateRelation>();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    public void addCourseArrangementByDate(Date date,Course course,Customer customer) {
        dateRelation.setDateRelation(date, course, customer);

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

    public boolean checkPublicCourseExists(Date date,String courseId) {
        Session session = null;

        try {
            session = factory.openSession();
            String sql = "select * from date_course_customer where date=" +simpleDateFormat.format(date)+" AND customer_id IS NULL AND course_id="+courseId;
            dateRelationList = session.createSQLQuery(sql).addEntity(DateRelation.class).list();
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

    public boolean checkPersonalCourseExists(Date date,int customerId,int courseId) {
        Session session = null;
        try {
            session = factory.openSession();
            String sql = "select * from date_course_customer where date=" + simpleDateFormat.format(date)+" AND course_id="+courseId+" AND customer_id="+customerId;
            dateRelationList = session.createSQLQuery(sql).addEntity(DateRelation.class).list();
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

    public List<DateRelation> getCourseArrangement(){
        Session session = null;
        try {
            session = factory.openSession();
            String sql = "SELECT * FROM date_course_customer";
            dateRelationList = session.createSQLQuery(sql).addEntity(DateRelation.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return dateRelationList;
    }

    public DateRelation getCourseArrangementById(int arrangementId) {
        Session session = null;
        try {
            session = factory.openSession();
            String sql = "SELECT * FROM date_course_customer WHERE id="+arrangementId;
            dateRelationList = session.createSQLQuery(sql).addEntity(DateRelation.class).list();
            dateRelation = dateRelationList.get(0);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return dateRelation;
    }

    public void deleteCourseArrangement(int id) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            dateRelation.setId(id);
            session.delete(dateRelation);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<DateRelation> getCourseArrangementByDate(Date date) {
        Session session = null;
        Coach currentCoach = new Coach();
        try {
            session = factory.openSession();
            String sql = "select * from date_course_customer where date=" + simpleDateFormat.format(date);
            dateRelationList = session.createSQLQuery(sql).addEntity(DateRelation.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }

        return dateRelationList;
    }

    public List<DateRelation> getPersonalCourses(String customerId) {
        List<DateRelation> dateRelationList = new ArrayList<DateRelation>();
        Session session = null;
        try {
            session = factory.openSession();
            String sql = "SELECT * FROM date_course_customer WHERE customer_id="+customerId;
            dateRelationList = session.createSQLQuery(sql).addEntity(DateRelation.class).list();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return dateRelationList;
    }
}

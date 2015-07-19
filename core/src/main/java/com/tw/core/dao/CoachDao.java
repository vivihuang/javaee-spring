package com.tw.core.dao;

import com.tw.core.entity.Coach;
import com.tw.core.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vivi on 7/17/15.
 */
@Service
public class CoachDao {

    @Autowired
    private Coach coach;

    private Configuration cfg = new Configuration().configure();
    private SessionFactory factory = cfg.buildSessionFactory();

    public Coach getCoachById(int id) {
        List<Coach> coachList = new ArrayList<Coach>();
        Session session = null;

        try {
            session = factory.openSession();
            Query query = session.createSQLQuery("select * from employee WHERE id ="+id).addEntity(Coach.class);
            coachList = query.list();
            coach = coachList.get(0);
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }
        return coach;
    }

    public List<Coach> getCoaches(){
        List<Coach> coachList = new ArrayList<Coach>();
        Session session = null;

        try {
            session = factory.openSession();
            String sql = "select * from employee where role = 'coach'";
            Query query = session.createSQLQuery(sql).addEntity(Coach.class);
            coachList = query.list();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }
        return coachList;
    }


}

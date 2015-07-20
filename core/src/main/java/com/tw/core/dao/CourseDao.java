package com.tw.core.dao;

import com.tw.core.entity.Course;
import com.tw.core.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PrimaryKeyJoinColumn;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vivi on 7/17/15.
 */
@Service
public class CourseDao {

    @Autowired
    private Course course;

    private Configuration cfg = new Configuration().configure();
    private SessionFactory factory = cfg.buildSessionFactory();
    private List<Course> courseList = new ArrayList<Course>();

    public Course getCourseById(int id){
        Session session = null;

        try {
            session = factory.openSession();
            String sql = "SELECT * from course WHERE id="+id;
            courseList = session.createSQLQuery(sql).addEntity(Course.class).list();
            course = courseList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }

        return course;
    }

    public List<Course> getCourses(){
        Session session = null;

        try {
            session = factory.openSession();
            String sql = "SELECT * from course";
            courseList = session.createSQLQuery(sql).addEntity(Course.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }

        return courseList;
    }

    public void addCourse(Course course){
        Session session = null;

        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(course);
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

    public void updateCourse(Course course){
        Session session = null;

        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(course);
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

    public void deleteCourse(int id) {
        Session session = null;

        try {
            session = factory.openSession();
            session.beginTransaction();

            course.setId(id);
            session.delete(course);
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
}

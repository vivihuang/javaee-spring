package com.tw.core.dao;

import com.tw.core.entity.Course;
import com.tw.core.entity.Customer;
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

    public Course getPersonalCourseByCustomer(Customer customer){
        int coachId = customer.getCoach().getId();
        Session session = null;

        try {
            session = factory.openSession();
            String sql = "SELECT * FROM course WHERE course_name='私教课' AND employee_id="+coachId;
            courseList = session.createSQLQuery(sql).addEntity(Course.class).list();
            if (courseList.size()==0) {
                addPersonalCourseByCoach(coachId);
                courseList = session.createSQLQuery(sql).addEntity(Course.class).list();
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }
        return courseList.get(0);
    }

    public void addPersonalCourseByCoach(int coachId) {
        Session session = null;
        try {
            session = factory.openSession();
            String sql = "INSERT INTO course VALUES (NULL ,'私教课',"+coachId+")";
            session.beginTransaction();
            session.save(sql);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }

    }

    public List<Course> getPublicCourses(){
        Session session = null;
        try {
            session = factory.openSession();
            String sql = "SELECT * FROM course WHERE course_name<>'私教课'";
            courseList = session.createSQLQuery(sql).addEntity(Course.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return courseList;
    }
}

package com.tw.core.dao;

import com.tw.core.entity.Course;
import com.tw.core.entity.Customer;
import com.tw.core.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PrimaryKeyJoinColumn;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vivi on 7/17/15.
 */
@Repository
@Transactional
public class CourseDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private Course course;
    private List<Course> courseList = new ArrayList<Course>();

    public Course getCourseById(int id){
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * from course WHERE id="+id;
        courseList = session.createSQLQuery(sql).addEntity(Course.class).list();
        course = courseList.get(0);
        return course;
    }

    public List<Course> getCourses(){
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * from course";
        courseList = session.createSQLQuery(sql).addEntity(Course.class).list();
        return courseList;
    }

    public void addCourse(Course course){
        Session session = sessionFactory.getCurrentSession();
        session.save(course);
    }

    public void updateCourse(Course course){
        Session session = sessionFactory.getCurrentSession();
        session.update(course);
    }

    public void deleteCourse(int id) {
        Session session = sessionFactory.getCurrentSession();
        course.setId(id);
        session.delete(course);
    }

    public Course getPersonalCourseByCustomer(Customer customer){
        int coachId = customer.getCoach().getId();
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM course WHERE course_name='私教课' AND employee_id="+coachId;
        courseList = session.createSQLQuery(sql).addEntity(Course.class).list();
        if (courseList.size()==0) {
            addPersonalCourseByCoach(coachId);
            courseList = session.createSQLQuery(sql).addEntity(Course.class).list();
        }
        return courseList.get(0);
    }

    public void addPersonalCourseByCoach(int coachId) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "INSERT INTO course VALUES (NULL ,'私教课',"+coachId+")";
        session.save(sql);
    }

    public List<Course> getPublicCourses(){
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM course WHERE course_name<>'私教课'";
        courseList = session.createSQLQuery(sql).addEntity(Course.class).list();
        return courseList;
    }
}

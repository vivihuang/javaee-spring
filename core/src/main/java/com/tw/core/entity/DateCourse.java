package com.tw.core.entity;

import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Vivi on 7/16/15.
 */
@Service
@Entity
@Table(name = "date_course")
public class DateCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private Date date;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private List<Course> courseList;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    public void setCourseList(List<Course> courses) {
        this.courseList = courses;
    }

    public List<Course> getCourseList(){
        return this.courseList;
    }
}

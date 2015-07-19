package com.tw.core.entity;

import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Vivi on 7/16/15.
 */

@Service
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "customer_name")
    private String name;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="employee_id")//加入一列作为外键
    private Coach coach;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "customer_course",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<Course> courseList;

    public int getId(){
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Coach getCoach(){
        return this.coach;
    }

    public void setCourseList(List<Course> courses){
        this.courseList = courses;
    }

    public List<Course> getCourseList(){
        return this.courseList;
    }
}

package com.tw.core.entity;

import com.google.gson.annotations.Expose;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vivi on 7/16/15.
 */
@Service
@Entity
@Table(name = "employee")
public class Coach{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Expose
    private int id;

    @Column(name = "employee_name")
    @Expose
    private String name;

    @OneToMany(targetEntity = Course.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private List<Course> courseList = new ArrayList<Course>();

    @OneToMany(targetEntity = Customer.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private List<Customer> customerList = new ArrayList<Customer>();

    public Coach() {
    }

    public Coach(int id,String name) {
        this.id = id;

        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}

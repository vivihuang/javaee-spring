package com.tw.core.entity;

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
    private int id;

    @Column(name = "employee_name")
    private String name;

    @OneToMany(targetEntity = Course.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private List<Course> courseList = new ArrayList<Course>();

    @OneToMany(targetEntity = Customer.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private List<Customer> customerList = new ArrayList<Customer>();

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Course> getCourseList(){
        return this.courseList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Customer> getCustomerList() {
        return this.customerList;
    }

}

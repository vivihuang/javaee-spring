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
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Expose
    private int id;

    @Column(name = "course_name")
    @Expose
    private String name;

    @ManyToOne(targetEntity = Coach.class,fetch=FetchType.LAZY)
    @JoinColumn(name="employee_id")//加入一列作为外键
    @Expose
    private Coach coach;

    @ManyToMany(targetEntity = Customer.class,fetch = FetchType.LAZY)
    @JoinTable(name = "date_course_customer",joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customer> customerList = new ArrayList<Customer>();

    public Course() {
    }

    public Course(String name, Coach coach, List<Customer> customerList) {
        this.name = name;
        this.coach = coach;
        this.customerList = customerList;
    }

    public void setId(int id) {
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

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Coach getCoach(){
        return this.coach;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Customer> getCustomerList() {
        return this.customerList;
    }

}

package com.tw.core.entity;

import com.google.gson.annotations.Expose;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vivi on 7/16/15.
 */
@Service
@Entity
@Table(name = "date_course_customer")
public class DateRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Expose
    private int id;

    @Column(name = "date")
    @Expose
    private Date date;

    @OneToOne(targetEntity = Course.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    @Expose
    private Course course;

    @OneToOne(targetEntity = Customer.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @Expose
    private Customer customer;

    public void setDateRelation(Date date,Course course,Customer customer) {
        this.date = date;
        this.course = course;
        this.customer = customer;
    }

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

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse(){
        return this.course;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer(){
        return this.customer;
    }

}

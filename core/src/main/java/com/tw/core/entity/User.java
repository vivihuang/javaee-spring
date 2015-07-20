package com.tw.core.entity;

import org.springframework.stereotype.Service;

import javax.persistence.*;

/**
 * Created by Vivi on 7/8/15.
 */
@Service
@Entity
@Table(name = "user")
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public User() {
    }

    public User(String name,String password,Employee employee) {
        this.name = name;
        this.password = password;
        this.employee = employee;
    }

    public User(int id,String user_name,String password,Employee employee) {
        this.id = id;
        this.name = user_name;
        this.password = password;
        this.employee = employee;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void setEmployee (Employee employee){
        this.employee = employee;
    }

    public Employee getEmployee(){
        return this.employee;
    }

}
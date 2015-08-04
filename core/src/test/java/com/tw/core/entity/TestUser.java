package com.tw.core.entity;

import com.google.gson.annotations.Expose;
import org.springframework.stereotype.Service;

import javax.persistence.*;

/**
 * Created by Vivi on 7/8/15.
 */
@Service
@Entity
@Table(name = "user")
public class TestUser {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Expose
    private int id;

    @Column(name = "user_name")
    @Expose
    private String name;

    @Column(name = "password")
    @Expose
    private String password;

    @OneToOne(targetEntity = TestEmployee.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    @Expose
    private TestEmployee employee;

    public TestUser() {
    }

    public TestUser(String name, String password, TestEmployee employee) {
        this.name = name;
        this.password = password;
        this.employee = employee;
    }

    public TestUser(int id, String user_name, String password, TestEmployee employee) {
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

    public void setEmployee (TestEmployee employee){
        this.employee = employee;
    }

    public TestEmployee getEmployee(){
        return this.employee;
    }

}

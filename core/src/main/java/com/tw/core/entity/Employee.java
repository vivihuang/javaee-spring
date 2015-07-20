package com.tw.core.entity;

import org.springframework.stereotype.Service;

import javax.persistence.*;

/**
 * Created by Vivi on 7/16/15.
 */
@Service
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "role")
    private String role;

    public void setId(int id) {this.id = id;}

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setRole(String role){
        this.role= role;
    }

    public String getRole(){
        return this.role;
    }
}
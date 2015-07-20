package com.tw.core.entity;

import org.springframework.stereotype.Service;

import javax.persistence.*;
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
    private int id;

    @Column(name = "course_name")
    private String name;

    @ManyToOne(targetEntity = Coach.class,fetch=FetchType.LAZY)
    @JoinColumn(name="employee_id")//加入一列作为外键
    private Coach coach;

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

}
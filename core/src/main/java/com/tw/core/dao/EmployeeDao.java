package com.tw.core.dao;

import com.tw.core.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vivi on 7/18/15.
 */
@Repository
@Transactional
public class EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private Employee employee;

    public Employee addEmployee(String name,String role) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println(employee.getId()+"!!!!!!!!!!!!!!!!!!!!!");
        employee.setId(0);
        employee.setName(name);
        employee.setRole(role);
        session.save(employee);
        return employee;
    }

    public void updateEmployee(Employee employee,String name,String role){
        employee.setName(name);
        employee.setRole(role);
        Session session = sessionFactory.getCurrentSession();
        session.update(employee);
    }
}

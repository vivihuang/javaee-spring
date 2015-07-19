package com.tw.core.dao;

import com.tw.core.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vivi on 7/18/15.
 */
@Service
public class EmployeeDao {

    @Autowired
    private Employee employee;

    private Configuration cfg = new Configuration().configure();
    private SessionFactory factory = cfg.buildSessionFactory();
    private List<Employee> employeeList = new ArrayList<Employee>();

    public Employee addEmployee(String name,String role) {
        Session session = null;
        employee.setName(name);
        employee.setRole(role);
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }
        return employee;
    }

    public void updateEmployee(Employee employee,String name,String role){
        employee.setName(name);
        employee.setRole(role);
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }
    }

}

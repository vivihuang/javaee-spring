package com.tw.core.dao;

import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vivi on 7/9/15.
 */
@Repository
@Transactional
//@EnableTransactionManagement
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private User user;
    @Autowired
    private EmployeeDao employeeDao;
    private List<User> userList = new ArrayList<User>();

    public User getUserById(int userId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("select * from user WHERE id="+userId).addEntity(User.class);
        userList = query.list();
        user = userList.get(0);
        return user;
    }

    public List<User> getUsers() {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * from user";
        userList = session.createSQLQuery(sql).addEntity(User.class).list();
        return userList;
    }


    public void addUser(String name,String password,Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        user.setName(name);
        user.setPassword(password);
        user.setEmployee(employee);
        session.save(user);
    }

    public void deleteUser(int userId){
        Session session = sessionFactory.getCurrentSession();
        user = getUserById(userId);
        user.setEmployee(null);
        session.delete(user);
    }

    public void updateUser(User user,String name,String password){
        user.setName(name);
        user.setPassword(password);
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    public String getUserPassword(String userName){
        List<User> userList = getUsers();
        for (int i=0;i<userList.size();i++) {
            user = userList.get(i);
            if (userName.equals(user.getName())) {
                return user.getPassword();
            }
        }
        return null;
    }

    public List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<Employee>();
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM employee";
        employeeList = session.createSQLQuery(sql).addEntity(Employee.class).list();
        return employeeList;
    }

    public void updateAngularUser(int id,String name,String role){
        user = getUserById(id);
        user.setName(name);
        employeeDao.updateEmployee(user.getEmployee(), name, role);
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    public User addAngularUser(String name,String password,Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        user.setName(name);
        user.setPassword(password);
        user.setEmployee(employee);
        session.save(user);
        return getUserByEmployee(employee);
    }

    public User getUserByEmployee(Employee employee){
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM user WHERE employee_id="+employee.getId();
        userList = session.createSQLQuery(sql).addEntity(User.class).list();
        return userList.get(0);
    }
}

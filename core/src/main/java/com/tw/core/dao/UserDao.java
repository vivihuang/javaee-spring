package com.tw.core.dao;

import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vivi on 7/9/15.
 */
@Service
public class UserDao {

    @Autowired
    private User user;
    @Autowired
    private EmployeeDao employeeDao;

    private Configuration cfg = new Configuration().configure();
    private SessionFactory factory = cfg.buildSessionFactory();
    private List<User> userList = new ArrayList<User>();

    public User getUserById(int userId){
        Session session = null;

        try {
            session = factory.openSession();
            Query query = session.createSQLQuery("select * from user WHERE id="+userId).addEntity(User.class);
            userList = query.list();
            user = userList.get(0);
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }
        return user;
    }

    public List<User> getUsers() {
        Session session = null;
        try {
            session = factory.openSession();
            String sql = "SELECT * from user";
            userList = session.createSQLQuery(sql).addEntity(User.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }
        return userList;
    }


    public void addUser(String name,String password,Employee employee) {
        Session session = null;
        user.setName(name);
        user.setPassword(password);
        user.setEmployee(employee);
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }
    }

    public void deleteUser(int userId){
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();

            user.setId(userId);
            user.setEmployee(null);
            session.delete(user);
            session.getTransaction().commit();
        }catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }

    }

    public void updateUser(User user,String name,String password){
        user.setName(name);
        user.setPassword(password);
        Session session = null;

        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        }catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }
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
        Session session = null;

        try {
            session = factory.openSession();
            String sql = "SELECT * FROM employee";
            employeeList = session.createSQLQuery(sql).addEntity(Employee.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeList;
    }

    public void updateAngularUser(int id,String name,String role){
        user = getUserById(id);
        user.setName(name);
        employeeDao.updateEmployee(user.getEmployee(),name,role);
        Session session = null;

        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        }catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            session.close();
        }
    }
}

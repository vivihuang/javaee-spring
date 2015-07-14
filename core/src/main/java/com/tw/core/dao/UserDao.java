package com.tw.core.dao;

import com.tw.core.user.User;
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

    private Configuration cfg = new Configuration().configure();
    private SessionFactory factory = cfg.buildSessionFactory();

    public void createUser(){
        List<User> userList = getUsers();
        for(int i=userList.size()-1;i>=0;i--) {
            deleteUser(userList.get(i).getId());
        }
        user.setName("张三");
        user.setSex("男");
        user.setEmail("zhangsan@gmail.com");
        user.setAge(30);
        addUser(user);
        user.setName("李四");
        user.setSex("男");
        user.setEmail("lisi@gmail.com");
        user.setAge(40);
        addUser(user);
    }

    public User getUserById(int userId){
        List<User> userList = new ArrayList<User>();
        //User user = new User();
        Session session = null;

        try {
            session = factory.openSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("select * from people WHERE id="+userId).addEntity(User.class);
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
        List<User> userList = new ArrayList<User>();

        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("select * from people").addEntity(User.class);
            userList = query.list();
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
        return userList;
    }


    public void addUser(User user) {

        Session session = null;

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

        //factory.close();
    }

    public void deleteUser(int userId){
        Session session = null;
        User user = new User();

        try {

            session = factory.openSession();
            session.beginTransaction();

            user.setId(userId);
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

    public void updateUser(User user){
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
}

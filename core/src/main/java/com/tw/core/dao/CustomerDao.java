package com.tw.core.dao;

import com.tw.core.entity.Coach;
import com.tw.core.entity.Course;
import com.tw.core.entity.Customer;
import com.tw.core.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vivi on 7/17/15.
 */
@Service
public class CustomerDao {

    @Autowired
    private Customer customer;

    @Autowired
    private CoachDao coachDao;

    private Configuration cfg = new Configuration().configure();
    private SessionFactory factory = cfg.buildSessionFactory();
    private List<Customer> customerList = new ArrayList<Customer>();

    public Customer getCustomerById(int id) {
        Session session = null;
        try {
            session = factory.openSession();
            String sql = "SELECT * from customer WHERE id="+id;
            customerList = session.createSQLQuery(sql).addEntity(Customer.class).list();
            customer = customerList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }
        return customer;
    }

    public List<Customer> getCustomers(){
        Session session = null;
        try {
            session = factory.openSession();
            String sql = "SELECT * from customer";
            customerList = session.createSQLQuery(sql).addEntity(Customer.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }
        return customerList;
    }

    public void addCustomer(String customerName,String coachId){
        Session session = null;
        if (coachId=="null") {
            customer.setCoach(null);
        }
        else {
            customer.setCoach(coachDao.getCoachById(Integer.parseInt(coachId)));
        }
        customer.setName(customerName);

        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(customer);
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

    public void updateCustomer(String customerId,String customerName,String coachId) {
        Session session = null;
        customer = getCustomerById(Integer.parseInt(customerId));
        customer.setName(customerName);
        customer.setCoach(coachDao.getCoachById(Integer.parseInt(coachId)));

        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(customer);
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

    public void deleteCustomer(String customerId) {
        Session session = null;

        try {
            session = factory.openSession();
            session.beginTransaction();

            customer.setId(Integer.parseInt(customerId));
            session.delete(customer);
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

package com.tw.core.dao;

import com.tw.core.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vivi on 7/17/15.
 */
@Repository
@Transactional
public class CustomerDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private Customer customer;
    @Autowired
    private CoachDao coachDao;

    private List<Customer> customerList = new ArrayList<Customer>();

    public Customer getCustomerById(int id) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * from customer WHERE id="+id;
        customerList = session.createSQLQuery(sql).addEntity(Customer.class).list();
        customer = customerList.get(0);
        return customer;
    }

    public List<Customer> getCustomers(){
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * from customer";
        customerList = session.createSQLQuery(sql).addEntity(Customer.class).list();
        return customerList;
    }

    public void addCustomer(String customerName,String coachId){
        Session session = sessionFactory.getCurrentSession();
        if (coachId=="null") {
            customer.setCoach(null);
        }
        else {
            customer.setCoach(coachDao.getCoachById(Integer.parseInt(coachId)));
        }
        customer.setName(customerName);

        session.save(customer);
    }

    public void updateCustomer(String customerId,String customerName,String coachId) {
        customer = getCustomerById(Integer.parseInt(customerId));
        customer.setName(customerName);
        customer.setCoach(coachDao.getCoachById(Integer.parseInt(coachId)));

        Session session = sessionFactory.getCurrentSession();
        session.update(customer);
    }

    public void deleteCustomer(String customerId) {
        Session session = sessionFactory.getCurrentSession();
        customer.setId(Integer.parseInt(customerId));
        session.delete(customer);
    }

}

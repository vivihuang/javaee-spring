package com.tw.core.service;

import com.tw.core.dao.CustomerDao;
import com.tw.core.dao.DateRelationDao;
import com.tw.core.entity.Course;
import com.tw.core.entity.Customer;
import com.tw.core.entity.DateRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Vivi on 7/19/15.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private Customer customer;

    @Autowired
    private DateRelationDao dateRelationDao;

    public void editCustomer(HttpServletRequest request) {
        String customerId = request.getParameter("id");
        String customerName = request.getParameter("name");
        String coachId = request.getParameter("coach_id");

        if (customerId == null || customerId.isEmpty()) {
            customerDao.addCustomer(customerName,coachId);
        }
        else {
            customerDao.updateCustomer(customerId,customerName,coachId);
        }
    }

    public List<DateRelation> getPersonalCourses(String customerId){
        return dateRelationDao.getPersonalCourses(customerId);
    }
}

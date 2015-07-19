package com.tw.core.service;

import com.tw.core.dao.CustomerDao;
import com.tw.core.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vivi on 7/19/15.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private Customer customer;

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
}

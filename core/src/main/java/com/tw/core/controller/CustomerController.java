package com.tw.core.controller;

import com.tw.core.dao.CoachDao;
import com.tw.core.dao.CustomerDao;
import com.tw.core.entity.Customer;
import com.tw.core.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vivi on 7/18/15.
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Customer customer;
    @Autowired
    private CoachDao coachDao;

    private ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showCustomerPage(){
        modelAndView.setViewName("customer");
        modelAndView.addObject("customerList",customerDao.getCustomers());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView editCustomer(HttpServletRequest request){
        customerService.editCustomer(request);
        modelAndView.setViewName("redirect:/customer");
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView addCustomer() {
        modelAndView.setViewName("modify_customer");
        modelAndView.addObject("coachList", coachDao.getCoaches());
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public ModelAndView updateCustomer(@PathVariable("id")String customerId){
        customer = customerDao.getCustomerById(Integer.parseInt(customerId));
        modelAndView.setViewName("modify_customer");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("coachList",coachDao.getCoaches());
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public ModelAndView deleteCustomer(@PathVariable("id")String customerId) {
        customer = customerDao.getCustomerById(Integer.parseInt(customerId));
        customerDao.deleteCustomer(customerId);
        modelAndView.setViewName("redirect:/customer");
        return modelAndView;
    }

    @RequestMapping(value = "/courses/{id}",method = RequestMethod.GET)
    public ModelAndView showPersonalCourses(@PathVariable("id")String customerId){
        modelAndView.setViewName("redirect:/customer");
        modelAndView.addObject("personalCourseList",customerService.getPersonalCourses(customerId));
        return modelAndView;
    }
}

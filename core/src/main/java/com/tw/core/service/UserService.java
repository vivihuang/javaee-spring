package com.tw.core.service;
import com.tw.core.dao.*;
import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vivi on 7/13/15.
 */
@Service
public class UserService {

    @Autowired
    private CookieService cookieService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private User user;
    @Autowired
    private Employee employee;
    @Autowired
    private EmployeeDao employeeDao;

    public void editUser(HttpServletRequest request) {
        String userId = request.getParameter("id");
        String userRole = request.getParameter("role");
        String userName = request.getParameter("name");
        String userPassword = request.getParameter("password");

        if (userId == null || userId.isEmpty()) {
            employee = employeeDao.addEmployee(userName,userRole);
            userDao.addUser(userName,userPassword,employee);
        } else {
            user = userDao.getUserById(Integer.parseInt(userId));
            employeeDao.updateEmployee(user.getEmployee(), userName, userRole);
            userDao.updateUser(user,userName,userPassword);
        }
    }

}

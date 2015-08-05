package com.tw.core.daoTest;

import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import com.tw.core.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
@Transactional
@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration("classpath:web.xml")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private User user;

    @Test
    @Rollback(true)
    public void test(){
        Assert.assertEquals("a","a");
    }

    @Test
    @Rollback(true)
    public void addUserTest(){
        Employee employee = new Employee("vivi","hr");
        user = userDao.addAngularUser("vivi", "admin", employee);
        Assert.assertNotNull("新增的员工ID为null", user.getId());
    }
}

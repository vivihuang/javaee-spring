package com.tw.core.controller;

import com.tw.core.User;
import com.tw.core.UserDao;
import java.io.*;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    UserDao userDao = new UserDao();
    Map<String,Object> data = new HashMap<String,Object>();

    @RequestMapping("/")
    public ModelAndView indexPage(){
        userDao.createUser();
        data.put("userList", userDao.getUsers());
        return new ModelAndView("index",data);
    }

    @RequestMapping("/user")
    public ModelAndView userPage(){
        return new ModelAndView("user");
    }

    @RequestMapping("/delete")
    public ModelAndView deleteUser(@RequestParam(value = "userId")String value){
        int userId = Integer.parseInt(value);
        userDao.deleteUser(userId);
        data.put("userList", userDao.getUsers());
        return new ModelAndView("index",data);
    }

    @RequestMapping("/add")
    public ModelAndView addUser(@RequestParam(value = "id")String userId,@RequestParam(value = "name")String userName,
                                   @RequestParam(value = "sex")String userSex, @RequestParam(value = "email")String userEmail,
                                   @RequestParam(value = "age")String userAge){
        System.out.println(userId);
        User user = new User();
        user.setName(userName);
        user.setSex(userSex);
        user.setEmail(userEmail);
        user.setAge(Integer.parseInt(userAge));

        if (userId == null || userId.isEmpty()){
            userDao.addUser(user);
        }
        else{
            user.setId(Integer.parseInt(userId));
            userDao.updateUser(user);
        }
        data.put("userList", userDao.getUsers());
        return new ModelAndView("index",data);
    }

    @RequestMapping("/update")
    public ModelAndView updateUser(@RequestParam(value = "userId")String id){
        int userId = Integer.parseInt(id);
        User user = userDao.getUserById(userId);
        data.put("user",user);
        return new ModelAndView("user",data);
    }
}

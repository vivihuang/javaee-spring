package com.tw.core.controller.angular;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.core.dao.*;
import com.tw.core.entity.*;
import com.tw.core.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/angular/user")
public class AngularUserController {
    @Autowired
    UserDao userDao;
    @Autowired
    EmployeeDao employeeDao;

    private Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation() //不导出实体中没有用@Expose注解的属性
            .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
            .serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")//时间转化为特定格式
//                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效.
            .setPrettyPrinting() //对json结果格式化.
            .setVersion(1.0)    //有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.
                    //@Since(版本号)能完美地实现这个功能.还的字段可能,随着版本的升级而删除,那么
                    //@Until(版本号)也能实现这个功能,GsonBuilder.setVersion(double)方法需要调用.
            .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
            .create();

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getUsers(){
        return gson.toJson(userDao.getUsers());
    }

    @RequestMapping(method = RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addUser(@RequestParam String name,
                          @RequestParam String password,
                          @RequestParam String role){
        Employee employee = employeeDao.addEmployee(name,role);
        userDao.addUser(name,password,employee);
        getUsers();
    }

    @RequestMapping(method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void deleteUser(@RequestParam int id){
        userDao.deleteUser(id);
        getUsers();
    }

    @RequestMapping(method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void updateUser(@RequestParam int id,
                           @RequestParam String name,
                           @RequestParam String role){
        userDao.updateAngularUser(id,name,role);
        getUsers();
    }

}

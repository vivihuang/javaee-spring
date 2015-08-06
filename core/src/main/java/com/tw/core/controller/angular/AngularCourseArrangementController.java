package com.tw.core.controller.angular;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.core.dao.DateRelationDao;
import com.tw.core.entity.DateRelation;
import com.tw.core.util.HibernateProxyTypeAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vivi on 7/31/15.
 */
@Controller
@ResponseBody
@RequestMapping(value = "/angular/courseArrangement")
public class AngularCourseArrangementController {
    @Autowired
    private DateRelationDao dateRelationDao;
    private List<DateRelation> dateRelationList = new ArrayList<DateRelation>();

    private Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation() //不导出实体中没有用@Expose注解的属性
            .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
            .serializeNulls().setDateFormat("yyyy-MM-dd")//时间转化为特定格式
//                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效.
            .setPrettyPrinting() //对json结果格式化.
            .setVersion(1.0)    //有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.
                    //@Since(版本号)能完美地实现这个功能.还的字段可能,随着版本的升级而删除,那么
                    //@Until(版本号)也能实现这个功能,GsonBuilder.setVersion(double)方法需要调用.
            .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
            .create();

    @RequestMapping(method = RequestMethod.GET)
    public String getCourseArrangementList(){
        dateRelationList = dateRelationDao.getCourseArrangement();
        return gson.toJson(dateRelationList);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteCourseArrangementList(@RequestParam String id){
        dateRelationDao.deleteCourseArrangement(Integer.parseInt(id));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String updateCourseArrangement(@RequestParam int id,String date,String courseId,String customerId){
        if (date!=null) {
            dateRelationDao.updateCourseArrangement(id,date,courseId,customerId);
        }
        return gson.toJson(dateRelationDao.getCourseArrangementById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addCourseArrangement(@RequestParam String date,String courseId,String customerId){
        return gson.toJson(dateRelationDao.addAngularCourseArrangementByDate(date,courseId,customerId));
    }
}

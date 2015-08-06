//package com.tw.core.util;
//
///**
// * Created by Vivi on 8/6/15.
// */
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//
//public class HibernateUtil {
//    private static final SessionFactory sessionFactory;
//
//    static {
//        Configuration configuration = new Configuration();
//        configuration.configure("core/src/main/resources/applicationContext.xml");
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties()).build();
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//    }
//
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//}

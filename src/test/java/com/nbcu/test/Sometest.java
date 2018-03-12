package com.nbcu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utils.mongo.MongoUtils;

public class Sometest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        MongoUtils utils = context.getBean("mongoUtils", MongoUtils.class);

    }
}

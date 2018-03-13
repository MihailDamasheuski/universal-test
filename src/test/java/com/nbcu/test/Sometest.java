package com.nbcu.test;

import com.google.gson.JsonObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utils.mongo.MongoUtils;
import utils.splunk.SplunkUtils;

public class Sometest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        MongoUtils mongoUtils = context.getBean("mongoUtils", MongoUtils.class);
        SplunkUtils splunkUtils = context.getBean("splunk", SplunkUtils.class);
        JsonObject article = mongoUtils.getObjectByGuid("tdnaat78091_jyhuamihz50");
        JsonObject scm = splunkUtils.getScmObjectFromSplunk("tdtxtestSplunkService");

    }

}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApplication {

    public static void main(String[] args) {
        // xml加载
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student s1 = (Student) appCtx.getBean("s1");
        Student s2 = (Student) appCtx.getBean("s2");
        System.out.println(s1.toString());
        System.out.println(s2.toString());

        // annotation 加载
        ApplicationContext annoAppCtx = new AnnotationConfigApplicationContext("com.example.demo");
        Student s3 = (Student) annoAppCtx.getBean("s3");
        System.out.println(s3.toString());
    }
}

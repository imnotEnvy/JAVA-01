package com.javabootcamp.lesson10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Lesson10Application {

    public static void main(String[] args) {
        ApplicationContext appCtx = SpringApplication.run(Lesson10Application.class, args);
        Student s1 = (Student) appCtx.getBean("s1");
        System.out.println(s1);
    }

}

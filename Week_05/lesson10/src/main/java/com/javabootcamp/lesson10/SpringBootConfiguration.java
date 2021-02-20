package com.javabootcamp.lesson10;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@EnableConfigurationProperties(StudentConfig.class)
public class SpringBootConfiguration {
    @Resource
    private StudentConfig studentConfig;

    @Bean("s1")
    public Student buildStudent() {
        return new Student(studentConfig.getId(), studentConfig.getName());
    }

}

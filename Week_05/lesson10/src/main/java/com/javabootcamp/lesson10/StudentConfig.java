package com.javabootcamp.lesson10;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "student")
public class StudentConfig {
    private String id;
    private String name;
}

package com.example.demo;

import lombok.Data;

@Data
public class Student {
    private String name;
    private String id;

    public Student() {

    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return String.format("Student(%s): %s", this.id, this.name);
    }
}

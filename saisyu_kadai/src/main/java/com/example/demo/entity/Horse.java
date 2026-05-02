package com.example.demo.entity;

import lombok.Data;

@Data
public class Horse {

    private Integer id;
    private Integer frameNumber;
    private String horseName;
    private String jockeyName;
    private String sex;
    private Integer age;
    private Integer popularity;

    private String fatherName;
    private String motherName;
    private String motherFatherName;
    private String ownerName;
    private Integer horseNumber;
}
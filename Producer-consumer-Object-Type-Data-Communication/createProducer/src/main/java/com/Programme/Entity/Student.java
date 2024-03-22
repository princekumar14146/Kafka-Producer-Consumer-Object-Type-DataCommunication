package com.Programme.Entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    private static Long serialVersionUID=123456789L;

    private Integer studentId;
    private String studentFirstName;
    private String studentLastName;
    private String course;
    private Long studentPhoneNo;



}

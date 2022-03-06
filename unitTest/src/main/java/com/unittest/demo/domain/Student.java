package com.unittest.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    private int id;
    private int age;
    private String name;
}

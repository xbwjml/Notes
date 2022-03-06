package com.unittest.demo.dao;

import com.unittest.demo.domain.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentDao {

    public Student getById(int id){
        return new Student(1, 20, "tom");
    }
}

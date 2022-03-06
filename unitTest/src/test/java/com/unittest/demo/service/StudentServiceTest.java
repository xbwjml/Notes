package com.unittest.demo.service;

import com.unittest.demo.DemoApplication;
import com.unittest.demo.domain.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest(classes = DemoApplication.class)
class StudentServiceTest {

    @Autowired
    private StudentService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getById() {
        Student stu = service.getById(1);
        Assert.notNull(stu);
    }
}
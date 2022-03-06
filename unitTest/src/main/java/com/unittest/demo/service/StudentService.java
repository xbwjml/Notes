package com.unittest.demo.service;

import com.unittest.demo.dao.StudentDao;
import com.unittest.demo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Student getById(int id){
        return studentDao.getById(id);
    }
}

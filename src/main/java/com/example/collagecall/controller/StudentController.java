package com.example.collagecall.controller;

import com.example.collagecall.dao.StudentDao;
import com.example.collagecall.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentDao studentDao;
    @GetMapping("/test")
    public List<Student> test(){
        List<Student> studentList=studentDao.selectList(null);
        return studentList;
    }




}

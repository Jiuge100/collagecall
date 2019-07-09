package com.example.collagecall.serviceimpl;

import com.example.collagecall.dao.StudentDao;
import com.example.collagecall.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
}

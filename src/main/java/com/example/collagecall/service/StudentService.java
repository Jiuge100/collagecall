package com.example.collagecall.service;

import com.example.collagecall.entity.Student;

import java.util.List;

public interface StudentService {
    /**
     * 增加用户
     * @param student
     */
    void insterstudent(Student student);

    /**
     * 查询所有学生
     * @return
     */
    List<Student> allstudent();

    /**
     * 查询用户的喜欢帖子数，收藏商品数，足迹
     * @return
     */
    String threenumber(String openid);
}

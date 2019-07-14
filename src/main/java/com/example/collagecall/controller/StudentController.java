package com.example.collagecall.controller;

import com.example.collagecall.dao.StudentDao;
import com.example.collagecall.entity.Student;
import com.example.collagecall.service.StudentService;
import com.example.collagecall.utils.CollegeJSONResult;
import com.example.collagecall.utils.GetOpenid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    /**
     * 增加用户
     * @param code
     * @param phone
     * @param name
     * @param sex
     * @param sno
     * @param school
     * @param time
     * @return
     */
    @GetMapping("/addstudent")
    public CollegeJSONResult addstudent(@RequestParam("code") String code, String phone, String name, String sex, String sno, String school, String time){
        String openid= GetOpenid.getOpenId(code);
        Student student = new Student();
        student.setOpenid(openid);
        student.setPhone(phone);
        student.setName(name);
        student.setSex(sex);
        student.setSno(sno);
        student.setSchool(school);
        student.setTime(time);
        studentService.insterstudent(student);
        return CollegeJSONResult.ok(student);
    }

//    @GetMapping("/wxlogin")
//    public CollegeJSONResult wxlogin(String userid){
//        System.out.println(userid);
//        return CollegeJSONResult.ok();
//    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/test")
    public CollegeJSONResult test(){
        List<Student> studentList=studentService.allstudent();
        return CollegeJSONResult.ok(studentList);
    }

    @GetMapping("/getnumber")
    public String threenumber(String openid){
        return studentService.threenumber(openid);
    }







}

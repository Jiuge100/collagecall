package com.example.collagecall.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import com.example.collagecall.dao.CollectDao;
import com.example.collagecall.dao.FootmarkDao;
import com.example.collagecall.dao.LoveDao;
import com.example.collagecall.dao.StudentDao;
import com.example.collagecall.entity.Collect;
import com.example.collagecall.entity.Footmark;
import com.example.collagecall.entity.Love;
import com.example.collagecall.entity.Student;
import com.example.collagecall.service.StudentService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.util.Length;

import java.util.HashMap;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    CollectDao collectDao;
    @Autowired
    FootmarkDao footmarkDao;
    @Autowired
    LoveDao loveDao;
    @Autowired
    private Sid sid;

    /**
     * 增加用户
     * @param student
     */
    @Override
    public void insterstudent(Student student) {
        String id=sid.nextShort();
        student.setStudentid(id);
        studentDao.insert(student);
    }

    /**
     * 查询所有学生
     * @return
     */
    @Override
    public List<Student> allstudent() {
        return studentDao.selectList(null);
    }

    /**
     * 查询用户的喜欢帖子数，收藏商品数，足迹
     * @return
     */
    @Override
    public String threenumber(String openid) {
        int number1,number2,number3;
        HashMap map = new HashMap();
        map.put("openid",openid);
        if(loveDao.selectByMap(map)==null){
            number1 = 0;
        }else {
            List<Love> list1 = loveDao.selectByMap(map);
            number1 = list1.size();
        }
        if (collectDao.selectByMap(map)==null){
            number2 = 0;
        }else {
            List<Collect> list2 = collectDao.selectByMap(map);
            number2 = list2.size();
        }
        if (footmarkDao.selectByMap(map)==null){
            number3 = 0;
        }else {
            List<Footmark> list3 = footmarkDao.selectByMap(map);
            number3 = list3.size();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("number1",number1);
        jsonObject.put("number2",number2);
        jsonObject.put("number3",number3);
        return jsonObject.toString();
    }


}

package com.example.collagecall.controller;

import com.example.collagecall.dao.GoodsDao;
import com.example.collagecall.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    GoodsDao goodsDao;
    @GetMapping("/allgoods")
    public List<Goods> allgoods(){
        List<Goods> list = goodsDao.selectList(null);
        return list;
    }
}

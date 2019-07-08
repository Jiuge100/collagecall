package com.example.collagecall.controller;

import com.example.collagecall.dao.OrderDao;

import com.example.collagecall.entity.Orders;
import com.example.collagecall.utils.CollegeJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OrderController {
    @Autowired
    OrderDao orderDao;

    @GetMapping("/allorder")
    public CollegeJSONResult allorder(){
        List<Orders> list = orderDao.selectList(null);
        return CollegeJSONResult.ok(list);
    }
    @GetMapping("/addorder")
    public void addorder(@RequestParam("openid") String openid,@RequestParam("total") int total,
                         @RequestParam("sum") float sum,@RequestParam("ordertime") String ordertime){
        Orders order = new Orders();
        order.setOpenid(openid);
        order.setTotal(total);
        order.setSum(sum);
        order.setOrdertime(ordertime);
        orderDao.insert(order);
    }

}

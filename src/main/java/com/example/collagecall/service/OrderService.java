package com.example.collagecall.service;

import com.example.collagecall.entity.Orders;

import java.util.List;

public interface OrderService {
    /**
     * 增加订单
     * @param order
     */
    void insterorder(Orders order);

    /**
     * 查询所有订单
     * @return
     */
    List<Orders> allorder();

    /**
     * 通过状态和用户openid查询订单
     * @return
     */
    List<Orders> orderbyopenidandstates (String openid, String states);

    /**
     * （通过用户openid和订单id查到订单）精确更改状态
     * @param openid
     * @param orderid
     * @param states
     */
    void updateorder(String openid,String orderid,String states);
}

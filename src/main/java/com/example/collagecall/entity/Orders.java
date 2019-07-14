package com.example.collagecall.entity;
import lombok.Data;

@Data
/**
 * 订单表实例化
 */
public class Orders {
    String orderid;
    String openid;
    int total;//总件（份）数
    float sum;//总价
    String ordertime;
    String states;
}
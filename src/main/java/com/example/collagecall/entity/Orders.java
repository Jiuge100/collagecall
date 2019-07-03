package com.example.collagecall.entity;
import lombok.Data;

@Data
public class Orders {
    int orderid;
    String openid;
    int total;//总件（份）数
    float sum;//总价
    String ordertime;
}
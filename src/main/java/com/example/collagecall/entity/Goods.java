package com.example.collagecall.entity;

import lombok.Data;

@Data
/*
将商品实例化
 */
public class Goods {
    int goodid;
    String name;
    String introduce;
    String type;
    String image;
    float price;
    int stock;
    int number;
    String state;
    String selecta;
    int num;
}

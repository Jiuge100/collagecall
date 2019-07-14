package com.example.collagecall.entity;
import lombok.Data;

@Data
/**
 * 将订单里的商品散装实例化
 */
public class Ordergood {
    String ordergoodid;
    String orderid;
    String goodid;
    int sum;
}

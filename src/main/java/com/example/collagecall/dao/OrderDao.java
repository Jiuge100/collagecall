package com.example.collagecall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.collagecall.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao extends BaseMapper<Orders> {
}

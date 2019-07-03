package com.example.collagecall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.collagecall.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsDao extends BaseMapper<Goods> {
}

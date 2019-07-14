package com.example.collagecall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.collagecall.entity.Card;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CardDao extends BaseMapper<Card> {
}

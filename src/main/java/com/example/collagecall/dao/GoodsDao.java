package com.example.collagecall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.collagecall.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsDao extends BaseMapper<Goods> {
    public List<String> getseacherwords();
}

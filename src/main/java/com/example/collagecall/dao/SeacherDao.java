package com.example.collagecall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.collagecall.entity.Search;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SeacherDao extends BaseMapper<Search> {
    public List<String> getHotwords();
}

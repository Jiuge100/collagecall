package com.example.collagecall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.collagecall.entity.Goods;

import java.util.List;

public interface GoodService {
    /**
     * @Description: 添加商品
     */
    void instergoods(Goods goods);

    /**
     * @Description: 分页查询商品列表
     */
    public IPage<Goods> getAllVideo(Goods goods,Integer issave,Integer page, Integer pagesize);

    /**
     * @Description: 获取热搜列表
     */
    public List<String> getHotwords();
}

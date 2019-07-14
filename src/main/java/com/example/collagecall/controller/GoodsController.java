package com.example.collagecall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.collagecall.dao.GoodsDao;
import com.example.collagecall.entity.Goods;
import com.example.collagecall.service.GoodService;
import com.example.collagecall.utils.CollegeJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    private GoodService goodService;

    /**
     * 分页显示所有商品
     * @param page
     * @param pagesize
     * @return
     */
    @GetMapping("/allgoods")
    public CollegeJSONResult allgoods(@RequestParam(value = "page",defaultValue ="1" ) Integer page,
                                      @RequestParam(value = "pagesize",defaultValue ="5")Integer pagesize){
        Page<Goods> goodsPage=new Page<>(page,pagesize);
        IPage<Goods> goodsIPage=goodsDao.selectPage(goodsPage,null);
        return CollegeJSONResult.ok(goodsIPage);
    }

    /**
     * 添加商品（暂时还少一个image）
     * @param name
     * @param introduce
     * @param type
     * @param price
     * @param stock
     * @param number
     * @param state
     * @param selected
     * @param num
     * @return
     */
    @GetMapping("/insgoods")
    public CollegeJSONResult insgoods(String name, String introduce, String type,
                                      float price, int stock, int number, String state, String selected, int num){
        Goods goods=new Goods();
        goods.setName(name);
        goods.setIntroduce(introduce);
        goods.setType(type);
        goods.setPrice(price);
        goods.setStock(stock);
        goods.setNum(num);
        goods.setNumber(number);
        goods.setState(state);
        goods.setSelected(selected);
        goodService.instergoods(goods);
        return CollegeJSONResult.ok(goods);
    }

    /**
     * 分页查找商品
     * @param goods
     * @param issave
     * @param page
     * @param pagesize
     * @return
     */
    @PostMapping("/goods")
    public CollegeJSONResult goods(Goods goods,Integer issave,
                                   @RequestParam(value = "page",defaultValue ="1" ) Integer page,
                                   @RequestParam(value = "pagesize",defaultValue ="5")Integer pagesize){
        IPage<Goods> goodsIPage=goodService.getAllVideo(goods,issave,page,pagesize);
        return CollegeJSONResult.ok(goodsIPage);
    }

    /**
     * 获取热搜词
     * @return
     */
    @GetMapping("/seachhot")
    public CollegeJSONResult seachhot(){
        return CollegeJSONResult.ok(goodService.getHotwords());
    }

    /**
     * 获取与搜索内容匹配的词
     * @return
     */
    @GetMapping("/seachname")
    public CollegeJSONResult seachname(){
        return CollegeJSONResult.ok(goodService.getseacherwords());
    }

    /**
     * 通过类型查找商品
     * @param type
     * @return
     */
    @GetMapping("/goodbytype")
    public CollegeJSONResult goodbytype(String type){
        return CollegeJSONResult.ok(goodService.goodbytype(type));
    }

}

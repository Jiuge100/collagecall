package com.example.collagecall.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.collagecall.dao.GoodsDao;
import com.example.collagecall.entity.Goods;
import com.example.collagecall.service.GoodService;
import com.example.collagecall.utils.CollegeJSONResult;
import com.example.collagecall.utils.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    private GoodService goodService;

    @GetMapping("/allgoods")
    public CollegeJSONResult allgoods(){
        List<Goods> list = goodsDao.selectList(null);
        return CollegeJSONResult.ok(list);
    }

    @GetMapping("/insgoods")
    public CollegeJSONResult insgoods(String name, String introduce, String type,
                                      float price, int stock, int number, String state, String selecta, int num){
        Goods goods=new Goods();
        goods.setName(name);
        goods.setIntroduce(introduce);
        goods.setType(type);
        goods.setPrice(price);
        goods.setStock(stock);
        goods.setNum(num);
        goods.setNumber(number);
        goods.setState(state);
        goods.setSelecta(selecta);
        goodService.instergoods(goods);
        return CollegeJSONResult.ok(goods);
    }

    @GetMapping("/goods")
    public CollegeJSONResult goods(Goods goods,Integer issave,
                                   @RequestParam(value = "page",defaultValue ="1" ) Integer page,
                                   @RequestParam(value = "pagesize",defaultValue ="5")Integer pagesize){
        IPage<Goods> goodsIPage=goodService.getAllVideo(goods,issave,page,pagesize);
        return CollegeJSONResult.ok(goodsIPage);
    }

    @GetMapping("/seachhot")
    public CollegeJSONResult seachhot(){
        return CollegeJSONResult.ok(goodService.getHotwords());
    }
}

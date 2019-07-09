package com.example.collagecall.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.collagecall.dao.GoodsDao;
import com.example.collagecall.dao.SeacherDao;
import com.example.collagecall.entity.Goods;
import com.example.collagecall.entity.Search;
import com.example.collagecall.service.GoodService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private SeacherDao seacherDao;
    @Autowired
    private Sid sid;


    @Override
    public void instergoods(Goods goods) {
        String id=sid.nextShort();
        goods.setGoodid(id);
        goodsDao.insert(goods);
    }


    public IPage<Goods> getAllVideo(Goods goods,Integer issave,Integer page, Integer pagesize) {
        String name=goods.getName();
        if ((issave!=null&&issave==1)){
            Search search=new Search();
            String id=sid.nextShort();
            search.setId(id);
            search.setContent(name);
            seacherDao.insert(search);
        }
        QueryWrapper<Goods> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name", name);
        Page<Goods> goodsPage=new Page<>(page,pagesize);
        IPage<Goods> goodsIPage=goodsDao.selectPage(goodsPage,queryWrapper);

        return goodsIPage;
    }

    @Override
    public List<String> getseacherwords() {
        return goodsDao.getseacherwords();
    }

    @Override
    public List<String> getHotwords() {
        return seacherDao.getHotwords();
    }
}

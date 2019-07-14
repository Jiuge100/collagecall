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

import java.util.HashMap;
import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private SeacherDao seacherDao;
    @Autowired
    private Sid sid;

    /**
     * 增加商品
     * @param goods
     */
    @Override
    public void instergoods(Goods goods) {
        String id=sid.nextShort();
        goods.setGoodid(id);
        goodsDao.insert(goods);
    }

    /**
     * 分页显示商品
     * @param goods
     * @param issave
     * @param page
     * @param pagesize
     * @return
     */
    @Override
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

    /**
     * 得到所有商品名字
     * @return
     */
    @Override
    public List<String> getseacherwords() {
        return goodsDao.getseacherwords();
    }


    /**
     * 得到已经排好序的热搜商品名字
     * @return
     */
    @Override
    public List<String> getHotwords() {
        return seacherDao.getHotwords();
    }

    /**
     * 通过类型查查找商品
     * @param type
     * @return
     */
    @Override
    public List<Goods> goodbytype(String type) {
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("type",type);
        return goodsDao.selectByMap(map);
    }

}

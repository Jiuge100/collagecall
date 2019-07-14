package com.example.collagecall.serviceimpl;

import com.example.collagecall.dao.OrderDao;
import com.example.collagecall.entity.Orders;
import com.example.collagecall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    /**
     * 增加订单
     * @param order
     */
    @Override
    public void insterorder(Orders order) {
        orderDao.insert(order);
    }

    /**
     * 查询所有订单
     * @return
     */
    @Override
    public List<Orders> allorder() {
        return orderDao.selectList(null);
    }

    @Override
    public List<Orders> orderbyopenidandstates(String openid, String states) {
        HashMap map = new HashMap();
        map.put("openid",openid);
        map.put("states",states);
        return orderDao.selectByMap(map);
    }

    /**
     * （通过用户openid和订单id查到订单）精确更改状态
     * @param openid
     * @param orderid
     * @param states
     */
    @Override
    public void updateorder(String openid, String orderid, String states) {
        orderDao.updatestate(openid,orderid,states);
    }


}

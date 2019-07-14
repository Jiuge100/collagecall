package com.example.collagecall.controller;

import com.example.collagecall.entity.Orders;
import com.example.collagecall.service.OrderService;
import com.example.collagecall.utils.CollegeJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    /**
     * 添加订单
     * @param openid
     * @param total
     * @param sum
     * @param ordertime
     */
    @GetMapping("/addorder")
    public void addorder(@RequestParam("openid") String openid,@RequestParam("total") int total,
                         @RequestParam("sum") float sum,@RequestParam("ordertime") String ordertime){
        Orders order = new Orders();
        order.setOpenid(openid);
        order.setTotal(total);
        order.setSum(sum);
        order.setOrdertime(ordertime);

        orderService.insterorder(order);
    }

    /**
     * 查询所有订单
     * @return
     */
    @GetMapping("/allorder")
    public CollegeJSONResult allorder(){
        List<Orders> list = orderService.allorder();
        return CollegeJSONResult.ok(list);
    }

    /**
     * 通过openid和状态查询订单
     * @param openid
     * @param states
     * @return
     */
    @GetMapping("/orderbyopenidandstates")
    public CollegeJSONResult orderbyopenidandstates(@RequestParam("openid") String openid,@RequestParam("states") String states){
        List<Orders> list = orderService.orderbyopenidandstates(openid,states);
        return CollegeJSONResult.ok(list);
    }

    /**
     * （通过用户openid和订单id查到订单）精确更改状态
     * @param openid
     * @param orderid
     * @param states
     */
    @GetMapping("/userchangestates")
    public void userchangestates(@RequestParam("openid") String openid,@RequestParam("orderid") String orderid,@RequestParam("states") String states){
        orderService.updateorder(openid, orderid, states);
    }


}

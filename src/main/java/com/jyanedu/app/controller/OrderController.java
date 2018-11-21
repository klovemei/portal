package com.jyanedu.app.controller;

import com.jyanedu.app.beans.Order;
import com.jyanedu.app.beans.Program;
import com.jyanedu.app.beans.User;
import com.jyanedu.app.dao.OrderDao;
import com.jyanedu.app.dao.ProgramDao;
import com.jyanedu.app.dao.UserDao;
import com.jyanedu.app.exception.DefException;
import com.jyanedu.app.module.GetOrderResp;
import com.jyanedu.app.module.OrderResp;
import com.jyanedu.app.module.PayResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liu_kai on 2018/3/1.
 */
@RestController
public class OrderController {
    @Autowired
    UserDao userDao;
    @Autowired
    ProgramDao programDao;
    @Autowired
    OrderDao orderDao;
    @RequestMapping(value = "/order")
    public OrderResp getOrder(String userId,String programIds) throws DefException {
        OrderResp resp = new OrderResp();
        if(userId==null||programIds==null){
            throw new DefException();
        }
        User user = userDao.getOne(userId);
        if(user==null)throw new DefException();
        String[] programIdList= programIds.split(",");
        List<Program> programs = programDao.findByIdIn(programIdList);
        if(programs == null || programs.size()<=0)throw new DefException();
        double totalCost = 0;
        for(Program program:programs){
            totalCost+=program.getMoney();
        }
        Order order = new Order();
        order.setOrderStatus(0);
        order.setPrograms(programs);
        order.setUser(user);
        order.setTotalCost(totalCost);
        orderDao.save(order);
        resp.setOrderId(order.getId());
        resp.setTotalCost(totalCost);
        return resp;
    }
    @RequestMapping(value = "/pay")
    public PayResp payOrder(String orderId,String payType) throws DefException {
        PayResp payResp = new PayResp();
        Order order = orderDao.getOne(orderId);
        if(order==null||order.getOrderStatus()>0)throw new DefException();
        order.setPayType(payType);
        order.setOrderStatus(1);
        orderDao.save(order);
        return payResp;
    }
    @RequestMapping(value = "getOrder")
    public GetOrderResp getOrder(String orderId)throws DefException{
        Order order = orderDao.getOne(orderId);
        if(order==null)throw new DefException();
        GetOrderResp getOrderResp = new GetOrderResp();
        getOrderResp.setOrder(order);
        return getOrderResp;
    }
}

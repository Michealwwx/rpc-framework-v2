package com.reign.service;

import com.reign.annotations.RpcService;
import com.reign.interfaces.OrderService;
import com.reign.model.Order;

import java.math.BigDecimal;

/**
 * @ClassName OrderServiceImpl
 * @Description 订单
 * @Author wuwenxiang
 * @Date 2019-09-20 22:58
 * @Version 1.0
 **/
@RpcService(OrderService.class)
public class OrderServiceImpl implements OrderService {
    @Override
    public Order getOrderInfo(String orderNo) {
        return new Order("iphone11",new BigDecimal(5499));
    }

    @Override
    public String createOrder(Order order) {
        return order.getOrderNo();
    }
}

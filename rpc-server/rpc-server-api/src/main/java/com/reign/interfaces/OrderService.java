package com.reign.interfaces;

import com.reign.model.Order;

/**
 * @ClassName OrderService
 * @Description 订单接口
 * @Author wuwenxiang
 * @Date 2019-09-20 22:58
 * @Version 1.0
 **/
public interface OrderService {
    Order getOrderInfo(String orderNo);
    String createOrder(Order order);
}

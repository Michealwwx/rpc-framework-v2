package com.reign;

import com.reign.interfaces.OrderService;
import com.reign.interfaces.UserService;
import com.reign.model.Order;
import com.reign.model.User;
import com.reign.proxy.RpcClientProxy;

import java.math.BigDecimal;

/**
 * @ClassName ClientMain
 * @Description 启动类
 * @Author wuwenxiang
 * @Date 2019-09-20 21:12
 * @Version 1.0
 **/
public class ClientMain {

    private static final String HOST = "localhost";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        RpcClientProxy rpcClientProxy = new RpcClientProxy();
//        UserService userService =  rpcClientProxy.getProxyObj(UserService.class, HOST, PORT);
//        String result = userService.sayHello("老王");
//        System.out.println(result);
//        User user = userService.addAge(new User("wuwx", 25));
//        System.out.println(user);
        OrderService orderService = rpcClientProxy.getProxyObj(OrderService.class,HOST,PORT);
        String orderNo= orderService.createOrder(new Order("小王买了个充气玩具",new BigDecimal(500)));
        System.out.println("orderNo"+orderNo);
        Order order = orderService.getOrderInfo("1");
        System.out.println(order);
    }

}

package com.reign.handler;

import com.reign.request.RpcRequest;
import com.reign.transport.RpcNetTransport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName RpcInvocationHandler
 * @Description 代理类
 * @Author wuwenxiang
 * @Date 2019-09-20 21:20
 * @Version 1.0
 **/
public class RpcInvocationHandler implements InvocationHandler {

    private String host;
    private int port;

    public RpcInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //组装请求发送给server
        RpcRequest rpcRequest = new RpcRequest(method.getDeclaringClass().getName(),method.getName(),args);
        System.out.println("请求信息："+rpcRequest);
        RpcNetTransport rpcNetTransport = new RpcNetTransport(host,port);
        Object o = rpcNetTransport.sendRequest(rpcRequest);
        return o;
    }
}

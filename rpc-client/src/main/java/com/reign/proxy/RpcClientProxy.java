package com.reign.proxy;

import com.reign.handler.RpcInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @ClassName RpcClientProxy
 * @Description 代理
 * @Author wuwenxiang
 * @Date 2019-09-20 21:18
 * @Version 1.0
 **/
public class RpcClientProxy {


    public <T> T getProxyObj(Class<T> clazz, String host, int port) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),new Class<?>[]{clazz}, new RpcInvocationHandler(host,port));
    }


}

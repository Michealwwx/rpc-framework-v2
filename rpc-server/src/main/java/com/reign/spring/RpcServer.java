package com.reign.spring;

import com.reign.annotations.RpcService;
import com.reign.handler.ProcessorHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName RpcServer
 * @Description 容器
 * @Author wuwenxiang
 * @Date 2019-09-20 22:36
 * @Version 1.0
 **/
@Component
public class RpcServer implements ApplicationContextAware, InitializingBean {
    private int port;
    private Map<String,Object> map = new HashMap<>();
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public RpcServer(int port) {
        this.port = port;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ServerSocket serverSocket = null;
        ObjectInputStream objectInputStream = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.submit(new ProcessorHandler(socket, map));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> serviceBeanMap = applicationContext.getBeansWithAnnotation(RpcService.class);
        if(!serviceBeanMap.isEmpty()){
            for(Object serviceBean : serviceBeanMap.values()){
                //拿到注解
                RpcService rpcService = serviceBean.getClass().getAnnotation(RpcService.class);
                //获取注解中的value（class）
                String serviceName = rpcService.value().getName();
                //存储beanName和已经被实例化的bean
                map.putIfAbsent(serviceName,serviceBean);
            }
        }
    }
}

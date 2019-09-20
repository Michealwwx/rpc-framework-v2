package com.reign.handler;

import com.reign.request.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

/**
 * @ClassName ProcessorHandler
 * @Description 请求处理类
 * @Author wuwenxiang
 * @Date 2019-09-20 20:46
 * @Version 1.0
 **/
public class ProcessorHandler implements Runnable {

    private Socket socket;

    private Map<String,Object>  handlerMap;

    public ProcessorHandler(Socket socket, Map<String,Object>  handlerMap) {
        this.socket = socket;
        this.handlerMap = handlerMap;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            //反序列化：
            RpcRequest request = (RpcRequest) objectInputStream.readObject();
            System.out.println("请求进来了");
            System.out.println("请求信息："+request);
            //处理
            Object result = invoke(request);
            //反序列化;
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    /**
     * 处理请求；
     *
     * @param rpcRequest
     * @return
     */
    private Object invoke(RpcRequest rpcRequest) {
        Object result = null;
        String className = rpcRequest.getClassName();
        String methodName = rpcRequest.getMethodName();
        //处理参数
        Object[] params = rpcRequest.getParams();
        int paramsNum = params.length;
        Class<?>[] types = new Class[paramsNum];
        for (int i = 0; i < types.length; i++) {
            types[i] = params[i].getClass();
        }
        //定位具体调用位置；
        try {
            Class clazz = Class.forName(className);
            Method method = clazz.getMethod(methodName, types);

            //通过名字获取相关的bean
            Object bean = handlerMap.get(className);
            if(bean == null){
                throw new RuntimeException("service not found,serviceName is "+className);
            }
            result = method.invoke(bean, params);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }
}

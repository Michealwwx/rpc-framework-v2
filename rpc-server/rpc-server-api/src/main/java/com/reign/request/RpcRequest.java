package com.reign.request;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @ClassName RpcRequest
 * @Description 请求的包装类
 * @Author wuwenxiang
 * @Date 2019-09-20 20:47
 * @Version 1.0
 **/
public class RpcRequest implements Serializable {
    private String className;

    private String methodName;

    private Object[] params;

    public RpcRequest(String className, String methodName, Object[] params) {
        this.className = className;
        this.methodName = methodName;
        this.params = params;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "RpcRequest{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", params=" + Arrays.toString(params) +
                '}';
    }
}

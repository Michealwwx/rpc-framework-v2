package com.reign.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName RpcService
 * @Description 暴露服务的注解
 * @Author wuwenxiang
 * @Date 2019-09-20 22:31
 * @Version 1.0
 **/
@Target(ElementType.TYPE)//类还是接口
@Retention(value = RetentionPolicy.RUNTIME)//保留到编译时还是运行时
@Component
public @interface RpcService {
    //获取到服务的接口
    Class<?> value();
}

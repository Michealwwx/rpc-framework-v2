package com.reign.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SpringConfig
 * @Description 配置spring
 * @Author wuwenxiang
 * @Date 2019-09-20 22:34
 * @Version 1.0
 **/
@Configuration
@ComponentScan(basePackages = "com.reign")
public class SpringConfig {

    @Bean(name = "rpcServer")
    public RpcServer getRpcServer(){
        return new RpcServer(8080);
    }
}

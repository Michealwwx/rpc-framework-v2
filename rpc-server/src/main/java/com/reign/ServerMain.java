package com.reign;

import com.reign.spring.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName ServerMain
 * @Description 启动入口
 * @Author wuwenxiang
 * @Date 2019-09-20 20:41
 * @Version 1.0
 **/
public class ServerMain {


    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        ((AnnotationConfigApplicationContext) applicationContext).start();
    }


}

package com.reign.service;

import com.reign.annotations.RpcService;
import com.reign.interfaces.UserService;
import com.reign.model.User;

/**
 * @ClassName UserServiceImpl
 * @Description 实现类
 * @Author wuwenxiang
 * @Date 2019-09-20 21:02
 * @Version 1.0
 **/
@RpcService(UserService.class)
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello(String name) {
        return "hello ," + name;
    }

    @Override
    public User addAge(User user) {
        user.setAge(user.getAge() + 1);
        return user;
    }
}

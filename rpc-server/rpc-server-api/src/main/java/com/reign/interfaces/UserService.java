package com.reign.interfaces;

import com.reign.model.User;

/**
 * @ClassName UserService
 * @Description 接口
 * @Author wuwenxiang
 * @Date 2019-09-20 21:01
 * @Version 1.0
 **/
public interface UserService {

    String sayHello(String name);

    User addAge(User user);

}

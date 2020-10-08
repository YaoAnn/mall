package com.yaohuaxiang.mall.service;

import com.yaohuaxiang.mall.bean.User;

/**
 * @author yaohuaxiang
 * @create 2020/9/24 - 16:01
 */
public interface UserService {
    User getUserByUsernameAndPassword(String username, String password);

    void insertUser(User user);
}

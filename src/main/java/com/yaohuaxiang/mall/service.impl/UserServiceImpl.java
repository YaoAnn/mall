package com.yaohuaxiang.mall.service.impl;

import com.yaohuaxiang.mall.bean.User;
import com.yaohuaxiang.mall.mapper.UserMapper;
import com.yaohuaxiang.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yaohuaxiang
 * @create 2020/9/24 - 16:02
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    UserMapper userMapper;
    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        return userMapper.getUserByUsernameAndPassword(username,password);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}

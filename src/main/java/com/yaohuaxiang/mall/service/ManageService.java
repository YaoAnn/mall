package com.yaohuaxiang.mall.service;

import com.yaohuaxiang.mall.bean.Manager;
import com.yaohuaxiang.mall.bean.User;

import java.util.List;

/**
 * @author yaohuaxiang
 * @create 2020/9/26 - 11:34
 */
public interface ManageService {
    List<User> getAllUser();
    Manager getManager(String name , String password);
}

package com.yaohuaxiang.mall.service.impl;

import com.yaohuaxiang.mall.bean.Manager;
import com.yaohuaxiang.mall.bean.User;
import com.yaohuaxiang.mall.mapper.ManageMapper;
import com.yaohuaxiang.mall.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yaohuaxiang
 * @create 2020/9/26 - 11:36
 */

@Service
public class ManageServiceImpl implements ManageService {
    @Autowired(required = false)
    ManageMapper manageMapper;

    @Override
    public List<User> getAllUser() {
        return manageMapper.getAllUser();
    }

    @Override
    public Manager getManager(String name, String password) {
        return manageMapper.getManager(name,password);
    }
}

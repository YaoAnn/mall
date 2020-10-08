package com.yaohuaxiang.mall.mapper;

import com.yaohuaxiang.mall.bean.Manager;
import com.yaohuaxiang.mall.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yaohuaxiang
 * @create 2020/9/26 - 11:30
 */
public interface ManageMapper {
    @Select("select * from user")
    List<User> getAllUser();

    @Select("select * from manager where name = #{name} and password = #{password}")
    Manager getManager(String name , String password);
}

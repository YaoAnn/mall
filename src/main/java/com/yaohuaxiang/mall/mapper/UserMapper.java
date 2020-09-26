package com.yaohuaxiang.mall.mapper;

import com.yaohuaxiang.mall.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author yaohuaxiang
 * @create 2020/9/24 - 16:03
 */
public interface UserMapper {
    @Select("select * from user where username = #{username} and password = #{password}")
    User getUserByUsernameAndPassword(String username, String password);

    @Insert("insert into user values(null , #{username}, #{password} , #{phone} , #{email} , #{address})")
    void insertUser(User user);
}

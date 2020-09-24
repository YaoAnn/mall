package com.yaohuaxiang.mall.controller;

import com.yaohuaxiang.mall.bean.User;
import com.yaohuaxiang.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yaohuaxiang
 * @create 2020/9/24 - 14:30
 */

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/tologin")
    public String tologin() {
        return "login";
    }

    @RequestMapping("/toindex")
    public String toindex(){
        return "index";
    }

    @RequestMapping("/toreg")
    public String toreg(){
        return "reg";
    }

    @RequestMapping("/toforget")
    public String toforget(){
        return "forget";
    }
    @RequestMapping("/login")
    public String login(String username , String password , Model model){
        User user = userService.getUserByUsernameAndPassword(username,password);
        if(user != null){
            model.addAttribute("user",user);
            return "index";
        }else{
            model.addAttribute("err","用户名或密码错误");
            return "login";
        }
    }




}

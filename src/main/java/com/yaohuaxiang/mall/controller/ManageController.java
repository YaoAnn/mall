package com.yaohuaxiang.mall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaohuaxiang.mall.bean.Manager;
import com.yaohuaxiang.mall.bean.User;
import com.yaohuaxiang.mall.service.ManageService;
import com.yaohuaxiang.mall.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author yaohuaxiang
 * @create 2020/9/26 - 11:30
 */

@RequestMapping("/manage")
@Controller
public class ManageController {
    @Autowired
    ManageService manageService;

    @RequestMapping("")
    public String manageIndex(){
        return "/manage/index";
    }

    @RequestMapping("/users/{pageNum}")
    public String manageUsers(@PathVariable("pageNum")Integer pageNum, Model model, HttpServletRequest httpServletRequest){
        PageUtil<User> pageUtil =new PageUtil<>();
        PageHelper.startPage(pageNum,2);
        List<User> users = manageService.getAllUser();

        PageInfo<User> pageInfo = new PageInfo<User>(users,3);
        String info = pageUtil.getPageInfo(pageInfo, httpServletRequest, "manage/users");
        model.addAttribute("users",users);
        model.addAttribute("info",info);
        return "/manage/users";
    }
    @RequestMapping("tologin")
    public String manageToLogin(){
        return "/manage/login";
    }

    @RequestMapping("login")
    public String manageLogin(String name , String  password , Model model){
        Manager manager = manageService.getManager(name, password);
        if(manager != null){
            model.addAttribute("manager",manager);
            return "/manage/index";
        }else{
            model.addAttribute("err","用户名或密码不正确");
            return "/manage/login";
        }
    }

  /*  @RequestMapping("manage/{pageNum}")
    public String manage(Model model, HttpServletRequest httpServletRequest, @PathVariable("pageNum") Integer pageNum) {
        PageUtil<User> pageUtil = new PageUtil<>();
        PageHelper.startPage(pageNum, 2);
        List<User> userList = manageService.getAllUser();

        PageInfo<User> pageInfo = new PageInfo<>(userList, 2);
        String info = pageUtil.getPageInfo(pageInfo, httpServletRequest, "manage");
        model.addAttribute("userlist", userList);
        model.addAttribute("pageInfo", info);
        return "manage_index";
    }

    @RequestMapping("manage")
    public String manager(HttpServletRequest httpServletRequest, HttpServletResponse response) {
        try {
            String path = httpServletRequest.getServletPath();
            response.sendRedirect(path + "/1");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}





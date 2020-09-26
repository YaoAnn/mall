package com.yaohuaxiang.mall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaohuaxiang.mall.bean.User;
import com.yaohuaxiang.mall.service.ManageService;
import com.yaohuaxiang.mall.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author yaohuaxiang
 * @create 2020/9/26 - 11:30
 */
@Controller
public class ManageController {
    @Autowired
    ManageService manageService;

    @RequestMapping("manage/{pageNum}")
    public String manage(Model model , HttpServletRequest httpServletRequest,@PathVariable("pageNum") Integer pageNum){
        PageUtil<User> pageUtil = new PageUtil<>();
        PageHelper.startPage(pageNum,2);
        List<User> userList = manageService.getAllUser();

        PageInfo<User> pageInfo = new PageInfo<>(userList,2);
        String info = pageUtil.getPageInfo(pageInfo, httpServletRequest, "manage");
        model.addAttribute("userlist",userList);
        model.addAttribute("pageInfo",info);
        return "manage_index";
    }
    @RequestMapping("manage")
    public String manager(HttpServletRequest httpServletRequest,HttpServletResponse response){
        try {
            String path = httpServletRequest.getServletPath();
            response.sendRedirect(path+"/1");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.yaohuaxiang.mall.controller;

import com.yaohuaxiang.mall.bean.User;
import com.yaohuaxiang.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author yaohuaxiang
 * @create 2020/9/24 - 14:30
 */

@Controller
public class UserController {
    @Autowired
    UserService userService;

    /*@RequestMapping("/tologin")
    public String tologin() {
        return "login";
    }

    @RequestMapping("/toindex")
    public String toindex() {
        return "index";
    }

    @RequestMapping("/toreg")
    public String toreg() {
        return "reg";
    }

    @RequestMapping("/toforget")
    public String toforget() {
        return "forget";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession httpSession, Model model) {
        User user = userService.getUserByUsernameAndPassword(username, password);
        if (user != null) {
            httpSession.setAttribute("user", user);
            return "index";
        } else {
            model.addAttribute("err", "用户名或密码错误");
            return "login";
        }
    }

    @RequestMapping("/tomyinfo")
    public String tomyinfo() {
        return "myinfo";
    }

    @RequestMapping("/tomygrxx")
    public String tomygrxx() {
        return "mygrxx";
    }

    @RequestMapping("/exit")
    public String exit(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        return "redirect:toindex";
    }

    @RequestMapping("reg")
    public String reg(User user) {
        userService.insertUser(user);
        return "redirect:toindex";
    }
*/
}

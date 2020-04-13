package com.jamel.adminpage.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jamel.adminpage.pojo.User;
import com.jamel.adminpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.Wrapper;

@Controller
public class UserController {
    @Autowired private UserService userService;

    // 登录
    @RequestMapping("/login")
    public String login(@RequestParam("name")String name, @RequestParam("pwd")String pwd, HttpSession session){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getName,name).eq(User::getPwd,pwd);
        User user = userService.getOne(wrapper);
        if (ObjectUtil.isNotEmpty(user)){
            session.setAttribute("user",user);
            return "redirect:index.html";
        }
        return "redirect:login.html";
    }
}

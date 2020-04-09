package com.jamel.adminpage.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jamel.adminpage.pojo.User;
import com.jamel.adminpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.Wrapper;

public class UserController {
    @Autowired private UserService userService;

    // 登录
    @PostMapping
    public Boolean login(@RequestParam("name")String name, @RequestParam("pwd")String pwd, HttpSession session){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getName,name);
        User user = userService.getOne(wrapper);
        if (ObjectUtil.isNotEmpty(user)){
            session.setAttribute("user",user);
            return true;
        }
        return false;
    }
}

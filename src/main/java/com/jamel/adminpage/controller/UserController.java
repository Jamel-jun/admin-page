package com.jamel.adminpage.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jamel.adminpage.pojo.User;
import com.jamel.adminpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Wrapper;

@RestController
@CrossOrigin
public class UserController {
    @Autowired private UserService userService;

}

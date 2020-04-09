package com.jamel.adminpage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jamel.adminpage.mapper.CompanyMapper;
import com.jamel.adminpage.mapper.UserMapper;
import com.jamel.adminpage.pojo.Company;
import com.jamel.adminpage.pojo.User;
import com.jamel.adminpage.service.CompanyService;
import com.jamel.adminpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired private UserMapper userMapper;

}

package com.jamel.adminpage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jamel.adminpage.pojo.Company;
import com.jamel.adminpage.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}

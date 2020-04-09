package com.jamel.adminpage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jamel.adminpage.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}

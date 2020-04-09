package com.jamel.adminpage.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jamel.adminpage.mapper.EmployeeMapper;
import com.jamel.adminpage.pojo.Employee;
import com.jamel.adminpage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService, IService<Employee> {
    @Autowired private EmployeeMapper employeeMapper;


}

package com.jamel.adminpage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jamel.adminpage.dto.EmployeeRespDto;
import com.jamel.adminpage.mapper.EmployeeMapper;
import com.jamel.adminpage.mapper.EmployeeSalaryMapper;
import com.jamel.adminpage.pojo.Company;
import com.jamel.adminpage.pojo.Employee;
import com.jamel.adminpage.pojo.EmployeeSalary;
import com.jamel.adminpage.service.CompanyService;
import com.jamel.adminpage.service.EmployeeSalaryService;
import com.jamel.adminpage.service.EmployeeService;
import com.jamel.adminpage.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSalaryServiceImpl extends ServiceImpl<EmployeeSalaryMapper, EmployeeSalary> implements EmployeeSalaryService {
}

package com.jamel.adminpage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jamel.adminpage.mapper.CompanySalaryMapper;
import com.jamel.adminpage.mapper.EmployeeSalaryMapper;
import com.jamel.adminpage.pojo.CompanySalary;
import com.jamel.adminpage.pojo.EmployeeSalary;
import com.jamel.adminpage.service.CompanySalaryService;
import com.jamel.adminpage.service.EmployeeSalaryService;
import org.springframework.stereotype.Service;

@Service
public class CompanySalaryServiceImpl extends ServiceImpl<CompanySalaryMapper, CompanySalary> implements CompanySalaryService {
}

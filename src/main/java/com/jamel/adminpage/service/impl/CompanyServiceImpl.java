package com.jamel.adminpage.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jamel.adminpage.mapper.CompanyMapper;
import com.jamel.adminpage.mapper.EmployeeMapper;
import com.jamel.adminpage.pojo.Company;
import com.jamel.adminpage.pojo.Employee;
import com.jamel.adminpage.service.CompanyService;
import com.jamel.adminpage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {
    @Autowired private CompanyMapper companyMapper;

}

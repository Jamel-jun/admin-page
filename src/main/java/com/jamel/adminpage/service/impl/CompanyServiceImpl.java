package com.jamel.adminpage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jamel.adminpage.dto.CompanyRespDto;
import com.jamel.adminpage.mapper.CompanyMapper;
import com.jamel.adminpage.mapper.EmployeeMapper;
import com.jamel.adminpage.pojo.Company;
import com.jamel.adminpage.pojo.Employee;
import com.jamel.adminpage.service.CompanyService;
import com.jamel.adminpage.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.DoubleStream;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {
    @Autowired private CompanyMapper companyMapper;
    @Autowired private EmployeeMapper employeeMapper;

    // 所有公司员工
    public List<CompanyRespDto> get(){
        List<Company> companyList = companyMapper.selectList(null);
        List<CompanyRespDto> companyRespDtoList = BeanCopyUtils.copyListProperties(companyList, CompanyRespDto::new);
        companyRespDtoList.forEach(company -> {
            // 根据公司ID查询所有员工
            List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>()
                    .lambda().eq(Employee::getCid, company.getCid()));
            double sum = employeeList.stream().flatMapToDouble(employee ->
                    DoubleStream.of(employee.getEbasicSalary() + employee.getEbonus())).sum();
            company.setCompanySalary(sum);
        });
        return companyRespDtoList;
    }
}

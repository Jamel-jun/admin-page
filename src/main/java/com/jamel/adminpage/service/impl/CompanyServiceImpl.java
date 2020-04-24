package com.jamel.adminpage.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jamel.adminpage.dto.CompanyRespDto;
import com.jamel.adminpage.dto.EmployeeRespDto;
import com.jamel.adminpage.mapper.CompanyMapper;
import com.jamel.adminpage.mapper.EmployeeMapper;
import com.jamel.adminpage.mapper.UserMapper;
import com.jamel.adminpage.pojo.Company;
import com.jamel.adminpage.pojo.CompanySalary;
import com.jamel.adminpage.pojo.Employee;
import com.jamel.adminpage.service.CompanySalaryService;
import com.jamel.adminpage.service.CompanyService;
import com.jamel.adminpage.service.EmployeeService;
import com.jamel.adminpage.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired private CompanySalaryService companySalaryService;

    // 所有公司
    @Override
    public List<CompanyRespDto> get() {
        List<CompanyRespDto> companyRespDtoList = BeanCopyUtils.copyListProperties(companyService.list(null), CompanyRespDto::new);
        companyRespDtoList.forEach(companyRespDto -> {
            // 管理费
            CompanySalary companySalary = companySalaryService.getOne(new QueryWrapper<CompanySalary>().lambda().eq(CompanySalary::getCid, companyRespDto.getCid()));
            companyRespDto.setCompanySalary(companySalary);

            List<EmployeeRespDto> employeeRespDtoList = employeeService.get(companyRespDto.getCid());
            double sum = employeeRespDtoList.stream().mapToDouble(employeeRespDto -> {
                Double actualSalary = employeeRespDto.getEmployeeSalary().getEsbasicSalary() + employeeRespDto.getEmployeeSalary().getEsbonus();
                return actualSalary;
            }).sum();
            companyRespDto.setCemployeeSalary(sum);

            // 税费
            companyRespDto.setTax(computeTax(sum));


            // 五险一金
            Double insurance = sum * 0.2;
            companyRespDto.setInsurance(insurance);

            companyRespDto.setActualSalary(companyRespDto.getTax() + companyRespDto.getInsurance() + companyRespDto.getCemployeeSalary() +companyRespDto.getInsurance());
        });
        return companyRespDtoList;
    }
    // 所有公司 名字
    @Override
    public List<CompanyRespDto> get(String cname) {
        List<CompanyRespDto> companyRespDtoList = BeanCopyUtils.copyListProperties(companyService.list(new QueryWrapper<Company>().lambda().eq(Company::getCname,cname)), CompanyRespDto::new);
        companyRespDtoList.forEach(companyRespDto -> {
            // 管理费
            CompanySalary companySalary = companySalaryService.getOne(new QueryWrapper<CompanySalary>().lambda().eq(CompanySalary::getCid, companyRespDto.getCid()));
            companyRespDto.setCompanySalary(companySalary);

            List<EmployeeRespDto> employeeRespDtoList = employeeService.get(companyRespDto.getCid());
            double sum = employeeRespDtoList.stream().mapToDouble(employeeRespDto -> {
                Double actualSalary = employeeRespDto.getEmployeeSalary().getEsbasicSalary() + employeeRespDto.getEmployeeSalary().getEsbonus();
                return actualSalary;
            }).sum();
            companyRespDto.setCemployeeSalary(sum);

            // 税费
            companyRespDto.setTax(computeTax(sum));


            // 五险一金
            Double insurance = sum * 0.2;
            companyRespDto.setInsurance(insurance);

            companyRespDto.setActualSalary(companyRespDto.getTax() + companyRespDto.getInsurance() + companyRespDto.getCemployeeSalary() +companyRespDto.getInsurance());
        });
        return companyRespDtoList;
    }

    // 计算税额
    private Double computeTax(Double salary){
        if (salary > 3000 && salary < 5000){
            return (salary - 3000) * 0.1;
        } else if (salary > 3000 && salary < 7000){
            return (salary - 3000) * 0.2;
        } else if (salary > 3000 && salary < 10000){
            return (salary - 3000) * 0.3;
        } else if (salary > 3000 && salary < 15000){
            return (salary - 3000) * 0.4;
        }else {
            return new Double("0");
        }
    }
}

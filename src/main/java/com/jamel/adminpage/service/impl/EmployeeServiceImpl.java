package com.jamel.adminpage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jamel.adminpage.dto.EmployeeRespDto;
import com.jamel.adminpage.dto.EmployeeSalaryRespDto;
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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Autowired private EmployeeService employeeService;
    @Autowired private CompanyService companyService;
    @Autowired private EmployeeSalaryService employeeSalaryService;
    @Autowired private EmployeeSalaryMapper employeeSalaryMapper;

    @Override
    public Integer isfafang(){
        List<EmployeeSalary> employeeSalaries = employeeSalaryMapper.selectList(null);
        int size = employeeSalaries.stream().map(employeeSalary -> {
            return employeeSalary.getIsfafang().equals("未发放") ? 1 : 0;
        }).collect(Collectors.toList()).size();
        return size;
    }

    // 计算员工的平均工资
    @Override
    public List<EmployeeRespDto> avgSalary(){
        List<Employee> employeeList = employeeService.list();
        List<EmployeeRespDto> employeeRespDtoList = BeanCopyUtils.copyListProperties(employeeList, EmployeeRespDto::new);
        employeeRespDtoList.forEach(employee -> {
            EmployeeSalaryRespDto employeeSalaryRespDto = employeeSalaryMapper.avgSalary(employee.getEid());
            employee.setEmployeeSalaryRespDto(employeeSalaryRespDto);
        });
        return employeeRespDtoList;
    }

    @Override
    public List<EmployeeRespDto> get(){
        List<Employee> employeeList = employeeService.list();
        List<EmployeeRespDto> employeeRespDtoList = BeanCopyUtils.copyListProperties(employeeList, EmployeeRespDto::new);
        employeeRespDtoList.forEach(employeeRespDto -> {
            EmployeeSalary employeeSalary = employeeSalaryService.getOne(new QueryWrapper<EmployeeSalary>().lambda().eq(EmployeeSalary::getEid,employeeRespDto.getEid()));
            // 实际发放工资
            Double actualSalary = employeeSalary.getEsbasicSalary() + employeeSalary.getEsbonus() - employeeSalary.getS1()
                    - employeeSalary.getS2() - employeeSalary.getS3() - employeeSalary.getS4()
                    - employeeSalary.getS5() - employeeSalary.getTax();
            employeeRespDto.setActualSalary(actualSalary);
            // 公司
            Company company = companyService.getOne(new QueryWrapper<Company>().lambda().eq(Company::getCid, employeeRespDto.getCid()));
            employeeRespDto.setCname(company.getCname());

            employeeRespDto.setEmployeeSalary(employeeSalary);
        });
        return employeeRespDtoList;
    }

    @Override
    public List<EmployeeRespDto> get(Integer cid){
        List<Employee> employeeList = employeeService.list(new QueryWrapper<Employee>().lambda().eq(Employee::getCid,cid));
        List<EmployeeRespDto> employeeRespDtoList = BeanCopyUtils.copyListProperties(employeeList, EmployeeRespDto::new);
        employeeRespDtoList.forEach(employeeRespDto -> {
            EmployeeSalary employeeSalary = employeeSalaryService.getOne(new QueryWrapper<EmployeeSalary>().lambda().eq(EmployeeSalary::getEid,employeeRespDto.getEid()));
            // 实际发放工资
            Double actualSalary = employeeSalary.getEsbasicSalary() + employeeSalary.getEsbonus() - employeeSalary.getS1()
                    - employeeSalary.getS2() - employeeSalary.getS3() - employeeSalary.getS4()
                    - employeeSalary.getS5() - employeeSalary.getTax();
            employeeRespDto.setActualSalary(actualSalary);
            // 公司
            Company company = companyService.getOne(new QueryWrapper<Company>().lambda().eq(Company::getCid, employeeRespDto.getCid()));
            employeeRespDto.setCname(company.getCname());

            employeeRespDto.setEmployeeSalary(employeeSalary);
        });
        return employeeRespDtoList;
    }


    // 根据员工姓名查询
    @Override
    public List<EmployeeRespDto> get(String ename){
        List<Employee> employeeList = employeeService.list(new QueryWrapper<Employee>().lambda().eq(Employee::getEname,ename));
        List<EmployeeRespDto> employeeRespDtoList = BeanCopyUtils.copyListProperties(employeeList, EmployeeRespDto::new);
        employeeRespDtoList.forEach(employeeRespDto -> {
            EmployeeSalary employeeSalary = employeeSalaryService.getOne(new QueryWrapper<EmployeeSalary>().lambda().eq(EmployeeSalary::getEid,employeeRespDto.getEid()));
            // 实际发放工资
            Double actualSalary = employeeSalary.getEsbasicSalary() + employeeSalary.getEsbonus() - employeeSalary.getS1()
                    - employeeSalary.getS2() - employeeSalary.getS3() - employeeSalary.getS4()
                    - employeeSalary.getS5() - employeeSalary.getTax();
            employeeRespDto.setActualSalary(actualSalary);
            // 公司
            Company company = companyService.getOne(new QueryWrapper<Company>().lambda().eq(Company::getCid, employeeRespDto.getCid()));
            employeeRespDto.setCname(company.getCname());

            employeeRespDto.setEmployeeSalary(employeeSalary);
        });
        return employeeRespDtoList;
    }

    // 根据公司名称查询
    @Override
    public List<EmployeeRespDto> getByCname(String cname){
        List<Company> companyList = companyService.list(new QueryWrapper<Company>().lambda().eq(Company::getCname, cname));
        if (companyList == null || companyList.size() <= 0) {
            List<Employee> employeeList = new ArrayList<>(0);
            List<EmployeeRespDto> employeeRespDtoList = BeanCopyUtils.copyListProperties(employeeList, EmployeeRespDto::new);
            return employeeRespDtoList;
        } else {
            List<Integer> collect = companyList.stream().map(Company::getCid).collect(Collectors.toList());
            List<Employee> employeeList = employeeService.list(new QueryWrapper<Employee>().lambda().in(Employee::getCid,collect));
            List<EmployeeRespDto> employeeRespDtoList = BeanCopyUtils.copyListProperties(employeeList, EmployeeRespDto::new);
            employeeRespDtoList.forEach(employeeRespDto -> {
                EmployeeSalary employeeSalary = employeeSalaryService.getOne(new QueryWrapper<EmployeeSalary>().lambda().eq(EmployeeSalary::getEid,employeeRespDto.getEid()));
                // 实际发放工资
                Double actualSalary = employeeSalary.getEsbasicSalary() + employeeSalary.getEsbonus() - employeeSalary.getS1()
                        - employeeSalary.getS2() - employeeSalary.getS3() - employeeSalary.getS4()
                        - employeeSalary.getS5() - employeeSalary.getTax();
                employeeRespDto.setActualSalary(actualSalary);
                // 公司
                Company company = companyService.getOne(new QueryWrapper<Company>().lambda().eq(Company::getCid, employeeRespDto.getCid()));
                employeeRespDto.setCname(company.getCname());

                employeeRespDto.setEmployeeSalary(employeeSalary);
            });
            return employeeRespDtoList;
        }
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

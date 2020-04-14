package com.jamel.adminpage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jamel.adminpage.dto.EmployeeRespDto;
import com.jamel.adminpage.mapper.EmployeeMapper;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Autowired private EmployeeService employeeService;
    @Autowired private CompanyService companyService;
    @Autowired private EmployeeSalaryService employeeSalaryService;

    @Override
    public List<EmployeeRespDto> get(){
        List<Employee> employeeList = employeeService.list();
        List<EmployeeRespDto> employeeRespDtoList = BeanCopyUtils.copyListProperties(employeeList, EmployeeRespDto::new);
        employeeRespDtoList.forEach(employeeRespDto -> {
            EmployeeSalary employeeSalary = employeeSalaryService.getOne(new QueryWrapper<EmployeeSalary>().lambda().eq(EmployeeSalary::getEid,employeeRespDto.getEid()));
            // 税额
            Double tax = this.computeTax(employeeSalary.getEsbasicSalary() + employeeSalary.getEsbonus());
            employeeRespDto.setTax(tax);
            // 五险一金
            Double insurance = (employeeSalary.getEsbasicSalary() + employeeSalary.getEsbonus()) * 0.2;
            employeeRespDto.setInsurance(insurance);
            // 实际发放工资
            Double actualSalary = employeeSalary.getEsbasicSalary() + employeeSalary.getEsbonus()
                    - employeeRespDto.getTax() - employeeRespDto.getInsurance();
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
            // 税额
            Double tax = this.computeTax(employeeSalary.getEsbasicSalary() + employeeSalary.getEsbonus());
            employeeRespDto.setTax(tax);
            // 五险一金
            Double insurance = (employeeSalary.getEsbasicSalary() + employeeSalary.getEsbonus()) * 0.2;
            employeeRespDto.setInsurance(insurance);
            // 实际发放工资
            Double actualSalary = employeeSalary.getEsbasicSalary() + employeeSalary.getEsbonus()
                    - employeeRespDto.getTax() - employeeRespDto.getInsurance();
            employeeRespDto.setActualSalary(actualSalary);
            // 公司
            Company company = companyService.getOne(new QueryWrapper<Company>().lambda().eq(Company::getCid, employeeRespDto.getCid()));
            employeeRespDto.setCname(company.getCname());

            employeeRespDto.setEmployeeSalary(employeeSalary);
        });
        return employeeRespDtoList;
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

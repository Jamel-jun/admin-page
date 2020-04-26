package com.jamel.adminpage.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.jamel.adminpage.pojo.Company;
import com.jamel.adminpage.pojo.Employee;
import com.jamel.adminpage.pojo.EmployeeSalary;


/**
 * 人员pojo
 */
public class EmployeeRespDto extends Employee {
    private EmployeeSalaryRespDto employeeSalaryRespDto;

    public EmployeeSalaryRespDto getEmployeeSalaryRespDto() {
        return employeeSalaryRespDto;
    }

    public void setEmployeeSalaryRespDto(EmployeeSalaryRespDto employeeSalaryRespDto) {
        this.employeeSalaryRespDto = employeeSalaryRespDto;
    }
    // 实际发放工资
    private Double actualSalary;
    // 公司名称
    private String cname;
    // 薪资
    private EmployeeSalary employeeSalary;

    public EmployeeSalary getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(EmployeeSalary employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Double getActualSalary() {
        return actualSalary;
    }

    public void setActualSalary(Double actualSalary) {
        this.actualSalary = actualSalary;
    }

}

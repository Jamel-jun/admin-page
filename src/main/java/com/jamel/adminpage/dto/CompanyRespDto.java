package com.jamel.adminpage.dto;

import com.jamel.adminpage.pojo.Company;
import com.jamel.adminpage.pojo.CompanySalary;
import com.jamel.adminpage.pojo.Employee;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 所有公司以及公司费用
 */
public class CompanyRespDto extends Company {
    // 员工工资支出
    private Double cemployeeSalary;
    // 实际支出费用
    private Double actualSalary;
    private CompanySalary companySalary;


    public CompanySalary getCompanySalary() {
        return companySalary;
    }

    public void setCompanySalary(CompanySalary companySalary) {
        this.companySalary = companySalary;
    }

    public Double getCemployeeSalary() {
        return cemployeeSalary;
    }

    public void setCemployeeSalary(Double cemployeeSalary) {
        this.cemployeeSalary = cemployeeSalary;
    }

    public Double getActualSalary() {
        return actualSalary;
    }

    public void setActualSalary(Double actualSalary) {
        this.actualSalary = actualSalary;
    }
}


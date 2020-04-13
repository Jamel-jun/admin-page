package com.jamel.adminpage.dto;

import com.jamel.adminpage.pojo.Company;
import com.jamel.adminpage.pojo.Employee;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 所有公司以及公司费用
 */
public class CompanyRespDto {
    private Integer cid;
    private String cname;
//    private List<Employee> employeeList;
    private Double companySalary;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Double getCompanySalary() {
        return companySalary;
    }

    public void setCompanySalary(Double companySalary) {
        this.companySalary = companySalary;
    }
}


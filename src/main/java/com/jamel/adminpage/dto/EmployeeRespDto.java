package com.jamel.adminpage.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.jamel.adminpage.pojo.Employee;


/**
 * 人员pojo
 */
public class EmployeeRespDto extends Employee {
    // 税额
    private Double tax;
    // 五险一金
    private Double insurance;
    // 实际发放工资
    private Double actualSalary;

    public Double getActualSalary() {
        return actualSalary;
    }

    public void setActualSalary(Double actualSalary) {
        this.actualSalary = actualSalary;
    }

    public Double getInsurance() {
        return insurance;
    }

    public void setInsurance(Double insurance) {
        this.insurance = insurance;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }
}

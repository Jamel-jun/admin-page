package com.jamel.adminpage.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 员工工资pojo
 */
@TableName(value = "employeeSalary")
public class EmployeeSalary {
    @TableId(value = "esId",type = IdType.AUTO)
    private Integer esId;
    // 基础薪水
    @TableField("esBasicSalary") private BigDecimal esBasicSalary;
    // 奖金
    @TableField("esBonus") private BigDecimal esBonus;

    // 月份
    @TableField("esDate") private String esDate;
    // 员工Id
    private Integer eId;

    public Integer getEsId() {
        return esId;
    }

    public void setEsId(Integer esId) {
        this.esId = esId;
    }

    public BigDecimal getEsBasicSalary() {
        return esBasicSalary;
    }

    public void setEsBasicSalary(BigDecimal esBasicSalary) {
        this.esBasicSalary = esBasicSalary;
    }

    public BigDecimal getEsBonus() {
        return esBonus;
    }

    public void setEsBonus(BigDecimal esBonus) {
        this.esBonus = esBonus;
    }

    public String getEsDate() {
        return esDate;
    }

    public void setEsDate(String esDate) {
        this.esDate = esDate;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }
}

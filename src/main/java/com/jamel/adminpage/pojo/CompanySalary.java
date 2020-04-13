package com.jamel.adminpage.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 公司费用pojo
 */
@TableName(value = "companySalary")
public class CompanySalary {
    @TableId(value = "csId",type = IdType.AUTO)
    private Integer csId;
    // 所有员工
    @TableField("csBasicSalary") private BigDecimal csBasicSalary;
    // 奖金
    @TableField("csBonus") private BigDecimal csBonus;

    // 月份
    @TableField("csDate") private String csDate;
    // 公司Id
    private Integer cId;

    public Integer getCsId() {
        return csId;
    }

    public void setCsId(Integer csId) {
        this.csId = csId;
    }

    public BigDecimal getCsBasicSalary() {
        return csBasicSalary;
    }

    public void setCsBasicSalary(BigDecimal csBasicSalary) {
        this.csBasicSalary = csBasicSalary;
    }

    public BigDecimal getCsBonus() {
        return csBonus;
    }

    public void setCsBonus(BigDecimal csBonus) {
        this.csBonus = csBonus;
    }

    public String getCsDate() {
        return csDate;
    }

    public void setCsDate(String csDate) {
        this.csDate = csDate;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }
}

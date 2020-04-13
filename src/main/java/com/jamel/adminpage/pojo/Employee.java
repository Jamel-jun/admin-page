package com.jamel.adminpage.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;


/**
 * 人员pojo
 */
public class Employee {
    @TableId(value = "eid",type = IdType.AUTO)
    private Integer eid;
    private String ename;
    // 基础薪水
    @TableField("ebasicSalary") private Double ebasicSalary;
    // 奖金
    private Double ebonus;
    // 月份
    private String edate;

   private Integer cid;

    public Double getEbasicSalary() {
        return ebasicSalary;
    }

    public void setEbasicSalary(Double ebasicSalary) {
        this.ebasicSalary = ebasicSalary;
    }

    public Double getEbonus() {
        return ebonus;
    }

    public void setEbonus(Double ebonus) {
        this.ebonus = ebonus;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}

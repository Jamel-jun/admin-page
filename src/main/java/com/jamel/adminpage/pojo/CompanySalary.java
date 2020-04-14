package com.jamel.adminpage.pojo;

import com.baomidou.mybatisplus.annotation.TableField;

public class CompanySalary {
    private Integer csid;
    @TableField("csmanageSalary") private Double csmanageSalary;
    private String csdate;
    private Integer cid;


    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public Double getCsmanageSalary() {
        return csmanageSalary;
    }

    public void setCsmanageSalary(Double csmanageSalary) {
        this.csmanageSalary = csmanageSalary;
    }

    public String getCsdate() {
        return csdate;
    }

    public void setCsdate(String csdate) {
        this.csdate = csdate;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}

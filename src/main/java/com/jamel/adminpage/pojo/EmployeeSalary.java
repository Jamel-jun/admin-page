package com.jamel.adminpage.pojo;

import com.baomidou.mybatisplus.annotation.TableField;

public class EmployeeSalary {
    private Integer esid;
    @TableField("esbasicSalary") private Double esbasicSalary;
    private Double esbonus;
    private String esdate;
    private Integer eid;

    public Integer getEsid() {
        return esid;
    }

    public void setEsid(Integer esid) {
        this.esid = esid;
    }

    public Double getEsbasicSalary() {
        return esbasicSalary;
    }

    public void setEsbasicSalary(Double esbasicSalary) {
        this.esbasicSalary = esbasicSalary;
    }

    public Double getEsbonus() {
        return esbonus;
    }

    public void setEsbonus(Double esbonus) {
        this.esbonus = esbonus;
    }

    public String getEsdate() {
        return esdate;
    }

    public void setEsdate(String esdate) {
        this.esdate = esdate;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }
}

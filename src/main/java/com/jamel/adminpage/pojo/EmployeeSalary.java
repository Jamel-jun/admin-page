package com.jamel.adminpage.pojo;

import com.baomidou.mybatisplus.annotation.TableField;

public class EmployeeSalary {
    private Integer esid;
    @TableField("esbasicSalary") private Double esbasicSalary;
    private Double esbonus;
    private String esdate;
    private Integer eid;
    private Double tax;
    private Double s1;	  //养老保险
    private Double s2;	  //事业保险
    private Double s3;	  //生育保险
    private Double s4;	  //医疗保险
    private Double s5;	  //公积金
    private String isfafang;

    public String getIsfafang() {
        return isfafang;
    }

    public void setIsfafang(String isfafang) {
        this.isfafang = isfafang;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getS1() {
        return s1;
    }

    public void setS1(Double s1) {
        this.s1 = s1;
    }

    public Double getS2() {
        return s2;
    }

    public void setS2(Double s2) {
        this.s2 = s2;
    }

    public Double getS3() {
        return s3;
    }

    public void setS3(Double s3) {
        this.s3 = s3;
    }

    public Double getS4() {
        return s4;
    }

    public void setS4(Double s4) {
        this.s4 = s4;
    }

    public Double getS5() {
        return s5;
    }

    public void setS5(Double s5) {
        this.s5 = s5;
    }

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

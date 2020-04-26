package com.jamel.adminpage.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

public class CompanySalary {
    private Integer csid;
    @TableField("csmanageSalary") private Double csmanageSalary;
    private String csdate;
    // 税额
    private Double tax;
    private Integer cid;
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

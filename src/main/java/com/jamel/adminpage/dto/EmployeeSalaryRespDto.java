package com.jamel.adminpage.dto;

public class EmployeeSalaryRespDto {
    private int eid;
    private String esdate;
    private String avgSalary;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEsdate() {
        return esdate;
    }

    public void setEsdate(String esdate) {
        this.esdate = esdate;
    }

    public String getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(String avgSalary) {
        this.avgSalary = avgSalary;
    }
}

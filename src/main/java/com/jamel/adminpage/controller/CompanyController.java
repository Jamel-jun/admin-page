package com.jamel.adminpage.controller;

import com.jamel.adminpage.pojo.Company;
import com.jamel.adminpage.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired private CompanyService companyService;
    // 所有公司
    @GetMapping
    public List<Company> getAllCompany(){
        List<Company> list = companyService.list();
        return list;
    }

    // 增加公司
    @PostMapping
    public void addCompany(Company company){
        companyService.save(company);
    }
}

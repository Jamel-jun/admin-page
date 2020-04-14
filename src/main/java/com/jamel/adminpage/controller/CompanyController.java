package com.jamel.adminpage.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.jamel.adminpage.dto.CompanyRespDto;
import com.jamel.adminpage.dto.Resp;
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
    public Resp<List<CompanyRespDto>> getAllCompany(){
        List<CompanyRespDto> list = companyService.get();
        return Resp.success(0,list);
    }

    // 增加公司
    @PostMapping
    public void addCompany(Company company){
        companyService.save(company);
    }
}

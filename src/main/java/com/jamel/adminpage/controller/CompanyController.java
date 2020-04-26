package com.jamel.adminpage.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.jamel.adminpage.dto.CompanyRespDto;
import com.jamel.adminpage.dto.EmployeeRespDto;
import com.jamel.adminpage.dto.Resp;
import com.jamel.adminpage.pojo.Company;
import com.jamel.adminpage.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@CrossOrigin
public class CompanyController {
    @Autowired private CompanyService companyService;

    @RequestMapping("/is")
    public Integer isfafang(){
        Integer isfafang = companyService.isfafang();
        return isfafang;
    }
    // 所有公司
    @PostMapping
    public Resp<List<CompanyRespDto>> getAllCompany(@RequestParam("cname")String cname){
        if (StrUtil.isBlank(cname)) {
            List<CompanyRespDto> list = companyService.get();
            return Resp.success(0,list);
        } else {
            List<CompanyRespDto> list = companyService.get(cname);
            return Resp.success(0,list);
        }
    }

    // 增加公司
    //@PostMapping
    public void addCompany(Company company){
        companyService.save(company);
    }
}

package com.jamel.adminpage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jamel.adminpage.dto.CompanyRespDto;
import com.jamel.adminpage.pojo.Company;

import java.util.List;

public interface CompanyService extends IService<Company> {
    List<CompanyRespDto> get();

    // 所有公司 名字
    List<CompanyRespDto> get(String cname);
}

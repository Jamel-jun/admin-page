package com.jamel.adminpage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jamel.adminpage.dto.CompanyRespDto;
import com.jamel.adminpage.pojo.Company;

import java.util.List;

public interface CompanyService extends IService<Company> {
    List<CompanyRespDto> get();
}

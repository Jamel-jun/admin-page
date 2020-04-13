package com.jamel.adminpage.controller;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jamel.adminpage.dto.EmployeeRespDto;
import com.jamel.adminpage.dto.Resp;
import com.jamel.adminpage.pojo.Employee;
import com.jamel.adminpage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired private EmployeeService employeeService;

    // 所有员工
    @RequestMapping
    public Resp<List<EmployeeRespDto>> getAllEmployee(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
        List<EmployeeRespDto> employeeRespDtos = employeeService.get();
        return Resp.success(0,employeeRespDtos);
    }
}

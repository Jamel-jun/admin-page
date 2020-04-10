package com.jamel.adminpage.controller;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jamel.adminpage.dto.Resp;
import com.jamel.adminpage.pojo.Employee;
import com.jamel.adminpage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired private EmployeeService employeeService;

    // 所有员工
    @RequestMapping
    public Resp<Employee> getAllEmployee(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
        Page<Employee> page1 = new Page<>(page, limit);
        Page<Employee> employeePage = employeeService.page(page1);
        return Resp.success(Convert.toInt(employeePage.getTotal()),employeePage.getRecords());
    }
}

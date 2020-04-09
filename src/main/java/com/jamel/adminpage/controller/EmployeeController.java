package com.jamel.adminpage.controller;

import com.jamel.adminpage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired private EmployeeService employeeService;

    // 所有员工

}

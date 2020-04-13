package com.jamel.adminpage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jamel.adminpage.dto.EmployeeRespDto;
import com.jamel.adminpage.pojo.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService extends IService<Employee> {
    List<EmployeeRespDto> get();
}

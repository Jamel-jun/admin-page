package com.jamel.adminpage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jamel.adminpage.dto.EmployeeRespDto;
import com.jamel.adminpage.pojo.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService extends IService<Employee> {
    Integer isfafang();

    // 计算员工的平均工资
    List<EmployeeRespDto> avgSalary();

    List<EmployeeRespDto> get();
    List<EmployeeRespDto> get(String ename);
    List<EmployeeRespDto> get(Integer cid);

    // 根据公司名称查询
    List<EmployeeRespDto> getByCname(String cname);
}

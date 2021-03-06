package com.jamel.adminpage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jamel.adminpage.dto.EmployeeSalaryRespDto;
import com.jamel.adminpage.pojo.Employee;
import com.jamel.adminpage.pojo.EmployeeSalary;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeSalaryMapper extends BaseMapper<EmployeeSalary> {

    // 计算员工的平均工资
    EmployeeSalaryRespDto avgSalary(Integer eid);
}

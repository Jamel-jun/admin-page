package com.jamel.adminpage.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jamel.adminpage.dto.EmployeeRespDto;
import com.jamel.adminpage.dto.Resp;
import com.jamel.adminpage.pojo.Employee;
import com.jamel.adminpage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/is")
    public Integer isfafang(){
        Integer isfafang = employeeService.isfafang();
        return isfafang;
    }

    // 登录
    @RequestMapping("/11")
    public String login(@RequestParam(value = "name",required = false)String name, HttpSession session){
        session.getServletContext().setAttribute("name",name);
        //QueryWrapper<User> wrapper = new QueryWrapper<>();
        //wrapper.lambda().eq(User::getName,name).eq(User::getPwd,pwd);
        //User user = userService.getOne(wrapper);
        //if (ObjectUtil.isNotEmpty(user)){
        //    session.setAttribute("user",user);
        //    return "redirect:index.html";
        //}
        //return "redirect:login.html";
        return "666";
    }


    // 计算员工的平均工资
    @RequestMapping("/avgSalary")
    public List<EmployeeRespDto> avgSalary() {
        List<EmployeeRespDto> employeeRespDtos = employeeService.avgSalary();
        return employeeRespDtos;
    }

    // 所有员工
    // 根据员工姓名查询
    @RequestMapping
    public Resp<List<EmployeeRespDto>> getAllEmployee(@RequestParam(value = "ename", required = false) String ename,
                                                      @RequestParam(value = "cname", required = false) String cname) {
        if (StrUtil.isBlank(ename) && StrUtil.isBlank(cname)) {
            List<EmployeeRespDto> employeeRespDtos = employeeService.get();
            return Resp.success(0, employeeRespDtos);
        } else if (StrUtil.isNotBlank(cname)) {
            List<EmployeeRespDto> employeeRespDtos = employeeService.getByCname(cname);
            return Resp.success(0, employeeRespDtos);
        } else {
            List<EmployeeRespDto> employeeRespDtos = employeeService.get(ename);
            return Resp.success(0, employeeRespDtos);
        }
    }

    // 所有员工
    // 根据员工姓名查询
    @RequestMapping("/me")
    public Resp<List<EmployeeRespDto>> getAllEmployee(HttpSession session) {
        Object name = session.getServletContext().getAttribute("name");
        System.out.println(name);
        List<EmployeeRespDto> employeeRespDtos = employeeService.get(name.toString());
        return Resp.success(0, employeeRespDtos);
    }
}

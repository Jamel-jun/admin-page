package com.jamel.adminpage;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.jamel.adminpage.mapper")
public class AdminPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminPageApplication.class, args);
    }

}

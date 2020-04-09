package com.jamel.adminpage.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 人员pojo
 */
@Data
@TableName(value = "employee")
public class Employee {
    @TableId(value = "cId",type = IdType.AUTO)
    private Integer eId;
    private String eName;
}

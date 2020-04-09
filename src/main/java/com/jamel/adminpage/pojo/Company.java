package com.jamel.adminpage.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 公司pojo
 */
@Data
@TableName(value = "company")
public class Company {
    @TableId(value = "cId",type = IdType.AUTO)
    private Integer cId;
    @TableField("cName")
    private String cName;
}

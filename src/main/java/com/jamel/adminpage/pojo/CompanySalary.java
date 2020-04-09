package com.jamel.adminpage.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 公司费用pojo
 */
@Data
@TableName(value = "companySalary")
public class CompanySalary {
    @TableId(value = "csId",type = IdType.AUTO)
    private Integer csId;
    // 所有员工
    @TableField("csBasicSalary") private BigDecimal csBasicSalary;
    // 奖金
    @TableField("csBonus") private BigDecimal csBonus;

    // 公司Id
    private Integer cId;
}

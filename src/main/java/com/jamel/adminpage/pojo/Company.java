package com.jamel.adminpage.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 公司pojo
 */
@Data
@Entity
public class Company {
    @Id
    private Integer cid;
    private String cname;
}

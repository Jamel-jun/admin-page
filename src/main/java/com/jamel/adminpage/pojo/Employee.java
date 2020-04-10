package com.jamel.adminpage.pojo;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 人员pojo
 */
@Data
@Entity
public class Employee {
    @Id
    private Integer eid;
    private String ename;

    @OneToOne(mappedBy = "Cid",cascade = CascadeType.ALL) private Company company;
}

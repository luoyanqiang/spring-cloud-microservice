package com.fish.providermovie.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "finance_user")
@Data
public class FinanceUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uid")
    private Integer uid;

    /**
     * 用户名
     */
    private String name;

    /**
     * 电话
     */
    private String tel;

    /**
     * 余额
     */
    private Long money;


}
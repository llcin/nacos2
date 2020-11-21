package com.yumstone.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author lee.
 * @date 2020/9/8 13:28
 */
@Entity(name = "shop_order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oid;

    private Integer uid;
    private String username;

    private Integer pid;
    private String panme;
    private Double pprice;
    private Integer number;
}

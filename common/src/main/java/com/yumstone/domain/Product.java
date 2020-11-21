package com.yumstone.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author lee.
 * @date 2020/9/8 13:27
 */
@Entity(name = "shop_product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;      //主键
    private String pname;  //商品命
    private Double pprice;  //价格
    private Integer stock; //数量
}

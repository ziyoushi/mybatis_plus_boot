package com.atguigu.mybatis_plus_boot.entity;

import lombok.Data;

/**
 * @author Administrator
 * @create 2019-07-10 11:49
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

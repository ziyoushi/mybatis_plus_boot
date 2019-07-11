package com.atguigu.mybatis_plus_boot.entity;

import lombok.Data;

/**
 * @author Administrator
 * @create 2019-07-10 11:49
 * mybatis_plus 默认的主键策略 ID_WORKER
 */
@Data
public class User {

    //主键策略 ID_WORKER
    //主键自增 在数据库 需要设置主键自增
//    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

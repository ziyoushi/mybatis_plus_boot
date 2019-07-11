package com.atguigu.mybatis_plus_boot.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

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

    //自动填充 在实体类上添加字段并添加注解
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    //在实体中添加version 乐观锁
    @Version
    private Integer version;

    //逻辑删除
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleted;


}

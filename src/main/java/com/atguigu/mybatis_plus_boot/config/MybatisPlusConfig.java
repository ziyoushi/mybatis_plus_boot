package com.atguigu.mybatis_plus_boot.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Administrator
 * @create 2019-07-11 10:30
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.atguigu.mybatis_plus_boot.mapper")
public class MybatisPlusConfig {

    //配置乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    //配置分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    //配置逻辑删
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

}

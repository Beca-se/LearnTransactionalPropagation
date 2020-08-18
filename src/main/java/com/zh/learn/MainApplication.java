package com.zh.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @Class Name MainApplication
 * @Desc 这个项目是为了学习和理解Spring 注解事务的传播{@link Transactional#propagation()}
 * @create: 2020-08-18 15:06
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.zh.learn.mapper")
public class MainApplication {
    public static void main(String[] args) {

        SpringApplication.run(MainApplication.class, args);
    }
}

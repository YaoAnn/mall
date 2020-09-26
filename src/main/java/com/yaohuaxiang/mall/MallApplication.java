package com.yaohuaxiang.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(value = "com.yaohuaxiang.mall.mapper")
@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan(basePackages = "com.yaohuaxiang.mall.filter")
public class MallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }

}

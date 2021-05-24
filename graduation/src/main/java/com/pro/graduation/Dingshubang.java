package com.pro.graduation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pro.graduation.mapper")
public class Dingshubang {

    public static void main(String[] args) {
        SpringApplication.run(Dingshubang.class, args);
    }

}
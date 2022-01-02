package com.olivia.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: TODO
 * @Author: olivia
 * @Data: 2022/1/1 9:34 下午
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("com.olivia.app.dao")
public class PostitCardApplication {
    public static void main(String[] args) {
        SpringApplication.run(PostitCardApplication.class,args);
    }
}

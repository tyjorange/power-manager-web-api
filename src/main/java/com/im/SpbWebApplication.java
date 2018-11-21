package com.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.im.mapper")
//@EnableScheduling
public class SpbWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbWebApplication.class, args);
    }
}

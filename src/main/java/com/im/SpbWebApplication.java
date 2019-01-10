package com.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
//@MapperScan({"com.im.mapper.first", "com.im.mapper.second"})
//@EnableScheduling
public class SpbWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbWebApplication.class, args);
    }

}

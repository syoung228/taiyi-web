package com.taiyi.websiate.taiyiweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.taiyi.websiate.taiyiweb.mapper")
public class TaiyiWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaiyiWebApplication.class, args);
    }

}

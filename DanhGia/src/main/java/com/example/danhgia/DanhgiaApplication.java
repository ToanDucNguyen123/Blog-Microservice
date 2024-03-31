package com.example.danhgia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DanhgiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DanhgiaApplication.class, args);
    }

}

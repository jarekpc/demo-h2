package com.example.demoh2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableTransactionManagement
public class DemoH2Application {

    public static void main(String[] args) {
//        System.setProperty("spring.main.lazy-initialization","true");
        SpringApplication.run(DemoH2Application.class, args);
    }


}
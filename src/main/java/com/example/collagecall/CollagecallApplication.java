package com.example.collagecall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={"com.example","org.n3r.idworker"})
public class CollagecallApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollagecallApplication.class, args);
    }

}

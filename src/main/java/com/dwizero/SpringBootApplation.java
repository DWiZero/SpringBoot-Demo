package com.dwizero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootApplation {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootApplation.class, args);
    }
}

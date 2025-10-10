package com.example.umc.global;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class UmcApplication {

    public static void main(String[] args) {
        SpringApplication.run(UmcApplication.class, args);
    }

}

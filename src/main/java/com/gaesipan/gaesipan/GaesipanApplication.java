package com.gaesipan.gaesipan;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@EnableJpaAuditing
@SpringBootApplication
public class GaesipanApplication {

    public static void main(String[] args) {
        SpringApplication.run(GaesipanApplication.class, args);
    }



}

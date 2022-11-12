package com.example;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CydeoTicketingOrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CydeoTicketingOrmApplication.class, args);}

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

}
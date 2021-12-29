package com.nulp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"com.nulp.controllers", "com.nulp.service", "com.nulp.repository", "com.nulp.config"})
@EntityScan({"com.nulp.models"})
@EnableJpaRepositories("com.nulp.repository")

public class KnightApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnightApplication.class,args);
    }

}
